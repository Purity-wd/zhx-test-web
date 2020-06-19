package com.endeavor.demo.pojo.Vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
@Data
public class UserVo {
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
    private Integer deptId;
    private Integer roleId;
}
