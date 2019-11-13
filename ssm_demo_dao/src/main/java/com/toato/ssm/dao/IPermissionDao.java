package com.toato.ssm.dao;

import com.toato.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 18:11
 */
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;


    @Select("select * from permission")
    List<Permission> findAll() throws Exception;



    @Insert("insert into permission(id, permissionName, url) values(#{id}, #{permissionName}, #{url})")
    void save(Permission permission) throws Exception;

}
