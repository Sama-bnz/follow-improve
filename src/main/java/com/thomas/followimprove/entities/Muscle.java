package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name ="muscles")
@Data
public class Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
}
