package com.mrxu.stucomplarear2.controller;


import com.mrxu.stucomplarear2.dto.GoodsCategoryDto;
import com.mrxu.stucomplarear2.service.GoodsCategoryService;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Xu
 * @since 2022-04-15
 */
@RestController
@RequestMapping("/goods-category")
public class GoodsCategoryController {
    @Resource
    private GoodsCategoryService goodsCategoryService;

    @ApiOperation("获取二手商品分类列表")
    @GetMapping("/list")
    public Result list(GoodsCategoryDto goodsCategoryDto) {
        Result result = goodsCategoryService.getGoodsCategoryList(goodsCategoryDto);
        return result;
    }

}
