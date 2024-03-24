package com.ada.gameheavenspringboot.deck.entity;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.game.entity.Game;
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
@Table(name = "decks")
public class Deck {

    private static Log log = LogFactory.getLog(User.class);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


    @PostPersist
    public void logDeckCreate() {
        log.info(id + " " + board.getGame());
    }

}
