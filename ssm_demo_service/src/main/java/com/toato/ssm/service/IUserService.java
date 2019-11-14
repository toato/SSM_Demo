package com.toato.ssm.service;

import com.toato.ssm.domain.Role;
import com.toato.ssm.domain.UserInfo;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 11:26
 */
public interface IUserService {

    public List<UserInfo> findAll(Integer page, Integer size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;

    void enable(Integer id) throws Exception;

    void disable(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
