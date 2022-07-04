package com.sevenine.api.futecopa.datasources.apifootball;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "api-football", url = "${api-football.api}")
public interface ApiFootballClient {

    @RequestMapping(method = RequestMethod.GET, value = "${api-football.resources.matches}?season=${api-football.season-code}&matchday={matchDay}")
    Map<String, Object> season(@PathVariable("matchDay") String matchDay);

}
