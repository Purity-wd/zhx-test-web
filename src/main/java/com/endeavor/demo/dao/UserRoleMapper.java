package com.endeavor.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.endeavor.demo.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
