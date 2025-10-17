package com.seidor.sgcx.domain.model;

public enum AccessLevel {
    PROJECT_MANAGER,   // solo sus proyectos
    MANAGER,           // proyectos de sus áreas + sus propios proyectos
    FULL_ACCESS;       // todos los proyectos

    public boolean hasFullAccess() {
        return this == FULL_ACCESS;
    }

    public boolean isManager() {
        return this == MANAGER;
    }

    public boolean isProjectManagerOnly() {
        return this == PROJECT_MANAGER;
    }
}