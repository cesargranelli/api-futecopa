package com.sevenine.api.futecopa.transportlayers.api;

import com.sevenine.api.futecopa.entities.Usuario;
import com.sevenine.api.futecopa.entities.UsuarioRegistrado;
import com.sevenine.api.futecopa.interactors.RegistroService;
import com.sevenine.api.futecopa.repositories.UsuarioQueryRepository;
import com.sevenine.api.futecopa.transportlayers.dto.UsuarioRegistro;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("usuarios")
@RestController
public class UsuarioApi {

    private final RegistroService registroService;
    private final UsuarioQueryRepository repository;

    @PostMapping(value = "registro")
    public UsuarioRegistrado registro(@RequestBody UsuarioRegistro usuarioRegistro) {
        return registroService.executar(usuarioRegistro);
    }

    @GetMapping("apelido")
    public Usuario apelido(@RequestHeader String apelido) {
        return repository.buscaUsuarioApelido(apelido);
    }

    @GetMapping("uid")
    public Usuario uid(@RequestHeader String uid) {
        return repository.buscaUsuarioUid(uid);
    }

}
