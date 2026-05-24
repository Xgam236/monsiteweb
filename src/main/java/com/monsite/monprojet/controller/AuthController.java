package com.monsite.monprojet.controller;

import com.monsite.monprojet.config.CaptchaValidationFilter;
import com.monsite.monprojet.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class AuthController {

    private final AuthService authService;
    private final Random random = new Random();

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(
            @RequestParam(value = "captchaError", required = false) String captchaError,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model,
            HttpSession session
    ) {
        int number1 = random.nextInt(10) + 1;
        int number2 = random.nextInt(10) + 1;

        int answer = number1 + number2;

        session.setAttribute(
                CaptchaValidationFilter.CAPTCHA_SESSION_KEY,
                String.valueOf(answer)
        );

        model.addAttribute(
                "captchaQuestion",
                number1 + " + " + number2 + " = ?"
        );

        if (captchaError != null) {
            model.addAttribute(
                    "error",
                    "Captcha incorrect. Réessaie avec le nouveau captcha."
            );
        }

        if (error != null) {
            model.addAttribute(
                    "error",
                    "Identifiant ou mot de passe incorrect."
            );
        }

        if (logout != null) {
            model.addAttribute(
                    "success",
                    "Tu as bien été déconnecté."
            );
        }

        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/home")
    public String homePage(Authentication authentication, Model model) {

        if (authentication != null) {
            model.addAttribute("username", authentication.getName());

            boolean isAdmin = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(role -> role.equals("ROLE_ADMIN"));

            model.addAttribute("isAdmin", isAdmin);
        }

        return "home";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            Model model,
            HttpSession session
    ) {
        try {
            authService.register(username, email, password);

            generateCaptcha(model, session);

            model.addAttribute(
                    "success",
                    "\"Compte créé ! Tu peux maintenant te connecter.\""
            );

            return "login";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/verify")
    public String verifyAccount(
            @RequestParam String token,
            Model model,
            HttpSession session
    ) {
        try {
            authService.verifyAccount(token);

            generateCaptcha(model, session);

            model.addAttribute(
                    "success",
                    "Ton compte est maintenant activé. Tu peux te connecter."
            );

            return "login";

        } catch (Exception e) {
            generateCaptcha(model, session);

            model.addAttribute(
                    "error",
                    "Lien de vérification invalide ou expiré."
            );

            return "login";
        }
    }

    private void generateCaptcha(Model model, HttpSession session) {
        int number1 = random.nextInt(10) + 1;
        int number2 = random.nextInt(10) + 1;

        int answer = number1 + number2;

        session.setAttribute(
                CaptchaValidationFilter.CAPTCHA_SESSION_KEY,
                String.valueOf(answer)
        );

        model.addAttribute(
                "captchaQuestion",
                number1 + " + " + number2 + " = ?"
        );
    }
}