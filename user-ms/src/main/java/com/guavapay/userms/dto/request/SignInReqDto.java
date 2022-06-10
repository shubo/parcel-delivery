package com.guavapay.userms.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignInReqDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
