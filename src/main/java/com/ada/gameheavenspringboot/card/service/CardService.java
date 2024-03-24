package com.ada.gameheavenspringboot.card.service;

import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.card.repository.CardRepository;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import com.ada.gameheavenspringboot.hand.service.HandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    HandService handService;

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card create(Card card) {
        return cardRepository.save(card);
    }

//    @Transactional
    public void update(Card card) {
        cardRepository.save(card);
    }

    public Optional<Card> find(Long id) {
        return cardRepository.findById(id);
    }

    public List<Card> findAll(Hand hand) {
        return cardRepository.findAllByHand(hand);
    }

    public void distributeCardsToHands(Board board, List<Card> deckCards) {
        List<Hand> hands = handService.findAll(board);

        int currentPositionIndex = 0;
        for (Card card : deckCards) {
            card.setHand(hands.get(currentPositionIndex));
            update(card);
            currentPositionIndex = (currentPositionIndex + 1) % hands.size();
        }
    }

    public void distributeCardsToHandsWithMusik(Board board, List<Card> deckCards) {
        List<Hand> hands = handService.findAll(board);
        int cardsPerUser = 0;
        int cardsToMusik = 0;

        if (hands.size() == 2) {
            cardsPerUser = 10;
            cardsToMusik = 4;
        } else if (hands.size() == 3 || hands.size() == 4) {
            cardsPerUser = 7;
            cardsToMusik = 3;
        }

        int currentPositionIndex = 0;
        int cardsDealt = 0;
        int musikIndex = hands.size() - 1;

        for (Card card : deckCards) {
            if (cardsDealt < hands.size() * cardsPerUser) {
                card.setHand(hands.get(currentPositionIndex));
                currentPositionIndex = (currentPositionIndex + 1) % hands.size();
            } else if (cardsDealt < hands.size() * cardsPerUser + cardsToMusik) {
                card.setHand(hands.get(musikIndex));
            }
            update(card);
            cardsDealt++;
        }
    }
}
