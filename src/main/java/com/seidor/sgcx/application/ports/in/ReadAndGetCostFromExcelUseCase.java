package com.seidor.sgcx.application.ports.in;

import com.seidor.sgcx.application.dto.cost.CostExcelRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReadAndGetCostFromExcelUseCase {
    List<CostExcelRequestDto> readExcelFileAndGetCosts(MultipartFile file);

}
