package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Match")
@Table(name = "matches")
public class MatchData {

    @Id
    private Long id;

    private Integer matchDay;

    @JoinColumn(name = "home_team_id", foreignKey = @ForeignKey(name = "matches_home_team_id_fk"))
    @ManyToOne(cascade = CascadeType.DETACH)
    private TeamData homeTeam;

    @JoinColumn(name = "away_team_id", foreignKey = @ForeignKey(name = "matches_away_team_id_fk"))
    @ManyToOne(cascade = CascadeType.DETACH)
    private TeamData awayTeam;

    @JoinColumn(name = "result_id", foreignKey = @ForeignKey(name = "matches_result_id_fk"))
    @OneToOne(cascade = CascadeType.ALL)
    private ResultData result;

    private LocalDateTime utcDate;
    private LocalDateTime lastUpdated;

}
