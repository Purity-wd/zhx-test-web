package com.endeavor.demo.controller;

import com.alibaba.fastjson.JSON;
import com.endeavor.demo.pojo.User;

import com.endeavor.demo.pojo.UserDepartment;
import com.endeavor.demo.service.DepartmentService;
import com.endeavor.demo.service.UserDepartmentService;
import com.endeavor.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDepartmentService userDepartmentService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("selectforid")
    @ApiOperation(value = "通过ID获取用户信息", nickname = "根据用户ID获取用户相关信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int")
    public String selectforid(int id){
        List<User> list = userService.selectforid(id);
        return JSON.toJSONString(list);
    }

    @PostMapping("selectAll")
    @ApiOperation(value = "获取用户所有信息接口", nickname = "直接获取user所有信息")
    public String selectAll(){
        List<User> list = userService.selectAll();
        return JSON.toJSONString(list);
    }

    @PostMapping("add")
    @ApiOperation(value = "添加用户信息接口", nickname = "把User添加")
    public int add(User user,String type){
        int userId = userService.add(user);
//        int deptId = departmentService.findId(type);
//        UserDepartment userDepartment = new UserDepartment();
//        userDepartment.setDeptId(deptId);
//        userDepartment.setUserId(userId);
//        boolean a = userDepartmentService.insert(userDepartment);
//        if (a) return "添加成功";
//        else return "添加失败";
        return userId;
    }

    @ApiOperation(value = "分页测试接口", nickname = "测试")
    @PostMapping("findList")
    public List<User> findList(int currPage){
        List<User> list = userService.findList((currPage-1)*4);
        return list;
    }

    @PostMapping("delete")
    @ApiOperation(value = "删除测试接口", nickname = "删除测试")
    public String deleteById(int id){
        boolean b = userService.deleteById(id);
        if (b) return "删除成功";
        else return "删除失败";
    }


}