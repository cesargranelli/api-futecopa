package com.sevenine.api.futecopa.datasources.apifootball.entities;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Match {
    private long id;
    private LocalDateTime utcDate;
    private String status;
    private int matchday;
    private String stage;
    private String group;
    private LocalDateTime lastUpdated;
    private Object homeTeam;
    private Object awayTeam;
    private Object score;
}
