package com.guavapay.userms.service;

import com.guavapay.userms.dto.request.UserReqDto;
import com.guavapay.userms.exception.ExistingEmailException;
import com.guavapay.userms.mapper.UserMapper;
import com.guavapay.userms.repo.UserRepo;
import com.guavapay.userms.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepo userRepo;
    @Mock
    UserMapper userMapper;

    @Test
    void createUser() {

        when(userRepo.existsByEmail("a@a.com")).thenReturn(true);
        assertThrows(ExistingEmailException.class, () -> userService.createUser(UserReqDto.builder().email("a@a.com").build()));
    }
}
