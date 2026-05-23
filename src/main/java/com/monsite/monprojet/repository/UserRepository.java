package com.monsite.monprojet.repository;

import com.monsite.monprojet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByVerificationToken(String verificationToken);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}