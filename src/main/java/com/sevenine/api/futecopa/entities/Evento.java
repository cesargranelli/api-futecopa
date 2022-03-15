package com.sevenine.api.futecopa.entities;

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
