package com.ada.gameheavenspringboot.dealcard.entity;


import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@Embeddable
public class DealCardId implements Serializable {

    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "deal_id")
    private Long dealId;

    @Column(name = "gaming_table_id")
    private Long gamingTableId;
}
