package com.monsite.monprojet.repository;

import com.monsite.monprojet.entity.ForumMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumMessageRepository extends JpaRepository<ForumMessage, Long> {
}