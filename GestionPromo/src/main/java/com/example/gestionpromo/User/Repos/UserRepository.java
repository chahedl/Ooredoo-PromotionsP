package com.example.gestionpromo.User.Repos;

import com.example.gestionpromo.User.Entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Integer> {
    Optional<user> findByEmail(String email);
}
