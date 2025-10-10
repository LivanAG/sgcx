package com.seidor.sgcx.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Area {

    private Long id;
    private String name;
    private String shortName;
    private Group group;
}
