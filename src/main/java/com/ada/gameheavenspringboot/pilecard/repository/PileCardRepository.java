package com.ada.gameheavenspringboot.pilecard.repository;

import com.ada.gameheavenspringboot.pilecard.entity.PileCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PileCardRepository extends JpaRepository<PileCard, Long> {
}
