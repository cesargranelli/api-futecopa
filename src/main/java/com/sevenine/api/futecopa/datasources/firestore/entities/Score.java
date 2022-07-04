package com.sevenine.api.futecopa.datasources.firestore.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private String duration;
    private String winner;
    private Time halfTime;
    private Time fullTime;
}
