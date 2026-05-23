package com.monsite.monprojet.repository;

import com.monsite.monprojet.entity.RevisionFiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RevisionFicheRepository extends JpaRepository<RevisionFiche, Long> {

    List<RevisionFiche> findByAuthorUsernameOrderByCreatedAtDesc(String authorUsername);

    List<RevisionFiche> findTop3ByAuthorUsernameOrderByCreatedAtDesc(String authorUsername);

    List<RevisionFiche> findByAuthorUsernameAndFavoriteTrueOrderByCreatedAtDesc(String authorUsername);

    long countByAuthorUsername(String authorUsername);

    long countByAuthorUsernameAndFavoriteTrue(String authorUsername);

    @Query("SELECT COUNT(DISTINCT f.subject) FROM RevisionFiche f WHERE f.authorUsername = :username")
    long countDistinctSubjectsByUsername(String username);

    @Query("SELECT COUNT(DISTINCT f.category) FROM RevisionFiche f WHERE f.authorUsername = :username")
    long countDistinctCategoriesByUsername(String username);
}