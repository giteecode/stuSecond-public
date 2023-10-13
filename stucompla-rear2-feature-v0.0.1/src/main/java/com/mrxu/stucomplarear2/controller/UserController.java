package com.mrxu.stucomplarear2.controller;

import com.mrxu.stucomplarear2.dto.LoginDto;
import com.mrxu.stucomplarear2.dto.RegisterDto;
import com.mrxu.stucomplarear2.dto.UserEditDto;
import com.mrxu.stucomplarear2.dto.UserFindDto;
import com.mrxu.stucomplarear2.entity.User;
import com.mrxu.stucomplarear2.service.UserService;
import com.mrxu.stucomplarear2.utils.jwt.JWTUtil;
import com.mrxu.stucomplarear2.utils.redis.RedisUtil;
import com.mrxu.stucomplarear2.utils.response.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("注册")
    @PostMapping("/register")
    public Object register(@RequestBody RegisterDto registerDto) {
        //初始化返回值
        String regResult = userService.register(registerDto);
        if (regResult.equals("注册成功")) {
            return Result.succ(200, regResult, null);
        } else {
            return Result.fail(regResult);
        }
    }

    @ApiOperation("修改密码")
    @RequiresRoles("user")
    @PostMapping("/changePassword")
    public Result changePassword(String oldPassword, String inPassword, String secondPassword, ServletRequest request) {
        String regResult = userService.changePassword(request, oldPassword, inPassword, secondPassword);
        if (regResult.equals("密码修改成功")) {
            return Result.succ(200, regResult, null);
        } else {
            return Result.fail(regResult);
        }
    }

    @ApiOperation("重置用户密码")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @PostMapping("/changePwdByAdmin")
    public Result changePwdByAdmin(String newPassword, String secondPassword, Integer userId) {
        Result result = userService.changePwdByAdmin(newPassword, secondPassword, userId);
        return result;
    }

    @ApiOperation("锁定用户")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @PostMapping("/lockedUser")
    public Result lockedUser(Integer userId, String cause) {
        Result result = userService.lockedUser(userId, cause);
        return result;
    }

    @ApiOperation("解锁用户")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @PostMapping("/unLockUser")
    public Result unLockUser(Integer userId) {
        Result result = userService.unLockUser(userId);
        return result;
    }

    @ApiOperation("编辑个人信息")
    @RequiresRoles("user")
    @PostMapping("/editUserInfo")
    public Result editUserInfo(@RequestBody UserEditDto userEditDto, HttpServletRequest request) {
        Result result = userService.editUserInfo(userEditDto, request);
        return result;
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto, ServletResponse response) {
        // 查询数据库获取用户信息
        User userFromDb = userService.getUserByUsername(loginDto.getUsername());
        // 用户不存在
        if (userFromDb == null) {
            return Result.fail("用户不存在！");
//            throw new UnknownAccountException("用户不存在！");
        }
        // 用户被锁定
        if (userFromDb.getLocked()) {
            return Result.fail("该用户已被锁定,暂时无法登录！请联系管理员1452162669@qq.com");
//            throw new LockedAccountException("该用户已被锁定,暂时无法登录！");
        }
        String inPassword = loginDto.getPassword()/*String.valueOf(new SimpleHash("SHA-1",
                loginDto.getPassword(), //输入的原始密码
                userFromDb.getUserId().toString(),//用户Id当盐值
                16))*/;
        if (!inPassword.equals(userFromDb.getPassword())) {
            return Result.fail("用户名或密码错误！");
//            throw new IllegalArgumentException("用户名或密码错误！");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String token = JWTUtil.createToken(String.valueOf(userFromDb.getUserId()), currentTimeMillis, "User");
        redisUtil.set("User" + userFromDb.getUserId(), currentTimeMillis, 60 * 30);//redis里存30分钟
        ((HttpServletResponse) response).setHeader("Authorization", token);
        ((HttpServletResponse) response).setHeader("Access-Control-Expose-Headers", "Authorization");//前端可以拿到这个响应头
        return Result.succ(200, "登陆成功", token);
    }

    @ApiOperation("无权限")
    @GetMapping(path = "/unauthorized/{message}")
    public Result unauthorized(@PathVariable String message) {
        return Result.fail(message);
    }

    @ApiOperation("登出")
    @DeleteMapping("/logout")
    @RequiresAuthentication
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String userId = JWTUtil.getUserId(token);
        redisUtil.del(userId);
        return Result.succ("退出成功");
    }

    @ApiOperation("获取用户列表")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/list")
    public Result listUser(UserFindDto userFindDto) {
        Map<String, Object> map = userService.findUserList(userFindDto);
        return Result.succ(map);
    }

    @ApiOperation("获取用户总数")
    @RequiresRoles(value = {"admin", "super"}, logical = Logical.OR)
    @GetMapping("/getUserTotal")
    public Result getUserTotal() {
        Result result = userService.getUserTotal();
        return result;
    }

    @ApiOperation("获取个人信息")
    @RequiresRoles("user")
    @GetMapping("/info")
    public Result getInfo(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        String userId = JWTUtil.getUserId(jwt);
        User user = userService.getUserByUserId(userId);
        if (user == null) {
            return Result.fail("用户不存在");
        }
        return Result.succ(user);
    }

}
