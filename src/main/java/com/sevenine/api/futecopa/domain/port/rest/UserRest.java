package com.sevenine.api.futecopa.domain.port.rest;

import com.sevenine.api.futecopa.domain.model.Register;
import com.sevenine.api.futecopa.domain.model.Registered;

public interface UserRest {

    default Registered register(Register register) {
        return new Registered();
    }

}
