package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Muscle;
import com.thomas.followimprove.entities.dto.MuscleDto;
import com.thomas.followimprove.entities.dto.MuscleGetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MuscleMapper {

    MuscleMapper INSTANCE = Mappers.getMapper(MuscleMapper.class);
    @Mapping(target ="id", ignore = true)
    public Muscle muscleDtoToMuscle (MuscleDto muscleDto);

    public MuscleGetDto muscleToMuscleGetDto(Muscle muscle);
}
