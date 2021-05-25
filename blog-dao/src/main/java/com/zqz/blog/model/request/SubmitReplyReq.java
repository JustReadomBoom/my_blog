package com.zqz.blog.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 14:19 2021/5/25
 */
@Data
public class SubmitReplyReq implements Serializable {

    private static final long serialVersionUID = -8135148677452597027L;

    private Integer reviewId;

    private Integer replyerId;

    private String content;
}
