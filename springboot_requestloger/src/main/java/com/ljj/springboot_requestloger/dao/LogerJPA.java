package com.ljj.springboot_requestloger.dao;

import com.ljj.springboot_requestloger.entity.LogerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @Auther: ljj
 * @Date: 2019/6/16 13:57
 * @Description:
 */
public interface LogerJPA extends JpaRepository<LogerEntity, Long>, JpaSpecificationExecutor, Serializable {
}
