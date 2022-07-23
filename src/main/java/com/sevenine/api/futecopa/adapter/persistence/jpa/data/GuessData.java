package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "Guess")
@Table(name = "guesses")
public class GuessData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "guesses_id_seq")
    private Long id;

    private String slug;

    private Integer matchDay;

    @JoinTable(name = "guesses_games",
            joinColumns = @JoinColumn(name = "guess_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    @OneToMany(cascade = CascadeType.ALL)
    private List<GameData> games;

}
