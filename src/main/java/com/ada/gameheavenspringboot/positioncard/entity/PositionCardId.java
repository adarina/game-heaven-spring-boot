package com.ada.gameheavenspringboot.positioncard.entity;

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
public class PositionCardId implements Serializable {

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "card_id")
    private Long cardId;

}
