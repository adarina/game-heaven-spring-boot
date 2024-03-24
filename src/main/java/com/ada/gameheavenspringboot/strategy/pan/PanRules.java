package com.ada.gameheavenspringboot.strategy.pan;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.board.service.BoardService;
import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.card.service.CardService;
import com.ada.gameheavenspringboot.deck.service.DeckService;
import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.pile.entity.PileBuilder;
import com.ada.gameheavenspringboot.pile.service.PileService;
import com.ada.gameheavenspringboot.hand.service.HandService;
import com.ada.gameheavenspringboot.strategy.GameRulesStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PanRules implements GameRulesStrategy {

    private final CardService cardService;

    private final DeckService deckService;

    private final BoardService boardService;

    private final HandService handService;

    private final PileService pileService;

    public PanRules(CardService cardService, DeckService deckService, BoardService boardService, HandService handService, PileService pileService) {
        this.cardService = cardService;
        this.deckService = deckService;
        this.boardService = boardService;
        this.handService = handService;
        this.pileService = pileService;
    }

    @Override
    public void initializeGame(Board board) {
        List<Card> deckCards = deckService.createAndShufflePartialDeckOfCards(board);
        cardService.distributeCardsToHands(board, deckCards);

        Pile pile = PileBuilder.aPile().withBoard(board).buildPileEntity();
        pileService.create(pile);

        //znajdź osobę która ma serce 9
    }
}
