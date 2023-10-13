package com.mrxu.stucomplarear2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrxu.stucomplarear2.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class LetterVo {

    /**
     * 私信ID
     */
    private Integer letterId;

    /**
     * 接收方ID
     */
    private Integer receiverId;
    private User receiver;

    /**
     * 发送方ID
     */
    private Integer senderId;
    private User sender;


    /**
     * 私信内容
     */
    private String letterDetail;

    /**
     * 私信状态 0-未读 1-已读
     */
    private Integer letterStatus;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 双方对话的标识 用户ID小的在前 如“2_3”
     */
    private String sessionId;
}
