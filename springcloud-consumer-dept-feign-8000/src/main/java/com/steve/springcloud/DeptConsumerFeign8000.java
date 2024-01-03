package com.steve.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: STEVE
 * @Description: 启动类 - 消费端负载均衡
 * @since: 2023/12/28
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.steve.springcloud"})
public class DeptConsumerFeign8000 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign8000.class, args);
    }

}
