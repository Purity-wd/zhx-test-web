package com.endeavor.demo.service;

import com.endeavor.demo.pojo.Role;

public interface RoleService {
    boolean insertRole(Role role);
    boolean updateRole(Role role);
    int findIdByName(String name);
}
