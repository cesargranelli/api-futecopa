package com.sevenine.api.futecopa.datasources.firestore.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gcp.data.firestore.Document;

@Getter
@Setter
@Document(collectionName = "rounds")
public class Round {
    private String end;
    private String name;
    private String matchDay;
    private String stage;
    private String start;
    private String status;
}
