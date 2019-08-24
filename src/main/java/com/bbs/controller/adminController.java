package com.bbs.controller;

import com.bbs.entity.admin;
import com.bbs.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by valar on 2019/1/5.
 */
@Controller
@RequestMapping(value = "/admin")
public class adminController {
    @Autowired
    private adminService adminService;
    @RequestMapping(value = "")
    public String doLogin(){
            return "admin/login";
    }

    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public @ResponseBody admin js(@RequestBody admin reply){
        return reply;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpSession session, Model model){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(adminService.login(username, password)){
            System.out.println("succes");
            return "admin/index";
        }else {
            model.addAttribute("error", "用户名或者密码错误");
            System.out.println("failture");
            return "admin/login";
        }
    }
}
