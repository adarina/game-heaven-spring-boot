package com.ada.gameheavenspringboot.boarduser.entity;

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
@Table(name = "users_gaming_tables")
public class BoardUser {

    private static Log log = LogFactory.getLog(User.class);

    @EmbeddedId
    private BoardUserId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("gamingTableId")
    @JoinColumn(name = "gaming_table_id")
    private Board board;

    @PostPersist
    public void logNewUserJoinedGamingTable() {
        log.info("Game '" + board.getGame().getName() + "' with ID: " + board.getId() + " joined user '" + user.getUsername() + "' with ID: " + user.getId());
    }

}





