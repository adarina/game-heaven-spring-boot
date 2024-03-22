package com.ada.gameheavenspringboot.position.entity;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.user.entity.User;

public class PositionBuilder {

    private Board board;

    private Integer number;

    private User user;

    private boolean available;

    private boolean active;

    private PositionBuilder() {
    }

    public static PositionBuilder aPosition() {
        return new PositionBuilder();
    }

    public PositionBuilder withGamingTable(Board board) {
        this.board = board;
        return this;
    }

    public PositionBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public PositionBuilder withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public PositionBuilder withAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public PositionBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }
    public Position buildPositionEntity() {
        Position position = new Position();
        position.setBoard(board);
        position.setNumber(number);
        position.setUser(user);
        position.setAvailable(available);
        position.setActive(active);
        return position;
    }
}
