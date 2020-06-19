package com.endeavor.demo.pojo;

import lombok.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户模型")
public class User{
    @ApiModelProperty(value = "用户ID")
    private int id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
