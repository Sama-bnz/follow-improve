package com.thomas.followimprove.repository;

import com.thomas.followimprove.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExerciseRepository extends JpaRepository<Exercise, Integer> {
}
