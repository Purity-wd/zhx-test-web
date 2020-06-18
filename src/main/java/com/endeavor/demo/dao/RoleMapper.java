package com.endeavor.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.endeavor.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;


public interface RoleMapper  extends BaseMapper<Role> {
    boolean insertRole(Role role);
    boolean updateRole(Role role);
    int findIdByName(String name);
}
