package com.toato.ssm.dao;

import com.toato.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 21:10
 */
public interface ISysLogDao {


    @Insert("insert into sysLog(id, visitTime, username, ip, url, executionTime, method) values(#{id}, #{visitTime}, #{username}, #{ip}, #{url}, #{executionTime}, #{method})")
    void save(SysLog sysLog) throws Exception;
}