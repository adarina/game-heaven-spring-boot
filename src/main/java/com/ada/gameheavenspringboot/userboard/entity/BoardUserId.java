package com.ada.gameheavenspringboot.userboard.entity;

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
public class BoardUserId implements Serializable{

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "gaming_table_id")
    private Long gamingTableId;

}