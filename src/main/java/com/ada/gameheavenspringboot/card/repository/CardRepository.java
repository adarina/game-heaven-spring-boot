package com.ada.gameheavenspringboot.card.repository;


import com.ada.gameheavenspringboot.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
