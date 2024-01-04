package com.steve.springcloud.service.impl;

import com.steve.springcloud.dao.DeptDao;
import com.steve.springcloud.pojo.Dept;
import com.steve.springcloud.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: 服务实现 - 部门
 * @since: 2023/12/21
 */
@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

    private final DeptDao deptDao;

    @Override
    public int addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

}
