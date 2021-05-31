package com.zqz.blog.controller;

import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.SubmitBlogReq;
import com.zqz.blog.model.request.SubmitReviewReq;
import com.zqz.blog.model.response.BlogListResp;
import com.zqz.blog.model.response.GetBlogByIdResp;
import com.zqz.blog.model.response.GetBlogByLoginIdResp;
import com.zqz.blog.model.response.WebResp;
import com.zqz.blog.service.BlogCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 16:40 2021/5/21
 */
@RestController
@RequestMapping("/blog")
@Slf4j
public class BlogController {
    @Autowired
    private BlogCommonService blogCommonService;

    @GetMapping("/getBlogList")
    public WebResp<BlogListResp> getBlogList() {
        try {
            return blogCommonService.doGetBlogList();
        } catch (Exception e) {
            log.error("getBlogList error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

    @GetMapping("/getBlogByBlogId")
    public WebResp<GetBlogByIdResp> getBlogByBlogId(@RequestParam("blogId") Integer blogId) {
        try {
            return blogCommonService.doGetBlogByBlogId(blogId);
        } catch (Exception e) {
            log.error("getBlogByBlogId error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

    @GetMapping("/updateNum")
    public WebResp updateNum(@RequestParam("blogId") Integer blogId,
                             @RequestParam("type") Integer type) {
        try {
            return blogCommonService.doUpdateNum(blogId, type);
        } catch (Exception e) {
            log.error("updateNum error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }


    @PostMapping("/submitBlog")
    public WebResp submitBlog(@RequestBody SubmitBlogReq req) {
        try {
            return blogCommonService.doSubmitBlog(req);
        } catch (Exception e) {
            log.error("submitBlog error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }


    @GetMapping("/getBlogByLoginId")
    public WebResp<GetBlogByLoginIdResp> getBlogByLoginId(@RequestParam("loginId") String loginId) {
        try {
            return blogCommonService.doGetBlogByLoginId(loginId);
        } catch (Exception e) {
            log.error("getBlogByLoginId error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

}
