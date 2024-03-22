package com.ada.gameheavenspringboot.board.dto;

import com.ada.gameheavenspringboot.Status;
import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.board.entity.Board;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateBoardRequest {

    private Game game;

    @JsonProperty("status")
    private String status;

    public Status getStatusEnum() {
        return Status.valueOf(status.toUpperCase());
    }

    public static Function<CreateBoardRequest, Board> dtoToEntityMapper(
            Supplier<Game> gameSupplier) {
        return request -> Board.builder()
                .status(request.getStatusEnum())
                .game(gameSupplier.get())
                .build();
    }
}