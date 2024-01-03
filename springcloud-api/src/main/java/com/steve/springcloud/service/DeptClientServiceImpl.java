package com.steve.springcloud.service;

import cn.hutool.core.collection.CollUtil;
import com.steve.springcloud.pojo.Dept;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: FallBack的处理类
 * @since: 2024/1/3
 */
public class DeptClientServiceImpl implements DeptClientService {

    @Override
    public List<Dept> queryAll() {
        Dept dept = Dept.builder().dname("网络异常，请稍后再试...").build();
        return CollUtil.newArrayList(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return null;
    }

    @Override
    public boolean addDept(Dept dept) {
        return false;
    }

}
