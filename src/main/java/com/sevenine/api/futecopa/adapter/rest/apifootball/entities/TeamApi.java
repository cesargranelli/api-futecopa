package com.sevenine.api.futecopa.adapter.rest.apifootball.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamApi {
    private Long id;
    private String name;
    private String shortName;
    private String tla;
    private String crest;
}
