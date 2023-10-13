package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class GoodsCategoryDto {
    private Integer categoryId;

    /**
     * 二手商品分类级别(1-一级分类 2-二级分类 3-三级分类)
     */
    private Integer categoryLevel;

    /**
     * 二手商品父分类id
     */
    private Integer parentId;

    /**
     * 二手商品分类名称
     */
    private String categoryName;

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
