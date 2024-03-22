package com.ada.gameheavenspringboot.deal.controller;

import com.ada.gameheavenspringboot.deal.dto.GetDealResponse;
import com.ada.gameheavenspringboot.deal.service.DealService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/games/{game_id}/gamingtables/{gamingtable_id}/deals")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/{deal_id}")
    public ResponseEntity<GetDealResponse> getDeal(@PathVariable("deal_id") Long dealId) {
        return dealService.find(dealId)
                .map(value -> ResponseEntity.ok(GetDealResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
