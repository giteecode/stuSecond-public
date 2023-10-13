package com.mrxu.stucomplarear2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LetterAddDto {

    /**
     * 接收方ID
     */
    private Integer receiverId;

    /**
     * 私信内容
     */
    private String letterDetail;
}
