package com.ada.gameheavenspringboot.user.entity;

import java.util.List;

public class UserBuilder {

    private String username;
    private String password;
    private String role;
    private boolean isPlaying;
    private boolean isWaiting;
    private boolean isManaging;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public UserBuilder withIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
        return this;
    }

    public UserBuilder withIsWaiting(boolean isWaiting) {
        this.isWaiting = isWaiting;
        return this;
    }

    public UserBuilder withIsManaging(boolean isManaging) {
        this.isManaging = isManaging;
        return this;
    }

    public User buildUserEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setPlaying(isPlaying);
        user.setWaiting(isWaiting);
        user.setManaging(isManaging);
        return user;
    }
}
