package com.toato.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.toato.ssm.domain.Role;
import com.toato.ssm.domain.UserInfo;
import com.toato.ssm.service.IUserService;
import com.toato.ssm.utls.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 11:25
 */

@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    IUserService userService;


    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page", defaultValue = Constants.DEFAULT_STARTPAGE) Integer page,
                                @RequestParam(name = "size", defaultValue = Constants.DEFAULT_PAGESIZE) Integer size) throws Exception {
        List<UserInfo> userList = userService.findAll(page, size);

        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(userList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");

        return mv;
    }


    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }


    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("delete.do")
    public String del(@RequestParam(value = "ids[]") List<Integer> ids) throws Exception {
        for(Integer id : ids) {
            System.out.println(id);
            userService.delete(id);
        }
        return "{\"code\": \"0\"}";
    }


    /**
     * 开启用户
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("enable.do")
    public String productEnable(@RequestParam(value = "ids[]") List<Integer> ids) throws Exception {
        for(Integer id : ids) {
            userService.enable(id);
        }
        return "{\"code\": \"0\"}";
    }


    /**
     * 停用用户
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("disable.do")
    public String productDisable(@RequestParam(value = "ids[]") List<Integer> ids) throws Exception {
        for(Integer id : ids) {
            userService.disable(id);
        }
        return "{\"code\": \"0\"}";
    }


    /**
     * 查询单个用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {

        UserInfo userInfo = userService.findById(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("userDetail", userInfo);
        mv.setViewName("user-show");
        return mv;
    }


    /**
     * 查询用户可以添加的role
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String userId) throws Exception {
        // 查询用户
        UserInfo userInfo = userService.findById(userId);
        // 查询用户可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }


    /**
     * 为用户添加角色
     * @param userId    用户id
     * @param roleIds   角色id
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,
                                @RequestParam(name="ids", required = true)String[] roleIds) throws Exception {
        userService.addRoleToUser(userId, roleIds);

        return "redirect:findAll.do";
    }
}
