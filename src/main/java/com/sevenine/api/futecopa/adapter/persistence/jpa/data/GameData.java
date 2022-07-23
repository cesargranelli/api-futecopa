package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Game")
@Table(name = "games")
public class GameData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "games_id_seq")
    private Long id;

    private Long matchId;

    private Integer matchDay;

    @JoinColumn(name = "home_team_id", foreignKey = @ForeignKey(name = "games_home_team_id_fk"))
    @ManyToOne(cascade = CascadeType.DETACH)
    private TeamData homeTeam;

    @JoinColumn(name = "away_team_id", foreignKey = @ForeignKey(name = "games_away_team_id_fk"))
    @ManyToOne(cascade = CascadeType.DETACH)
    private TeamData awayTeam;

    @JoinColumn(name = "score_id", foreignKey = @ForeignKey(name = "games_score_id_fk"))
    @OneToOne(cascade = CascadeType.ALL)
    private ScoreData score;

    private LocalDateTime utcDate;

    @CreationTimestamp
    private LocalDateTime lastUpdated;

    @JoinTable(name = "guesses_games",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "guess_id")
    )
    @ManyToOne
    private GuessData guess;

}
