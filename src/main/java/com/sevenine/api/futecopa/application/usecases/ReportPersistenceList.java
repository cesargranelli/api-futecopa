package com.sevenine.api.futecopa.application.usecases;

import com.sevenine.api.futecopa.adapter.persistence.jpa.repository.ReportRepository;
import com.sevenine.api.futecopa.application.domain.entities.Report;
import com.sevenine.api.futecopa.application.domain.ports.services.ReportPersistence;
import com.sevenine.api.futecopa.application.mappers.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReportPersistenceList implements ReportPersistence<Object, List<Report>> {

    private final ReportRepository repository;

    @Override
    public List<Report> execute(Object... objects) {
        return ReportMapper.INSTANCE.toReports(repository.findAll());
    }

}
