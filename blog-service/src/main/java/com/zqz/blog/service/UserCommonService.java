package com.zqz.blog.service;

import com.zqz.blog.entity.User;
import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.LoginReq;
import com.zqz.blog.model.request.UpdateUserReq;
import com.zqz.blog.model.response.GetUserResp;
import com.zqz.blog.model.response.LoginResp;
import com.zqz.blog.model.response.WebResp;
import com.zqz.blog.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:15 2021/5/21
 */
@Service
@Slf4j
public class UserCommonService {
    @Autowired
    private UserService userService;

    public WebResp<LoginResp> doLogin(LoginReq req){
        String userName = req.getUserName();
        String pwd = req.getPwd();
        log.info("-----> do login, userName:[{}], pwd:[{}]", userName, pwd);

        User user = userService.getUserByUserName(userName);

        if(null == user){
            return new WebResp<>(RespEnum.RE_03);
        }

        LoginResp loginResp = new LoginResp();
        String password = user.getPassword();

        String md5Pwd = MD5Util.Md5(pwd, 32);
        if(StringUtils.isBlank(md5Pwd) || !md5Pwd.equals(password)){
            return new WebResp<>(RespEnum.RE_04);
        }
        loginResp.setLoginName(StringUtils.isBlank(user.getNickName()) ? userName : user.getNickName());
        loginResp.setLoginId(user.getId());
        return new WebResp<>(loginResp);
    }

    public WebResp<GetUserResp> doGetUserInfo(Integer userId) {
        User user = userService.getUserById(userId);

        if(null == user){
            log.info("User is not exist, id = [{}]", userId);
            return new WebResp<>(RespEnum.RE_03);
        }

        GetUserResp userResp = new GetUserResp();
        userResp.setUserName(user.getUserName());
        userResp.setNickName(user.getNickName());
        userResp.setAge(user.getAge());
        userResp.setMobile(user.getMobile());
        userResp.setEmail(user.getEmail());
        userResp.setPhotoUrl(user.getPhotoUrl());
        userResp.setSex(user.getSex());

        return new WebResp<>(userResp);
    }

    public WebResp doUpdateUser(UpdateUserReq req) {
        Integer userId = req.getUserId();

        User user = new User();
        user.setId(userId);
        user.setNickName(req.getNickName());
        user.setSex(req.getSex());
        user.setAge(req.getAge());
        user.setMobile(req.getMobile());
        user.setEmail(req.getEmail());

        userService.updateUser(user);

        return new WebResp();
    }
}
