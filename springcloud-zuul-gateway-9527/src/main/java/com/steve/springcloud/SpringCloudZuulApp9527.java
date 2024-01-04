package com.steve.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: STEVE
 * @Description: Zuul启动类
 * @since: 2024/1/4
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulApp9527 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApp9527.class, args);
    }

}
