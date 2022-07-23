package com.sevenine.api.futecopa.adapter.persistence.jpa.repository;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.ReportData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportData, Long> {
}
