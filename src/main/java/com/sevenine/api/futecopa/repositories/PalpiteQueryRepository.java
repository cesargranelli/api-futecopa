package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.PalpiteResponse;

import java.util.List;

public interface PalpiteQueryRepository {
    List<PalpiteResponse> findHunchesBySlugAndRound(String slug, String round);
}
