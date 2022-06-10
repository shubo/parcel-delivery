package com.guavapay.orderms.dto.response;

import com.guavapay.orderms.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResDto {
    private Long id;
    private String username;
    private String fromAddress;
    private String toAddress;
    private Double weight;
    private OrderStatus status;
    private String courier;
}
