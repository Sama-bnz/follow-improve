package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Exercise;
import com.thomas.followimprove.entities.dto.ExerciseDto;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ExerciseMapperMapStruct {

    ExerciseMapperMapStruct INSTANCE = Mappers.getMapper(ExerciseMapperMapStruct.class);

    @Mapping(target = "id", ignore = true)
    Exercise exerciseDtoToUser (ExerciseDto exerciseDto);

    // BESOIN D'UN RAPPEL SUR LE RAPPEL/GET DTO
}
