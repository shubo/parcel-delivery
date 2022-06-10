package com.guavapay.orderms.entity;

import com.guavapay.orderms.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_pd")
@NoArgsConstructor
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @Column(name = "from_addr")
    private String fromAddress;
    @Column(name = "to_addr")
    private String toAddress;
    private Double weight;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String courier;
}
