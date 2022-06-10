package com.guavapay.orderms.controller;

import com.guavapay.orderms.dto.request.AssignToCourierReqDto;
import com.guavapay.orderms.dto.request.OrderReqDto;
import com.guavapay.orderms.dto.response.OrderResDto;
import com.guavapay.orderms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderReqDto orderReqDto,
                                      @RequestHeader("Authorization") String authHeader) {
        orderService.createOrder(orderReqDto, authHeader);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResDto>> getOrders(@RequestHeader("Authorization") String authHeader) {

        return ResponseEntity.ok(orderService.getOrders(authHeader));
    }

    @PutMapping("/assign-to-courier")
    public ResponseEntity assignToCourier(@Valid @RequestBody AssignToCourierReqDto assignToCourierReq,
                                          @RequestHeader("Authorization") String authHeader) {

        orderService.assignOrderToCourier(assignToCourierReq, authHeader);
        return ResponseEntity.ok().build();
    }
}
