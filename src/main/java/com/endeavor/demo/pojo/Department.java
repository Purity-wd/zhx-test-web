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
@ApiModel(value = "部门模型")
public class Department{
    @ApiModelProperty(value = "id")
    private int id;
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "所属总公司ID")
    private int parentId;

}
