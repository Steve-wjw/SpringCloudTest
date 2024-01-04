package com.steve.springcloud.service;

import com.steve.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: 部门客户端服务
 * @since: 2024/1/3
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept queryById(@PathVariable("id") Long id); //根据id查询部门

    @GetMapping("/dept/list")
    List<Dept> queryAll(); //查询所有部门

    @PostMapping(value = "/dept/add")
    boolean addDept(Dept dept); //添加一个部门

}
