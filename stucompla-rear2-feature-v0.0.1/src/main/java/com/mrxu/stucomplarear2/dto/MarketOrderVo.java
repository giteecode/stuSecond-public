package com.mrxu.stucomplarear2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrxu.stucomplarear2.entity.Goods;
import com.mrxu.stucomplarear2.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class MarketOrderVo {

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 卖家信息
     */
    private User seller;

    /**
     * 买家信息
     */
    private User buyer;

    /**
     * 商品信息
     */
    private Integer goodsId;

    /**
     * 商品信息
     */
    private Goods goods;

    /**
     * 购买数量
     */
    private Integer buyCount;

    /**
     * 订单总价
     */
    private Double totalPrice;

    /**
     * 订单生成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 订单状态：0-未付 1-已付 2-已发货 3-已签收 4-已退货 5-订单完成
     */
    private Integer orderStatus;


    /**
     * 二手商品名称
     */
    private String goodsName;

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
}
