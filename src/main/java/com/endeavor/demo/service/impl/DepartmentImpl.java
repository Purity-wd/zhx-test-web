package com.endeavor.demo.service.impl;

import com.endeavor.demo.dao.DepartmentMapper;
import com.endeavor.demo.pojo.Department;
import com.endeavor.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public boolean insertDept(Department department)
    {
        return departmentMapper.insertDept(department);
    }

    @Override
    public int findId(String type) {
        return departmentMapper.findId(type);
    }

    @Override
    public boolean update(Department department) {
        return departmentMapper.update(department);
    }
}
