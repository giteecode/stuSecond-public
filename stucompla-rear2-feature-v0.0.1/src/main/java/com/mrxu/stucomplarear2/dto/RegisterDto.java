package com.mrxu.stucomplarear2.dto;

import lombok.Data;

@Data
public class RegisterDto {

    private String username;
    private String password;
    private String secondPassword;
    private String sex;
}