package com.thomas.followimprove.repository;

import com.thomas.followimprove.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findByLogin(String login);
}
