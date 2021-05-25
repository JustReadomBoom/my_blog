package com.zqz.blog.service;

import com.zqz.blog.entity.ReplyInfo;
import com.zqz.blog.mapper.ReplyInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:03 2021/5/24
 */
@Service
public class ReplyInfoService {
    @Resource
    private ReplyInfoMapper mapper;

    public int insert(ReplyInfo info) {
        return mapper.insert(info);
    }

    public List<ReplyInfo> getByReviewId(Integer reviewId) {
        return mapper.getByReviewId(reviewId);
    }
}
