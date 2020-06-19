package com.endeavor.demo.service.impl;

import com.endeavor.demo.dao.UserMapper;
import com.endeavor.demo.pojo.User;
import com.endeavor.demo.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class UserMapperImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public int insertUser(User user) {
        userMapper.insertUser(user);
        return user.getId();
    }
}
