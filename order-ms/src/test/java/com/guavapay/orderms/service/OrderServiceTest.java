package com.guavapay.orderms.service;

import com.guavapay.orderms.dto.request.OrderReqDto;
import com.guavapay.orderms.exception.InsufficientPrivilegesException;
import com.guavapay.orderms.mapper.OrderMapper;
import com.guavapay.orderms.repo.OrderRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepo orderRepo;
    @Mock
    OrderMapper orderMapper;

    @Test
    void createOrder() {

        var orderReq = OrderReqDto.builder().build();
        assertThrows(InsufficientPrivilegesException.class, () -> orderService.createOrder(orderReq, "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhQGEuY29tIiwicm9sZSI6IkFETUlOIiwiZXhwIjoxNjU0OTMxNTU1fQ.HlNhApjXKYjg4qQFViVhWt2PrcqrYfNINigX-YJq6Z9YpYiEWHDDmCUhvT9Rt1uVocXA23pAnCV0qusldXOuCw"));
    }
}
