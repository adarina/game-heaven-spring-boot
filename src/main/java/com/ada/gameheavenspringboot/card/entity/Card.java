package com.ada.gameheavenspringboot.card.entity;

import com.ada.gameheavenspringboot.Rank;
import com.ada.gameheavenspringboot.Suit;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "suit")
    private Suit suit;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank")
    private Rank rank;
}