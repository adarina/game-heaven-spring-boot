package com.ada.gameheavenspringboot.card.dto;

import com.ada.gameheavenspringboot.Rank;
import com.ada.gameheavenspringboot.Suit;
import com.ada.gameheavenspringboot.hand.entity.Hand;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCardsResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Card {

        private Long id;

        private Suit suit;

        private Rank rank;

        private Hand hand;
    }

    @Singular
    private List<Card> cards;

    public static Function<Collection<com.ada.gameheavenspringboot.card.entity.Card>, GetCardsResponse> entityToDtoMapper() {
        return cards -> {
            GetCardsResponse.GetCardsResponseBuilder response = GetCardsResponse.builder();
            cards.stream()
                    .map(card -> GetCardsResponse.Card.builder()
                            .id(card.getId())
                            .suit(card.getSuit())
                            .rank(card.getRank())
//                            .position(card.getPosition())
                            .build())
                    .forEach(response::card);
            return response.build();
        };
    }

//    public static Function<Collection<com.ada.gameheavenspringboot.board.entity.Board>,
//            GetBoardsResponse> entityToDtoMapper() {
//        return boards -> {
//            GetBoardsResponse.GetBoardsResponseBuilder response = GetBoardsResponse.builder();
//            boards.stream()
//                    .map(board -> GetBoardsResponse.Board.builder()
//                            .id(board.getId())
//                            .status(board.getStatus())
//                            .build())
//                    .forEach(response::board);
//            return response.build();
//        };
//    }
}

