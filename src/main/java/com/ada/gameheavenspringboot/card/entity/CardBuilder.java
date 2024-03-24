package com.ada.gameheavenspringboot.card.entity;

import com.ada.gameheavenspringboot.Rank;
import com.ada.gameheavenspringboot.Suit;
import com.ada.gameheavenspringboot.deck.entity.Deck;
import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.hand.entity.Hand;

public class CardBuilder {

    private Suit suit;

    private Rank rank;

    private Deck deck;

    private Hand hand;

    private Pile pile;

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

    public CardBuilder withDeck(Deck deck) {
        this.deck = deck;
        return this;
    }

    public CardBuilder withPosition(Hand hand) {
        this.hand = hand;
        return this;
    }

    public CardBuilder withPile(Pile pile) {
        this.pile = pile;
        return this;
    }


    public Card buildCardEntity() {
        Card card = new Card();
        card.setSuit(suit);
        card.setRank(rank);
        card.setDeck(deck);
        card.setHand(hand);
        card.setPile(pile);
        return card;
    }
}