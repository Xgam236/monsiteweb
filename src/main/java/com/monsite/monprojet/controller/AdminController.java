package com.monsite.monprojet.controller;

import com.monsite.monprojet.service.AdminLogService;
import com.monsite.monprojet.service.ForumService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminLogService adminLogService;
    private final ForumService forumService;

    public AdminController(
            AdminLogService adminLogService,
            ForumService forumService
    ) {
        this.adminLogService = adminLogService;
        this.forumService = forumService;
    }

    @GetMapping
    public String adminHome(Model model) {
        model.addAttribute("logs", adminLogService.getLastLogs());
        model.addAttribute("topics", forumService.getAllTopicsForAdmin());
        return "admin";
    }

    @PostMapping("/forum/{id}/close")
    public String closeForum(
            @PathVariable Long id,
            Authentication authentication
    ) {
        forumService.closeTopic(id, authentication.getName());
        return "redirect:/admin";
    }

    @PostMapping("/forum/{id}/reopen")
    public String reopenForum(
            @PathVariable Long id,
            Authentication authentication
    ) {
        forumService.reopenTopic(id, authentication.getName());
        return "redirect:/admin";
    }

    @PostMapping("/forum/{id}/delete")
    public String deleteForum(
            @PathVariable Long id,
            Authentication authentication
    ) {
        forumService.deleteTopic(id, authentication.getName());
        return "redirect:/admin";
    }

    @PostMapping("/forum/{id}/delete-forever")
    public String deleteForumForever(
            @PathVariable Long id,
            Authentication authentication
    ) {
        forumService.deleteTopicForever(id, authentication.getName());
        return "redirect:/admin";
    }
}