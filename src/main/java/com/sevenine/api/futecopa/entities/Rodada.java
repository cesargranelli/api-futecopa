package com.sevenine.api.futecopa.entities;

import com.sevenine.api.futecopa.datasources.firestore.entities.Evento;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rodada {
    private Integer id;
    private String nome;
    private String apelido;
    private String emAndamento;
    private List<Evento> eventos;
}
