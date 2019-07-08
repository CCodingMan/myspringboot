package com.ljj.springboot_requestloger.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljj.springboot_requestloger.util.LoggerUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ljj
 * @Date: 2019/7/8 22:51
 * @Description:
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/login")
    public JSONObject login(HttpServletRequest request, String name) throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "用户" + name + "登录成功");
        request.setAttribute(LoggerUtils.LOGGER_RETURN, jsonObject);
        return jsonObject;
    }
}
