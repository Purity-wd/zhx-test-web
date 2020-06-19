package com.endeavor.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.endeavor.demo.pojo.UserDepartment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDepartmentMapper extends BaseMapper<UserDepartment> {

}
