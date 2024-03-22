package com.ada.gameheavenspringboot.pilecard.entity;

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
public class PileCardId implements Serializable {

    @Column(name = "pile_id")
    private Long pileId;

    @Column(name = "card_id")
    private Long cardId;

}
