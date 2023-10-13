package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class OrderAddDto {
    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 购买数量
     */
    private Integer buyCount;

}
