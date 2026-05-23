package com.monsite.monprojet.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendVerificationEmail(String to, String username, String token) {

        String link = "http://localhost:8080/verify?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Vérification de ton compte");

        message.setText(
                "Bonjour " + username + ",\n\n" +
                        "Merci d'avoir créé ton compte.\n\n" +
                        "Clique sur ce lien pour activer ton compte :\n" +
                        link + "\n\n" +
                        "Si tu n'es pas à l'origine de cette demande, ignore ce message.\n\n" +
                        "L'équipe Révision École"
        );

        mailSender.send(message);
    }
}