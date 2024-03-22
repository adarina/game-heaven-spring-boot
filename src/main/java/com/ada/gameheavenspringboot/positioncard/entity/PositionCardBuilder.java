package com.ada.gameheavenspringboot.positioncard.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.position.entity.Position;

public class PositionCardBuilder {

    private Position position;

    private Card card;

    private PositionCardBuilder() {
    }

    public static PositionCardBuilder aPositionCard() {
        return new PositionCardBuilder();
    }

    public PositionCardBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public PositionCardBuilder withCard(Card card) {
        this.card = card;
        return this;
    }

    public PositionCard buildPositionCardEntity() {
        PositionCardId positionCardId = new PositionCardId();
        positionCardId.setPositionId(position.getId());
        positionCardId.setCardId(card.getId());

        PositionCard positionCard = new PositionCard();
        positionCard.setId(positionCardId);
        positionCard.setPosition(position);
        positionCard.setCard(card);
        return positionCard;
    }
}
