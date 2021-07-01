package com.zqz.blog.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:06 2021/6/29
 */
@Data
public class RegisterReq implements Serializable {
    private static final long serialVersionUID = -6658464930161850165L;

    private String userName;

    private String pwd;

    private String rePwd;
}
