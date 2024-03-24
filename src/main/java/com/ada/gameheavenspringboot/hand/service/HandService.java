package com.ada.gameheavenspringboot.hand.service;


import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.repository.BoardRepository;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import com.ada.gameheavenspringboot.hand.entity.HandBuilder;
import com.ada.gameheavenspringboot.hand.repository.HandRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HandService {

    private final HandRepository handRepository;

    private final BoardRepository boardRepository;

    public HandService(HandRepository handRepository, BoardRepository boardRepository) {
        this.handRepository = handRepository;
        this.boardRepository = boardRepository;
    }

    public Hand create(Hand hand) {
        return handRepository.save(hand);
    }

    public List<Hand> findAll(Board board) {
        return handRepository.findAllByBoard(board);
    }

    public Optional<Hand> find(Long boardId, Integer positionNumber) {
        Optional<Board> board = boardRepository.findById(boardId);
        if (board.isPresent()) {
            return handRepository.findByBoardAndNumber(board.get(), positionNumber);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Hand> find(Long id) {
        return handRepository.findById(id);
    }


    public void createHands(Board board, int maxPlayers) {
        for (int i = 1; i <= maxPlayers; i++) {
            Hand hand = HandBuilder.aHand()
                    .withNumber(i)
                    .withBoard(board)
                    .withAvailable(true)
                    .withCurrent(false)
                    .buildHandEntity();
            create(hand);
        }
    }
    @Transactional
    public Hand update(Hand hand) {
        return handRepository.save(hand);
    }

    public boolean checkIfAllPositionsOccupied(Long boardId) {
        Optional<Board> boardOptional = boardRepository.findById(boardId);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            List<Hand> occupiedHands = handRepository.findByBoardAndUserIsNotNull(board);
            List<Hand> allHands = handRepository.findByBoard(board);

            return occupiedHands.size() == allHands.size();
        } else {
            return false;
        }
    }
}
