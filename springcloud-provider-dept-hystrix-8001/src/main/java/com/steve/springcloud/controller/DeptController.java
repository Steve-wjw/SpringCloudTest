package com.steve.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    //一旦调用服务方法失败并抛出了错误信息后
    // 会自动调用HystrixCommand标注好的fallbackMethod调用类中指定方法
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if (dept==null){
            throw new RuntimeException("该id：" + id + "没有对应的的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return Dept.builder()
                .deptNo(id)
                .dname("该id：" + id + "没有对应的信息，null--@HystrixCommand")
                .dbSource("no this database in MySQL").build();
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
