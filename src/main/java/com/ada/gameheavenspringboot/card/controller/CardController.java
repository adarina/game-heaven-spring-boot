package com.ada.gameheavenspringboot.card.controller;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.service.BoardService;
import com.ada.gameheavenspringboot.card.dto.GetCardResponse;
import com.ada.gameheavenspringboot.card.dto.GetCardsResponse;
import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.card.service.CardService;
import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.pile.service.PileService;
import com.ada.gameheavenspringboot.hand.dto.UpdateHandRequest;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import com.ada.gameheavenspringboot.hand.service.HandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/boards/{board_id}/positions/{position_id}/cards")
public class CardController {

    private final BoardService boardService;

    private final CardService cardService;

    private final HandService handService;

    private final PileService pileService;

    public CardController(BoardService boardService, CardService cardService, HandService handService, PileService pileService) {
        this.boardService = boardService;
        this.cardService = cardService;
        this.handService = handService;
        this.pileService = pileService;
    }

    @GetMapping("/{card_id}")
    public ResponseEntity<GetCardResponse> getCard(@PathVariable("card_id") Long cardId) {
        return cardService.find(cardId)
                .map(value -> ResponseEntity.ok(GetCardResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<GetCardsResponse> getCards(@PathVariable("board_id") Long boardId,
                                                     @PathVariable("position_id") Long positionId) {
        Optional<Board> board = boardService.find(boardId);
        Optional<Hand> position = handService.find(positionId);
        if (board.isPresent() && position.isPresent()) {
            return position.map(value -> ResponseEntity.ok(GetCardsResponse.entityToDtoMapper().apply(cardService.findAll(value))))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{card_id}")
    public ResponseEntity<Void> updateCard(@RequestBody UpdateHandRequest request,
                                           @PathVariable("board_id") Long boardId,
                                           @PathVariable("position_id") Long positionId,
                                           @PathVariable("card_id") Long cardId) {

        Optional<Board> board = boardService.find(boardId);
        Optional<Hand> position = handService.find(positionId);
        Optional<Card> card = cardService.find(cardId);

        if (position.isPresent() && board.isPresent() && card.isPresent()) {

            List<Pile> piles = pileService.findAll(board.get());
            card.get().setPile(piles.get(0));
            cardService.update(card.get());

            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
