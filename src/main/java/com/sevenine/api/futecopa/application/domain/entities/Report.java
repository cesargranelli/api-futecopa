package com.sevenine.api.futecopa.application.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {
    private Long id;
    private String slug;
    private Integer matchDay;
    private Long matchId;
    private Integer scoreWinner;
    private Integer scoreLooser;
    private Integer resultWinner;
    private Integer resultLooser;
    private String winnerGame;
    private String winnerMatch;
    private Integer points;
}
