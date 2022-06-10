package com.guavapay.userms.controller;

import com.guavapay.userms.dto.request.SignInReqDto;
import com.guavapay.userms.dto.request.SignUpReqDto;
import com.guavapay.userms.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/signin")
    public ResponseEntity signin(@Valid @RequestBody SignInReqDto signInReqDto) {
        authService.sigin(signInReqDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody SignUpReqDto signUpReqDto) {
        authService.signup(signUpReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signup/courier")
    public ResponseEntity courierSignup(@Valid @RequestBody SignUpReqDto signUpReqDto,
                                        @RequestHeader("Authorization") @NotNull String authorizationHeader) {

        authService.signupCourier(signUpReqDto, authorizationHeader);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
