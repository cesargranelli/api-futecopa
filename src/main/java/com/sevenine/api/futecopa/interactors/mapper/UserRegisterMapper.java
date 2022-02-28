package com.sevenine.api.futecopa.interactors.mapper;

import com.sevenine.api.futecopa.entities.AuthCreate;
import com.sevenine.api.futecopa.entities.AuthCreated;
import com.sevenine.api.futecopa.entities.User;
import com.sevenine.api.futecopa.transportlayers.dto.UserRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface UserRegisterMapper {

    UserRegisterMapper INSTANCE = Mappers.getMapper(UserRegisterMapper.class);

    @Mapping(target = "displayName", source = "name")
    AuthCreate toAuthCreate(UserRegister userRegister);

    @Mapping(target = "uid", source = "authCreated.uid")
    @Mapping(target = "slug", source = "userRegister.nickname")
    @Mapping(target = "email", source = "authCreated.email")
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "round", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "foto", ignore = true)
    User toUser(AuthCreated authCreated, UserRegister userRegister);

}
