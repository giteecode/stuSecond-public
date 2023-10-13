package com.mrxu.stucomplarear2.controller;


import com.alibaba.fastjson.JSONObject;
import com.mrxu.stucomplarear2.service.ImageService;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Xu
 * @since 2022-01-23
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * 关于图片（文件）上传
     * 一般来说，现在比较常用的是对象存储--->很简单，看文档就可以学会了
     * 使用 Nginx + fastDFS == > fastDFS -- > 处理文件上传， Nginx -- > 负责处理文件访问
     *
     * @param files
     * @return
     */
    @ApiOperation("上传图片")
    @RequiresRoles("user")
    @PostMapping("/upload")
    public String uploadImage(HttpServletRequest request, @RequestPart("files") MultipartFile[] files) {
        //使用@RequestPart -- 解决(Swagger 3.0.0)——【文件上传，接收file类型时显示string】

        Result uploadResult = imageService.uploadImage(request, files);
        return JSONObject.toJSONString(uploadResult);
    }

    @ApiOperation("显示图片")
    @GetMapping("/{imageId}")
    public void getImage(HttpServletResponse response, @PathVariable("imageId") String imageId) {
        try {
            imageService.viewImage(response, imageId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("图片列表")
    //@RequiresRoles("user")
    @GetMapping("/list/{page}/{size}")
    public Result listImages(@PathVariable("page") int page, @PathVariable("size") int size) {
        return imageService.listImages(page, size);
    }

    @ApiOperation("删除图片")
    //@RequiresRoles("user")
    @DeleteMapping("/{imageId}")
    public Result DeleteImage(@PathVariable("imageId") String imageId) {
        return imageService.deleteById(imageId);
    }
}
