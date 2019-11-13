package com.toato.ssm.domain;

import lombok.Data;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 10:13
 */
@Data
public class Traveller {

    private Integer id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;    // 证件类型 0身份证 I护照 2军官证
    private String credentialsNum;
    private Integer travellerType;      // 旅窖类型 0成人 1儿童

    private String credentialsTypeStr;
    private String travellerTypeStr;


    public String getCredentialsTypeStr() {
        //证件类型 0身份证 I护照 2军官证
        if(credentialsType != null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "身份证";
            }else if(credentialsType == 1) {
                credentialsTypeStr = "护照";
            }else if(credentialsType == 2) {
                credentialsTypeStr = "军官证";
            }
        }

        return credentialsTypeStr;
    }


    public String getTravellerTypeStr() {
        //旅窖类型 0成人 1儿童
        if(travellerType != null) {
            if (travellerType == 0) {
                travellerTypeStr = "成人";
            }else if(travellerType == 1) {
                travellerTypeStr = "儿童";
            }
        }

        return travellerTypeStr;
    }

}
