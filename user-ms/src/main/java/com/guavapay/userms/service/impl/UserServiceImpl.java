package com.guavapay.userms.service.impl;

import com.guavapay.userms.dto.request.UserReqDto;
import com.guavapay.userms.dto.response.UserResDto;
import com.guavapay.userms.entity.UserEntity;
import com.guavapay.userms.enums.UserRole;
import com.guavapay.userms.exception.ExistingEmailException;
import com.guavapay.userms.exception.InsufficientPrivilegesException;
import com.guavapay.userms.exception.UserNotFoundException;
import com.guavapay.userms.mapper.UserMapper;
import com.guavapay.userms.repo.UserRepo;
import com.guavapay.userms.service.UserService;
import com.guavapay.userms.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public void createUser(UserReqDto userReqDto) {

        var user = new UserEntity();

        var existsByEmail = userRepo.existsByEmail(userReqDto.getEmail());
        if (existsByEmail) {
            throw new ExistingEmailException("This Email already using");
        }

        user = userMapper.toUserEntity(userReqDto);
        userRepo.save(user);
    }

    @Override
    public UserResDto getUser(Long userId) {

        log.info("Get User By Id: {}", userId);
        var user = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        var userRes = userMapper.toUserResDto(user);

        log.info("Mapped User Dto: {}", userRes);
        return userRes;
    }

    @Override
    public UserResDto getUserByEmail(String email) {

        log.info("Get User By Email: {}", email);
        var user = userRepo.findByEmail(email).orElseThrow(UserNotFoundException::new);
        var userRes = userMapper.toUserResDto(user);

        log.info("Mapped User Dto: {}", userRes);
        return userRes;
    }

    @Override
    public List<UserResDto> getUser(UserRole userRole, String authHeader) {

        log.info("Get Users By Role: {}", userRole);
        var currentUser = JwtUtil.getRoleByAuth(authHeader);
        if (currentUser.equals(UserRole.ADMIN)) {

            var userEntityList = userRepo.findAllByRole(userRole);
            var userDtos = userMapper.toUserResDtoList(userEntityList);
            return userDtos;
        } else {
            throw new InsufficientPrivilegesException();
        }
    }

}
