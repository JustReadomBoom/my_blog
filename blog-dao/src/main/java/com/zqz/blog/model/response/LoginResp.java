package com.zqz.blog.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 11:19 2021/5/25
 */
@Data
public class LoginResp implements Serializable {

    private static final long serialVersionUID = 1370547452420995777L;

    private String loginName;

    private Integer loginId;
}
