package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {}
