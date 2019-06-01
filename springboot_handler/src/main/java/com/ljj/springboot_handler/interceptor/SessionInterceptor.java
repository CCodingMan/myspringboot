package com.ljj.springboot_handler.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ljj
 * @Date: 2019/5/30 22:50
 * @Description:
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")){
            return true;
        }
        Object o = request.getSession().getAttribute("session_user");
        if(o == null){
            response.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }
}
