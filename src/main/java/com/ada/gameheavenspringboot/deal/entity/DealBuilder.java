package com.ada.gameheavenspringboot.deal.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.board.entity.Board;

public class DealBuilder {

    private Board board;

    private Card card;

    private int number;

    public static DealBuilder aDeal() {
        return new DealBuilder();
    }

    public DealBuilder withNumber(int number) {
        this.number = number;
        return this;
    }

    public DealBuilder withGamingTable(Board board) {
        this.board = board;
        return this;
    }

    public DealBuilder withCard(Card card) {
        this.card = card;
        return this;
    }

    public Deal buildDealEntity() {
        Deal deal = new Deal();
        deal.setBoard(board);
        deal.setNumber(number);
        return deal;
    }
}
