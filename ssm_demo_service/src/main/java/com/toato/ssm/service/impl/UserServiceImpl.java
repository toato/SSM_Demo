package com.toato.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.toato.ssm.dao.IUserDao;
import com.toato.ssm.domain.Role;
import com.toato.ssm.domain.UserInfo;
import com.toato.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 11:28
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {


    @Autowired
    IUserDao userDao;

    // 注入BCryptPasswordEncoder密码加密类
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    /**
     * 新建用户
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for(String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;

        // System.out.println(username);

        // 根据用户名获取用户
        UserInfo userInfo = userDao.findByUsername(username);
        // System.out.println(userInfo);
        if(userInfo != null) {
            user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        }
        
        return user;
    }

    // 返回一个List集合，集合中装入的是角色的名称
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
