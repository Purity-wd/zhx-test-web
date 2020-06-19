package com.endeavor.demo.service.impl;

import com.endeavor.demo.controller.UserController;
import com.endeavor.demo.dao.UserDepartmentMapper;
import com.endeavor.demo.dao.UserMapper;
import com.endeavor.demo.pojo.User;
import com.endeavor.demo.pojo.UserDepartment;
import com.endeavor.demo.pojo.UserRole;
import com.endeavor.demo.pojo.Vo.UserVo;
import com.endeavor.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class UserMapperImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserDepartmentMapper userDepartmentMapper;


    @Override
    public int insertUser(User user) {
        userMapper.insertUser(user);
        return user.getId();
    }

    @Override
    public String addUser(UserVo userVo) {
        User user=new User();
        BeanUtils.copyProperties(userVo,user);
        int insert = userMapper.insert(user);
        if(insert>0&&userVo.getDeptId()!=null){
            logger.info("");
            UserDepartment userDepartment=new UserDepartment();
            userDepartment.setUserId(userVo.getId());
            userDepartment.setDeptId(userVo.getDeptId());
            int insert1 = userDepartmentMapper.insert(userDepartment);
            if(insert1>0&&userVo.getRoleId()!=null){
                UserRole userRole=new UserRole();
                userRole.setRoleId(userVo.getRoleId());
                userRole.setUserId(userVo.getId());
            }else {
                return  "添加成功";
            }
        }
        else {
            return  "添加成功";
        }
        return "添加成功";
    }
}
