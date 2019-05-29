package com.ljj.springboot_handler.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Auther: ljj
 * @Date: 2019/5/29 22:29
 * @Description:
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

    private static final long serialVersionUID = -3668829120870258913L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "name")
    private String name;

    public User() {
    }

    public User(int id, int age, String sex, String name) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
