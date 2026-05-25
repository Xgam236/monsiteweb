package com.monsite.monprojet.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/cours")
    public String coursPage(Authentication authentication, Model model) {
        addUserInfo(authentication, model);
        return "cours";
    }

    @GetMapping("/cours/tronc-commun")
    public String troncCommunPage(Authentication authentication, Model model) {
        addUserInfo(authentication, model);
        return "cours-tronc-commun";
    }

    @GetMapping("/cours/specialites")
    public String specialitesPage(Authentication authentication, Model model) {
        addUserInfo(authentication, model);
        return "cours-specialites";
    }

    @GetMapping("/planning")
    public String planningPage(Authentication authentication, Model model) {
        addUserInfo(authentication, model);
        return "planning";
    }

    @GetMapping("/statistiques")
    public String statistiquesPage(Authentication authentication, Model model) {
        addUserInfo(authentication, model);
        return "statistiques";
    }

    private void addUserInfo(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());

            boolean isAdmin = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(role -> role.equals("ROLE_ADMIN"));

            model.addAttribute("isAdmin", isAdmin);
        } else {
            model.addAttribute("isAdmin", false);
        }
    }
}