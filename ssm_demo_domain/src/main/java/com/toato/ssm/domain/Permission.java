package com.toato.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 11:12
 */
@Data
public class Permission {

    private Integer id;
    private String permissionName;
    private String url;
    // 多种角色可有同一种权限
    private List<Role> roles;

}
