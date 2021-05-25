package com.zqz.blog.mapper;


import com.zqz.blog.entity.ReplyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyInfoMapper {
    int insert(ReplyInfo record);

    List<ReplyInfo> getByReviewId(@Param("reviewId") Integer reviewId);
}