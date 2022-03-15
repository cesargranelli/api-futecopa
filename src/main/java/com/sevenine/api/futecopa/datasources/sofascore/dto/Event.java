package com.sevenine.api.futecopa.datasources.sofascore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    private String id;
    private Round roundInfo;
    private long startTimestamp;
    private Team homeTeam;
    private Score homeScore;
    private Team awayTeam;
    private Score awayScore;
}
