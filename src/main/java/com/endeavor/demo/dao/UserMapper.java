package com.endeavor.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.endeavor.demo.pojo.User;
import com.endeavor.demo.pojo.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    int insertUser(User user);

    List<Map<String,Object>> findSubordinate(UserVo userVo);
}
