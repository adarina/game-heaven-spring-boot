package com.ada.gameheavenspringboot.position.repository;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.position.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    Optional<Position> findByBoardAndNumber(Board board, Integer positionNumber);
}
