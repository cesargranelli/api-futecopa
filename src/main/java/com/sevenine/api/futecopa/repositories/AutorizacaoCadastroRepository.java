package com.sevenine.api.futecopa.repositories;

import com.sevenine.api.futecopa.entities.UsuarioCadastrado;
import com.sevenine.api.futecopa.entities.UsuarioCadastro;

public interface AutorizacaoCadastroRepository {
    UsuarioCadastrado create(UsuarioCadastro usuarioCadastro);
}
