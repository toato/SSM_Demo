package com.toato.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 11:11
 */
@Data
public class Role {

    private Integer id;
    private String roleName;
    private String roleDesc;

    // 角色有多个权限
    private List<Permission> permissions;
    // 多个用户可以对应同一种角色
    private List<UserInfo> users;

}
