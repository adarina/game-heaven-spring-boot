package com.ada.gameheavenspringboot.game.service;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.game.repository.GameRepository;
import com.ada.gameheavenspringboot.strategy.GameRulesStrategy;
import com.ada.gameheavenspringboot.strategy.bridge.BridgeRules;
import com.ada.gameheavenspringboot.strategy.war.WarRules;
import com.ada.gameheavenspringboot.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {


    @Autowired
    private BridgeRules bridgeRules;

    @Autowired
    private WarRules warRules;
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public Game create(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Optional<Game> find(Long id) {
        return gameRepository.findById(id);
    }

    public void startGame(Long gameId, Board board) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            System.out.println(gameId);
            System.out.println(game);
            GameRulesStrategy gameRulesStrategy = getGameRulesStrategy(game);
            if (gameRulesStrategy != null) {
                gameRulesStrategy.initializeGame(board);
            } else {
                throw new IllegalArgumentException("No rules found for game: " + game.getName());
            }
        } else {
            throw new IllegalArgumentException("Game not found with ID: " + gameId);
        }
    }

    private GameRulesStrategy getGameRulesStrategy(Game game) {
        return switch (game.getName()) {
            case "BRIDGE" -> bridgeRules;
            case "WAR" -> warRules;
            default -> throw new IllegalArgumentException("Unsupported game: " + game.getName());
        };
    }
}

