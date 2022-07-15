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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;

    private Integer matchDay;

    @OneToMany(mappedBy = "guess", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GameData> games;

}
