package com.sevenine.api.futecopa.datasources.firestore.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Getter
@Setter
@Document(collectionName = "matchDays")
public class MatchDay {

    @DocumentId
    private String id;

    private List<Game> games;

}
