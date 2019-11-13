package com.toato.ssm.service;

import com.toato.ssm.domain.Permission;
import com.toato.ssm.domain.Role;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 19:31
 */
public interface IRoleService {

    List<Role> findAll(Integer page, Integer size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;


}
