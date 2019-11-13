package com.toato.ssm.controller;

import com.toato.ssm.domain.SysLog;
import com.toato.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 21:03
 */
@Component
@Aspect
public class LogAop {


    // 注入HttpServletRequest(需在web.xml中配置requestContext的监听器)
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;     // 访问时间
    private Class clazz;        // 访问的类
    private Method method;      // 访问的方法
    private String url;         // 访问的URL(访问的路径)







    /**
     * 前置通知
     * 拦截controller下所有方法
     * 获取开始时间、执行类、执行方法
     * @param jp
     */
    @Before("execution(* com.toato.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();                             // 获取访问时间
        clazz = jp.getTarget().getClass();                  // 获取Class
        String methodStr = jp.getSignature().getName();     // 获取方法名


        // 根据方法名获取Method对象
        Object[] args = jp.getArgs();                       // 获取访问方法的参数
        if(args == null || args.length == 0) {
            // 方法无参数
            method = clazz.getMethod(methodStr);
        }else {
            // 方法有参

            // 根据参数构造class数组
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodStr, classArgs);
        }
    }


    /**
     * 后置通知
     * @param jp
     */
    @After("execution(* com.toato.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long executeTime = new Date().getTime() - visitTime.getTime();      // 获取访问时长


        // 获取url
        // url = 类上的注解值 + 方法上的注解值
        if(clazz != null && method != null && clazz != LogAop.class) {

            // 获取类上的RequestMapping注解
            RequestMapping classReqMapAnno = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classReqMapAnno != null) {
                // 获取类上的RequestMapping注解的value值
                String[] classValues = classReqMapAnno.value();

                // 获取方法上的RequestMapping注解
                RequestMapping methodReqMapAnno = method.getAnnotation(RequestMapping.class);
                if(methodReqMapAnno != null) {
                    // 获取方法上的RequestMapping注解的value值
                    String[] methodValues = methodReqMapAnno.value();

                    // 组合得到url
                    url = classValues[0] + methodValues[0];

                    // 获取访问ip
                    String ip = request.getRemoteAddr();


                    // 获取操作者(通过SpringSecurity提供的上下文获取)
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();


                    // 封装得到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setVisitTime(visitTime);
                    sysLog.setUsername(username);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setExecutionTime(executeTime);
                    sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());

                    // 调用service方法将其保存至数据库
                    sysLogService.save(sysLog);
                }
            }
        }





    }



}
