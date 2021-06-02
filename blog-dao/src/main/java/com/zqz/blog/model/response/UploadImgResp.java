package com.zqz.blog.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 11:31 2021/6/2
 */
@Data
public class UploadImgResp implements Serializable {
    private static final long serialVersionUID = 2403142604932761525L;

    private String imgUrl;
}
