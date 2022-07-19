package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import com.sevenine.api.futecopa.adapter.persistence.jpa.data.UserData;
import com.sevenine.api.futecopa.application.domain.entities.Bet;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface BetMapper {

    BetMapper INSTANCE = Mappers.getMapper(BetMapper.class);

    //    @Mapping(target = "user", source = "userData")
//    @Mapping(target = "game", ignore = true)
//    @Mapping(target = "game.id", source = "gameData.matchId")
//    @Mapping(target = "game.utcDate", source = "gameData.utcDate")
//    @Mapping(target = "game.lastUpdated", source = "gameData.lastUpdated")
//    @Mapping(target = "game.matchDay", source = "gameData.matchDay")
//    @Mapping(target = "game.homeTeam", source = "gameData.homeTeam")
//    @Mapping(target = "game.awayTeam", source = "gameData.awayTeam")
//    @Mapping(target = "game.score", source = "gameData.score")
    @Named(value = "fromGameDataList")
    Bet fromGuessData(GameData gameData, UserData userData);

    //    @IterableMapping(qualifiedByName = "fromGameDataList")
    void insertGameList(List<GameData> gameDataList, @MappingTarget List<Bet> bets);

}
