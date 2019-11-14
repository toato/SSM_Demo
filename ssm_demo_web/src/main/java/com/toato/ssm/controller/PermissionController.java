package com.toato.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.toato.ssm.domain.Permission;
import com.toato.ssm.service.IPermissionService;
import com.toato.ssm.utls.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 19:38
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    IPermissionService permissionService;


    /**
     * 查询所有权限
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page", defaultValue = Constants.DEFAULT_STARTPAGE) Integer page,
                                @RequestParam(name = "size", defaultValue = Constants.DEFAULT_PAGESIZE) Integer size) throws Exception {
        List<Permission> permissionList = permissionService.findAll(page, size);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }


    /**
     * 新增一个权限
     * @param permission
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

}
