package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class CommentFindDto {

    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 内容
     */
    private String text;

    /**
     * 帖子ID
     */
    private Integer postId;

    /**
     * 评论人ID
     */
    private Integer userId;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;

    private String sort;
}
