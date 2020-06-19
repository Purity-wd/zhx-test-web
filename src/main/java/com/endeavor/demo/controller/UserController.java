package com.endeavor.demo.controller;

import com.endeavor.demo.dao.*;
import com.endeavor.demo.pojo.Role;
import com.endeavor.demo.pojo.User;
import com.endeavor.demo.pojo.UserDepartment;
import com.endeavor.demo.pojo.UserRole;
import com.endeavor.demo.pojo.Vo.UserVo;
import com.endeavor.demo.service.DepartmentService;
import com.endeavor.demo.service.RoleService;
import com.endeavor.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(value = "用户接口",tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Autowired
    private DepartmentService departmentService;
    @Resource
    private UserDepartmentMapper userDepartmentMapper;
    @Autowired
    private RoleService roleService;
    @Resource
    private UserRoleMapper userRoleMapper;


    @PostMapping("add")
    @ApiOperation(value = "添加用户信息接口", nickname = "把User添加")
    public String add(@RequestParam User user,@RequestParam UserDepartment userDepartment, @RequestParam Role role){

        int uid = userService.insertUser(user);
        logger.info("用户ID查找成功");
        userDepartment.setUserId(user.getId());
        userDepartmentMapper.insert(userDepartment);
        logger.info("用户部门中间表新增成功");
        roleMapper.insert(role);
        logger.info("角色表新增成功");
        int roleId = roleService.findRoleId(role.getName());
        UserRole userRole = new UserRole();
        userRole.setId(uid);
        userRole.setRoleId(roleId);
        userRoleMapper.insert(userRole);
        logger.info("用户角色表新增成功");
        return "用户新增成功";
    }


    @Transactional
    @PostMapping("add1")
    @ApiOperation(value = "添加用户信息接口", nickname = "把User添加")
    public String add1(@RequestBody UserVo userVo){

        return userService.addUser(userVo);
    }
}