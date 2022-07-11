package com.sevenine.api.futecopa.application.domain.ports.rest;

import com.sevenine.api.futecopa.application.domain.entities.Login;
import com.sevenine.api.futecopa.application.domain.entities.Logon;
import com.sevenine.api.futecopa.application.domain.entities.Register;
import com.sevenine.api.futecopa.application.domain.entities.Registered;

public interface UserRest {

    Registered register(Register register);

    Logon login(Login login);

}
