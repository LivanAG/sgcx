package com.seidor.sgcx.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String username;
    private boolean fullAccess;
}
