package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Time")
@Table(name = "times")
public class TimeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "times_id_seq")
    private Long id;

    private String home;
    private String away;

}
