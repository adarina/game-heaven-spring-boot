package com.ada.gameheavenspringboot.deal.entity;

import com.ada.gameheavenspringboot.card.entity.Card;
import com.ada.gameheavenspringboot.board.entity.Board;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gaming_table")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "card")
    private Card card;

    @Column(name = "number")
    private int number;


}