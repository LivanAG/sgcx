package com.seidor.sgcx.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectManagerAssignment {
    private Long id;
    private User user;
    private Project project;
}