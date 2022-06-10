package com.guavapay.userms.service;

import com.guavapay.userms.dto.request.UserReqDto;
import com.guavapay.userms.dto.response.UserResDto;
import com.guavapay.userms.enums.UserRole;

import java.util.List;

public interface UserService {
    void createUser(UserReqDto newUser);

    UserResDto getUser(Long userId);

    UserResDto getUserByEmail(String email);

    List<UserResDto> getUser(UserRole userRole, String authHeaderzxl);
}
