package com.zqz.blog.service;

import com.zqz.blog.entity.User;
import com.zqz.blog.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:04 2021/5/21
 */
@Service
public class UserService {
    @Resource
    private UserMapper mapper;

    public int insert(User user){
        return mapper.insert(user);
    }

    public User getUserByUserName(String userName) {
        return mapper.getUserByUserName(userName);
    }

    public List<User> getUsers() {
        return mapper.getUsers();
    }

    public User getUserById(Integer authId) {
        return mapper.getUserById(authId);
    }
}
