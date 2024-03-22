package com.ada.gameheavenspringboot.position.controller;


import com.ada.gameheavenspringboot.position.dto.UpdatePositionRequest;
import com.ada.gameheavenspringboot.position.entity.Position;
import com.ada.gameheavenspringboot.position.service.PositionService;
import com.ada.gameheavenspringboot.user.entity.User;
import com.ada.gameheavenspringboot.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/boards/{board_id}/users/{user_id}/positions")
public class BoardUserPositionController {

    private final PositionService positionService;
    private final UserService userService;

    public BoardUserPositionController(PositionService positionService, UserService userService) {
        this.positionService = positionService;
        this.userService = userService;
    }

    @PutMapping("{position_number}")
    public ResponseEntity<Void> updatePosition(@RequestBody UpdatePositionRequest request,
                                               @PathVariable("board_id") Long boardId,
                                               @PathVariable("user_id") Long userId,
                                               @PathVariable("position_number") Integer positionNumber) {

        Optional<User> user = userService.find(userId);
        Optional<Position> position = positionService.find(boardId, positionNumber);

        if (position.isPresent() && position.get().isAvailable() && user.isPresent()) {
            position.get().setUser(user.get());
            position.get().setAvailable(request.isAvailable());
            positionService.update(position.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
