package com.ada.gameheavenspringboot.hand.dto;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import com.ada.gameheavenspringboot.user.entity.User;
import lombok.*;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateHandRequest {

    private Integer number;

    private Board board;

    private User user;

    private boolean available;

    public static BiFunction<Hand, UpdateHandRequest, Hand> dtoToEntityUpdater() {
        return (hand, request) -> {
            hand.setUser(request.getUser());
            hand.setAvailable(request.isAvailable());
            return hand;
        };
    }
}
