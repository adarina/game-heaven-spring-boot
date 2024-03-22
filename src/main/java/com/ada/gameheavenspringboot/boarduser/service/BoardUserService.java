package com.ada.gameheavenspringboot.boarduser.service;

import com.ada.gameheavenspringboot.Status;
import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.user.entity.User;
import com.ada.gameheavenspringboot.boarduser.repository.BoardUserRepository;
import com.ada.gameheavenspringboot.boarduser.entity.BoardUser;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import jakarta.persistence.*;


import java.util.List;
import java.util.Optional;

@Service
public class BoardUserService {

    private static final Log log = LogFactory.getLog(User.class);

    private final BoardUserRepository boardUserRepository;

    public BoardUserService(BoardUserRepository boardUserRepository) {
        this.boardUserRepository = boardUserRepository;
    }

    @Transactional
    public BoardUser create(BoardUser boardUser) {
        Long gamingTableId = boardUser.getBoard().getId();
        if (isBoardActive(gamingTableId)) {
            BoardUser savedBoardUser = boardUserRepository.save(boardUser);
            manageBoard(gamingTableId);
            return savedBoardUser;
        }
        return null;
    }

    @Transactional
    public boolean isBoardActive(Long gamingTableId) {
        Status status = boardUserRepository.findBoardStatusById(gamingTableId);
        try {
            return status == Status.ACTIVE;
        } catch (NoResultException e) {
            log.warn("No result found for GamingTable with ID: " + gamingTableId);
            return false;
        }
    }

    @Transactional
    public void manageBoard(Long gamingTableId) {
        Long userCount = boardUserRepository.countUsersAtBoard(gamingTableId);
        Integer maxPlayers = boardUserRepository.findMaxPlayersByBoardId(gamingTableId);

        if (userCount >= maxPlayers) {
            int rowsUpdated = boardUserRepository.updateBoardStatusToInactive(gamingTableId);
            System.out.println("Number of rows updated: " + rowsUpdated);

            rowsUpdated = boardUserRepository.incrementDealNumberByBoardId(gamingTableId);
            System.out.println("Number of rows updated: " + rowsUpdated);

        }
    }

    public Optional<BoardUser> find(Long id) {
        return boardUserRepository.findById(id);
    }

    public List<BoardUser> findByUserAndBoard(User user, Board board) {
        return boardUserRepository.findByUserAndBoard(user, board);
    }
}
