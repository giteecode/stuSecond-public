package com.mrxu.stucomplarear2.controller;


import com.mrxu.stucomplarear2.dto.CommentDto;
import com.mrxu.stucomplarear2.dto.CommentFindDto;
import com.mrxu.stucomplarear2.service.CommentService;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Xu
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("评论")
    @RequiresRoles("user")
    @PostMapping("/create")
    public Result createComment(HttpServletRequest request, @RequestBody CommentDto commentDto) {
        return commentService.createComment(request, commentDto);
    }

    @ApiOperation("用户删除评论")
    @RequiresRoles("user")
    @DeleteMapping("/{commentId}")
    public Result deleteCommentByUser(@PathVariable("commentId") Integer commentId, HttpServletRequest request) {
        return commentService.deleteCommentByUser(commentId, request);
    }

    @ApiOperation("管理员删除评论")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @DeleteMapping("deleteByAdmin")
    public Result deleteCommentByAdmin(Integer commentId, String cause) {
        return commentService.deleteCommentByAdmin(commentId, cause);
    }

    @ApiOperation("帖子的评论列表")
    @GetMapping("/list/{postId}/{page}/{size}")
    public Result listComment(@PathVariable("postId") Integer postId, @PathVariable("page") int page, @PathVariable("size") int size) {

        return commentService.listCommentFromPost(postId, page, size);
    }

    @ApiOperation("评论列表(管理员页面)")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/listByAdmin")
    public Result listCommentByAdmin(CommentFindDto commentFindDto) {
        return commentService.listComment(commentFindDto);
    }

    @ApiOperation("我的评论列表")
    @RequiresRoles("user")
    @GetMapping("/myList/{page}/{size}")
    public Result getMyList(@PathVariable("page") Integer page, @PathVariable("size") Integer size, HttpServletRequest request) {

        return commentService.getMyList(page, size, request);
    }

    @ApiOperation("获取评论总数")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/getCommentTotal")
    public Result getCommentTotal() {
        Result result = commentService.getCommentTotal();
        return result;
    }

}
