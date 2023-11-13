package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name= "exercise")
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="muscle")
    private String muscle;
}
