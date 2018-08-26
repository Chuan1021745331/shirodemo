package com.chuan.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @类名:
 * @包名: com.chuan.shirodemo.controller
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/8/26 10:08
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String loginUrl(){
        return "login";
    }

    @PostMapping("/loginUser")
    public String login(@RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password){
        //todo 加密
        //生成token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        //登录
        subject.login(token);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject!=null){
            subject.logout();
        }
        return "login";
    }

}
