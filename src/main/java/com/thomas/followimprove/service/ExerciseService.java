package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Exercise;
import com.thomas.followimprove.entities.dto.ExerciseDto;
import com.thomas.followimprove.entities.dto.ExerciseGetDto;
import com.thomas.followimprove.entities.dto.MuscleGetDto;
import com.thomas.followimprove.repository.IExerciseRepository;
import com.thomas.followimprove.repository.IMuscleRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    private IExerciseRepository exerciseRepository;
    @Autowired
    private  IMuscleRepository muscleRepository;

    private ExerciseMapperMapStruct exerciseMapperMapStruct = ExerciseMapperMapStruct.INSTANCE;
    @Transactional
    public Exercise createExercise (ExerciseDto exerciseDto) {
        Exercise exercise = exerciseMapperMapStruct.exerciseDtoToExercise(exerciseDto);
        List<Integer> muscleIds = new ArrayList<>();
        for(MuscleGetDto muscle: exerciseDto.getMuscles()) {
            muscleIds.add(muscle.getId());
        }
        exercise.setMuscles(muscleRepository.findMuscleWhereIdIN(muscleIds));
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
        return exerciseMapperMapStruct.mapExerciseToExerciseGetDtoWithMuscles(exercise);
    }
}
