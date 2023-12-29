package com.steve.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: STEVE
 * @Description: 自定义规则的Ribbon类
 * @since: 2023/12/29
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new SteveRandomRule();
    }

}
