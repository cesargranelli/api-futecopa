package com.sevenine.api.futecopa.datasources.sofascore.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SofascoreEventsResponse {
    private List<Event> events;
    private boolean hasNextPage;
}
