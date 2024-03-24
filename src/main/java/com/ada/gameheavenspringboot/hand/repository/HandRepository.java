package com.ada.gameheavenspringboot.hand.repository;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HandRepository extends JpaRepository<Hand, Long> {

    Optional<Hand> findByBoardAndNumber(Board board, Integer positionNumber);

    List<Hand> findByBoardAndUserIsNotNull(Board board);
    List<Hand> findByBoard(Board board);

    List<Hand> findAllByBoard(Board board);

}
