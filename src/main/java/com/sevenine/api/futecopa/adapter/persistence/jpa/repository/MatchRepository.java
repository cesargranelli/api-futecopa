package com.sevenine.api.futecopa.adapter.persistence.jpa.repository;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.MatchData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<MatchData, Long> {
    List<MatchData> findByMatchDay(Integer matchDay);
}
