package com.ada.gameheavenspringboot.user.dto;

import com.ada.gameheavenspringboot.user.entity.User;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetUserResponse {

    private String username;

    public static Function<User, GetUserResponse> entityToDtoMapper() {
        return worker -> GetUserResponse.builder()
                .username(worker.getUsername())
                .build();
    }
}
