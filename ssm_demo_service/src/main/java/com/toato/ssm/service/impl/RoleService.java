package com.toato.ssm.service.impl;

import com.toato.ssm.dao.IRoleDao;
import com.toato.ssm.domain.Permission;
import com.toato.ssm.domain.Role;
import com.toato.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 19:31
 */
@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    IRoleDao roleDao;


    @Override
    public List<Role> findAll(Integer page, Integer size) throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String pId : permissionIds) {
            roleDao.addPermissionToRole(roleId, pId);
        }
    }
}
