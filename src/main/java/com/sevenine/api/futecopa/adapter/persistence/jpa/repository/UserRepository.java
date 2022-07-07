package com.sevenine.api.futecopa.adapter.persistence.jpa.repository;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByUid(String uid);

    UserData findBySlug(String slug);
}
