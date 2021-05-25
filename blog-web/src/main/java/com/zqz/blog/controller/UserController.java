package com.zqz.blog.controller;

import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.LoginReq;
import com.zqz.blog.model.response.LoginResp;
import com.zqz.blog.model.response.WebResp;
import com.zqz.blog.service.UserCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:07 2021/5/21
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserCommonService userCommonService;

    @PostMapping("/login")
    public WebResp<LoginResp> login(@RequestBody LoginReq req){
        try{
            return userCommonService.doLogin(req);
        }catch (Exception e){
            log.error("login error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }
}
