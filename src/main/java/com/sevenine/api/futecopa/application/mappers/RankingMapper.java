package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.application.domain.entities.Ranking;
import com.sevenine.api.futecopa.application.domain.entities.Report;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface RankingMapper {

    RankingMapper INSTANCE = Mappers.getMapper(RankingMapper.class);

    @Mapping(target = "total", source = "points")
    @Named(value = "toRankings")
    Ranking toRanking(Report report);

    @IterableMapping(qualifiedByName = "toRankings")
    List<Ranking> toRankings(List<Report> report);

}
