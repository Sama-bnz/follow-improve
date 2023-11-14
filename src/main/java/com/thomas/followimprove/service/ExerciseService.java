package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Exercise;
import com.thomas.followimprove.entities.dto.ExerciseDto;
import com.thomas.followimprove.entities.dto.ExerciseGetDto;
import com.thomas.followimprove.repository.IExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    @Autowired
    private IExerciseRepository exerciseRepository;
    private ExerciseMapperMapStruct exerciseMapperMapStruct = ExerciseMapperMapStruct.INSTANCE;

    public Exercise createExercise (ExerciseDto exerciseDto) {
        Exercise exercise = exerciseMapperMapStruct.exerciseDtoToExercise(exerciseDto);
        return exerciseRepository.save(exercise);
    }


    public List<ExerciseGetDto> getAllExercises(){
        return exerciseRepository.findAll().stream()
                .map(exercise -> exerciseMapperMapStruct.exerciceToExerciseGetDto(exercise))
                //.filter(exerciseGetDto -> exerciseGetDto.getId() == 1)
                .collect(Collectors.toList());
    }

    public ExerciseGetDto findExerciseById(int exerciseId) {

        Exercise exercise = exerciseRepository.findById(exerciseId).orElse(null);
        return exerciseMapperMapStruct.exerciceToExerciseGetDto(exercise);
    }
}
