package com.guavapay.orderms.mapper;

import com.guavapay.orderms.dto.request.OrderReqDto;
import com.guavapay.orderms.dto.response.OrderResDto;
import com.guavapay.orderms.entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity toEntity(OrderReqDto orderReqDto);

    List<OrderResDto> toResDto(List<OrderEntity> orderEntity);
}
