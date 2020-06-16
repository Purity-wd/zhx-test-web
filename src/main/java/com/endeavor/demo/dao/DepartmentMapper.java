package com.endeavor.demo.dao;

import com.endeavor.demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {
    boolean insertDept(Department department);
    int findId(String type);
}
