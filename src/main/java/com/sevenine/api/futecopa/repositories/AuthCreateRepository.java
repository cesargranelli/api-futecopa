package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.AuthCreate;
import com.sevenine.api.futecopa.entities.AuthCreated;

public interface AuthCreateRepository {
    AuthCreated create(AuthCreate authCreate);
}
