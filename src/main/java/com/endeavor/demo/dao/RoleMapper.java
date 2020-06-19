package com.endeavor.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.endeavor.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleMapper  extends BaseMapper<Role> {
    int findRoleId(String name);
}
