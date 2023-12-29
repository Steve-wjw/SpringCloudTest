package com.steve.springcloud.dao;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.steve.springcloud.mapper.DeptMapper;
import com.steve.springcloud.pojo.Dept;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: STEVE
 * @Description: DAO - 部门
 * @since: 2023/12/21
 */
@Repository
@RequiredArgsConstructor
public class DeptDao {

    private final DeptMapper deptMapper;

    /**
     * 增加部门
     *
     * @param dept 部门
     * @return
     */
    public int addDept(Dept dept) {
        return deptMapper.insert(dept);
    }

    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    public Dept queryById(Long id) {
        return deptMapper.selectById(id);
    }

    /**
     * 查询所有部门
     *
     * @return
     */
    public List<Dept> queryAll() {
        return new LambdaQueryChainWrapper<>(deptMapper).list();
    }

}
