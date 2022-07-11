package com.sevenine.api.futecopa.application.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
    private Long id;
    private String name;
    private String shortName;
    private String tla;
    private String crest;
}
