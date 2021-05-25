package com.zqz.blog.mapper;


import com.zqz.blog.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    User getUserByUserName(@Param("userName") String userName);

    List<User> getUsers();

    User getUserById(@Param("authId") Integer authId);
}