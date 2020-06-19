package com.endeavor.demo.service.impl;

import com.endeavor.demo.dao.UserDepartmentMapper;
import com.endeavor.demo.pojo.UserDepartment;
import com.endeavor.demo.service.UserDepartmentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserDepartmentImpl implements UserDepartmentService {
    @Resource
    private UserDepartmentMapper userDepartmentMapper;

}
