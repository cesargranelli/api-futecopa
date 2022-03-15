package com.sevenine.api.futecopa.interactors.mapper;

import com.sevenine.api.futecopa.datasources.sofascore.dto.Event;
import com.sevenine.api.futecopa.datasources.sofascore.dto.Round;
import com.sevenine.api.futecopa.datasources.sofascore.dto.Score;
import com.sevenine.api.futecopa.datasources.sofascore.dto.Team;
import com.sevenine.api.futecopa.entities.Evento;
import com.sevenine.api.futecopa.entities.Rodada;
import com.sevenine.api.futecopa.entities.Time;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl", imports = StringUtils.class)
public interface RodadaMapper {

    RodadaMapper INSTANCE = Mappers.getMapper(RodadaMapper.class);

    @Mapping(target = "id", source = "round.round")
    @Mapping(target = "nome", source = "round.name")
    @Mapping(target = "apelido", expression = "java(!StringUtils.isEmpty(round.getSlug())?round.getSlug():String.valueOf(round.getRound()))")
    @Mapping(target = "emAndamento", source = "currentRound.slug")
    @Mapping(target = "eventos", ignore = true)
    Rodada convertRoundToRodada(Round round, Round currentRound);

    @IterableMapping(qualifiedByName = "convertEventToEvento")
    List<Evento> convertEventsToEventos(List<Event> events);

    @Mapping(target = "mandante", expression = "java(convertTeamToTime(event.getHomeTeam(), event.getHomeScore()))")
    @Mapping(target = "visitante", expression = "java(convertTeamToTime(event.getAwayTeam(), event.getAwayScore()))")
    @Mapping(target = "inicio", source = "startTimestamp")
    @Named(value = "convertEventToEvento")
    Evento convertEventToEvento(Event event);

    @Mapping(target = "nome", source = "team.name")
    @Mapping(target = "apelido", source = "team.slug")
    @Mapping(target = "sigla", source = "team.nameCode")
    @Mapping(target = "placar", source = "score.current")
    @Mapping(target = "logo", expression = "java(\"https://www.sofascore.com/images/team-logo/football_\".concat(String.valueOf(team.getId())).concat(\".png\"))")
    Time convertTeamToTime(Team team, Score score);

}
