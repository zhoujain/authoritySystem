package com.zhoujian.controller;

import com.zhoujian.domain.Permission;
import com.zhoujian.domain.Role;
import com.zhoujian.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv= new ModelAndView();
        List<Role> roleList=roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(value = "id",required = true)String id)throws Exception{
        Role role = roleService.findById(id);
        List<Permission> permissionList = roleService.findOtherPermission(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(value = "roleId",required = true)String roleId,@RequestParam(value = "ids",required = true)String[] permissions) throws Exception{
       roleService.addPermissionToRole(roleId,permissions);
        return "redirect:findAll.do";
    }
}
