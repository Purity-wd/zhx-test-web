package com.endeavor.demo.service;


import com.endeavor.demo.pojo.User;
import com.endeavor.demo.pojo.Vo.UserVo;


import java.util.HashMap;
import java.util.List;

public interface UserService {
    int insertUser(User user);

    String addUser(UserVo userVo);
}
