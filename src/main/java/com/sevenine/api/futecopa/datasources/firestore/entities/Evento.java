package com.sevenine.api.futecopa.datasources.firestore.entities;

import com.sevenine.api.futecopa.entities.Time;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evento {
    private String id;
    private Long inicio;
    private Time mandante;
    private Time visitante;
}
