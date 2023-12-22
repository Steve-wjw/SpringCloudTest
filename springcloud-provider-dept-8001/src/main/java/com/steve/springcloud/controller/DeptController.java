package com.steve.springcloud.controller;

import com.steve.springcloud.pojo.Dept;
import com.steve.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Future;
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

}
