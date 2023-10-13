package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class GoodsFindDto {

    /**
     * 二手商品id
     */
    private Integer goodsId;

    /**
     * 查询关键词
     */
    private String keyName;

    /**
     * 二手商品分类id
     */
    private Integer goodsCategoryId;

    /**
     * 二手商品上架状态：0-下架 1-上架
     */
    private Boolean goodsStatus;

    
    /**
     * 发布人id
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
