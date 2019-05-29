package com.ljj.springboot_handler.controller;

import com.ljj.springboot_handler.dao.UserJPA;
import com.ljj.springboot_handler.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2019/5/29 22:34
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @GetMapping("/findAll")
    public List<User> findUserList(){
        List<User> userList = userJPA.findAll();
        return userList;
    }

    /**
     * 增加，修改
     * @param user
     * @return
     */
    @GetMapping("/save")
    public User save(User user){
        return userJPA.save(user);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public List<User> deleteUser(@PathVariable Integer id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

    /**
     * 查一个
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public User findUser(@PathVariable Integer id){
        return userJPA.getOne(id);
    }
}