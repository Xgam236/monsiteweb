package com.monsite.monprojet.service;

import com.monsite.monprojet.entity.ForumMessage;
import com.monsite.monprojet.entity.ForumStatus;
import com.monsite.monprojet.entity.ForumTopic;
import com.monsite.monprojet.repository.ForumMessageRepository;
import com.monsite.monprojet.repository.ForumTopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {

    private final ForumTopicRepository topicRepository;
    private final ForumMessageRepository messageRepository;
    private final AdminLogService adminLogService;

    public ForumService(
            ForumTopicRepository topicRepository,
            ForumMessageRepository messageRepository,
            AdminLogService adminLogService
    ) {
        this.topicRepository = topicRepository;
        this.messageRepository = messageRepository;
        this.adminLogService = adminLogService;
    }

    public List<ForumTopic> getVisibleTopics() {
        return topicRepository.findByStatusNotOrderByCreatedAtDesc(ForumStatus.DELETED);
    }

    public List<ForumTopic> getAllTopicsForAdmin() {
        return topicRepository.findAllByOrderByCreatedAtDesc();
    }

    public ForumTopic getTopic(Long id) {
        return topicRepository.findByIdWithMessages(id)
                .orElseThrow(() -> new RuntimeException("Forum introuvable"));
    }

    public void createTopic(String title, String content, String username) {
        ForumTopic topic = new ForumTopic();

        topic.setTitle(title);
        topic.setContent(content);
        topic.setAuthorUsername(username);
        topic.setStatus(ForumStatus.OPEN);

        topicRepository.save(topic);

        adminLogService.log(
                "FORUM_CREATED",
                username,
                "Forum créé : " + title
        );
    }

    public void addMessage(Long topicId, String message, String username) {
        ForumTopic topic = getTopic(topicId);

        if (topic.getStatus() != ForumStatus.OPEN) {
            throw new RuntimeException("Ce forum est fermé.");
        }

        ForumMessage forumMessage = new ForumMessage();
        forumMessage.setTopic(topic);
        forumMessage.setMessage(message);
        forumMessage.setAuthorUsername(username);

        messageRepository.save(forumMessage);

        adminLogService.log(
                "FORUM_MESSAGE",
                username,
                "Message ajouté dans le forum : " + topic.getTitle()
        );
    }

    public void closeTopic(Long id, String adminUsername) {
        ForumTopic topic = getTopic(id);

        topic.setStatus(ForumStatus.CLOSED);
        topicRepository.save(topic);

        adminLogService.log(
                "FORUM_CLOSED",
                adminUsername,
                "Forum fermé : " + topic.getTitle()
        );
    }

    public void reopenTopic(Long id, String adminUsername) {
        ForumTopic topic = getTopic(id);

        topic.setStatus(ForumStatus.OPEN);
        topicRepository.save(topic);

        adminLogService.log(
                "FORUM_REOPENED",
                adminUsername,
                "Forum rouvert : " + topic.getTitle()
        );
    }

    // Suppression simple : le forum devient invisible côté utilisateur
    public void deleteTopic(Long id, String adminUsername) {
        ForumTopic topic = getTopic(id);

        topic.setStatus(ForumStatus.DELETED);
        topicRepository.save(topic);

        adminLogService.log(
                "FORUM_DELETED",
                adminUsername,
                "Forum masqué/supprimé : " + topic.getTitle()
        );
    }

    // Suppression définitive : supprimé de la base SQL + du panel admin
    public void deleteTopicForever(Long id, String adminUsername) {
        ForumTopic topic = getTopic(id);

        String title = topic.getTitle();

        topicRepository.delete(topic);

        adminLogService.log(
                "FORUM_DELETED_FOREVER",
                adminUsername,
                "Forum supprimé définitivement : " + title
        );
    }
}