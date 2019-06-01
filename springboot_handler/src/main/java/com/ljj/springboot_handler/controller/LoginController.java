package com.ljj.springboot_handler.controller;

/**
 * @Auther: ljj
 * @Date: 2019/5/30 22:03
 * @Description:
 */

import com.ljj.springboot_handler.dao.UserJPA;
import com.ljj.springboot_handler.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserJPA userJPA;

    @PostMapping("/login")
    public String login(User user, ModelMap map, HttpServletRequest request){
        String result = "登录成功";
        boolean flag = true;
        User user1 = null;
        Optional<User> optional = userJPA.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("userName"),user.getUserName());
            }
        });
        if (optional.isPresent()){
            user1 = optional.get();
        }
        if(user1 == null){
            flag = false;
            map.addAttribute("msg", "用户不存在，登录失败");
        }else if (!user.getPassword().equals(user1.getPassword())){
            flag = false;
            map.addAttribute("msg", "密码错误");
        }
        if(flag){
            map.addAttribute("msg", "欢迎来到Spring Boot");
            request.getSession().setAttribute("session_user", user1);
        }
        return "thymeleaf/index";
    }
}
