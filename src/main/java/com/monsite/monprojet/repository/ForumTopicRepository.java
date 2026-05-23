package com.monsite.monprojet.repository;

import com.monsite.monprojet.entity.ForumStatus;
import com.monsite.monprojet.entity.ForumTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ForumTopicRepository extends JpaRepository<ForumTopic, Long> {

    List<ForumTopic> findByStatusNotOrderByCreatedAtDesc(ForumStatus status);

    List<ForumTopic> findAllByOrderByCreatedAtDesc();

    @Query("SELECT t FROM ForumTopic t LEFT JOIN FETCH t.messages WHERE t.id = :id")
    Optional<ForumTopic> findByIdWithMessages(@Param("id") Long id);
}