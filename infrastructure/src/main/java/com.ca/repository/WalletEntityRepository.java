package com.ca.repository;

import com.ca.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}
