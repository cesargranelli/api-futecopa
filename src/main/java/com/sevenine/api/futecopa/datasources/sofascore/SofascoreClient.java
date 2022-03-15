package com.sevenine.api.futecopa.datasources.sofascore;

import com.sevenine.api.futecopa.datasources.sofascore.dto.SofascoreEventsResponse;
import com.sevenine.api.futecopa.datasources.sofascore.response.RoundResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sofascore", url = "${sofascore.api}")
public interface SofascoreClient {

    @RequestMapping(method = RequestMethod.GET, value = "${sofascore.source.rounds}")
    RoundResponse getRounds();

    @RequestMapping(method = RequestMethod.GET, value = "${sofascore.source.events}/round/{round}")
    SofascoreEventsResponse getEventsByRound(@PathVariable("round") final String round);

}
