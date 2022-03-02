package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.User;

public interface UserQueryRepository {
    User findByUserWithSlug(String slug);

    User findByUserWithUid(String uid);
}
