package com.zhoujian.controller;

import com.zhoujian.domain.Role;
import com.zhoujian.domain.UserInfo;
import com.zhoujian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<UserInfo> users = userService.findAll();
        ModelAndView mv =new ModelAndView();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/userAdd.do")
    public String userAdd(){
        return "user-add";
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.saveUser(userInfo);
       return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(value = "id",required = true) String id) throws Exception{
        ModelAndView mv =new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        //根据id查询可添加的角色
        List<Role> roleList = userService.findOtherRole(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(value = "userId",required = true)String userid,@RequestParam(value = "ids",required = true)String[] roles) throws Exception{
        userService.addRoleToUser(userid,roles);
        return "redirect:findAll.do";
    }


}
