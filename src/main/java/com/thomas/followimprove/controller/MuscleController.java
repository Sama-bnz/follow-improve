package com.thomas.followimprove.controller;

import com.thomas.followimprove.entities.Muscle;
import com.thomas.followimprove.entities.dto.ExerciseGetDto;
import com.thomas.followimprove.entities.dto.MuscleDto;
import com.thomas.followimprove.entities.dto.MuscleGetDto;
import com.thomas.followimprove.service.MuscleMapper;
import com.thomas.followimprove.service.MuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/muscles")
public class MuscleController {

    @Autowired
    private MuscleService muscleService;

    private MuscleMapper muscleMapper = MuscleMapper.INSTANCE;

    @PostMapping
    public ResponseEntity<MuscleGetDto> createMuscle(@RequestBody MuscleDto muscleDto) {

        if(muscleDto.getName() == null || muscleDto.getDescription() == null) {
            return ResponseEntity.badRequest().build();
        } else {
            Muscle createMuscle = muscleService.createMuscle(muscleDto);
            MuscleGetDto muscleGetDto = muscleMapper.muscleToMuscleGetDto(createMuscle);
            return ResponseEntity.status(HttpStatus.CREATED).body(muscleGetDto);
        }
    }

    @GetMapping
    public ResponseEntity<List<MuscleGetDto>> getAllMuscles() {
        List<MuscleGetDto> muscleGetDtos = muscleService.getAllMuscles();
        return ResponseEntity.ok(muscleGetDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuscleGetDto> getMuscleById(@PathVariable int id) {
        MuscleGetDto muscleGetDto = muscleService.findMuscleById(id);
        if(muscleGetDto != null) {
            return  ResponseEntity.ok(muscleGetDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
