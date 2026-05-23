package com.monsite.monprojet.controller;

import com.monsite.monprojet.entity.RevisionFiche;
import com.monsite.monprojet.service.RevisionFicheService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FicheController {

    private final RevisionFicheService ficheService;

    public FicheController(RevisionFicheService ficheService) {
        this.ficheService = ficheService;
    }

    @GetMapping("/fiche")
    public String fichePage(Authentication authentication, Model model) {
        String username = authentication.getName();
        addCommonFicheModel(username, authentication, model);
        return "fiche";
    }

    @PostMapping("/fiche/create")
    public String createFiche(
            @RequestParam String subject,
            @RequestParam String chapter,
            @RequestParam String theme,
            Authentication authentication
    ) {
        ficheService.createFicheWithAi(
                authentication.getName(),
                subject,
                chapter,
                theme
        );

        return "redirect:/fiche";
    }

    @GetMapping("/fiche/{id}")
    public String openFiche(
            @PathVariable Long id,
            Authentication authentication,
            Model model
    ) {
        String username = authentication.getName();
        RevisionFiche fiche = ficheService.getFicheForUser(id, username);

        model.addAttribute("fiche", fiche);
        model.addAttribute("username", username);
        model.addAttribute("isAdmin", isAdmin(authentication));

        return "fiche-view";
    }

    @GetMapping("/fiche/{id}/edit")
    public String editFichePage(
            @PathVariable Long id,
            Authentication authentication,
            Model model
    ) {
        String username = authentication.getName();
        RevisionFiche fiche = ficheService.getFicheForUser(id, username);

        model.addAttribute("fiche", fiche);
        model.addAttribute("username", username);
        model.addAttribute("isAdmin", isAdmin(authentication));

        return "fiche-edit";
    }

    @PostMapping("/fiche/{id}/edit")
    public String updateFiche(
            @PathVariable Long id,
            @RequestParam String subject,
            @RequestParam String chapter,
            @RequestParam String theme,
            @RequestParam String content,
            Authentication authentication
    ) {
        ficheService.updateFiche(
                id,
                authentication.getName(),
                subject,
                chapter,
                theme,
                content
        );

        return "redirect:/fiche/" + id;
    }

    @PostMapping("/fiche/{id}/favorite")
    public String toggleFavorite(
            @PathVariable Long id,
            Authentication authentication
    ) {
        ficheService.toggleFavorite(id, authentication.getName());
        return "redirect:/fiche";
    }

    @PostMapping("/fiche/{id}/delete")
    public String deleteFiche(
            @PathVariable Long id,
            Authentication authentication
    ) {
        ficheService.deleteFiche(id, authentication.getName());
        return "redirect:/fiche";
    }

    private void addCommonFicheModel(
            String username,
            Authentication authentication,
            Model model
    ) {
        List<RevisionFiche> myFiches = ficheService.getMyFiches(username);
        List<RevisionFiche> recentFiches = ficheService.getRecentFiches(username);
        List<RevisionFiche> favoriteFiches = ficheService.getFavoriteFiches(username);

        model.addAttribute("username", username);
        model.addAttribute("fiches", myFiches);
        model.addAttribute("recentFiches", recentFiches);
        model.addAttribute("favoriteFiches", favoriteFiches);

        model.addAttribute("totalFiches", ficheService.countMyFiches(username));
        model.addAttribute("totalFavorites", ficheService.countFavoriteFiches(username));
        model.addAttribute("totalSubjects", ficheService.countSubjects(username));
        model.addAttribute("totalCategories", ficheService.countCategories(username));

        model.addAttribute("isAdmin", isAdmin(authentication));
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_ADMIN"));
    }
}