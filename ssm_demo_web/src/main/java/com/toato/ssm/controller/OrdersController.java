package com.toato.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.toato.ssm.domain.Orders;
import com.toato.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/11 9:50
 */
@Controller
@RequestMapping("orders")
public class OrdersController {


    @Autowired
    IOrdersService ordersService;



    /**
     * 分页查询所有订饭
     * @param page  当前页
     * @param size  每页包含记录的数量
     * @return
     * @throws Exception
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name="page", defaultValue = "1") Integer page,
                                @RequestParam(name = "size", defaultValue = "4") Integer size) throws Exception {

        List<Orders> ordersList = ordersService.findAll(page, size);

        ModelAndView mv = new ModelAndView();                   // 创建ModelAndView对象
        PageInfo pageInfo = new PageInfo(ordersList);           // 构造分页对象
        mv.addObject("ordersPageInfo", pageInfo);
        mv.setViewName("orders-list");

        return mv;
    }



    /**
     * 通过订单id查询订单详情
     * @param id        订单id
     * @return
     * @throws Exception
     */
    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {

        Orders orders = ordersService.findById(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersDetail", orders);
        mv.setViewName("orders-show");

        return mv;
    }
}
