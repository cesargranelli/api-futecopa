package com.sevenine.api.futecopa.datasources.apifootball.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchesApi {
    private List<MatchApi> matches;
}
