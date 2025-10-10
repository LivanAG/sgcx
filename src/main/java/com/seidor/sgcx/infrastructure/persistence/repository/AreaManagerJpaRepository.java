package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.AreaManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaManagerJpaRepository extends JpaRepository<AreaManagerEntity, Long> {
    List<AreaManagerEntity> findByUserId(Long userId);
    boolean existsByUserId(Long userId);
}
