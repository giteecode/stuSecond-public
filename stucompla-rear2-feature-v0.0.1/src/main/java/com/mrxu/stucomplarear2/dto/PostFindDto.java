package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class PostFindDto {

    /**
     * 帖子ID
     */
    private Integer postId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String detail;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 点击数
     */
    private Integer viewNum;

    /**
     * 发布人ID
     */
    private Integer userId;

    /**
     * 种类ID
     */
    private Integer categoryId;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;

    private String sort;

    /**
     * 是否精帖
     */
    private Boolean bestPost;

    /**
     * 帖子状态
     */
    private Integer postStatus;
}
