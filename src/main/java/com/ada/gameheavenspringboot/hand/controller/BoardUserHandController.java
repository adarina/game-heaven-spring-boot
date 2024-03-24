package com.ada.gameheavenspringboot.hand.controller;


import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.service.BoardService;
import com.ada.gameheavenspringboot.game.service.GameService;
import com.ada.gameheavenspringboot.hand.dto.UpdateHandRequest;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import com.ada.gameheavenspringboot.hand.service.HandService;
import com.ada.gameheavenspringboot.user.entity.User;
import com.ada.gameheavenspringboot.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/boards/{board_id}/users/{user_id}/positions")
public class BoardUserHandController {

    private final HandService handService;
    private final UserService userService;

    private final GameService gameService;
    private final BoardService boardService;

    public BoardUserHandController(HandService handService, UserService userService, GameService gameService, BoardService boardService) {
        this.handService = handService;
        this.userService = userService;
        this.gameService = gameService;
        this.boardService = boardService;
    }



    @PutMapping("{position_number}")
    public ResponseEntity<Void> updatePosition(@RequestBody UpdateHandRequest request,
                                               @PathVariable("board_id") Long boardId,
                                               @PathVariable("user_id") Long userId,
                                               @PathVariable("position_number") Integer positionNumber) {

        Optional<User> user = userService.find(userId);
        Optional<Hand> hand = handService.find(boardId, positionNumber);

        if (hand.isPresent() && hand.get().isAvailable() && user.isPresent()) {
            hand.get().setUser(user.get());
            hand.get().setAvailable(request.isAvailable());
            handService.update(hand.get());
            boolean availablePositions = handService.checkIfAllPositionsOccupied(boardId);

            // sprawdź czy gra już zaczęta
            Optional<Board> board = boardService.find(boardId);
            if (availablePositions && board.isPresent()) {
                gameService.startGame(board.get().getGame().getId(), board.get());
            }

                return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
