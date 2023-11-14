package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Exercise;
import com.thomas.followimprove.entities.dto.ExerciseDto;
import com.thomas.followimprove.entities.dto.ExerciseGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ExerciseMapperMapStruct {

    ExerciseMapperMapStruct INSTANCE = Mappers.getMapper(ExerciseMapperMapStruct.class);

    @Mapping(target = "id", ignore = true)
    public Exercise exerciseDtoToExercise (ExerciseDto exerciseDto);

    public ExerciseGetDto exerciceToExerciseGetDto(Exercise exercise);

    // BESOIN D'UN RAPPEL SUR LE RAPPEL/GET DTO et mapping
}
