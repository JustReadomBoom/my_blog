package com.zqz.blog.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 10:50 2021/5/24
 */
@Data
public class BlogListDTO implements Serializable {
    private static final long serialVersionUID = 4228397599690361798L;

    private Integer blogId;

    private String title;

    private Integer authId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private String tag;

    private Integer likeNum;

    private Integer reviewNum;

    private Integer lookNum;

    private String content;

    private String nickName;

    private String authImgUrl;

}
