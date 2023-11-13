package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Exercise;
import com.thomas.followimprove.entities.dto.ExerciseDto;
import com.thomas.followimprove.repository.IExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExerciseService {

    @Autowired
    private IExerciseRepository exerciseRepository;




    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }

    public Exercise findExerciseById(int exerciseId) {
        return exerciseRepository.findById(exerciseId).orElse(null);
    }
}
