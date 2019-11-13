package com.toato.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.toato.ssm.dao.IPermissionDao;
import com.toato.ssm.domain.Permission;
import com.toato.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 19:38
 */
@Service
@Transactional
public class PermissionService implements IPermissionService {


    @Autowired
    IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

}
