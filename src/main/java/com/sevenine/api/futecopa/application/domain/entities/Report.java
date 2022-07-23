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
    private Integer scoreHome;
    private Integer scoreAway;
    private Integer resultHome;
    private Integer resultAway;
    private Integer points;
}
