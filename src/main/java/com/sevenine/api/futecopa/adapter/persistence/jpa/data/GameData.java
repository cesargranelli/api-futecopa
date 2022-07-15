package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "games")
public class GameData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;

    private Integer matchDay;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamData homeTeam;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamData awayTeam;

    @OneToOne(cascade = CascadeType.ALL)
    private ScoreData score;

    private LocalDateTime utcDate;

    @CreationTimestamp
    private LocalDateTime lastUpdated;

//    @JoinTable(
//            name = "guesses_games",
//            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "guess_id", referencedColumnName = "id")
//    )
//    @ManyToOne
//    private GuessData guess;

}
