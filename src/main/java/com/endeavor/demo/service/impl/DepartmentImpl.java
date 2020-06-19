package com.endeavor.demo.service.impl;

import com.endeavor.demo.dao.DepartmentMapper;
import com.endeavor.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentImpl implements DepartmentService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int findId(String type) {
        return departmentMapper.findId(type);
    }
}
