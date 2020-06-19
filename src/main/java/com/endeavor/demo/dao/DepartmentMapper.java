package com.endeavor.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.endeavor.demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    int findId(String type);
}
