package com.endeavor.demo.dao;

import com.endeavor.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface UserMapper {
    int add(User user);
    List<User> selectforid(int id);
    List<User> selectAll();
    List<User> findList(int currPage);
    boolean deleteById(int id);
    List<HashMap<String,Object>> findAllType(int currPage);
    boolean updateUser(User user);
    int findUserId(String username,String password);
}
