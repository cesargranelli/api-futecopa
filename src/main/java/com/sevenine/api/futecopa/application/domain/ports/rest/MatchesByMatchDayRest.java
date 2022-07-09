package com.sevenine.api.futecopa.application.domain.ports.rest;

import com.sevenine.api.futecopa.application.domain.entities.Game;

import java.util.List;

public interface MatchesByMatchDayRest {
    List<Game> matches(String matchDay);
}
