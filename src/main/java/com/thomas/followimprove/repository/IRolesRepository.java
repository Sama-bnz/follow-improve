package com.thomas.followimprove.repository;

import com.thomas.followimprove.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer> {

    public Roles findRolesByLabel(String label);
}
