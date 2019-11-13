package com.toato.ssm.service;

import com.toato.ssm.domain.Product;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/10 15:50
 */
public interface IProductService {

    public List<Product> findAll(Integer page, Integer size);

    void save(Product product);

    void delete(Integer id);

    void update(Product product);

    void disable(Integer id);

    void enable(Integer id);
}
