package com.mrxu.stucomplarear2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mrxu.stucomplarear2.dto.PostEditDto;
import com.mrxu.stucomplarear2.dto.PostFindDto;
import com.mrxu.stucomplarear2.dto.PostPublishDto;
import com.mrxu.stucomplarear2.dto.PostVo;
import com.mrxu.stucomplarear2.entity.Category;
import com.mrxu.stucomplarear2.entity.Post;
import com.mrxu.stucomplarear2.entity.User;
import com.mrxu.stucomplarear2.mapper.CategoryMapper;
import com.mrxu.stucomplarear2.mapper.UserMapper;
import com.mrxu.stucomplarear2.service.PostService;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Xu
 * @since 2021-12-27
 */
@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostService postService;

    @ApiOperation("发帖")
    @RequiresRoles("user")
    @PostMapping("/publish")
    public Result publish(HttpServletRequest request, @RequestBody PostPublishDto postDto) {
        //System.out.println(postDto);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", postDto.getCategoryId());
        if (categoryMapper.selectOne(queryWrapper) == null || postDto.getTitle().isEmpty() || postDto.getDetail().isEmpty()) {
            return Result.fail("参数错误");
        }
        if (postDto.getTitle().length() < 1 || postDto.getTitle().length() > 30) {
            return Result.fail("标题长度只能在1-30位");
        }
        postService.publishPost(request, postDto);
        return Result.succ(postDto);
    }

    @ApiOperation("修改帖子")
    @RequiresRoles("user")
    @PostMapping("/edit")
    public Result edit(HttpServletRequest request, @RequestBody PostEditDto postEditDto) {
        //System.out.println(postDto);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", postEditDto.getCategoryId());
        if (categoryMapper.selectOne(queryWrapper) == null || postEditDto.getTitle().isEmpty() || postEditDto.getDetail().isEmpty()) {
            return Result.fail("种类参数错误");
        }
        Result result = postService.editPost(request, postEditDto);
        return result;
    }

    @ApiOperation("用户删除帖子")
    @RequiresRoles("user")
    @DeleteMapping("/{postId}")
    public Result deleteMyPost(@PathVariable("postId") Integer postId, HttpServletRequest request) {
        Result result = postService.deleteMyPost(postId, request);
        return result;
    }

    @ApiOperation("管理员锁定帖子")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @PostMapping("/lockedPost")
    public Result lockedPost(Integer postId, String cause) {
        Result result = postService.lockedPost(postId, cause);
        return result;
    }

    @ApiOperation("解锁帖子")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @PostMapping("/unLockPost")
    public Result unLockPost(Integer postId) {
        Result result = postService.unLockPost(postId);
        return result;
    }

    @ApiOperation("管理员删除帖子")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @DeleteMapping("/deleteByAdmin")
    public Result deleteByAdmin(Integer postId, String cause) {
        Result result = postService.deleteByAdmin(postId, cause);
        return result;
    }

    @ApiOperation("帖子详情")
    @GetMapping("/{postId}")
    public Result getPost(@PathVariable("postId") Integer postId) {
        try {
            QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("post_id", postId);
            Post post = postService.getOne(queryWrapper);
            if (post == null) {
                return Result.fail("帖子不存在");
            }
            //这里还是交给前端处理，因为就算锁定了，按逻辑要给用户修改的权利
//            if (post.getPostStatus()==1) {
//                return Result.fail("该贴已被锁定，如需申诉请联系管理员1452162669@qq.com");
//            }
            post = postService.updateViewNum(post);
            PostVo postVo = new PostVo();
            BeanUtils.copyProperties(post, postVo);
            //查对应的发布人信息
            User user = userMapper.selectById(post.getUserId());
            postVo.setUser(user);
            //查对应的帖子类型信息
            Category category = categoryMapper.selectById(post.getCategoryId());
            postVo.setCategory(category);

            return Result.succ(postVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    @ApiOperation("获取帖子列表")
//    @RequiresRoles(value = {"admin", "super","user"}, logical = Logical.OR)
    @GetMapping("/list")
    public Result listPost(PostFindDto postFindDto) {
        Map<String, Object> map = postService.findPostList(postFindDto);
        return Result.succ(map);
    }
//
//    @ApiOperation("获取帖子收藏数量")
//    @GetMapping("/getCollectNum")
//    public Result getCollectNum(Integer postId) {
////        int collectNum = postService.getCollectNum(postId);
//        return null;
//    }

    @ApiOperation("获取帖子总数")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/getPostTotal")
    public Result getPostTotal() {
        Result result = postService.getPostTotal();
        return result;
    }

    @ApiOperation("帖子分类统计")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/getPostData")
    public Result getPostData() {
        Result result = postService.getPostData();
        return result;
    }


}
