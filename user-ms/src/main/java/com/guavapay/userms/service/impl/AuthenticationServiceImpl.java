package com.guavapay.userms.service.impl;

import com.guavapay.userms.dto.request.SignInReqDto;
import com.guavapay.userms.dto.request.SignUpReqDto;
import com.guavapay.userms.dto.request.UserReqDto;
import com.guavapay.userms.enums.UserRole;
import com.guavapay.userms.exception.InsufficientPrivilegesException;
import com.guavapay.userms.service.AuthenticationService;
import com.guavapay.userms.service.UserService;
import com.guavapay.userms.util.JwtUtil;
import com.guavapay.userms.util.constant.AuthConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void sigin(SignInReqDto signInReqDto) {

        var user = userService.getUserByEmail(signInReqDto.getEmail());
        log.info("signed in user: {}", user);
    }

    @Override
    public void signup(SignUpReqDto signUpReqDto) {
        createUser(signUpReqDto, UserRole.USER);
    }

    @Override
    public void signupCourier(SignUpReqDto signUpReqDto, String authHeader) {

        UserRole role = JwtUtil.getRoleByAuth(authHeader);
        if (role.equals(UserRole.ADMIN)) {

            createUser(signUpReqDto, UserRole.COURIER);
        } else {
            throw new InsufficientPrivilegesException();
        }
    }

    private void createUser(SignUpReqDto signUpReqDto, UserRole role) {

        UserReqDto userReqDto = UserReqDto.builder()
                .email(signUpReqDto.getEmail())
                .password(passwordEncoder.encode(signUpReqDto.getPassword()))
                .role(role)
                .build();

        log.info("Create User: {}", userReqDto);
        userService.createUser(userReqDto);
    }
}
