package com.endeavor.demo.controller;

import com.endeavor.demo.dao.DepartmentMapper;
import com.endeavor.demo.pojo.Department;
import com.endeavor.demo.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(value = "部门接口",tags = "部门接口")
@RestController
@RequestMapping("dept")
public class DepartmentController {
    @Resource
    private DepartmentMapper departmentMapper;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Resource
    private DepartmentService departmentService;

    @PostMapping("addDept")
    @ApiOperation(value = "添加用户信息接口", nickname = "把User添加")
    public String addDept(@RequestBody Department department, String type){
        int id = departmentService.findId(type);
        logger.info("");
        if ("总公司".equals(type))department.setParentId(1);
        else department.setParentId(id);
        int insert = departmentMapper.insert(department);
        return ""+insert;
    }

}
