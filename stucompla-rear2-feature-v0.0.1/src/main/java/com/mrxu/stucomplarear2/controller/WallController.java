package com.mrxu.stucomplarear2.controller;

import com.mrxu.stucomplarear2.dto.WallApplyDto;
import com.mrxu.stucomplarear2.dto.WallAuditDto;
import com.mrxu.stucomplarear2.dto.WallFindDto;
import com.mrxu.stucomplarear2.service.WallService;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Xu
 * @since 2021-12-15
 */
@RestController
@RequestMapping("/wall")
public class WallController {

    @Resource
    private WallService wallService;

    @ApiOperation("申请上墙")
    @RequiresRoles("user")
    @PostMapping("/apply")
    public Result apply(@RequestBody WallApplyDto wallApplyDto, HttpServletRequest request) {
        String applyResult = wallService.apply(wallApplyDto, request);
        if (applyResult.equals("申请成功")) {
            return Result.succ(200, applyResult, null);
        } else {
            return Result.fail(applyResult);
        }
    }

    @ApiOperation("上墙审核")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @PostMapping("/audit")
    public Result audit(@RequestBody WallAuditDto wallAuditDto, HttpServletRequest request) {
        String auditResult = wallService.audit(wallAuditDto, request);
        if (auditResult.equals("审核成功")) {
            return Result.succ(200, auditResult, null);
        }
        return Result.fail(auditResult);
    }

    @ApiOperation("墙列表（用户页面）")
//    @RequiresRoles("user")
    @GetMapping("/wallList")
    public Result wallList(Integer pageNum, Integer pageSize) {
        WallFindDto wallFindDto = new WallFindDto();
        wallFindDto.setAuditState(1);//已审核的内容
        wallFindDto.setPageNum(pageNum);
        wallFindDto.setPageSize(pageSize);
        Map<String, Object> map = wallService.findWall(wallFindDto);
        return Result.succ(map);
    }


    @ApiOperation("我的墙列表")
    @RequiresRoles("user")
    @GetMapping("/myWallList")
    public Result getmyWallList(Integer pageNum, Integer pageSize, HttpServletRequest request) {
        WallFindDto wallFindDto = new WallFindDto();
//        wallFindDto.setAuditState(1);//已审核的内容
        wallFindDto.setPageNum(pageNum);
        wallFindDto.setPageSize(pageSize);
        Result result = wallService.findMyWall(wallFindDto, request);
        return result;
    }


    @ApiOperation("获取表白墙总数")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/getWallTotal")
    public Result getWallTotal() {
        Result result = wallService.getWallTotal();
        return result;
    }


    @ApiOperation("表白墙分类统计")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/getWallData")
    public Result getWallData() {
        Result result = wallService.getWallData();
        return result;
    }

//
//    @ApiOperation("个人墙列表")
//    @RequiresRoles("user")
//    @GetMapping("/myWallList")
//    public Result myWallList(ServletRequest request, Integer auditState, Integer pageNum, Integer pageSize) {
//        HttpServletRequest req = (HttpServletRequest) request;
//        //获取传递过来的accessToken
//        String accessToken = req.getHeader("Authorization");
//        //获取token里面的用户ID
//        String userId = JWTUtil.getUserId(accessToken);
//
//        WallFindDto wallFindDto = new WallFindDto();
//        wallFindDto.setUserId(Integer.valueOf(userId));
//        wallFindDto.setAuditState(auditState);
//        wallFindDto.setPageNum(pageNum);
//        wallFindDto.setPageSize(pageSize);
//        Map<String, Object> map = wallService.findWall(wallFindDto);
//        return Result.succ(map);
//    }

    @ApiOperation("墙列表（管理员页面）")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/auditWallList")
    public Result auditWallList(WallFindDto wallFindDto) {
        Map<String, Object> map = wallService.findWall(wallFindDto);
        return Result.succ(map);
    }
}
