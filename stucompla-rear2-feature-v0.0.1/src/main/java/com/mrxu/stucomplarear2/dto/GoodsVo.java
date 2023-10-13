package com.mrxu.stucomplarear2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrxu.stucomplarear2.entity.GoodsCategory;
import com.mrxu.stucomplarear2.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class GoodsVo {
    /**
     * 二手商品id
     */
    private Integer goodsId;

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
    private GoodsCategory goodsCategory;

    /**
     * 二手商品数量
     */
    private Integer goodsCount;

    /**
     * 二手商品上架状态：0-下架 1-上架
     */
    private boolean goodsStatus;

    /**
     * 二手商品发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 二手商品信息更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 发布人id
     */
    private User user;

    /*
    点击数
     */
    private Integer viewNum;

}
