package com.ada.gameheavenspringboot.game.entity;

public class GameBuilder {

    private GameBuilder() {
    }

    public static GameBuilder aGame() {
        return new GameBuilder();
    }

    public Game defaultBuildBridgeEntity() {
        Game game = new Game();
        game.setName("BRIDGE");
        game.setMaxPlayers(4);
        return game;
    }

    public Game defaultBuildWarEntity() {
        Game game = new Game();
        game.setName("WAR");
        game.setMaxPlayers(2);
        return game;
    }
}
