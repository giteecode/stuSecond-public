package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Integer postId;
    private Integer parentId;
    private String text;
    private String images;
}
