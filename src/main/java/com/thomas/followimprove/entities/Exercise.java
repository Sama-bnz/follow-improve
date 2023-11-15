package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name= "exercises")
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
    })
    @JoinTable(name = "exo_muscle",
            joinColumns = @JoinColumn(name = "exercice_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id")
    )
    private List<Muscle> muscles = new ArrayList<>();

    public void addMuscle (Muscle muscle) {
        this.muscles.add(muscle);
        muscle.getExercises().add(this);
    }

}
