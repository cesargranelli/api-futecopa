package com.sevenine.api.futecopa.application.rules;

import com.sevenine.api.futecopa.application.domain.entities.Report;
import com.sevenine.api.futecopa.application.domain.enumerators.Scoring;
import com.sevenine.api.futecopa.application.domain.ports.services.ScoringRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Lazy))
@Component
public class ScoringRuleServiceExactScore implements ScoringRuleService<Object, Integer> {

    @Lazy
    private final List<ScoringRuleService<Object, Integer>> rules;

    @Override
    public Integer execute(Object... objects) {
        Report report = (Report) objects[0];

        if (report.getScoreHome().equals(report.getResultHome()) && report.getScoreAway().equals(report.getResultAway()) &&
                !report.getScoreHome().equals(report.getResultAway())) {
            return Scoring.EXACT_SCORE.getPoints();
        }

        return rules.stream().filter(object -> object instanceof ScoringRuleServiceWinnerScore).findAny().orElseThrow()
                .execute(report);
    }

}
