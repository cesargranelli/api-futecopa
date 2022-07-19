package com.sevenine.api.futecopa.adapter.persistence.jpa.repository;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.GameData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<GameData, Long> {
    Optional<List<GameData>> findByMatchId(Long matchId);
}
