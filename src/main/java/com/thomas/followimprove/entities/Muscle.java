package com.thomas.followimprove.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToMany(mappedBy = "muscles",fetch = FetchType.LAZY)
    private List<Exercise> exercises;

    public void add (Exercise exercise) {
        if(this.exercises==null){
            exercises = new ArrayList<>();
        }
        this.exercises.add(exercise);
    }
}
