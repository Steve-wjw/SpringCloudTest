package com.steve.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: STEVE
 * @Description: 实体类 - 部门
 * @since: 2023/12/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "dept", autoResultMap = true)
public class Dept implements Serializable {

    @TableId(value = "deptno", type = IdType.AUTO)
    private Long deptNo;

    @TableField("dname")
    private String dname;

    @TableField("db_source")
    private String dbSource;

    public Dept(String dname) {
        this.dname = dname;
    }

}
