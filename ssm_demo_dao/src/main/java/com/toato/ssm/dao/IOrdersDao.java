package com.toato.ssm.dao;

import com.toato.ssm.domain.Member;
import com.toato.ssm.domain.Orders;
import com.toato.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 9:56
 */
public interface IOrdersDao {



    @Select("select * from orders")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.toato.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;


    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.toato.ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.toato.ssm.dao.IMemberDao.findById")),
            // 订单与旅客之间通过一张中间表相互关联 1:n
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.toato.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String id) throws Exception;
}
