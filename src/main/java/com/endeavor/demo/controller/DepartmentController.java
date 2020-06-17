package com.endeavor.demo.controller;

import com.endeavor.demo.pojo.Department;
import com.endeavor.demo.pojo.UserDepartment;
import com.endeavor.demo.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "部门接口",tags = "部门接口")
@RestController
@RequestMapping("dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("insert")
    @ApiOperation(value = "添加部门信息接口", nickname = "把Department添加")
    public String insertDept(Department department){
        boolean a = departmentService.insertDept(department);
        if (a) return "添加成功";
        else return "添加失败";
    }

    @PostMapping("findId")
    @ApiOperation(value = "通过部门查找ID", nickname = "啊啊啊")
    public int findId(String type){
        int id = departmentService.findId(type);
        return id;
    }

    @PostMapping("update")
    @ApiOperation(value = "更改部门信息", nickname = "啊啊啊")
    public String update(Department department,String type){
        int id = departmentService.findId(type);
        department.setId(id);
        boolean update = departmentService.update(department);
        if (update) return "更改成功";
        else return "更改失败";
    }

}
