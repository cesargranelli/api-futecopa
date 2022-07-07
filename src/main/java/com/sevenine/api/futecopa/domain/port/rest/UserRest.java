package com.sevenine.api.futecopa.domain.port.rest;

import com.sevenine.api.futecopa.domain.model.Login;
import com.sevenine.api.futecopa.domain.model.Logon;
import com.sevenine.api.futecopa.domain.model.Register;
import com.sevenine.api.futecopa.domain.model.Registered;

public interface UserRest {

    Registered register(Register register);

    Logon login(Login login);

}
