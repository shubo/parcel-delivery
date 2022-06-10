package com.guavapay.userms.repo;

import com.guavapay.userms.entity.UserEntity;
import com.guavapay.userms.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

    List<UserEntity> findAllByRole(UserRole role);
}
