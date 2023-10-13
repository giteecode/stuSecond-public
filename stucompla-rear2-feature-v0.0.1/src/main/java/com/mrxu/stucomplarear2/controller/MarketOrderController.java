package com.mrxu.stucomplarear2.controller;


import com.mrxu.stucomplarear2.dto.MarketOrderFindDto;
import com.mrxu.stucomplarear2.dto.OrderAddDto;
import com.mrxu.stucomplarear2.service.MarketOrderService;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Xu
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/market-order")
public class MarketOrderController {
    @Resource
    private MarketOrderService marketOrderService;

    @ApiOperation("添加订单")
    @RequiresRoles("user")
    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody OrderAddDto orderAddDto, HttpServletRequest request) {
        Result result = marketOrderService.addOrder(orderAddDto, request);
        return result;
    }

//    @ApiOperation("删除订单")
//    @RequiresRoles("user")
//    @DeleteMapping("/{orderId}")
//    public Result deleteOrder(@PathVariable("orderId") Integer orderId, HttpServletRequest request) {
//        Result result = marketOrderService.deleteOrder(orderId, request);
//        return result;
//    }

    @ApiOperation("订单支付")
    @RequiresRoles("user")
    @PostMapping("/payOrder/{orderId}")
    public Result payOrder(@PathVariable("orderId") Integer orderId) {
        Result result = marketOrderService.payOrder(orderId);
        return result;
    }

    @ApiOperation("订单发货")
    @RequiresRoles("user")
    @GetMapping("/sendGoods/{orderId}")
    public Result sendGoods(@PathVariable("orderId") Integer orderId, HttpServletRequest request) {
        Result result = marketOrderService.sendGoods(orderId, request);
        return result;
    }

    @ApiOperation("订单签收")
    @RequiresRoles("user")
    @PostMapping("/receipt/{orderId}")
    public Result receipt(@PathVariable("orderId") Integer orderId, HttpServletRequest request) {
        Result result = marketOrderService.receipt(orderId, request);
        return result;
    }

    @ApiOperation("申请退货")
    @RequiresRoles("user")
    @PostMapping("/applyReturn/{orderId}")
    public Result applyReturn(@PathVariable("orderId") Integer orderId, HttpServletRequest request) {
        Result result = marketOrderService.applyReturn(orderId, request);
        return result;
    }

    @ApiOperation("审核退货")
    @RequiresRoles("user")
    @PostMapping("/auditReturn")
    public Result auditReturn(Integer orderId, Integer auditState, String cause, HttpServletRequest request) {
        Result result = marketOrderService.auditReturn(orderId, auditState, cause, request);
        return result;
    }

    @ApiOperation("获取我的订单")
    @RequiresRoles("user")
    @GetMapping("/myOrder")
    public Result getMyOrder(MarketOrderFindDto marketOrderFindDto, HttpServletRequest request) {
        Result result = marketOrderService.getMyOrder(marketOrderFindDto, request);
        return result;
    }

    @ApiOperation("获取我的销售订单")
    @RequiresRoles("user")
    @GetMapping("/mySalesOrders")
    public Result getMySalesOrders(MarketOrderFindDto marketOrderFindDto, HttpServletRequest request) {
        Result result = marketOrderService.getMySalesOrders(marketOrderFindDto, request);
        return result;
    }


    @ApiOperation("管理员获取订单列表")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/orderList")
    public Result getOrderList(MarketOrderFindDto marketOrderFindDto) {
        Result result = marketOrderService.getOrderList(marketOrderFindDto);
        return result;
    }


    @ApiOperation("获取订单总数")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/getOrderTotal")
    public Result getOrderTotal() {
        Result result = marketOrderService.getOrderTotal();
        return result;
    }


}
