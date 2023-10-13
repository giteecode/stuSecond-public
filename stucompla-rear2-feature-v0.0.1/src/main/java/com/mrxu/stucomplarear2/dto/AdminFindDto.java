package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class AdminFindDto {
    /**
     * 管理员ID
     */
    private Integer adminId;

    /**
     * 账号
     */
    private String username;

    /**
     * 角色ID
     */
    private Integer roleId;

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
