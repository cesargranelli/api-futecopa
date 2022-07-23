package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.ReportRepository;
import com.sevenine.api.futecopa.application.domain.entities.Ranking;
import com.sevenine.api.futecopa.application.domain.entities.Report;
import com.sevenine.api.futecopa.application.domain.ports.services.RankingService;
import com.sevenine.api.futecopa.application.domain.ports.services.ScoringRuleService;
import com.sevenine.api.futecopa.application.mappers.RankingMapper;
import com.sevenine.api.futecopa.application.mappers.ReportMapper;
import com.sevenine.api.futecopa.application.rules.ScoringRuleServiceExactScore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RankingServiceList implements RankingService<Object, List<Ranking>> {

    private final ReportRepository repository;

    private final List<ScoringRuleService<Object, Integer>> rules;

    @Override
    public List<Ranking> execute(Object... objects) {
        List<Report> reports = ReportMapper.INSTANCE.toReports(repository.findAll());

        return RankingMapper.INSTANCE.toRankings(reports.stream().peek(report -> {
            report.setPoints(rules.stream().filter(object -> object instanceof ScoringRuleServiceExactScore).findAny().orElseThrow()
                    .execute(report));
        }).collect(Collectors.toList()));
    }

}
