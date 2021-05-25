package com.zqz.blog.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:18 2021/5/24
 */
@Data
public class ReplyDataResp implements Serializable {
    private static final long serialVersionUID = -2371787767358201745L;

    private String replyerName;

    private String reviewerName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private String content;
}
