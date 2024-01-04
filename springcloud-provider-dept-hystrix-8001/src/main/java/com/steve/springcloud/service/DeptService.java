package com.steve.springcloud.service;

import com.steve.springcloud.pojo.Dept;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: 服务接口 - 部门
 * @since: 2023/12/21
 */
public interface DeptService {

    /**
     * 添加一个部门
     *
     * @param dept
     * @return
     */
    int addDept(Dept dept);

    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    Dept queryById(Long id);

    /**
     * 查询所有部门
     *
     * @return
     */
    List<Dept> queryAll();

}
