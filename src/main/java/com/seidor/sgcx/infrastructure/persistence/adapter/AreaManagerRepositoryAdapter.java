package com.seidor.sgcx.infrastructure.persistence.adapter;

import com.seidor.sgcx.application.ports.out.AreaManagerRepositoryPort;
import com.seidor.sgcx.domain.model.AreaManager;
import com.seidor.sgcx.infrastructure.persistence.mapper.AreaManagerEntityMapper;
import com.seidor.sgcx.infrastructure.persistence.repository.AreaManagerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AreaManagerRepositoryAdapter implements AreaManagerRepositoryPort {

    AreaManagerJpaRepository areaManagerJpaRepository;
    AreaManagerEntityMapper areaManagerEntityMapper;



    @Override
    public List<AreaManager> findByUserId(Long userId) {
        return areaManagerJpaRepository.findByUserId(userId).stream()
                .map(areaManagerEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByUserId(Long userId) {
        return areaManagerJpaRepository.existsByUserId(userId);
    }
}
