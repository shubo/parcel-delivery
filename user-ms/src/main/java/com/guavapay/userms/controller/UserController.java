package com.guavapay.userms.controller;

import com.guavapay.userms.dto.response.UserResDto;
import com.guavapay.userms.enums.UserRole;
import com.guavapay.userms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResDto> getUser(@PathVariable Long userId) {

        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/courier")
    public ResponseEntity<List<UserResDto>> getAllCouriers(@RequestHeader("Authorization") @NotNull String authorizationHeader) {

        return ResponseEntity.ok(userService.getUser(UserRole.COURIER, authorizationHeader));
    }
}
