package com.endeavor.demo.dao;

import com.endeavor.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    boolean insertRole(Role role);
    boolean updateRole(Role role);
    int findIdByName(String name);
}
