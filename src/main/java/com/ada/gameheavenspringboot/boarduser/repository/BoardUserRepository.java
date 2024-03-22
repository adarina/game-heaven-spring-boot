package com.ada.gameheavenspringboot.boarduser.repository;


import com.ada.gameheavenspringboot.Status;
import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.user.entity.User;
import com.ada.gameheavenspringboot.boarduser.entity.BoardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BoardUserRepository extends JpaRepository<BoardUser, Long> {

    List<BoardUser> findByUserAndBoard(User user, Board board);

    @Query("SELECT b.status FROM Board b WHERE b.id = :boardId")
    Status findBoardStatusById(@Param("boardId") Long boardId);

    @Query("select count(b) from BoardUser b where b.board.id = :boardId")
    Long countUsersAtBoard(@Param("boardId") Long boardId);

    @Query("select g.maxPlayers from Board b join b.game g where b.id = :boardId")
    Integer findMaxPlayersByBoardId(@Param("boardId") Long boardId);

    @Modifying
    @Query("update Board b set b.status = 'INACTIVE' where b.id = :boardId")
    int updateBoardStatusToInactive(@Param("boardId") Long boardId);

    @Modifying
    @Query("update Deal d set d.number = d.number + 1 where d.board.id = :boardId")
    int incrementDealNumberByBoardId(@Param("boardId") Long boardId);

}
