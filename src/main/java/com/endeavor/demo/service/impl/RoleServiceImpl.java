package com.endeavor.demo.service.impl;

import com.endeavor.demo.dao.RoleMapper;
import com.endeavor.demo.pojo.Role;
import com.endeavor.demo.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;


    @Override
    public int findRoleId(String name) {
        return roleMapper.findRoleId(name);
    }
}
