package com.monsite.monprojet.service;

import com.monsite.monprojet.entity.User;
import com.monsite.monprojet.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AdminLogService adminLogService;

    public AuthService(
            UserRepository repository,
            PasswordEncoder passwordEncoder,
            AdminLogService adminLogService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.adminLogService = adminLogService;
    }

    public void register(String username, String email, String password) {

        if (repository.existsByUsername(username)) {
            throw new RuntimeException("Cet identifiant existe déjà.");
        }

        if (repository.existsByEmail(email)) {
            throw new RuntimeException("Cette adresse email est déjà utilisée.");
        }

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");

        // Le compte est activé directement, sans vérification mail
        user.setEnabled(true);
        user.setVerificationToken(null);

        repository.save(user);

        adminLogService.log(
                "ACCOUNT_CREATED",
                username,
                "Compte créé avec l'adresse email : " + email
        );
    }

    public void verifyAccount(String token) {
        throw new RuntimeException("La vérification par email est désactivée.");
    }
}