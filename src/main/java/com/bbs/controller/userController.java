package com.bbs.controller;

import com.bbs.entity.reply;
import com.bbs.entity.title;
import com.bbs.entity.user;
import com.bbs.service.replyService;
import com.bbs.service.titleService;
import com.bbs.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


/**
 * Created by valar on 2019/1/5.
 */
@Controller
@RequestMapping(value = "")
public class userController {

    @Autowired
    private titleService titleService;
    @Autowired
    private userService userService;

    @Autowired
    private replyService replyService;
    private user user;

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public String reply(HttpServletRequest request, HttpSession session, Model model) {
         int titId = Integer.parseInt(request.getParameter("id"));
         String replyText = request.getParameter("content");
         int userId = Integer.parseInt(request.getParameter("userId"));
         String username = request.getParameter("username");
        List<title> articles = titleService.list();
        model.addAttribute("titles", articles);
        if(replyService.doReply(titId,replyText,userId,username)) {
            model.addAttribute("error", "回复成功！");
            return "dissess";
        } else {
            model.addAttribute("error", "回复失败！");
            return "dissess";
        }
    }
    @RequestMapping("/detail")
    public String detail(@RequestParam(value="id",defaultValue = "1")  Integer id, Model model) {
        System.out.println(134);
        title title = titleService.search(id);
        System.out.println(title.getTitName());
        System.out.println(title.getTitName());
        List<reply> articles = replyService.getReply(id);
        System.out.println(articles.size());
        model.addAttribute("replys", articles);
        model.addAttribute("title", title);
        return "detail";
    }
    @RequestMapping(value = "/dissess")
    public String discuss(Model model) {
        List<title> articles = titleService.list();
        model.addAttribute("titles", articles);
        return "dissess";
    }
    @RequestMapping(value = "/person")
    public String person(Model model) {
        System.out.println("person");
        return "person";
    }
    @RequestMapping(value = "/dotitle", method = RequestMethod.POST)
    public String dotitle(HttpServletRequest request, HttpSession session, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String titName = request.getParameter("subject");
        String titText = request.getParameter("content");
        System.out.println(userId);
        if(titleService.newtitle(userId,email,titText,titName,username)) {
            model.addAttribute("error", "发表成功！");
            return "main";
        } else {
            model.addAttribute("error", "发表失败！");
            return "main";
        }
    }

    @RequestMapping(value = "/newtitle")
    public String newtitle(Model model) {
        System.out.println("newtitle");
        return "newtitle";
    }

    @RequestMapping(value = "/doregist", method = RequestMethod.POST)
    public String doregist(HttpServletRequest request, HttpSession session, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        if (userService.regist(username, password, sex, age, telephone, email)) {
            System.out.println("succes");
            return "login";
        } else {
            model.addAttribute("error", "用户名或者密码错误");
            System.out.println("failture");
            return "error1";
        }
    }

    @RequestMapping(value = "")
    public String doLogin() {

        return "login";
    }

    @RequestMapping(value = "/regist")
    public String regist(Model model) {
        System.out.println("regist");
        return "regist";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpSession session, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user = userService.login(username, password);
        if (user != null) {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss");
            java.util.Date currentTime = new java.util.Date();
            String time = simpleDateFormat.format(currentTime).toString();
            request.getSession(true); // 创建一个 session
            session.setAttribute("username", username);
            session.setAttribute("time", time);
            session.setAttribute("sex", user.getUsersex());
            session.setAttribute("age", user.getUserage());
            session.setAttribute("tel", user.getUserphone());
            session.setAttribute("email", user.getUseremail());
            session.setAttribute("id", user.getUserid());
            System.out.println("succes");
            return "main";
        } else {
            model.addAttribute("error", "用户名或者密码错误");
            System.out.println("failture");
            return "login";
        }
    }
}
