package com.zqz.blog.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 16:36 2021/5/21
 */
@Data
public class BlogListResp implements Serializable {
    private static final long serialVersionUID = 8575196783169679015L;

    private List<BlogListDTO> blogList;

}
