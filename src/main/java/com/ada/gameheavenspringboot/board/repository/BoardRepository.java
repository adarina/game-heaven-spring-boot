package com.ada.gameheavenspringboot.board.repository;


import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByGame(Game game);
}
