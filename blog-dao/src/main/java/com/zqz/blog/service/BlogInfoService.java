package com.zqz.blog.service;

import com.zqz.blog.entity.BlogInfo;
import com.zqz.blog.mapper.BlogInfoMapper;
import com.zqz.blog.model.request.UpBlogDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 16:44 2021/5/21
 */
@Service
public class BlogInfoService {
    @Resource
    private BlogInfoMapper mapper;

    public int insert(BlogInfo blogInfo){
        return mapper.insert(blogInfo);
    }

    public List<BlogInfo> getBlogs(){
        return mapper.getBlogs();
    }

    public BlogInfo getBlogById(Integer blogId) {
        return mapper.getBlogById(blogId);
    }

    public int updateById(UpBlogDTO upBlogDTO) {
        return mapper.updateById(upBlogDTO);
    }

    public List<BlogInfo> getBlogByLoginId(String loginId) {
        return mapper.getBlogByLoginId(loginId);
    }
}
