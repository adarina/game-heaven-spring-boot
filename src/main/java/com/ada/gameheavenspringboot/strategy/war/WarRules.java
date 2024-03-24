package com.ada.gameheavenspringboot.strategy.war;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.service.BoardService;
import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.card.service.CardService;
import com.ada.gameheavenspringboot.deck.service.DeckService;
import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.pile.entity.PileBuilder;
import com.ada.gameheavenspringboot.pile.service.PileService;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import com.ada.gameheavenspringboot.hand.service.HandService;
import com.ada.gameheavenspringboot.strategy.GameRulesStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WarRules implements GameRulesStrategy {

    private final CardService cardService;

    private final DeckService deckService;

    private final BoardService boardService;

    private final HandService handService;

    private final PileService pileService;

    public WarRules(CardService cardService, DeckService deckService, BoardService boardService, HandService handService, PileService pileService) {
        this.cardService = cardService;
        this.deckService = deckService;
        this.boardService = boardService;
        this.handService = handService;
        this.pileService = pileService;
    }

    @Override
    public void initializeGame(Board board) {
        List<Card> deckCards = deckService.createAndShuffleDeckOfCards(board);
        cardService.distributeCardsToHands(board, deckCards);

        Pile pile = PileBuilder.aPile().withBoard(board).buildPileEntity();
        pileService.create(pile);
        playing(board);

    }


    public void playing(Board board) {

        List<Hand> hands = handService.findAll(board);
//        positions.get(0).getId()


    }
}
