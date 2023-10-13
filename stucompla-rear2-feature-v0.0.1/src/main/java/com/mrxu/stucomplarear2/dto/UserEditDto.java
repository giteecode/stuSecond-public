package com.mrxu.stucomplarear2.dto;


import lombok.Data;

@Data
public class UserEditDto {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 账号
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 个性签名
     */
    private String signature;
}
