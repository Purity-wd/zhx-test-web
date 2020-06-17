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
    public boolean insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public boolean updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public int findIdByName(String name) {
        return roleMapper.findIdByName(name);
    }
}
