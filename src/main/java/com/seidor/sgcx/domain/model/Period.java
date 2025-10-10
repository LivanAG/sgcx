package com.seidor.sgcx.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Period {
    private Long id;
    private String code;
    private int year;
    private int month;
    private boolean enabled;
}
