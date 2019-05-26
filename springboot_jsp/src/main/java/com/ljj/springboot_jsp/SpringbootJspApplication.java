package com.ljj.springboot_jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootJspApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJspApplication.class, args);
    }

    /**
     *
     * @deprecated：继承SpringBootServletInitializer使用外部容器（后期文章讲解使用外部tomcat如何运行项目）
     * 运行项目时会自动加载并且装配
     * @param builder SpringApplicationBuilder对象
     * @return SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootJspApplication.class);
    }
}
