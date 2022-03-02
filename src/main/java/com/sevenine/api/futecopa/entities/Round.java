package com.sevenine.api.futecopa.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Round {
    private String closed;
    private String name;
    private String next;
    private String nextId;
    private String prev;
    private Integer round;
    private String year;
}
