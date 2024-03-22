package com.ada.gameheavenspringboot.boarduser.dto;


import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.user.entity.User;
import com.ada.gameheavenspringboot.boarduser.entity.BoardUser;
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
public class CreateBoardUserRequest {

    private User user;

    private Board board;

    public static Function<CreateBoardUserRequest, BoardUser> dtoToEntityMapper(
            Supplier<Board> gamingTableSupplier, Supplier<User> userSupplier) {
        return request -> BoardUser.builder()
                .board(gamingTableSupplier.get())
                .user(userSupplier.get())
                .build();
    }
}
