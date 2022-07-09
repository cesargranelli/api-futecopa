package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "matches")
public class MatchData {

    @Id
    private Long id;

    private Integer matchDay;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamData homeTeam;

    @OneToOne(cascade = CascadeType.ALL)
    private TeamData awayTeam;

    private LocalDateTime utcDate;
    private LocalDateTime lastUpdated;

}
