package com.thomas.followimprove.entities.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ExerciseDto {

    public String name;
    public String description;
    public List<MuscleGetDto> muscles = new ArrayList<>();
}
