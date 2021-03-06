package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.RoundData;
import com.sevenine.api.futecopa.application.domain.entities.Round;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface RoundMapper {

    RoundMapper INSTANCE = Mappers.getMapper(RoundMapper.class);

    @Named(value = "toRounds")
    Round toRound(RoundData roundData);

    @IterableMapping(qualifiedByName = "toRounds")
    List<Round> toRounds(List<RoundData> roundsData);

}
