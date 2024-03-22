package com.ada.gameheavenspringboot.position.service;


import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.repository.BoardRepository;
import com.ada.gameheavenspringboot.position.entity.Position;
import com.ada.gameheavenspringboot.position.entity.PositionBuilder;
import com.ada.gameheavenspringboot.position.repository.PositionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    private final BoardRepository boardRepository;

    public PositionService(PositionRepository positionRepository, BoardRepository boardRepository) {
        this.positionRepository = positionRepository;
        this.boardRepository = boardRepository;
    }

    public Position create(Position position) {
        return positionRepository.save(position);
    }

    public Optional<Position> find(Long boardId, Integer positionNumber) {
        Optional<Board> board = boardRepository.findById(boardId);
        if (board.isPresent()) {
            return positionRepository.findByBoardAndNumber(board.get(), positionNumber);
        } else {
            return Optional.empty();
        }
    }


    public void createPositions(Board board, int maxPlayers) {
        for (int i = 0; i < maxPlayers; i++) {
            Position position = PositionBuilder.aPosition()
                    .withNumber(i)
                    .withGamingTable(board)
                    .withAvailable(true)
                    .buildPositionEntity();
            create(position);
        }
    }
    @Transactional
    public Position update(Position position) {
        return positionRepository.save(position);
    }
}
