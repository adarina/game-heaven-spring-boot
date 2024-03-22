package com.ada.gameheavenspringboot.card.entity;

import com.ada.gameheavenspringboot.Rank;
import com.ada.gameheavenspringboot.Suit;

public class CardBuilder {

    private Suit suit;

    private Rank rank;

    private CardBuilder() {
    }

    public static CardBuilder aCard() {
        return new CardBuilder();
    }

    public CardBuilder withSuit(Suit suit) {
        this.suit = suit;
        return this;
    }

    public CardBuilder withRank(Rank rank) {
        this.rank = rank;
        return this;
    }

    public Card buildCardEntity() {
        Card card = new Card();
        card.setSuit(suit);
        card.setRank(rank);
        return card;
    }
}