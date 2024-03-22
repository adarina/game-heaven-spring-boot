package com.ada.gameheavenspringboot.positioncard.repository;

import com.ada.gameheavenspringboot.positioncard.entity.PositionCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionCardRepository extends JpaRepository<PositionCard, Long> {
}
