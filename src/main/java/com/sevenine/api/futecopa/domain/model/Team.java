package com.sevenine.api.futecopa.domain.model;

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
