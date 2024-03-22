package com.ada.gameheavenspringboot.game.service;

import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.game.repository.GameRepository;
import com.ada.gameheavenspringboot.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

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
}

