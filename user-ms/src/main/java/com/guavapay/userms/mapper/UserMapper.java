package com.guavapay.userms.mapper;

import com.guavapay.userms.dto.request.UserReqDto;
import com.guavapay.userms.dto.response.UserResDto;
import com.guavapay.userms.entity.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserEntity toUserEntity(UserReqDto userReqDto);

    UserResDto toUserResDto(UserEntity userEntity);

    List<UserResDto> toUserResDtoList(List<UserEntity> userEntities);
}
