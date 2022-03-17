package com.sevenine.api.futecopa.interactors.mapper;

import com.sevenine.api.futecopa.entities.UsuarioCadastrado;
import com.sevenine.api.futecopa.entities.UsuarioCadastro;
import com.sevenine.api.futecopa.entities.Usuario;
import com.sevenine.api.futecopa.transportlayers.dto.UsuarioRegistro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(implementationPackage = "<PACKAGE_NAME>.impl")
public interface UsuarioCadastroMapper {

    UsuarioCadastroMapper INSTANCE = Mappers.getMapper(UsuarioCadastroMapper.class);

    @Mapping(target = "displayName", source = "name")
    UsuarioCadastro registroToCadastro(UsuarioRegistro usuarioRegistro);

    @Mapping(target = "uid", source = "usuarioCadastrado.uid")
    @Mapping(target = "slug", source = "usuarioRegistro.nickname")
    @Mapping(target = "email", source = "usuarioCadastrado.email")
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "round", ignore = true)
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "foto", ignore = true)
    Usuario toUser(UsuarioCadastrado usuarioCadastrado, UsuarioRegistro usuarioRegistro);

}
