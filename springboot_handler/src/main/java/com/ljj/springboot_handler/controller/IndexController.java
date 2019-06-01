package com.ljj.springboot_handler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: ljj
 * @Date: 2019/5/30 22:04
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    @GetMapping("/login_view")
    public String login_view(){
        return "thymeleaf/login";
    }

    @GetMapping("/index")
    public String index(){
        return "thymeleaf/index";
    }
}
