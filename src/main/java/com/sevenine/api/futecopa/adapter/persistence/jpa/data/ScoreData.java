package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Score")
@Table(name = "scores")
public class ScoreData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "scores_id_seq")
    private Long id;

    private String winner;
    private String duration;
    private Integer home;
    private Integer away;

}
