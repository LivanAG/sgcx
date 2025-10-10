package com.seidor.sgcx.application.service;

import com.seidor.sgcx.application.ports.out.AreaManagerRepositoryPort;
import com.seidor.sgcx.domain.model.AreaManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AreaManagerApplicationService {

    private final AreaManagerRepositoryPort  areaManagerRepositoryPort;


    public List<AreaManager> findByUserId(Long id) {
        return areaManagerRepositoryPort.findByUserId(id);
    }

    public boolean isAreaManager(Long id) {
        return areaManagerRepositoryPort.existsByUserId(id);
    }
}
