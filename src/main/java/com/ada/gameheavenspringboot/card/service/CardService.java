package com.ada.gameheavenspringboot.card.service;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.card.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card create(Card card) {
        return cardRepository.save(card);
    }
}
