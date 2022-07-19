package com.sevenine.api.futecopa.application.mappers;

import com.sevenine.api.futecopa.adapter.persistence.jpa.data.UserData;
import com.sevenine.api.futecopa.application.domain.entities.Register;
import com.sevenine.api.futecopa.application.domain.entities.Registered;
import com.sevenine.api.futecopa.application.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "uid", source = "registered.localId")
    @Mapping(target = "name", source = "register.name")
    @Mapping(target = "slug", source = "register.nickname")
    @Mapping(target = "nickname", source = "register.nickname")
    @Mapping(target = "email", source = "register.email")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "round", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "photo", ignore = true)
    UserData toUserData(Register register, Registered registered);

    User toUser(UserData userData);

}
