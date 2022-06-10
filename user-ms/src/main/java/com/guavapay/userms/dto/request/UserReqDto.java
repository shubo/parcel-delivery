package com.guavapay.userms.dto.request;

import com.guavapay.userms.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

    @NotBlank
    private String email;

    @Size(min = 8)
    @NotNull
    private String password;
    private UserRole role;
}
