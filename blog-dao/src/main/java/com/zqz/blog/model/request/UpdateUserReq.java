package com.zqz.blog.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:27 2021/5/26
 */
@Data
public class UpdateUserReq implements Serializable {

    private static final long serialVersionUID = -9160356850972606355L;
    private Integer userId;
    private String nickName;
    private Integer sex;
    private Integer age;
    private String mobile;
    private String email;

}
