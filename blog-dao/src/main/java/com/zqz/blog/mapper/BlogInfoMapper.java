package com.zqz.blog.mapper;

import com.zqz.blog.entity.BlogInfo;
import com.zqz.blog.model.request.UpBlogDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogInfoMapper {
    int insert(BlogInfo record);


    List<BlogInfo> getBlogs();

    BlogInfo getBlogById(@Param("blogId") Integer blogId);

    int updateById(UpBlogDTO upBlogDTO);

    List<BlogInfo> getBlogByLoginId(@Param("loginId") String loginId);

    int addReviewNum(@Param("blogId") Integer blogId);
}