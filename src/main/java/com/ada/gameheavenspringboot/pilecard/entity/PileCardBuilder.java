package com.ada.gameheavenspringboot.pilecard.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.pile.entity.Pile;

public class PileCardBuilder {

    private Pile pile;

    private Card card;

    private PileCardBuilder() {
    }

    public static PileCardBuilder aPileCard() {
        return new PileCardBuilder();
    }

    public PileCardBuilder withPile(Pile pile) {
        this.pile = pile;
        return this;
    }

    public PileCardBuilder withCard(Card card) {
        this.card = card;
        return this;
    }

    public PileCard buildPileCardEntity() {
        PileCardId pileCardId = new PileCardId();
        pileCardId.setPileId(pile.getId());
        pileCardId.setCardId(card.getId());

        PileCard pileCard = new PileCard();
        pileCard.setId(pileCardId);
        pileCard.setPile(pile);
        pileCard.setCard(card);
        return pileCard;
    }
}
