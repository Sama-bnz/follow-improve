package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "muscles")
    private List<Exercise> exercises = new ArrayList<>();

    public void add (Exercise exercise) {
        this.exercises.add(exercise);
    }
}
