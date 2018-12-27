/*
package com.yufb.top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



*/
/**
 * 若打包成war包，上面的启动类继承SpringBootServletInitializer
 * 然后重写configure即可
 *//*

@SpringBootApplication
@MapperScan("com.yufb.top.dao.*")
@ComponentScan(basePackages = {"com.yufb.top.*"})
public class WarApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WarApplication.class, args);
    }
}




*/
