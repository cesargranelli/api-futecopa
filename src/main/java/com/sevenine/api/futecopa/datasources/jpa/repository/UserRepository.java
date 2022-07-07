package com.sevenine.api.futecopa.datasources.jpa.repository;

import com.sevenine.api.futecopa.datasources.jpa.entities.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByUid(String uid);
}
