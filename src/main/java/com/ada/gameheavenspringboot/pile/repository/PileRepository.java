package com.ada.gameheavenspringboot.pile.repository;

import com.ada.gameheavenspringboot.pile.entity.Pile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PileRepository extends JpaRepository<Pile, Long> {
}
