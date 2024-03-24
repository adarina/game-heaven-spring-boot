package com.ada.gameheavenspringboot.board.controller;

import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.game.service.GameService;
import com.ada.gameheavenspringboot.board.dto.CreateBoardRequest;
import com.ada.gameheavenspringboot.board.dto.GetBoardsResponse;
import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.service.BoardService;
import com.ada.gameheavenspringboot.hand.service.HandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/games/{game_id}/boards")
public class GameBoardController {

    private final GameService gameService;

    private final BoardService boardService;

    private final HandService handService;

    @Autowired
    public GameBoardController(GameService gameService, BoardService boardService, HandService handService) {
        this.gameService = gameService;
        this.boardService = boardService;
        this.handService = handService;
    }

    @GetMapping
    public ResponseEntity<GetBoardsResponse> getBoards(@PathVariable("game_id") Long gameId) {
        Optional<Game> game = gameService.find(gameId);
        if (game.isPresent()) {
            return game.map(value -> ResponseEntity.ok(GetBoardsResponse.entityToDtoMapper().apply(boardService.findAll(value))))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createBoard(@PathVariable("game_id") Long gameId,
                                            @RequestBody CreateBoardRequest request,
                                            UriComponentsBuilder builder) {
        Optional<Game> game = gameService.find(gameId);
        if (game.isPresent()) {
            Board board = CreateBoardRequest
                    .dtoToEntityMapper(game::get)
                    .apply(request);
            board = boardService.create(board);
            handService.createHands(board, game.get().getMaxPlayers());


            return ResponseEntity.created(builder.path("/api/games/{game_id}/boards/{board_id}")
                    .buildAndExpand(game.get().getId(), board.getId()).toUri()).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
