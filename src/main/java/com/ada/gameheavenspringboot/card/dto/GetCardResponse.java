package com.ada.gameheavenspringboot.card.dto;

import com.ada.gameheavenspringboot.Rank;
import com.ada.gameheavenspringboot.Suit;
import com.ada.gameheavenspringboot.card.entity.Card;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCardResponse {

    private Suit suit;

    private Rank rank;

    public static Function<Card, GetCardResponse> entityToDtoMapper() {
        return card -> GetCardResponse.builder()
                .suit(card.getSuit())
                .rank(card.getRank())
                .build();
    }
}