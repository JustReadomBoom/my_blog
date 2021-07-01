package com.zqz.blog.controller;

import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.LoginReq;
import com.zqz.blog.model.request.RegisterReq;
import com.zqz.blog.model.request.UpdateUserReq;
import com.zqz.blog.model.response.GetUserResp;
import com.zqz.blog.model.response.LoginResp;
import com.zqz.blog.model.response.UploadImgResp;
import com.zqz.blog.model.response.WebResp;
import com.zqz.blog.service.UserCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public WebResp<LoginResp> login(@RequestBody LoginReq req) {
        try {
            return userCommonService.doLogin(req);
        } catch (Exception e) {
            log.error("login error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

    @PostMapping("/register")
    public WebResp register(@RequestBody RegisterReq req) {
        try {
            return userCommonService.doRegister(req);
        } catch (Exception e) {
            log.error("register error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }


    @GetMapping("/getUserInfo")
    public WebResp<GetUserResp> getUserInfo(@RequestParam("userId") Integer userId) {
        try {
            return userCommonService.doGetUserInfo(userId);
        } catch (Exception e) {
            log.error("getUserInfo error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

    @PostMapping("/updateUser")
    public WebResp updateUser(@RequestBody UpdateUserReq req) {
        try {
            return userCommonService.doUpdateUser(req);
        } catch (Exception e) {
            log.error("updateUser error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

    @PostMapping("/uploadImg")
    public WebResp<UploadImgResp> uploadImg(@RequestParam MultipartFile file,
                                            @RequestParam("userId") Integer userId) {
        try {
            return userCommonService.doUploadImg(file, userId);
        } catch (Exception e) {
            log.error("uploadImg error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

}
