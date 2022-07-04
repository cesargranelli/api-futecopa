package com.sevenine.api.futecopa.datasources.firestore.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
    private long id;
    private String name;
    private String shortName;
    private String tla;
}
