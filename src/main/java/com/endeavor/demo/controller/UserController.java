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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Api(value = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserDepartmentService userDepartmentService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("selectforid")
    @ApiOperation(value = "通过ID获取用户信息", nickname = "根据用户ID获取用户相关信息")
    public String selectforid(int id){
        logger.info("添加之前");
        List<User> list = userService.selectforid(id);
        logger.info("添加成功");
        return JSON.toJSONString(list);
    }

    @PostMapping("selectAll")
    @ApiOperation(value = "获取用户所有信息接口", nickname = "直接获取user所有信息")
    public String selectAll(){
        logger.info("获取之前");
        List<User> list = userService.selectAll();
        logger.info("获取之后");
        return JSON.toJSONString(list);
    }

    @PostMapping("add")
    @ApiOperation(value = "添加用户信息接口", nickname = "把User添加")
    public String add( User user, String type){
        int userId = userService.add(user);
        int deptId = departmentService.findId(type);
        logger.info("获取用户部门id");
        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setDeptId(deptId);
        userDepartment.setUserId(userId);
        boolean a = userDepartmentService.insert(userDepartment);
        logger.info("新增成功");
        if (a) return "添加成功";
        else return "添加失败";
    }

    @ApiOperation(value = "用户分页测试接口", nickname = "测试")
    @PostMapping("findList")
    public List<User> findList(int currPage){
        logger.info("分页前");
        List<User> list = userService.findList((currPage-1)*4);
        logger.info("分页后");
        return list;
    }

    @PostMapping("findAllType")
    @ApiOperation(value = "显示用户部门分页测试接口", nickname = "测试")
    public String findAllType(int currPage){
        logger.info("分页前");
        List<HashMap<String, Object>> list = userService.findAllType((currPage-1)*4);
        logger.info("分页后");
        return JSON.toJSONString(list);
    }

    @PostMapping("update1")
    @ApiOperation(value = "用户更新测试接口", nickname = "测试")
    public String updateUser(User user,String userename,String password){
        int id = userService.findUserId(userename, password);
        logger.info("获取部门id");
        user.setId(id);
        boolean update = userService.updateUser(user);
        logger.info("修改成功");
        if (update) return "修改成功";
        else return "修改失败";
    }
    @PostMapping("delete")
    @ApiOperation(value = "用户删除测试接口", nickname = "测试")
    public String delete(String username,String password){
        int id = userService.findUserId(username, password);
        logger.info("获取部门ID");
        boolean b = userService.deleteById(id);
        boolean b1 = userDepartmentService.deleteMid(id);
        logger.info("删除用户和级联表中得数据");
        if (b & b1) return "删除成功";
        else return "删除失败";
    }
}