package com.seidor.sgcx.application.ports.out;

import com.seidor.sgcx.domain.model.AreaManager;
import com.seidor.sgcx.domain.model.Project;

import java.util.List;

public interface AreaManagerRepositoryPort {
    List<AreaManager> findByUserId(Long userId);

    boolean existsByUserId(Long userId);
}
