package com.ada.gameheavenspringboot.user.dto;

import com.ada.gameheavenspringboot.user.entity.User;
import lombok.*;

import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateUserRequest {

    private String username;

    private String password;

    private String role;

    public static Function<CreateUserRequest, User> dtoToEntityMapper() {
        return request -> User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }
}
