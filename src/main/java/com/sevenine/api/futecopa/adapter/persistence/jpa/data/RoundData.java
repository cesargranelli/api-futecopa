package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "Round")
@Table(name = "rounds")
public class RoundData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "rounds_id_seq")
    private Long id;

    private Integer matchDay;
    private String name;
    private String stage;
    private LocalDate start;

    @Column(name = "`end`")
    private LocalDate end;

    private String status;

}
