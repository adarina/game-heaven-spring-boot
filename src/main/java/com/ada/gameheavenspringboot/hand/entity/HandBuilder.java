package com.ada.gameheavenspringboot.hand.entity;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.user.entity.User;

public class HandBuilder {

    private Board board;

    private Integer number;

    private User user;

    private boolean available;

    private boolean current;

    private HandBuilder() {
    }

    public static HandBuilder aHand() {
        return new HandBuilder();
    }

    public HandBuilder withBoard(Board board) {
        this.board = board;
        return this;
    }

    public HandBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public HandBuilder withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public HandBuilder withAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public HandBuilder withCurrent(boolean current) {
        this.current = current;
        return this;
    }

    public Hand buildHandEntity() {
        Hand hand = new Hand();
        hand.setBoard(board);
        hand.setNumber(number);
        hand.setUser(user);
        hand.setAvailable(available);
        hand.setCurrent(current);
        return hand;
    }
}
