package com.sevenine.api.futecopa.datasources.firestore.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Getter
@Setter
@Document(collectionName = "events")
public class Event1 {
    private Integer id;
    private String nome;
    private String apelido;
    private String emAndamento;
    private List<Evento> eventos;
}
