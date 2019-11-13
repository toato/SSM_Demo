package com.toato.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.toato.ssm.dao.IProductDao;
import com.toato.ssm.domain.Product;
import com.toato.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/10 15:51
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao productDao;

    @Override
    public List<Product> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void disable(Integer id) {
        productDao.disable(id);
    }

    @Override
    public void enable(Integer id) {
        productDao.enable(id);
    }
}
