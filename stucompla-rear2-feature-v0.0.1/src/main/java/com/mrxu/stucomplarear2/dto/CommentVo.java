package com.mrxu.stucomplarear2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrxu.stucomplarear2.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {

    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 内容
     */
    private String text;

    /**
     * 图片
     */
    private String images;

    /**
     * 帖子ID
     */
    private Integer postId;
    private PostVo postVo;

    /**
     * 父评论ID
     */
    private CommentVo parentCommentVo;

    /**
     * 评论人ID
     */
    private Integer userId;
    private User user;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;}
