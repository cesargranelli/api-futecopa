package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.MatchData;
import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchApi;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface MatchMapper {

    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    List<Match> toMatches(List<MatchData> matchesData);

    List<MatchData> toMatchesData(List<MatchApi> matches);

}
