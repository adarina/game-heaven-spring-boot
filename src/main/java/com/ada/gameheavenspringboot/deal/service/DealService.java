package com.ada.gameheavenspringboot.deal.service;

import com.ada.gameheavenspringboot.deal.entity.Deal;
import com.ada.gameheavenspringboot.deal.repository.DealRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DealService {

    private final DealRepository dealRepository;

    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public Deal create(Deal deal) {
        return dealRepository.save(deal);
    }

    public Optional<Deal> find(Long id) {
        return dealRepository.findById(id);
    }
}
