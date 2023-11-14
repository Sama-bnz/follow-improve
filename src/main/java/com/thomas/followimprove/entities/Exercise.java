package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name= "exercises")
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="muscles")
    private String muscles;
}
