package com.guavapay.orderms.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guavapay.orderms.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderReqDto {
    private String username;
    private String fromAddress;
    private String toAddress;
    private Double weight;
    private OrderStatus status;
}
