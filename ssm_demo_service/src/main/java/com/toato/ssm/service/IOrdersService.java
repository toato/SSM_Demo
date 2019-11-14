package com.toato.ssm.service;

import com.toato.ssm.domain.Orders;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 10:39
 */
public interface IOrdersService {

    public List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String id) throws Exception;

    void disable(Integer id) throws Exception;

    void enable(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
