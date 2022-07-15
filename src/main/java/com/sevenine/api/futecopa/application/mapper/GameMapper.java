package com.sevenine.api.futecopa.application.mapper;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface GameMapper {

    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

    @Mapping(target = "id", source = "matchId")
    @Named(value = "fromGamesData")
    Game fromGameData(GameData gameData);

    @IterableMapping(qualifiedByName = "fromGamesData")
    List<Game> fromGamesData(List<GameData> gamesData);

    @Mapping(target = "game.id", ignore = true)
    @Mapping(target = "lastUpdated", expression = "java(LocalDateTime.now())")
    @Mapping(target = "score.home", source = "score.home")
    @Mapping(target = "score.away", source = "score.away")
    @Mapping(target = "matchId", source = "game.id")
    void updateScores(Game game, @MappingTarget GameData gameData);

}
