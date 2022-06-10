package com.guavapay.orderms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignToCourierReqDto {

    @NotNull
    private Long orderId;
    @NotBlank
    private String courierUserName;
}
