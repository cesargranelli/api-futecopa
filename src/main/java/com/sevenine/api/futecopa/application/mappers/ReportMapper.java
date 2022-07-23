package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.ReportData;
import com.sevenine.api.futecopa.application.domain.entities.Report;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    List<Report> toReports(List<ReportData> reportData);

}
