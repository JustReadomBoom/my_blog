package com.zqz.blog.service;

import com.alibaba.fastjson.JSON;
import com.zqz.blog.entity.BlogInfo;
import com.zqz.blog.entity.ReviewInfo;
import com.zqz.blog.entity.User;
import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.SubmitBlogReq;
import com.zqz.blog.model.request.SubmitReviewReq;
import com.zqz.blog.model.request.UpBlogDTO;
import com.zqz.blog.model.response.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 16:42 2021/5/21
 */
@Service
@Slf4j
public class BlogCommonService {
    @Autowired
    private BlogInfoService blogInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewInfoService reviewInfoService;

    public WebResp<BlogListResp> doGetBlogList() {
        BlogListResp resp = new BlogListResp();

        List<BlogInfo> blogs = blogInfoService.getBlogs();
        if (!blogs.isEmpty()) {
            List<BlogListDTO> blogList = new ArrayList<>();
            for (BlogInfo bi : blogs) {
                log.info("Blog:[{}]", JSON.toJSONString(bi));
                Integer authId = bi.getAuthId();
                BlogListDTO dto = new BlogListDTO();
                dto.setBlogId(bi.getId());
                dto.setTitle(bi.getTitle());
                dto.setAuthId(authId);
                dto.setDate(bi.getcTime());
                dto.setTag(bi.getTag());
                dto.setLikeNum(bi.getLikeNum());
                dto.setReviewNum(bi.getReviewNum());
                dto.setLookNum(bi.getLookNum());
                dto.setContent(bi.getContent());

                User u = userService.getUserById(authId);
                log.info("User:[{}]", JSON.toJSONString(u));
                dto.setNickName(Optional.of(u).map(User::getNickName).orElse(null));
                dto.setAuthImgUrl(Optional.of(u).map(User::getPhotoUrl).orElse(null));

                blogList.add(dto);
            }
            resp.setBlogList(blogList);
        } else {
            return new WebResp<>(RespEnum.RE_01);
        }
        return new WebResp<>(resp);
    }

    public WebResp<GetBlogByIdResp> doGetBlogByBlogId(Integer blogId) {
        WebResp<GetBlogByIdResp> resp = new WebResp<>();
        BlogInfo blog = blogInfoService.getBlogById(blogId);
        log.info("Blog:[{}]", JSON.toJSONString(blog));
        if (null == blog) {
            return new WebResp<>(RespEnum.RE_05);
        }

        GetBlogByIdResp blogByIdResp = new GetBlogByIdResp();
        blogByIdResp.setBlogId(blog.getId());
        blogByIdResp.setTitle(blog.getTitle());
        blogByIdResp.setContent(blog.getContent());
        blogByIdResp.setLikeNum(blog.getLikeNum());
        blogByIdResp.setLookNum(blog.getLookNum());
        blogByIdResp.setReviewNum(blog.getReviewNum());
        blogByIdResp.setDate(blog.getcTime());

        resp.setData(blogByIdResp);
        return resp;
    }

    public WebResp doUpdateNum(Integer blogId, Integer type) {
        BlogInfo blog = blogInfoService.getBlogById(blogId);
        if (null == blog) {
            throw new RuntimeException("Blog is not exist");
        }
        UpBlogDTO upBlogDTO = new UpBlogDTO();
        upBlogDTO.setBlogId(blogId);
        if (1 == type) {
            upBlogDTO.setLookNum(blog.getLookNum() + 1);
        } else {
            upBlogDTO.setLikeNum(blog.getLikeNum() + 1);
        }
        blogInfoService.updateById(upBlogDTO);
        return new WebResp();
    }

    public WebResp doSubmitBlog(SubmitBlogReq req) {
        Integer writerId = req.getWriterId();
        String blogTitle = req.getBlogTitle();
        String blogTag = req.getBlogTag();
        String blogContent = req.getBlogContent();

        User user = userService.getUserById(writerId);
        if (null == user) {
            log.info("User is not exist, id = [{}]", writerId);
            return new WebResp(RespEnum.RE_03);
        }

        BlogInfo b = new BlogInfo();
        b.setTitle(blogTitle);
        b.setAuthId(writerId);
        b.setTag(blogTag);
        b.setContent(blogContent);
        b.setDate(new Date());
        b.setLikeNum(0);
        b.setLookNum(0);
        b.setReviewNum(0);
        int i = blogInfoService.insert(b);
        if (i > 0) {
            return new WebResp();
        }
        return new WebResp(RespEnum.RE_01);
    }

    public WebResp<GetBlogByLoginIdResp> doGetBlogByLoginId(String loginId) {

        List<BlogInfo> blogs = blogInfoService.getBlogByLoginId(loginId);
        if(blogs.isEmpty()){
            return new WebResp<>(RespEnum.RE_05);
        }

        GetBlogByLoginIdResp resp = new GetBlogByLoginIdResp();

        List<GetBlogByIdResp> queryList = new ArrayList<>();

        for(BlogInfo b : blogs){
            GetBlogByIdResp blog = new GetBlogByIdResp();
            blog.setBlogId(b.getId());
            blog.setTitle(b.getTitle());
            blog.setContent(b.getContent());
            blog.setDate(b.getcTime());
            blog.setLookNum(b.getLookNum());
            blog.setLikeNum(b.getLikeNum());
            blog.setReviewNum(b.getReviewNum());
            queryList.add(blog);
        }
        resp.setBlogList(queryList);
        return new WebResp<>(resp);
    }
}
