package com.toato.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.toato.ssm.domain.Product;
import com.toato.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/10 16:06
 */

@Controller
@RequestMapping("product")
public class ProductController {



    @Autowired
    IProductService productService;

    /**
     * 查询所有产品
     * @return
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name="page", defaultValue = "1") Integer page,
                                @RequestParam(name = "size", defaultValue = "4") Integer size) {

        List<Product> list = productService.findAll(page, size);

        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 产品添加
     * @param product
     */
    @RequestMapping("save.do")
    public String save(Product product) {
        System.out.println(product.getDepartureTime());
        productService.save(product);

        // 添加完成重新查询产所有产品
        return "redirect:findAll.do";
    }

//    /**
//     * 删除产品
//     * @param id    产品id
//     * @return
//     */
//    @RequestMapping("delete.do")
//    public String del(Integer id) {
//        productService.delete(id);
//        return "redirect:findAll.do";
//    }


    /**
     * 批量删除产品
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("delete.do")
    public String del(@RequestParam(value = "ids[]") List<Integer> ids) {
        for(Integer id : ids) {
            System.out.println(id);
            productService.delete(id);
        }
        return "{\"code\", \"0\"}";
    }


    /**
     * 开启产品
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("enable.do")
    public String productEnable(@RequestParam(value = "ids[]") List<Integer> ids) {
        for(Integer id : ids) {
            productService.enable(id);
        }
        return "{\"code\", \"0\"}";
    }


    /**
     * 关闭产品
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("disable.do")
    public String productDisable(@RequestParam(value = "ids[]") List<Integer> ids) {
        for(Integer id : ids) {
            productService.disable(id);
        }
        return "{\"code\", \"0\"}";
    }


    /**
     * 修改
     * @param product
     * @return
     */
    @RequestMapping("update.do")
    public String update(Product product) {
        productService.update(product);
        return "redirect:findAll.do";
    }
}
