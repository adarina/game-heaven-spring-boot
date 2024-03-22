package com.ada.gameheavenspringboot.deal.dto;

import com.ada.gameheavenspringboot.deal.entity.Deal;
import lombok.*;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetDealResponse {

    private int number;

    public static Function<Deal, com.ada.gameheavenspringboot.deal.dto.GetDealResponse> entityToDtoMapper() {
        return worker -> GetDealResponse.builder()
                .number(worker.getNumber())
                .build();
    }
}




