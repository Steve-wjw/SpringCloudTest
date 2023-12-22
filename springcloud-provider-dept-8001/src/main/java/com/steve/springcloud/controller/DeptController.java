package com.steve.springcloud.controller;

import com.steve.springcloud.pojo.Dept;
import com.steve.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: 控制器 - 部门
 * @since: 2023/12/21
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public int addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    @GetMapping("/discovery")
    public Object discovery() {
        // 获得微服务列表清单
        List<String> list = client.getServices();
        System.out.println("client.getServices()==>" + list);

        // 得到一个具体的微服务
        List<ServiceInstance> serviceInstanceList = client.getInstances("springcloud-provider-dept");

        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println(
                    serviceInstance.getServiceId()+"\t"+
                            serviceInstance.getHost()+"\t"+
                            serviceInstance.getPort()+"\t"+
                            serviceInstance.getUri()
            );
        }
        return this.client;
    }

}
