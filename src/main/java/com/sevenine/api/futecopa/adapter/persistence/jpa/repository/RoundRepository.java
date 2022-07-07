package com.sevenine.api.futecopa.adapter.persistence.jpa.repository;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.RoundData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<RoundData, Long> {
}
