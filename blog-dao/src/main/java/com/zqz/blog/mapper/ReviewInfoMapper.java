package com.zqz.blog.mapper;


import com.zqz.blog.entity.ReviewInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewInfoMapper {
    int insert(ReviewInfo record);

    List<ReviewInfo> getByBlogId(@Param("blogId") Integer blogId);

    ReviewInfo getById(@Param("id") Integer reviewId);
}