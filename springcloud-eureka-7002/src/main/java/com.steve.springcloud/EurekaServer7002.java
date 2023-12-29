package com.steve.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: STEVE
 * @Description: EurekaServer服务器端启动类，接受其他微服务注册进来！
 * @since: 2023/12/22
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class,args);
    }

}
