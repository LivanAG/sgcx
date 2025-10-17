package com.seidor.sgcx.infrastructure.rest.controller;


import com.seidor.sgcx.application.dto.cost.CostExcelRequestDto;
import com.seidor.sgcx.application.ports.in.ReadAndGetCostFromExcelStreamingUseCase;
import com.seidor.sgcx.application.ports.in.ReadAndGetCostFromExcelUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cost")
public class CostExcelController{

    private final ReadAndGetCostFromExcelUseCase readCostFromExcelUseCase;
    private final ReadAndGetCostFromExcelStreamingUseCase   readCostFromExcelStreamingUseCase;

    public CostExcelController(ReadAndGetCostFromExcelUseCase readCostFromExcelUseCase, ReadAndGetCostFromExcelStreamingUseCase readCostFromExcelStreamingUseCase) {
        this.readCostFromExcelUseCase = readCostFromExcelUseCase;
        this.readCostFromExcelStreamingUseCase = readCostFromExcelStreamingUseCase;
    }

    @PostMapping("/import-cost-excel-file")
    public ResponseEntity<List<CostExcelRequestDto>> importCosts(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(readCostFromExcelUseCase.readExcelFileAndGetCosts(file));
    }

    @PostMapping("/import-cost-excel-file-streaming")
    public ResponseEntity<List<CostExcelRequestDto>> importCostsStreaming(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(readCostFromExcelStreamingUseCase.readExcelFileAndGetCostsStreaming(file));
    }
}
