package com.sevenine.api.futecopa.datasources.firestore.entities;

import com.google.cloud.firestore.annotation.PropertyName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Event {

    @PropertyName("games")
    private List<Game> games;

}
