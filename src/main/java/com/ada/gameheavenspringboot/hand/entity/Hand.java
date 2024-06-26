package com.ada.gameheavenspringboot.hand.entity;

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
@Table(name = "positions")
public class Hand {

    private static Log log = LogFactory.getLog(User.class);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "available")
    private boolean available;

    @Column(name = "current")
    private boolean current;

    @PostPersist
    public void logNewPositionCreated() {
        log.info("Position '" + number + "' with ID: " + id + " created in board '" + board.getId());
    }

    @PostUpdate
    public void logUpdate() {
        log.info("Position '" + number + "' with ID: " + id + " created in board '" + board.getId() + user.getUsername() + available);
    }
}
