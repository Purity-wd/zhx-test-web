package com.endeavor.demo.service;


import com.endeavor.demo.pojo.User;


import java.util.HashMap;
import java.util.List;

public interface UserService {
    int add(User user);
    List<User> selectforid(int id);
    List<User> selectAll();
    List<User> findList(int currPage);
    boolean deleteById(int id);
    List<HashMap<String,Object>> findAllType(int currPage);
    boolean updateUser(User user);
    int findUserId(String username,String password);

}
