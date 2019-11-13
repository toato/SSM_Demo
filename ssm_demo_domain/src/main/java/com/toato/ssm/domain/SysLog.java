package com.toato.ssm.domain;

import com.toato.ssm.utls.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 21:08
 */
@Data
public class SysLog {

    private Integer id;
    private Date visitTime;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    private String visitTimeStr;


    public String getVisitTimeStr() {
        if(visitTime != null) {
            visitTimeStr = DateUtils.date2String(visitTime, "yyyy-MM-dd HH:mm:ss");
        }
        return visitTimeStr;
    }
}
