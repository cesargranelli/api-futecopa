package com.sevenine.api.futecopa.interactors.mapper;

import com.sevenine.api.futecopa.datasources.firestore.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uid", expression = "java(userRecord.get(\"localId\"))")
    @Mapping(target = "name", expression = "java(user.get(\"name\"))")
    @Mapping(target = "slug", expression = "java(user.get(\"nickname\"))")
    @Mapping(target = "nickname", expression = "java(user.get(\"nickname\"))")
    @Mapping(target = "email", expression = "java(user.get(\"email\"))")
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "round", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "photo", ignore = true)
    User toUser(Map<String, String> user, Map<String, String> userRecord);

}
