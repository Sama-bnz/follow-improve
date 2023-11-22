package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.Muscle;
import com.thomas.followimprove.entities.dto.MuscleDto;
import com.thomas.followimprove.entities.dto.MuscleGetDto;
import com.thomas.followimprove.repository.IMuscleRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuscleService {

    @Autowired
    private IMuscleRepository muscleRepository;

    private MuscleMapper muscleMapper = MuscleMapper.INSTANCE;

    public Muscle createMuscle (MuscleDto muscleDto) {
        Muscle muscle = muscleMapper.muscleDtoToMuscle(muscleDto);
        return muscleRepository.save(muscle);
    }

    public List<MuscleGetDto> getAllMuscles(){
        return muscleRepository.findAll().stream()
                .map(muscle -> muscleMapper.muscleToMuscleGetDto(muscle))
                .collect(Collectors.toList());
    }

    public MuscleGetDto findMuscleById(int muscleId) {

        Muscle muscle = muscleRepository.findById(muscleId).orElse(null);
        return muscleMapper.muscleToMuscleGetDto(muscle);
    }
    public List<Muscle> findAllWhereIdIn(List<Integer> ids){
        return muscleRepository.findMuscleWhereIdIN(ids);
    }
}
