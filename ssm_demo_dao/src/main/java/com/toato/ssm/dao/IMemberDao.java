package com.toato.ssm.dao;

import com.toato.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 10:07
 */
public interface IMemberDao {


    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;

}
