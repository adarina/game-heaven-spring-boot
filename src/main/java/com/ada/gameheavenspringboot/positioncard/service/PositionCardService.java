package com.ada.gameheavenspringboot.positioncard.service;

import com.ada.gameheavenspringboot.positioncard.entity.PositionCard;
import com.ada.gameheavenspringboot.positioncard.repository.PositionCardRepository;
import com.ada.gameheavenspringboot.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionCardService {

    private final PositionCardRepository positionCardRepository;

    public PositionCardService(PositionCardRepository positionCardRepository) {
        this.positionCardRepository = positionCardRepository;
    }

    public PositionCard create(PositionCard positionCard) {
        return positionCardRepository.save(positionCard);
    }

    public void delete(PositionCard positionCard) {
        positionCardRepository.delete(positionCard);
    }

    public List<PositionCard> findAll() {
        return positionCardRepository.findAll();
    }
}
