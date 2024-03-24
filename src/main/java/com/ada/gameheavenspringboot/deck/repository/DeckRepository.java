package com.ada.gameheavenspringboot.deck.repository;

import com.ada.gameheavenspringboot.deck.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {
}
