package com.sevenine.api.futecopa.application.mapper;

import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchApi;
import com.sevenine.api.futecopa.application.domain.entities.Match;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface MatchMapper {

    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    @Named(value = "fromMatchesApi")
    Match fromMatchApi(MatchApi matchApi);

    @IterableMapping(qualifiedByName = "fromMatchesApi")
    List<Match> fromMatchesApi(List<MatchApi> matchesApi);

}
