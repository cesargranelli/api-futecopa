package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.Usuario;

public interface UsuarioCadastroRepository {
    void create(Usuario newUsuario);
}
