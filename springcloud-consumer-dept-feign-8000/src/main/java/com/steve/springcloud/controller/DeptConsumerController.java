package com.steve.springcloud.controller;

import com.steve.springcloud.pojo.Dept;
import com.steve.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: STEVE
 * @Description: 消费端控制器
 * @since: 2023/12/22
 */
@RestController
public class DeptConsumerController {

    @Resource
    private DeptClientService service;

    @RequestMapping("/consumer/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.service.queryById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return this.service.queryAll();
    }

}
