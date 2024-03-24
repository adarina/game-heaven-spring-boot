package com.ada.gameheavenspringboot.card.repository;


import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByHand(Hand hand);

}
