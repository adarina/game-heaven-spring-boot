package com.ada.gameheavenspringboot.deck.service;

import com.ada.gameheavenspringboot.Rank;
import com.ada.gameheavenspringboot.Suit;
import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.card.entity.CardBuilder;
import com.ada.gameheavenspringboot.card.service.CardService;
import com.ada.gameheavenspringboot.deck.entity.Deck;
import com.ada.gameheavenspringboot.deck.entity.DeckBuilder;
import com.ada.gameheavenspringboot.deck.repository.DeckRepository;
import com.ada.gameheavenspringboot.hand.service.HandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeckService {

    private final DeckRepository deckRepository;
    private final HandService handService;
    private final CardService cardService;

    public DeckService(DeckRepository deckRepository, HandService handService, CardService cardService) {
        this.deckRepository = deckRepository;
        this.handService = handService;
        this.cardService = cardService;
    }

    public Deck create(Deck deck) {
        return deckRepository.save(deck);
    }

    public List<Card> createAndShuffleDeckOfCards(Board board) {
        Deck deck = DeckBuilder.aDeck().withBoard(board).buildDeckEntity();
        create(deck);

        List<Card> deckCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deckCards.add(createCard(deck, suit, rank));
            }
        }
        Collections.shuffle(deckCards);
        return deckCards;
    }

    public List<Card> createAndShufflePartialDeckOfCards(Board board) {
        Deck deck = DeckBuilder.aDeck().withBoard(board).buildDeckEntity();
        create(deck);

        List<Card> deckCards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            if (suit == Suit.HEARTS || suit == Suit.DIAMONDS) {
                deckCards.add(createCard(deck, suit, Rank.ACE));
                deckCards.add(createCard(deck, suit, Rank.TEN));
                deckCards.add(createCard(deck, suit, Rank.KING));
                deckCards.add(createCard(deck, suit, Rank.QUEEN));
                deckCards.add(createCard(deck, suit, Rank.JACK));
                deckCards.add(createCard(deck, suit, Rank.NINE));
            }
        }
        Collections.shuffle(deckCards);
        return deckCards;
    }

    private Card createCard(Deck deck, Suit suit, Rank rank) {
        Card card = CardBuilder.aCard().withSuit(suit).withRank(rank).withDeck(deck).buildCardEntity();
        cardService.create(card);
        return card;
    }
}
