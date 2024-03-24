package com.ada.gameheavenspringboot.board.service;

import com.ada.gameheavenspringboot.game.entity.Game;
import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;


    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;

    }

    @Transactional
    public Board create(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> findAll(Game game) {
        return boardRepository.findAllByGame(game);
    }


    public Optional<Board> find(Long id) {
        return boardRepository.findById(id);
    }

}
