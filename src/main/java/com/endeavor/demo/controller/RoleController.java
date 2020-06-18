package com.endeavor.demo.controller;

import com.endeavor.demo.pojo.Role;
import com.endeavor.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "角色接口",tags = "角色接口")
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @PostMapping("insert")
    @ApiOperation(value = "添加角色接口", nickname = "添加角色接口")
    public String insert(@RequestBody Role role){
        logger.info("添加前");
        boolean a = roleService.insertRole(role);
        logger.info("添加后");
        if (a) return "添加角色成功";
        else return "添加角色失败";
    }

    @PostMapping("update")
    @ApiOperation(value = "更新角色接口", nickname = "更新角色接口")
    public String update(Role role,String name){
        int id = roleService.findIdByName(name);
        logger.info("更新前找到角色ID");
        role.setId(id);
        boolean a = roleService.updateRole(role);
        logger.info("更新后");
        if (a) return "更新角色成功";
        else return "更新角色失败";
    }
}
