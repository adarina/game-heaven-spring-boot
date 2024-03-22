package com.ada.gameheavenspringboot.game.dto;

import com.ada.gameheavenspringboot.user.entity.User;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

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
public class GetGamesResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Game {

        private Long id;

        private String name;

        private int maxPlayers;

    }

    @Singular
    private List<com.ada.gameheavenspringboot.game.dto.GetGamesResponse.Game> games;

    public static Function<Collection<com.ada.gameheavenspringboot.game.entity.Game>,
            com.ada.gameheavenspringboot.game.dto.GetGamesResponse> entityToDtoMapper() {
        return games -> {
            com.ada.gameheavenspringboot.game.dto.GetGamesResponse.GetGamesResponseBuilder response = com.ada.gameheavenspringboot.game.dto.GetGamesResponse.builder();
            games.stream()
                    .map(game -> com.ada.gameheavenspringboot.game.dto.GetGamesResponse.Game.builder()
                            .id(game.getId())
                            .name(game.getName())
                            .maxPlayers(game.getMaxPlayers())
                            .build())
                    .forEach(response::game);
            return response.build();
        };
    }
}