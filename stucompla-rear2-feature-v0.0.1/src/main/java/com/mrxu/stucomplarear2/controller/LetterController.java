package com.mrxu.stucomplarear2.controller;


import com.mrxu.stucomplarear2.dto.LetterAddDto;
import com.mrxu.stucomplarear2.service.LetterService;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
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
 * @since 2022-04-28
 */
@RestController
@RequestMapping("/letter")
public class LetterController {

    @Resource
    private LetterService letterService;

    @ApiOperation("发送私信")
    @RequiresRoles("user")
    @PostMapping("/send")
    public Result add(@RequestBody LetterAddDto letterAddDto, HttpServletRequest request) {
        Result result = letterService.add(letterAddDto, request);
        return result;
    }
//
//    @ApiOperation("系统发送通知")
//    @PostMapping("/sendNotice")
//    public Result addNotice(@RequestBody LetterAddDto letterAddDto) {
//        Result result = letterService.addNotice(letterAddDto);
//        return result;
//    }

    @ApiOperation("获取我的私信列表")
    @RequiresRoles("user")
    @PostMapping("/mySessionList")
    public Result getMySessionList(HttpServletRequest request) {
        Result result = letterService.getMySessionList(request);
        return result;
    }

    @ApiOperation("获取当前会话的私信列表")
    @RequiresRoles("user")
    @GetMapping("/letterList/{sessionId}")
    public Result getLetterListBySessionId(@PathVariable("sessionId") String sessionId, HttpServletRequest request) {
        Result result = letterService.getLetterListBySessionId(sessionId, request);
        return result;
    }

    @ApiOperation("获取我的通知列表")
    @RequiresRoles("user")
    @PostMapping("/myNoticeList")
    public Result getMyNoticeList(HttpServletRequest request) {
        Result result = letterService.getMyNoticeList(request);
        return result;
    }

    @ApiOperation("获取我的未读总数")
    @RequiresRoles("user")
    @PostMapping("/myUnReadTotal")
    public Result getMyUnReadTotal(HttpServletRequest request) {
        Result result = letterService.getMyUnReadTotal(request);
        return result;
    }

    @ApiOperation("获取我的私信未读数")
    @RequiresRoles("user")
    @PostMapping("/myUnReadLetterTotal")
    public Result getMyUnReadLetterTotal(HttpServletRequest request) {
        Result result = letterService.getMyUnReadLetterTotal(request);
        return result;
    }

    @ApiOperation("获取我的通知未读数")
    @RequiresRoles("user")
    @PostMapping("/myUnReadNoticeTotal")
    public Result getMyUnReadNoticeTotal(HttpServletRequest request) {
        Result result = letterService.getMyUnReadNoticeTotal(request);
        return result;
    }

}
