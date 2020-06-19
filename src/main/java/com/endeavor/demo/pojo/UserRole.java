package com.endeavor.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @ApiModelProperty(value = "id")
    private int id;
    @ApiModelProperty(value = "用户ID")
    private int userId;
    @ApiModelProperty(value = "角色ID")
    private int roleId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
