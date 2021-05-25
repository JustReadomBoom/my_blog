package com.zqz.blog.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:40 2021/5/24
 */
@Data
public class UpBlogDTO implements Serializable {

    private static final long serialVersionUID = 8409854350121494009L;
    private Integer blogId;

    private Integer likeNum;

    private Integer lookNum;

    private Integer reviewNum;
}
