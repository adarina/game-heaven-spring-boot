package com.ada.gameheavenspringboot.game.repository;

import com.ada.gameheavenspringboot.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
