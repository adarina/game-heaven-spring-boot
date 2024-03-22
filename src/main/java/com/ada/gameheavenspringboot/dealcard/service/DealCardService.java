package com.ada.gameheavenspringboot.dealcard.service;

import com.ada.gameheavenspringboot.dealcard.entity.DealCard;
import com.ada.gameheavenspringboot.dealcard.repository.DealCardRepository;
import com.ada.gameheavenspringboot.user.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class DealCardService {

    private static final Log log = LogFactory.getLog(User.class);

    DealCardRepository dealCardRepository;

    public DealCardService(DealCardRepository dealCardRepository) {
        this.dealCardRepository = dealCardRepository;
    }

    public DealCard create(DealCard dealCard) {
        return dealCardRepository.save(dealCard);
    }
}
