package com.ada.gameheavenspringboot.deal.repository;

import com.ada.gameheavenspringboot.deal.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {


}
