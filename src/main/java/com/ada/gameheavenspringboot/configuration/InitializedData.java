package com.ada.gameheavenspringboot.configuration;

import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.game.entity.GameBuilder;
import com.ada.gameheavenspringboot.game.service.GameService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializedData {

    private final GameService gameService;


    @Autowired
    public InitializedData(GameService gameService) {
        this.gameService = gameService;
    }

    @PostConstruct
    private synchronized void init() {

        Game warGame = GameBuilder.aGame().defaultBuildWarEntity();
        gameService.create(warGame);

        Game bridgeGame = GameBuilder.aGame().defaultBuildBridgeEntity();
        gameService.create(bridgeGame);

    }
}
