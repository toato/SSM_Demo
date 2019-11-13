package com.toato.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.toato.ssm.dao.IOrdersDao;
import com.toato.ssm.domain.Orders;
import com.toato.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 10:40
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    IOrdersDao ordersDao;


    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}