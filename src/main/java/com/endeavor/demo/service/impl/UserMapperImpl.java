package com.endeavor.demo.service.impl;

import com.endeavor.demo.dao.UserMapper;
import com.endeavor.demo.pojo.User;
import com.endeavor.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserMapperImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        userMapper.add(user);
        return user.getId();
    }

    @Override
    public List<User> selectforid(int id) {
        return userMapper.selectforid(id);
    }


    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> findList(int currPage) {
        return userMapper.findList(currPage);
    }

    @Override
    public boolean deleteById(int id) {
        return userMapper.deleteById(id);
    }


}
