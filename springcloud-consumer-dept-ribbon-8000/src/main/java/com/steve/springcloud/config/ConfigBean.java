package com.steve.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: STEVE
 * @Description: 注入RestTemplate
 * @since: 2023/12/22
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
//        return new RandomRule();
        return new RetryRule();
    }

}
