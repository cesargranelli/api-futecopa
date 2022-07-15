package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "Team")
@Table(name = "teams")
public class TeamData {

    @Id
    private Long id;

    private String name;
    private String shortName;
    private String tla;
    private String crest;

}
