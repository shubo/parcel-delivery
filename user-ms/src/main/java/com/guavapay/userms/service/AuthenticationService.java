package com.guavapay.userms.service;

import com.guavapay.userms.dto.request.SignInReqDto;
import com.guavapay.userms.dto.request.SignUpReqDto;

public interface AuthenticationService {

    void sigin(SignInReqDto signInReqDto);

    void signup(SignUpReqDto signUpReqDto);

    void signupCourier(SignUpReqDto signUpReqDto, String authHeader);
}
