package com.ada.gameheavenspringboot.pile.service;


import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.pile.repository.PileRepository;
import com.ada.gameheavenspringboot.position.entity.Position;
import com.ada.gameheavenspringboot.position.repository.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PileService {

    private final PileRepository pileRepository;

    public PileService(PileRepository pileRepository) {
        this.pileRepository = pileRepository;
    }


    public Pile create(Pile pile) {
        return pileRepository.save(pile);
    }
}
