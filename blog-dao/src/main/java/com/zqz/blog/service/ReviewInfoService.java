package com.zqz.blog.service;

import com.zqz.blog.entity.ReviewInfo;
import com.zqz.blog.mapper.ReviewInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:02 2021/5/24
 */
@Service
public class ReviewInfoService {
    @Resource
    private ReviewInfoMapper mapper;

    public int insert(ReviewInfo info){
        return mapper.insert(info);
    }

    public List<ReviewInfo> getByBlogId(Integer blogId) {
        return mapper.getByBlogId(blogId);
    }

    public ReviewInfo getById(Integer reviewId) {
        return mapper.getById(reviewId);
    }
}
