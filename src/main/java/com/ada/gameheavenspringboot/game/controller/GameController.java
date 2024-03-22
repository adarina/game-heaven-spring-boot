package com.ada.gameheavenspringboot.game.controller;

import com.ada.gameheavenspringboot.game.dto.GetGamesResponse;
import com.ada.gameheavenspringboot.game.service.GameService;
import com.ada.gameheavenspringboot.user.dto.GetUsersResponse;
import com.ada.gameheavenspringboot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/games")
public class GameController {

    private final GameService gameService;

    @Value("${secret.key}")
    private String KEY;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public ResponseEntity<GetGamesResponse> getGames() {
        return ResponseEntity.ok(GetGamesResponse.entityToDtoMapper().apply(gameService.findAll()));
    }
}
