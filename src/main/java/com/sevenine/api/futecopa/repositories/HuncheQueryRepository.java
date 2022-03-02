package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.Hunche;

import java.util.List;

public interface HuncheQueryRepository {
    List<Hunche> findBySlugAndRound(String slug, String round);
}
