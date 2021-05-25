package com.zqz.blog.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 11:28 2021/5/25
 */
@Data
public class SubmitReviewReq implements Serializable {

    private static final long serialVersionUID = 5856665032066627923L;

    private Integer reviewerId;

    private Integer blogId;

    private String content;
}
