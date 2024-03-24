package com.ada.gameheavenspringboot.pile.repository;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.pile.entity.Pile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PileRepository extends JpaRepository<Pile, Long> {

    List<Pile> findAllByBoard(Board board);

}
