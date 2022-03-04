package com.sevenine.api.futecopa.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hunche {
    private Long id;
    private String awayLogo;
    private String awayScore;
    private String awaySlug;
    private String awayTeam;
    private String formatedStartDate;
    private String homeLogo;
    private String homeScore;
    private String homeSlug;
    private String homeTeam;
    private String round;
    private String startTime;
    private String startTimestamp;
}
