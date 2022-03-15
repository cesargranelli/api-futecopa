package com.sevenine.api.futecopa.datasources.sofascore.response;

import com.sevenine.api.futecopa.datasources.sofascore.dto.Round;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoundResponse {
    private Round currentRound;
    private List<Round> rounds;
}
