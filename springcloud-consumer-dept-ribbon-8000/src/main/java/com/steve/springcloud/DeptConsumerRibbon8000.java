package com.steve.springcloud;

import com.steve.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: STEVE
 * @Description: 启动类 - 消费端负载均衡
 * @since: 2023/12/28
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = MySelfRule.class)
public class DeptConsumerRibbon8000 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerRibbon8000.class, args);
    }

}
