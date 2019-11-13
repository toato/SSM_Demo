package com.toato.ssm.domain;

import lombok.Data;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 11:10
 */
@Data
public class UserInfo {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private List<Role> roles;   // 用户对应的角色(一个用户可以有多个角色)

    private String statusStr;

    public String getStatusStr() {
        // 状态 0未开启 1开启
        if(status == 0) {
            statusStr = "未开启";
        }else if(status == 1) {
            statusStr = "开启";
        }

        return statusStr;
    }
}
