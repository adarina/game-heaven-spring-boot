package com.ada.gameheavenspringboot.musik.entity;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import com.ada.gameheavenspringboot.user.entity.User;

public class MusikBuilder {

    private Board board;

    private Integer number;

    private User user;

    private boolean available;

    private MusikBuilder() {
    }

    public static MusikBuilder aMusik() {
        return new MusikBuilder();
    }

    public MusikBuilder withBoard(Board board) {
        this.board = board;
        return this;
    }

    public MusikBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public MusikBuilder withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public MusikBuilder withAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public Hand buildMusikEntity() {
        Hand hand = new Hand();
        hand.setBoard(board);
        hand.setNumber(number);
        hand.setUser(user);
        hand.setAvailable(available);
        return hand;
    }
}
