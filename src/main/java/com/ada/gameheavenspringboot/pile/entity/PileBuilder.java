package com.ada.gameheavenspringboot.pile.entity;

import com.ada.gameheavenspringboot.board.entity.Board;

public class PileBuilder {

    private Board board;

    private PileBuilder() {
    }

    public static PileBuilder aPile() {
        return new PileBuilder();
    }

    public PileBuilder withBoard(Board board) {
        this.board = board;
        return this;
    }

    public Pile buildPileEntity() {
        Pile pile = new Pile();
        pile.setBoard(board);
        return pile;
    }
}
