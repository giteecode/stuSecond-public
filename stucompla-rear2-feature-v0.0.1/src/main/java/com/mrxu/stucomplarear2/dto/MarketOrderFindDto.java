package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class MarketOrderFindDto {

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 卖家id
     */
    private Integer sellerId;

    /**
     * 买家id
     */
    private Integer buyerId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 订单状态：0-未付 1-已付 2-已发货 3-已签收 4-已退货 5-订单完成
     */
    private Integer orderStatus;

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
