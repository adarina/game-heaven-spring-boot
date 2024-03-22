package com.ada.gameheavenspringboot.dealcard.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.deal.entity.Deal;
import com.ada.gameheavenspringboot.board.entity.Board;
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
@Table(name = "deals_cards")
public class DealCard {

    private static Log log = LogFactory.getLog(User.class);

    @EmbeddedId
    private DealCardId id;

    @ManyToOne
    @MapsId("dealId")
    @JoinColumn(name = "deal_id")
    private Deal deal;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @MapsId("gamingTableId")
    @JoinColumn(name = "gaming_table_id")
    private Board board;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PostPersist
    public void logNewUserJoinedGamingTable() {
        log.info("Game '" + board.getStatus() + "' with ID: " + card.getId() + " joined user '" + user.getUsername() + "' with ID: " + deal.getId());
    }
}
