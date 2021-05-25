package com.zqz.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 14:38 2021/5/21
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zqz.blog.mapper"})
public class ApplicationStart {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
