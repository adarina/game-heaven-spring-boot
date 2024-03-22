package com.ada.gameheavenspringboot.userboard.entity;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.user.entity.User;

public class BoardUserBuilder {


    private User user;

    private Board board;

    private BoardUserBuilder() {
    }

    public static BoardUserBuilder aBoardUser() {
        return new BoardUserBuilder();
    }

    public BoardUserBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public BoardUserBuilder withBoard(Board board) {
        this.board = board;
        return this;
    }

    public BoardUser buildBoardUserEntity() {
        BoardUserId boardUserId = new BoardUserId();
        boardUserId.setUserId(user.getId());
        boardUserId.setGamingTableId(board.getId());

        BoardUser boardUser = new BoardUser();
        boardUser.setId(boardUserId);
        boardUser.setUser(user);
        boardUser.setBoard(board);
        return boardUser;
    }
}