package com.ada.gameheavenspringboot.pilecard.service;

import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.pilecard.entity.PileCard;
import com.ada.gameheavenspringboot.pilecard.repository.PileCardRepository;
import org.springframework.stereotype.Service;

@Service
public class PileCardService {

    private final PileCardRepository pileCardRepository;

    public PileCardService(PileCardRepository pileCardRepository) {
        this.pileCardRepository = pileCardRepository;
    }


    public PileCard create(PileCard pileCard) {
        return pileCardRepository.save(pileCard);
    }
}
