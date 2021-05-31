package com.zqz.blog.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 09:42 2021/5/31
 */
@Data
public class GetBlogByLoginIdResp implements Serializable {

    private static final long serialVersionUID = -3710381137929168083L;

    private List<GetBlogByIdResp> blogList;
}
