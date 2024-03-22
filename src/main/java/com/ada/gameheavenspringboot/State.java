package com.ada.gameheavenspringboot;

import lombok.Getter;

@Getter
public enum State {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String state;

    State(String state) {
        this.state = state;
    }
}
