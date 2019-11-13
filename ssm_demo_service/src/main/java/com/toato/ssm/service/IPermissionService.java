package com.toato.ssm.service;

import com.toato.ssm.domain.Permission;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 19:38
 */
public interface IPermissionService {
    List<Permission> findAll(Integer page, Integer size) throws Exception;

    void save(Permission permission) throws Exception;
}
