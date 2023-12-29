package com.steve.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.steve.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: STEVE
 * @Description: Mapper - 部门
 * @since: 2023/12/21
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
