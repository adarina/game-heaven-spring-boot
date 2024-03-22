package com.ada.gameheavenspringboot.position.service;


import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.position.entity.Position;
import com.ada.gameheavenspringboot.position.entity.PositionBuilder;
import com.ada.gameheavenspringboot.position.repository.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position create(Position position) {
        return positionRepository.save(position);
    }

    public void createPositions(Board board, int maxPlayers) {
        for (int i = 0; i < maxPlayers; i++) {
            Position position = PositionBuilder.aPosition()
                    .withNumber(i)
                    .withGamingTable(board)
                    .withAvailable(true)
                    .withActive(false)
                    .buildPositionEntity();
            create(position);
        }
    }
}
