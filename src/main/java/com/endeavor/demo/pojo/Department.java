package com.endeavor.demo.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "部门模型")
public class Department implements Serializable {
    private int id;
    private String type;
    private String name;
    private Date createTime;
    private Date updateTime;
}
