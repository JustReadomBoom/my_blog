package com.zqz.blog.service;

import com.zqz.blog.entity.ReplyInfo;
import com.zqz.blog.entity.ReviewInfo;
import com.zqz.blog.entity.User;
import com.zqz.blog.enums.RespEnum;
import com.zqz.blog.model.request.SubmitReplyReq;
import com.zqz.blog.model.request.SubmitReviewReq;
import com.zqz.blog.model.response.ReplyDataResp;
import com.zqz.blog.model.response.ReviewAndReplyResp;
import com.zqz.blog.model.response.ReviewDataResp;
import com.zqz.blog.model.response.WebResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zqz
 * @Description:
 * @Date: Created in 17:13 2021/5/24
 */
@Service
@Slf4j
public class ReviewAndReplyCommonService {
    @Autowired
    private ReviewInfoService reviewInfoService;
    @Autowired
    private ReplyInfoService replyInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private BlogInfoService blogInfoService;


    public WebResp<ReviewAndReplyResp> doGetByBlogId(Integer blogId) {
        WebResp<ReviewAndReplyResp> resp = new WebResp<>();

        //查评论
        List<ReviewInfo> reviewInfos = reviewInfoService.getByBlogId(blogId);
        if (reviewInfos.isEmpty()) {
            return new WebResp<>(RespEnum.RE_05);
        }

        ReviewAndReplyResp reviewAndReplyResp = new ReviewAndReplyResp();
        List<ReviewDataResp> reviewDataRespList = new ArrayList<>();

        for (ReviewInfo reviewInfo : reviewInfos) {
            ReviewDataResp reviewDataResp = new ReviewDataResp();
            reviewDataResp.setReviewId(reviewInfo.getId());
            reviewDataResp.setReviewerName(reviewInfo.getReviewerName());
            reviewDataResp.setDate(reviewInfo.getcTime());
            reviewDataResp.setContent(reviewInfo.getContent());

            //查回复
            List<ReplyInfo> replyInfos = replyInfoService.getByReviewId(reviewInfo.getId());
            if (!replyInfos.isEmpty()) {
                List<ReplyDataResp> replyDataResps = new ArrayList<>();
                for (ReplyInfo replyInfo : replyInfos) {
                    ReplyDataResp replyDataResp = new ReplyDataResp();
                    replyDataResp.setReplyerName(replyInfo.getReplyerName());
                    replyDataResp.setDate(replyInfo.getcTime());
                    replyDataResp.setContent(replyInfo.getContent());
                    replyDataResp.setReviewerName(reviewInfo.getReviewerName());
                    replyDataResps.add(replyDataResp);
                }
                reviewDataResp.setReplyList(replyDataResps);
            }
            reviewDataRespList.add(reviewDataResp);

        }

        reviewAndReplyResp.setReviewList(reviewDataRespList);
        resp.setData(reviewAndReplyResp);
        return resp;
    }


    public WebResp doSubmitReview(SubmitReviewReq req) {
        Integer reviewerId = req.getReviewerId();
        Integer blogId = req.getBlogId();
        String content = req.getContent();

        User user = userService.getUserById(reviewerId);
        if (null == user) {
            log.info("User is not exist, id=[{}]", reviewerId);
            return new WebResp(RespEnum.RE_03);
        }

        ReviewInfo r = new ReviewInfo();
        r.setBlogId(blogId);
        r.setReviewerId(reviewerId);
        r.setDate(new Date());
        r.setReviewerName(StringUtils.isBlank(user.getNickName()) ? user.getUserName() : user.getNickName());
        r.setContent(content);

        int i = reviewInfoService.insert(r);
        if (i > 0) {
            //更新评论数量
            blogInfoService.addReviewNum(blogId);
            return new WebResp();
        }


        return new WebResp(RespEnum.RE_01);
    }

    public WebResp doSubmitReply(SubmitReplyReq req) {
        Integer reviewId = req.getReviewId();
        Integer userId = req.getReplyerId();
        String content = req.getContent();

        User user = userService.getUserById(userId);
        if (null == user) {
            log.info("User is not exist, id=[{}]", userId);
            return new WebResp(RespEnum.RE_03);
        }

        ReviewInfo reviewInfo = reviewInfoService.getById(reviewId);
        if (null == reviewInfo) {
            log.info("Review info is not exist, id=[{}]", reviewId);
            return new WebResp(RespEnum.RE_06);
        }

        ReplyInfo r = new ReplyInfo();
        r.setReviewId(reviewId);
        r.setReplyerId(userId);
        r.setDate(new Date());
        r.setReplyerName(StringUtils.isBlank(user.getNickName()) ? user.getUserName() : user.getNickName());
        r.setContent(content);

        int i = replyInfoService.insert(r);
        if (i > 0) {
            return new WebResp();
        }
        return new WebResp(RespEnum.RE_01);
    }
}
