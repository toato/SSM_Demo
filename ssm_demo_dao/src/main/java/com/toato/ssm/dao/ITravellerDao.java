package com.toato.ssm.dao;

import com.toato.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 10:25
 */
public interface ITravellerDao {

    // 通过查询中间表来得到对应订单的所有旅客id,再查询旅客表找到所有对应旅客
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(Integer ordersId);


}
