package com.ada.gameheavenspringboot.pile.entity;

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
@Table(name = "piles")
public class Pile {

    private static Log log = LogFactory.getLog(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pile_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @PostPersist
    public void logNewUserJoinedGamingTable() {
        log.info("Game '" + board.getId() + "' with ID: " + " joined user '" + id);
    }
}