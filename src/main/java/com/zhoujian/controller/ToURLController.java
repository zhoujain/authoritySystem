package com.zhoujian.controller;

import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class ToURLController {
    //private Logger logger = (Logger) LoggerFactory.getLogger(ToURLController.class);
    @RequestMapping("/main.do")
    public String toMain(){
        return "main";
    }
    @RequestMapping("/product-add.do")
    public String toProductAdd(){
        return "product-add";
    }
    @RequestMapping("role-add.do")
    public String toRoleAdd(){
        return "role-add";
    }
    @RequestMapping("permission-add.do")
    public String toPermissionAdd(){
        return "permission-add";
    }

    @RequestMapping("/home")
    public String showHome(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        //logger.info("当前登陆用户："+name);
        return "home";
    }

    @RequestMapping("/admin11")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String diaplayAdmin(){
        return "你是管理员";
    }

    @RequestMapping("/user11")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String diaplayUser(){
        return "你是普通用户";
    }


}
