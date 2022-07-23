package com.sevenine.api.futecopa.application.domain.enumerators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Scoring {
    EXACT_SCORE(25),
    WINNER_SCORE(18),
    DIFFERENT_SCORE(15),
    NOT_EXACT_DRAW(15),
    LOOSER_SCORE(12),
    WINNER_TEAM(10),
    BET_DRAW_WINNER(2);

    private final Integer points;
}
