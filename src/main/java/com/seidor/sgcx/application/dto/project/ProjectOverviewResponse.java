package com.seidor.sgcx.application.dto.project;

import com.seidor.sgcx.domain.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectOverviewResponse {
    private String pep;
    private String name;
    private Client client;
}
