package com.monsite.monprojet.controller;

import com.monsite.monprojet.entity.ForumTopic;
import com.monsite.monprojet.service.ForumService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ForumController {

    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/forum")
    public String forumPage(Model model) {
        model.addAttribute("topics", forumService.getVisibleTopics());
        return "forum";
    }

    @PostMapping("/forum/create")
    public String createForum(
            @RequestParam String title,
            @RequestParam String content,
            Authentication authentication
    ) {
        forumService.createTopic(title, content, authentication.getName());
        return "redirect:/forum";
    }

    @GetMapping("/forum/{id}")
    public String forumTopic(
            @PathVariable Long id,
            Model model
    ) {
        ForumTopic topic = forumService.getTopic(id);
        model.addAttribute("topic", topic);
        return "forum-topic";
    }

    @PostMapping("/forum/{id}/message")
    public String addMessage(
            @PathVariable Long id,
            @RequestParam String message,
            Authentication authentication
    ) {
        forumService.addMessage(id, message, authentication.getName());
        return "redirect:/forum/" + id;
    }
}