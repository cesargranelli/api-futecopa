package com.sevenine.api.futecopa.datasources.firestore.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Getter
@Setter
@Document(collectionName = "matches")
public class Match {

    @DocumentId
    private String matchDay;

    @PropertyName("games")
    private List<Game> games;

}
