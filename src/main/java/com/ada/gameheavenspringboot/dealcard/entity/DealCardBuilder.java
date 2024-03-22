package com.ada.gameheavenspringboot.dealcard.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.deal.entity.Deal;
import com.ada.gameheavenspringboot.board.entity.Board;

public class DealCardBuilder {

    private Board board;

    private Deal deal;

    private Card card;

    public static DealCardBuilder aDealCard() {
        return new DealCardBuilder();
    }

    public DealCardBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public DealCardBuilder withCard(Card card) {
        this.card = card;
        return this;
    }

    public DealCardBuilder withGamingTable(Board board) {
        this.board = board;
        return this;
    }

    public DealCard buildDealEntity() {
        DealCard dealCard = new DealCard();
        dealCard.setBoard(board);
        dealCard.setCard(card);
        dealCard.setDeal(deal);
        return dealCard;
    }
}
