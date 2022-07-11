package com.sevenine.api.futecopa.adapter.rest.apifootball.client;

import com.sevenine.api.futecopa.adapter.rest.apifootball.entities.MatchesApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "api-football", url = "${api-football.api}")
public interface ApiFootballClient {

    @RequestMapping(method = RequestMethod.GET, value = "${api-football.resources.matches}?season=${api-football.season-code}&matchday={matchDay}")
    MatchesApi matches(@PathVariable("matchDay") String matchDay);

}
