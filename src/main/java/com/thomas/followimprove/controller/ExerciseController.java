package com.thomas.followimprove.controller;

import com.thomas.followimprove.entities.Exercise;
import com.thomas.followimprove.entities.dto.ExerciseDto;
import com.thomas.followimprove.entities.dto.ExerciseGetDto;
import com.thomas.followimprove.service.ExerciseMapperMapStruct;
import com.thomas.followimprove.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    private ExerciseMapperMapStruct exerciseMapperMapStruct = ExerciseMapperMapStruct.INSTANCE;
    @PostMapping
    public ResponseEntity<ExerciseGetDto> createExercise(@RequestBody ExerciseDto exerciseDto) {

        if (exerciseDto.getName()== null || exerciseDto.getDescription() == null) {
            return ResponseEntity.badRequest().body(null);
        } else {

            Exercise createExercise = exerciseService.createExercise(exerciseDto);
            ExerciseGetDto exerciseGetDto = exerciseMapperMapStruct.exerciceToExerciseGetDto(createExercise);
            return ResponseEntity.status(HttpStatus.CREATED).body(exerciseGetDto);
        }
    }

    @GetMapping
    public ResponseEntity<List<ExerciseGetDto>> getAllExercises() {
        List<ExerciseGetDto> exerciseGetDtos = exerciseService.getAllExercises();
        return ResponseEntity.ok(exerciseGetDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseGetDto> getExerciseById(@PathVariable int id) {
        ExerciseGetDto exerciseGetDto = exerciseService.findExerciseById(id);
        if(exerciseGetDto != null) {
            return  ResponseEntity.ok(exerciseGetDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
