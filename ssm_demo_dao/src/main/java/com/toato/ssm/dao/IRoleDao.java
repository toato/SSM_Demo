package com.toato.ssm.dao;

import com.toato.ssm.domain.Permission;
import com.toato.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 11:34
 */
public interface IRoleDao {


    // 根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id" ,javaType = java.util.List.class, many = @Many(select = "com.toato.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;


    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(id, roleName, roleDesc) values(#{id}, #{roleName}, #{roleDesc})")
    void save(Role role);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId) throws Exception;

    @Insert("insert into role_permission (permissionId, roleId) values (#{permissionId}, #{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("pId") String pId);
}
