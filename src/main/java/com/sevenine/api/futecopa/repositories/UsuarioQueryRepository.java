package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.Usuario;

public interface UsuarioQueryRepository {
    Usuario buscaUsuarioApelido(String apelido);

    Usuario buscaUsuarioUid(String uid);
}
