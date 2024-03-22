package com.ada.gameheavenspringboot.position.dto;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.position.entity.Position;
import com.ada.gameheavenspringboot.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdatePositionRequest {

    private Integer number;

    private Board board;

    private User user;

    private boolean available;

    public static BiFunction<Position, UpdatePositionRequest, Position> dtoToEntityUpdater() {
        return (position, request) -> {
            position.setUser(request.getUser());
            position.setAvailable(request.isAvailable());
            return position;
        };
    }
}
