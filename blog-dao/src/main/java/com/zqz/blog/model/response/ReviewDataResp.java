package com.zqz.blog.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:15 2021/5/24
 */
@Data
public class ReviewDataResp implements Serializable {

    private static final long serialVersionUID = 2588021529898124073L;

    private Integer reviewId;

    private String reviewerName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    private String content;

    private List<ReplyDataResp> replyList;

}
