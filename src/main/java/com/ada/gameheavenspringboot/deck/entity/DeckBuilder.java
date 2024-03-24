package com.ada.gameheavenspringboot.deck.entity;


import com.ada.gameheavenspringboot.board.entity.Board;


public class DeckBuilder {

    private Board board;

    private DeckBuilder() {
    }

    public static DeckBuilder aDeck() {
        return new DeckBuilder();
    }

    public DeckBuilder withBoard(Board board) {
        this.board = board;
        return this;
    }

    public Deck buildDeckEntity() {
        Deck deck = new Deck();
        deck.setBoard(board);
        return deck;
    }
}
