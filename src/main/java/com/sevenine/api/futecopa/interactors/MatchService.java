package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.datasources.apifootball.ApiFootballClient;
import com.sevenine.api.futecopa.datasources.apifootball.entities.Match;
import com.sevenine.api.futecopa.datasources.firestore.entities.Event;
import com.sevenine.api.futecopa.datasources.firestore.entities.Game;
import com.sevenine.api.futecopa.datasources.firestore.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MatchService {

    private final ApiFootballClient apiFootballClient;

    private final EventRepository eventRepository;

    private final ObjectMapper mapper;

    public Event findByGames(String matchDay) {
//        List<Match> matches = mapper.convertValue(apiFootballClient.season(matchDay).get("matches"), new TypeReference<>() {
//        });
//
//        Event event = new Event();
//        event.setDocument(matchDay);
//        event.setGames(matches.stream().map(match -> mapper.convertValue(match, Game.class)).collect(Collectors.toList()));

        return null;//eventRepository.save(event).block();
    }

}
