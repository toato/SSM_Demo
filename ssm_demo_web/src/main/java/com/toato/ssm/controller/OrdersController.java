package com.toato.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.toato.ssm.domain.Orders;
import com.toato.ssm.service.IOrdersService;
import com.toato.ssm.utls.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @Secured({"ROLE_ADMIN"})          // 只有admin用户才有权查看所有订单
    public ModelAndView findAll(@RequestParam(name="page", defaultValue = Constants.DEFAULT_STARTPAGE) Integer page,
                                @RequestParam(name = "size", defaultValue = Constants.DEFAULT_PAGESIZE) Integer size) throws Exception {
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



    /**
     * 批量删除订单
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("delete.do")
    public String del(@RequestParam(value = "ids[]") List<Integer> ids) throws Exception {
        for(Integer id : ids) {
            System.out.println(id);
            ordersService.delete(id);
        }
        return "{\"code\": \"0\"}";
    }


    /**
     * 开启订单
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("enable.do")
    public String productEnable(@RequestParam(value = "ids[]") List<Integer> ids) throws Exception {
        for(Integer id : ids) {
            ordersService.enable(id);
        }
        return "{\"code\": \"0\"}";
    }


    /**
     * 停用订单
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("disable.do")
    public String productDisable(@RequestParam(value = "ids[]") List<Integer> ids) throws Exception {
        for(Integer id : ids) {
            ordersService.disable(id);
        }
        return "{\"code\": \"0\"}";
    }
}
