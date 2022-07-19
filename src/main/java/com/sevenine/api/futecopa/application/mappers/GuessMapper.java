package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Guess;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface GuessMapper {

    GuessMapper INSTANCE = Mappers.getMapper(GuessMapper.class);

    @Mapping(target = "guess", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "matchId", source = "game.id")
    @Named(value = "toGamesData")
    GameData toGameData(Game game);

    @IterableMapping(qualifiedByName = "toGamesData")
    List<GameData> toGamesData(List<Game> game);

    @Mapping(target = "id", ignore = true)
    GuessData toGuessData(Guess guess);

}
