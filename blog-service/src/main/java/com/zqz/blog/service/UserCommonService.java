package com.zqz.blog.service;

import com.zqz.blog.entity.User;
import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.LoginReq;
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
}
