package com.zhoujian.controller;

import com.zhoujian.domain.Permission;
import com.zhoujian.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv= new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.setViewName("permission-list");
        mv.addObject("permissionList",permissionList);
        return mv;
    }
}
