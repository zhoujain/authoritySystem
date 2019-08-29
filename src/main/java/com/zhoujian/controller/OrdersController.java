package com.zhoujian.controller;

import com.github.pagehelper.PageInfo;
import com.zhoujian.domain.Orders;
import com.zhoujian.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    //未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception{
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("orders-list");
//        List<Orders> ordersList = ordersService.findAll();
//        mv.addObject("ordersList",ordersList);
//        return mv;
//    }
    //分页
    @RequestMapping("/findAll1.do")
    public ModelAndView findAll1(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name="pageSize",required = true,defaultValue = "4")Integer pageSize) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAllByPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList,pageSize);
        mv.setViewName("orders-list");
        //PageInfo一个分页bean
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)throws Exception{
        Orders orders = ordersService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders",orders);
        return mv;
    }
}
