package com.sevenine.api.futecopa.adapter.persistence.jpa.repository;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GuessData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuessRepository extends JpaRepository<GuessData, Long> {
    Optional<GuessData> findBySlugAndMatchDay(String slug, Integer matchDay);
}
