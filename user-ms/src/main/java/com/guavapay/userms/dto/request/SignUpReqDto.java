package com.guavapay.userms.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SignUpReqDto {
    @NotBlank
    private String email;

    @Size(min = 8)
    @NotNull
    private String password;
}
