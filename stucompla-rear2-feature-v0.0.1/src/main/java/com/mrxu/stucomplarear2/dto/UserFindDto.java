package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class UserFindDto {

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
     * 状态 1锁定 0正常
     */
    private Integer status;

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
