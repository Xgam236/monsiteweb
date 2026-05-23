package com.monsite.monprojet.service;

import com.monsite.monprojet.entity.User;
import com.monsite.monprojet.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final AdminLogService adminLogService;

    public AuthService(
            UserRepository repository,
            PasswordEncoder passwordEncoder,
            EmailService emailService,
            AdminLogService adminLogService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
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
        user.setEnabled(false);

        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);

        repository.save(user);

        adminLogService.log(
                "ACCOUNT_CREATED",
                username,
                "Compte créé avec l'adresse email : " + email
        );

        emailService.sendVerificationEmail(email, username, token);
    }

    public void verifyAccount(String token) {

        User user = repository.findByVerificationToken(token)
                .orElseThrow(() -> new RuntimeException("Lien de vérification invalide."));

        user.setEnabled(true);
        user.setVerificationToken(null);

        repository.save(user);

        adminLogService.log(
                "ACCOUNT_VERIFIED",
                user.getUsername(),
                "Compte vérifié par email"
        );
    }
}