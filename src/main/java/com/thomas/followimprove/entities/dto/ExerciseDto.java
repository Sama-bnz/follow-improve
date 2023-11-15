package com.thomas.followimprove.entities.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExerciseDto {

    public String name;
    public String description;
    public List<MuscleGetDto> muscles = new ArrayList<>();
}
