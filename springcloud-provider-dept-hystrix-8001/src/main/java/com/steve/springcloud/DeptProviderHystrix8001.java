package com.steve.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author: STEVE
 * @Description: DeptProvider的主启动类
 * @since: 2023/12/21
 */
@SpringBootApplication
@EnableEurekaClient // 本服务启动之后会自动注册进Eureka中
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker // //对hystrix 熔断机制的支持
public class DeptProviderHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001.class,args);
    }

    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/actuator/hystrix.stream");
        return registration;
    }

}
