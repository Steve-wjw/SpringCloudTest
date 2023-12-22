package com.steve.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: STEVE
 * @Description: 消费端启动类
 * @since: 2023/12/22
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DeptConsumer8000 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8000.class,args);
    }

}
