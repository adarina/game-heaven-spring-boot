package com.ada.gameheavenspringboot.board.dto;

import com.ada.gameheavenspringboot.Status;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetBoardsResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Board {

        private Long id;

        private Status status;
    }

    @Singular
    private List<Board> boards;

    public static Function<Collection<com.ada.gameheavenspringboot.board.entity.Board>,
            GetBoardsResponse> entityToDtoMapper() {
        return boards -> {
            GetBoardsResponseBuilder response = GetBoardsResponse.builder();
            boards.stream()
                    .map(board -> Board.builder()
                            .id(board.getId())
                            .status(board.getStatus())
                            .build())
                    .forEach(response::board);
            return response.build();
        };
    }
}
