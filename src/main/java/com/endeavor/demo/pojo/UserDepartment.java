package com.endeavor.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "中间表模型")
public class UserDepartment{
    @ApiModelProperty(value = "中间表ID")
    private int id;
    @ApiModelProperty(value = "部门ID")
    private int deptId;
    @ApiModelProperty(value = "用户ID")
    private int userId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更改时间")
    private Date updatetime;

}



