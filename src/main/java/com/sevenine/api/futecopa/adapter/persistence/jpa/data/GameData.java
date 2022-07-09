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
    private Long id;

    private Integer matchDay;

    @OneToOne
    private TeamData homeTeam;

    @OneToOne
    private TeamData awayTeam;

    @OneToOne(cascade = CascadeType.ALL)
    private ScoreData score;

    private LocalDateTime utcDate;

    @CreationTimestamp
    private LocalDateTime lastUpdated;

}
