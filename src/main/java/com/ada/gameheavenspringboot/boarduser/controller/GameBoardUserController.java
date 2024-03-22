package com.ada.gameheavenspringboot.boarduser.controller;

import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.game.service.GameService;
import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.service.BoardService;
import com.ada.gameheavenspringboot.user.entity.User;
import com.ada.gameheavenspringboot.user.service.UserService;
import com.ada.gameheavenspringboot.boarduser.dto.CreateBoardUserRequest;
import com.ada.gameheavenspringboot.boarduser.entity.BoardUser;
import com.ada.gameheavenspringboot.boarduser.entity.BoardUserId;
import com.ada.gameheavenspringboot.boarduser.service.BoardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/games/{game_id}/boards/{board_id}/users/{user_id}/board_user")
public class GameBoardUserController {


    private final BoardService boardService;

    private final BoardUserService boardUserService;

    private final UserService userService;

    private final GameService gameService;

    @Autowired
    public GameBoardUserController(BoardService boardService, UserService userService, BoardUserService boardUserService, GameService gameService) {
        this.boardService = boardService;
        this.boardUserService = boardUserService;
        this.userService = userService;
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<BoardUser>> getUsersGamingTables(@PathVariable("game_id") Long gameId,
                                                                @PathVariable("board_id") Long boardId,
                                                                @PathVariable("user_id") Long userId) {
        Optional<Game> game = gameService.find(gameId);
        Optional<Board> board = boardService.find(boardId);
        Optional<User> user = userService.find(userId);

        if (board.isPresent() && user.isPresent() && game.isPresent()) {
            List<BoardUser> boardUsers = boardUserService.findByUserAndBoard(user.get(), board.get());
            return ResponseEntity.ok(boardUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createBoardUser(@PathVariable("game_id") Long gameId,
                                                @PathVariable("board_id") Long boardId,
                                                @PathVariable("user_id") Long userId,
                                                @RequestBody CreateBoardUserRequest request,
                                                UriComponentsBuilder builder) {
        Optional<Game> game = gameService.find(gameId);
        Optional<Board> board = boardService.find(boardId);
        Optional<User> user = userService.find(userId);

        if (board.isPresent() && user.isPresent() && game.isPresent()) {

            BoardUserId boardUserId = new BoardUserId(userId, boardId);
            BoardUser boardUser = CreateBoardUserRequest
                    .dtoToEntityMapper(board::get, user::get)
                    .apply(request);
            boardUser.setId(boardUserId);
            boardUserService.create(boardUser);

            user.get().setWaiting(true);
            userService.save(user.get());

            return ResponseEntity.created(builder.path("/api/games/{game_id}/boards/{board_id}/users/{user_id}")
                    .buildAndExpand(board.get().getId(), game.get().getId(), user.get().getId()).toUri()).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}