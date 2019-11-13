package com.toato.ssm.dao;

import com.toato.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/10 15:48
 */
public interface IProductDao {

    @Select("select * from product")
    public List<Product> findAll();

    @Select("select * from product where id = #{id}")
    Product findById(String id) throws Exception;

    @Insert("insert into product(productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) values (#{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    void save(Product product);

    @Delete("delete from product where id = #{id}")
    void delete(Integer id);

    @Update("update product set productNum=#{productNum}, productName=#{productName}, cityName=#{cityName}, departureTime=#{departureTime}, productPrice=#{productPrice}, productDesc=#{productDesc}, productStatus=#{productStatus}")
    void update(Product product);

    @Update("update product set productStatus=0 where id=#{id}")
    void disable(Integer id);

    @Update("update product set productStatus=1 where id=#{id}")
    void enable(Integer id);
}
