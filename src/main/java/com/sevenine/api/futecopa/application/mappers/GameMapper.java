package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import com.sevenine.api.futecopa.application.domain.entities.Game;
import com.sevenine.api.futecopa.application.domain.entities.Match;
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

    @Mapping(target = "guess", ignore = true)
    @Mapping(target = "gameData.id", ignore = true)
    @Mapping(target = "gameData.score.id", ignore = true)
    @Mapping(target = "lastUpdated", expression = "java(LocalDateTime.now())")
    @Mapping(target = "matchId", source = "game.id")
    void updateScores(Game game, @MappingTarget GameData gameData);

    List<Game> fromMatches(List<Match> matches);
}
