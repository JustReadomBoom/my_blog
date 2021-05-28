package com.zqz.blog.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 15:06 2021/5/24
 */
@Data
public class GetBlogByIdResp implements Serializable {

    private static final long serialVersionUID = -4897165933789894319L;

    private Integer blogId;

    private String title;

    private String content;

    private Integer likeNum;

    private Integer lookNum;

    private Integer reviewNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

}
