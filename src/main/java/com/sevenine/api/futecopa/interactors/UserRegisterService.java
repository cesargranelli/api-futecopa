package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.entities.AuthCreate;
import com.sevenine.api.futecopa.entities.AuthCreated;
import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.entities.UserRegistered;
import com.sevenine.api.futecopa.interactors.mapper.UserRegisterMapper;
import com.sevenine.api.futecopa.repositories.AuthCreateRepository;
import com.sevenine.api.futecopa.repositories.UserQueryRepository;
import com.sevenine.api.futecopa.repositories.UserRegisterRepository;
import com.sevenine.api.futecopa.transportlayers.dto.UserRegister;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserRegisterService {

    private final AuthCreateRepository authCreateRepository;
    private final UserRegisterRepository userRegisterRepository;
    private final UserQueryRepository userQueryRepository;

    private final ObjectMapper objectMapper;

    public UserRegistered executar(UserRegister userRegister) {
        AuthCreate authCreate = UserRegisterMapper.INSTANCE.toAuthCreate(userRegister);

        AuthCreated authCreated = authCreateRepository.create(authCreate);

        User newUser = UserRegisterMapper.INSTANCE.toUser(authCreated, userRegister);

        userRegisterRepository.create(newUser);

        return objectMapper.convertValue(newUser, UserRegistered.class);
    }

}
