package com.ada.gameheavenspringboot.positioncard.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.position.entity.Position;
import com.ada.gameheavenspringboot.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "positions_cards")
public class PositionCard {

    private static Log log = LogFactory.getLog(User.class);

    @EmbeddedId
    private PositionCardId id;

    @ManyToOne
    @MapsId("positionId")
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name = "card_id")
    private Card card;




    @PrePersist
    public void logNewUserJoinedGamingTable() {
        log.info("Game '" + position.getId() + "' with ID: " + card.getId() + " joined user '"+ id );
    }
}
