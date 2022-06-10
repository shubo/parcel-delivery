package com.guavapay.userms.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guavapay.userms.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResDto {
    private String email;
    private UserRole role;

    @JsonIgnore
    private String password;
}
