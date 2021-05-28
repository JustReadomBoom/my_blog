package com.zqz.blog.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 10:24 2021/5/26
 */
@Data
public class GetUserResp implements Serializable {

    private static final long serialVersionUID = 7961815889038216635L;

    private String userName;

    private String nickName;

    private Integer age;

    private Integer sex;

    private String mobile;

    private String email;

    private String photoUrl;


}
