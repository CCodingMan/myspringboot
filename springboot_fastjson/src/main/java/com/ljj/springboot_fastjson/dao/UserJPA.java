package com.ljj.springboot_fastjson.dao;

import com.ljj.springboot_fastjson.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @Auther: ljj
 * @Date: 2019/5/21 21:31
 * @Description:
 */
public interface UserJPA extends JpaRepository<User, Integer>, JpaSpecificationExecutor, Serializable {
}
