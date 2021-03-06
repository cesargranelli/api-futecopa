package com.sevenine.api.futecopa.adapter.rest.apifootball.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreApi {
    private String winner;
    private String duration;
    private TimeApi fullTime;
    private TimeApi halfTime;
    private Long matchId;
}
