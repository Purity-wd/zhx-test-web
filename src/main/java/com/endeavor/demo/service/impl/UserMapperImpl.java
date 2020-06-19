package com.endeavor.demo.service.impl;

import com.endeavor.demo.dao.UserDepartmentMapper;
import com.endeavor.demo.dao.UserMapper;
import com.endeavor.demo.dao.UserRoleMapper;
import com.endeavor.demo.pojo.User;
import com.endeavor.demo.pojo.UserDepartment;
import com.endeavor.demo.pojo.UserRole;
import com.endeavor.demo.pojo.Vo.UserVo;
import com.endeavor.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class UserMapperImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserDepartmentMapper userDepartmentMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserService userService;


    @Override
    public int insertUser(User user) {
        userMapper.insertUser(user);
        return user.getId();
    }

    @Override
    public String addUser(UserVo userVo) {
        User user=new User();
        BeanUtils.copyProperties(userVo,user);
        int insert = userMapper.insertUser(user);
        userVo.setId(user.getId());
        if(insert>0&&userVo.getDeptId()!=null){
            logger.info("王大头是憨批");
            UserDepartment userDepartment=new UserDepartment();
            userDepartment.setUserId(userVo.getId());
            userDepartment.setDeptId(userVo.getDeptId());
            int insert1 = userDepartmentMapper.insert(userDepartment);
                if(insert1>0&&userVo.getRoleId()!=null){
                    UserRole userRole=new UserRole();
                    userRole.setRoleId(userVo.getRoleId());
                    userRole.setUserId(userVo.getId());
                    int insert2 = userRoleMapper.insert(userRole);
                    if (insert2>0)return "全部添加成功";
                }else {
                return  "添加用户角色表成功";
            }
        }
        else {
            return  "添加用户部门表成功";
        }
        return "添加用户成功";
    }

    @Override
    public List<Map<String, Object>> findSubordinate(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        if (userVo.getRoleId()!=0 && userVo.getDeptId()!=0){
            List<Map<String, Object>> map = userService.findSubordinate(userVo);
            return map;
        }else return null;
    }
}
