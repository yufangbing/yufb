package com.yufb.top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.yufb.top.dao.*")
@ComponentScan(basePackages = {"com.yufb.top.*"})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


/**
 * 若打包成war包，上面的启动类继承SpringBootServletInitializer
 * 然后重写configure即可
 */
/*public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}*/
