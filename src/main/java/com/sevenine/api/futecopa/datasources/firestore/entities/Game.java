package com.sevenine.api.futecopa.datasources.firestore.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gcp.data.firestore.Document;

@Getter
@Setter
@Document(collectionName = "games")
public class Game {

    @DocumentId
    private String id;

    private String utcDate;
    private String status;
    private int matchday;
    private String stage;
    private String group;
    private String lastUpdated;
    private Team homeTeam;
    private Team awayTeam;
    private Score score;

}
