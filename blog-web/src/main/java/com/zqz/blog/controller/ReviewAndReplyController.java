package com.zqz.blog.controller;

import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.SubmitReplyReq;
import com.zqz.blog.model.request.SubmitReviewReq;
import com.zqz.blog.model.response.ReviewAndReplyResp;
import com.zqz.blog.model.response.WebResp;
import com.zqz.blog.service.ReviewAndReplyCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:05 2021/5/24
 */
@RestController
@RequestMapping("/reviewAndReply")
@Slf4j
public class ReviewAndReplyController {

    @Autowired
    private ReviewAndReplyCommonService reviewAndReplyCommonService;

    @GetMapping("/getByBlogId")
    public WebResp<ReviewAndReplyResp> getByBlogId(@RequestParam("blogId") Integer blogId) {
        try {
            return reviewAndReplyCommonService.doGetByBlogId(blogId);
        } catch (Exception e) {
            log.error("getByBlogId error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

    @PostMapping("/submitReview")
    public WebResp submitReview(@RequestBody SubmitReviewReq req) {
        try {
            return reviewAndReplyCommonService.doSubmitReview(req);
        } catch (Exception e) {
            log.error("submitReview error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

    @PostMapping("submitReply")
    public WebResp submitReply(@RequestBody SubmitReplyReq req){
        try {
            return reviewAndReplyCommonService.doSubmitReply(req);
        } catch (Exception e) {
            log.error("submitReply error:[{}]", e.getMessage(), e);
            return new WebResp<>(RespEnum.RE_99);
        }
    }

}
