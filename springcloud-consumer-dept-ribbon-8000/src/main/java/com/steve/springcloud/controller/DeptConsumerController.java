package com.steve.springcloud.controller;

import com.steve.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: 消费端控制器
 * @since: 2023/12/22
 */
@RestController
public class DeptConsumerController {

    // 使用RestTemplate访问restful接口非常的简单粗暴且无脑
    // （url，requestMap，ResponseBean.class） 这三个参数分别代表
    // REST请求地址，请求参数，Http响应转换 被 转换成的对象类型
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public int add(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Integer.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @GetMapping("/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }

}
