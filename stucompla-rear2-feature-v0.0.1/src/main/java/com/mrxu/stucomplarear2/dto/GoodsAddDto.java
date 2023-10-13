package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class GoodsAddDto {

    /**
     * 二手商品名称
     */
    private String goodsName;

    /**
     * 二手商品详情
     */
    private String goodsDetail;

    /**
     * 二手商品图片
     */
    private String goodsImages;

    /**
     * 二手商品定价
     */
    private Double goodsPrice;

    /**
     * 二手商品分类id
     */
    private Integer goodsCategoryId;

    /**
     * 二手商品数量
     */
    private Integer goodsCount;

}
