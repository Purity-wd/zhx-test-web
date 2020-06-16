package com.endeavor.demo.dao;

import com.endeavor.demo.pojo.UserDepartment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDepartmentMapper {
    boolean insert(UserDepartment userDepartment);
}
