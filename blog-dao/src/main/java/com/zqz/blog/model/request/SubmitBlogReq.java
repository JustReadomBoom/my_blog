package com.zqz.blog.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:31 2021/5/25
 */
@Data
public class SubmitBlogReq implements Serializable {

    private static final long serialVersionUID = 1603632660052136426L;

    private Integer writerId;

    private String blogTitle;

    private String blogTag;

    private String blogContent;
}
