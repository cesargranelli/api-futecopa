package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "Report")
@Table(name = "reports")
public class ReportData {

    @Id
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

}
