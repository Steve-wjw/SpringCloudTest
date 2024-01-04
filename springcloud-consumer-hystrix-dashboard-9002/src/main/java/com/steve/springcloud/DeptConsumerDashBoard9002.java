package com.steve.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: STEVE
 * @Description: 消费端启动类
 * @since: 2023/12/22
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class DeptConsumerDashBoard9002 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashBoard9002.class,args);
    }

}
