package com.sevenine.api.futecopa.adapter.rest.apifootball.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MatchApi {

    private Long id;

    @JsonAlias(value = "matchday")
    private Integer matchDay;

    private TeamApi homeTeam;
    private TeamApi awayTeam;
    private ScoreApi score;
    private LocalDateTime utcDate;
    private LocalDateTime lastUpdated;

}
