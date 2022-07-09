package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.adapter.rest.apifootball.client.ApiFootballClient;
import com.sevenine.api.futecopa.datasources.firestore.entities.MatchDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchService {

    private final ApiFootballClient apiFootballClient;

//    private final EventRepository eventRepository;

    private final ObjectMapper mapper;

    public MatchDay findByGames(String matchDay) {
//        List<Match> matches = mapper.convertValue(apiFootballClient.season(matchDay).get("matches"), new TypeReference<>() {
//        });
//
//        Event event = new Event();
//        event.setDocument(matchDay);
//        event.setGames(matches.stream().map(match -> mapper.convertValue(match, Game.class)).collect(Collectors.toList()));

        return null;//eventRepository.save(event).block();
    }

}
