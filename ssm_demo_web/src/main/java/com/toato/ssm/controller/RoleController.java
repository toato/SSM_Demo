package com.toato.ssm.controller;

import com.toato.ssm.domain.Permission;
import com.toato.ssm.domain.Role;
import com.toato.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 19:30
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService roleService;


    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page", defaultValue = "1") Integer page,
                                @RequestParam(name = "size", defaultValue = "4") Integer size) throws Exception {

        List<Role> roleList = roleService.findAll(page, size);

        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }


    /**
     * 新建角色
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);

        return "redirect:findAll.do";
    }


    /**
     * 获取所有可添加的权限集合
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findRoleByIdAndAllRermission.do")
    public ModelAndView findRoleByIdAndAllRermission(String roleId) throws Exception {

        //
        Role role = roleService.findById(roleId);
        //
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);


        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);

        mv.setViewName("role-permission-add");
        return mv;
    }


    /**
     * 为角色添加权限
     * @param roleId
     * @param permissionIds
     * @return
     * @throws Exception
     */
    public String addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }

}