package com.thomas.followimprove.repository;

import com.thomas.followimprove.entities.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMuscleRepository extends JpaRepository<Muscle, Integer> {
}
