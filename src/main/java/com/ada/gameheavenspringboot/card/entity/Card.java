package com.ada.gameheavenspringboot.card.entity;

import com.ada.gameheavenspringboot.Rank;
import com.ada.gameheavenspringboot.Suit;
import com.ada.gameheavenspringboot.deck.entity.Deck;
import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.hand.entity.Hand;
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
@Table(name = "cards")
public class Card {

    private static Log log = LogFactory.getLog(User.class);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "suit")
    private Suit suit;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank")
    private Rank rank;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Hand hand;

    @ManyToOne
    @JoinColumn(name = "pile_id")
    private Pile pile;
    @PostPersist
    public void logCardCreate() {
        log.info(id + " " + suit + " " + rank);
    }

    @PostUpdate
    public void logCardUpdate() {
        log.info(id + " "  + " " + hand.getId() + " " + pile);
    }
}