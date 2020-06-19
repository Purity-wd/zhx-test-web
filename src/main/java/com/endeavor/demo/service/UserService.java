package com.endeavor.demo.service;


import com.endeavor.demo.pojo.User;
import com.endeavor.demo.pojo.Vo.UserVo;

import java.util.List;
import java.util.Map;


public interface UserService {
    int insertUser(User user);

    String addUser(UserVo userVo);

    List<Map<String,Object>> findSubordinate(UserVo userVo);
}
