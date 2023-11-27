package com.thomas.followimprove.controller;

import com.thomas.followimprove.entities.Exercise;
import com.thomas.followimprove.entities.dto.ExerciseDto;
import com.thomas.followimprove.entities.dto.ExerciseGetDto;
import com.thomas.followimprove.service.ExerciseMapperMapStruct;
import com.thomas.followimprove.service.ExerciseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    // Injection de dépendance pour le service Exercise
    @Autowired
    private ExerciseService exerciseService;

    // Instance du mapper MapStruct
    private ExerciseMapperMapStruct exerciseMapperMapStruct = ExerciseMapperMapStruct.INSTANCE;
    //Endpoint pour créer un exercice
    @PostMapping
    public ResponseEntity<ExerciseGetDto> createExercise(@RequestBody ExerciseDto exerciseDto) {

        // Vérification des paramètres de la requête
        if (exerciseDto.getName()== null || exerciseDto.getDescription() == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            // Création de l'exercice via le service
            Exercise createExercise = exerciseService.createExercise(exerciseDto);
            // Mapping de l'entité Exercise vers ExerciseGetDto
            ExerciseGetDto exerciseGetDto = exerciseMapperMapStruct.exerciceToExerciseGetDto(createExercise);
            // Retourne une réponse avec le statut CREATED et le DTO de l'exercice créé
            return ResponseEntity.status(HttpStatus.CREATED).body(exerciseGetDto);
        }
    }
    // Endpoint pour obtenir tous les exercices
    @GetMapping
    public ResponseEntity<List<ExerciseGetDto>> getAllExercises() {
        List<ExerciseGetDto> exerciseGetDtos = exerciseService.getAllExercises();
        return ResponseEntity.ok(exerciseGetDtos);
    }
    // Endpoint pour obtenir un exercice par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseGetDto> getExerciseById(@PathVariable int id) {
        ExerciseGetDto exerciseGetDto = exerciseService.findExerciseById(id);
        if(exerciseGetDto != null) {
            return  ResponseEntity.ok(exerciseGetDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseById(@PathVariable int id) {
         exerciseService.deleteExercise(id);
         return  ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseGetDto> updateExercise(@PathVariable int id,@RequestBody ExerciseDto exerciseDto){
        Exercise exercise = exerciseService.updateExercise(id, exerciseDto);

        if(exercise != null) {
            ExerciseGetDto exerciseGetDto = exerciseMapperMapStruct.exerciceToExerciseGetDto(exercise);
            return ResponseEntity.ok(exerciseGetDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
