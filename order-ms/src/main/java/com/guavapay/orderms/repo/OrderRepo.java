package com.guavapay.orderms.repo;

import com.guavapay.orderms.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByUsername(String username);
}
