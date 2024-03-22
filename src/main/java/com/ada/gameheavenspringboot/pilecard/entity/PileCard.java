package com.ada.gameheavenspringboot.pilecard.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.pile.entity.Pile;
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
@Table(name = "piles_cards")
public class PileCard {

    private static Log log = LogFactory.getLog(User.class);

    @EmbeddedId
    private PileCardId id;

    @ManyToOne
    @MapsId("pileId")
    @JoinColumn(name = "pile_id")
    private Pile pile;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name = "card_id")
    private Card card;




    @PostPersist
    public void logNewUserJoinedGamingTable() {
        log.info("Game '" + pile.getId() + "' with ID: " + card.getId() + " joined user '"+ id );
    }
}