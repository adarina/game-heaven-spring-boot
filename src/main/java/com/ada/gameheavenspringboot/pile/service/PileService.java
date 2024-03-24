package com.ada.gameheavenspringboot.pile.service;


import com.ada.gameheavenspringboot.board.entity.Board;
import com.ada.gameheavenspringboot.pile.entity.Pile;
import com.ada.gameheavenspringboot.pile.repository.PileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PileService {

    private final PileRepository pileRepository;

    public PileService(PileRepository pileRepository) {
        this.pileRepository = pileRepository;
    }


    public Pile create(Pile pile) {
        return pileRepository.save(pile);
    }

    public List<Pile> findAll(Board board) {
        return pileRepository.findAllByBoard(board);
    }

}
