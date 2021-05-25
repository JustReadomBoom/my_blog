package com.zqz.blog.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:14 2021/5/24
 */
@Data
public class ReviewAndReplyResp implements Serializable {
    private static final long serialVersionUID = 6120382405712485864L;

    private List<ReviewDataResp> reviewList;

}
