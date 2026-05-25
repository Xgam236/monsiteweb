package com.monsite.monprojet.controller;

import com.monsite.monprojet.service.CourseChapterService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseChapterController {

    private final CourseChapterService courseChapterService;

    public CourseChapterController(CourseChapterService courseChapterService) {
        this.courseChapterService = courseChapterService;
    }

    @GetMapping("/cours/chapitre")
    public String chapterPage(
            String matiere,
            String chapitre,
            Authentication authentication,
            Model model
    ) {
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("isAdmin", isAdmin(authentication));
        }

        model.addAttribute("matiere", matiere);
        model.addAttribute("chapitre", chapitre);
        model.addAttribute("course", courseChapterService.generateChapter(matiere, chapitre));

        return "cours-chapitre";
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_ADMIN"));
    }
}