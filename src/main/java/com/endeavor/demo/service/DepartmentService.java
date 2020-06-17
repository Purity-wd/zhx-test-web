package com.endeavor.demo.service;

import com.endeavor.demo.pojo.Department;

public interface DepartmentService {
    boolean insertDept(Department department);
    int findId(String type);
    boolean update(Department department);
}
