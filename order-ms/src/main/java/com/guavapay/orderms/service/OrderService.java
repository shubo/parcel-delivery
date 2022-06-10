package com.guavapay.orderms.service;

import com.guavapay.orderms.dto.request.AssignToCourierReqDto;
import com.guavapay.orderms.dto.request.OrderReqDto;
import com.guavapay.orderms.dto.response.OrderResDto;
import com.guavapay.orderms.entity.OrderEntity;
import com.guavapay.orderms.enums.OrderStatus;
import com.guavapay.orderms.enums.UserRole;
import com.guavapay.orderms.exception.InsufficientPrivilegesException;
import com.guavapay.orderms.exception.OrderNotFoundException;
import com.guavapay.orderms.mapper.OrderMapper;
import com.guavapay.orderms.repo.OrderRepo;
import com.guavapay.orderms.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    public void createOrder(OrderReqDto orderReqDto, String authHeader) {

        log.info("Create Order: {}", orderReqDto);
        var role = JwtUtil.getRoleByAuth(authHeader);
        log.info("Create Order With Role: {}", role);

        if (UserRole.USER.equals(role)) {
            orderReqDto.setStatus(OrderStatus.PENDING);
            var orderEntity = orderMapper.toEntity(orderReqDto);
            orderRepo.save(orderEntity);
        } else {
            throw new InsufficientPrivilegesException();
        }
    }

    public List<OrderResDto> getOrders(String authHeader) {

        var role = JwtUtil.getRoleByAuth(authHeader);
        var username = JwtUtil.getUserName(authHeader);

        log.info("Get Orders By User: {}", username);

        List<OrderEntity> orders = new ArrayList<>();

        if (UserRole.ADMIN.equals(role)) {

            orders = orderRepo.findAll();
        } else if (role.equals(UserRole.USER)) {

            orders = orderRepo.findAllByUsername(username);
        }

        return orderMapper.toResDto(orders);
    }

    public void assignOrderToCourier(AssignToCourierReqDto assignToCourierReq, String authHeader) {

        log.info("Assign Order To Courier: {}", assignToCourierReq);

        var role = JwtUtil.getRoleByAuth(authHeader);

        if (role.equals(UserRole.ADMIN)) {

            var order = orderRepo.findById(assignToCourierReq.getOrderId()).orElseThrow(OrderNotFoundException::new);
            order.setCourier(assignToCourierReq.getCourierUserName());
            order.setStatus(OrderStatus.ON_THE_WAY);
            orderRepo.save(order);
        } else {
            throw new InsufficientPrivilegesException();
        }
    }
}
