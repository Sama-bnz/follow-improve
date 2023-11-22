package com.thomas.followimprove.repository;

import com.thomas.followimprove.entities.Muscle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMuscleRepository extends JpaRepository<Muscle, Integer> {
    @Query("SELECT m FROM com.thomas.followimprove.entities.Muscle m WHERE m.id IN ?1")
    List<Muscle> findMuscleWhereIdIN(List<Integer> ids);
}
