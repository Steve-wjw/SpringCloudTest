package com.steve.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: STEVE
 * @Description: DeptProvider的主启动类
 * @since: 2023/12/21
 */
@SpringBootApplication
@EnableEurekaClient // 本服务启动之后会自动注册进Eureka中
@EnableDiscoveryClient // 服务发现
public class DeptProvider8002 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002.class,args);
    }

}
