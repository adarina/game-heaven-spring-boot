package com.ada.gameheavenspringboot.board.entity;


import com.ada.gameheavenspringboot.Status;
import com.ada.gameheavenspringboot.game.entity.Game;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "gaming_tables")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
