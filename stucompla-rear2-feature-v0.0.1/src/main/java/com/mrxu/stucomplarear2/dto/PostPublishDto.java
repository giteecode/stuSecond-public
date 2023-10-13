package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class PostPublishDto {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String detail;

    /**
     * 图片
     */
    private String images;

    /**
     * 种类ID
     */
    private Integer categoryId;

}
