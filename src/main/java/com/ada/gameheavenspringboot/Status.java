package com.ada.gameheavenspringboot;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}

