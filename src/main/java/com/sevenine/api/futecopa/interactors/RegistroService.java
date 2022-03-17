package com.sevenine.api.futecopa.interactors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.api.futecopa.entities.Usuario;
import com.sevenine.api.futecopa.entities.UsuarioCadastrado;
import com.sevenine.api.futecopa.entities.UsuarioCadastro;
import com.sevenine.api.futecopa.entities.UsuarioRegistrado;
import com.sevenine.api.futecopa.interactors.mapper.UsuarioCadastroMapper;
import com.sevenine.api.futecopa.repositories.AutorizacaoCadastroRepository;
import com.sevenine.api.futecopa.repositories.UsuarioCadastroRepository;
import com.sevenine.api.futecopa.transportlayers.dto.UsuarioRegistro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistroService {

    private final AutorizacaoCadastroRepository autorizacaoCadastroRepository;
    private final UsuarioCadastroRepository usuarioCadastroRepository;

    private final ObjectMapper objectMapper;

    public UsuarioRegistrado executar(UsuarioRegistro usuarioRegistro) {
        UsuarioCadastro usuarioCadastro = UsuarioCadastroMapper.INSTANCE.registroToCadastro(usuarioRegistro);

        UsuarioCadastrado usuarioCadastrado = autorizacaoCadastroRepository.create(usuarioCadastro);

        Usuario novoUsuario = UsuarioCadastroMapper.INSTANCE.toUser(usuarioCadastrado, usuarioRegistro);

        usuarioCadastroRepository.create(novoUsuario);

        return objectMapper.convertValue(novoUsuario, UsuarioRegistrado.class);
    }

}
