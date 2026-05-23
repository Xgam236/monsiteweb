package com.monsite.monprojet.service;

import com.monsite.monprojet.entity.RevisionFiche;
import com.monsite.monprojet.repository.RevisionFicheRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevisionFicheService {

    private final RevisionFicheRepository ficheRepository;
    private final AdminLogService adminLogService;
    private final AiFicheService aiFicheService;

    public RevisionFicheService(
            RevisionFicheRepository ficheRepository,
            AdminLogService adminLogService,
            AiFicheService aiFicheService
    ) {
        this.ficheRepository = ficheRepository;
        this.adminLogService = adminLogService;
        this.aiFicheService = aiFicheService;
    }

    public void createFicheWithAi(
            String username,
            String subject,
            String chapter,
            String theme
    ) {
        String title = subject + " • " + theme;
        String generatedContent = aiFicheService.generateRevisionFiche(subject, chapter, theme);

        RevisionFiche fiche = new RevisionFiche();
        fiche.setAuthorUsername(username);
        fiche.setTitle(title);
        fiche.setSubject(subject);
        fiche.setChapter(chapter);
        fiche.setTheme(theme);
        fiche.setCategory("IA");
        fiche.setContent(generatedContent);
        fiche.setFavorite(false);
        fiche.setGeneratedByAi(true);

        ficheRepository.save(fiche);

        adminLogService.log(
                "FICHE_AI_CREATED",
                username,
                "Fiche IA créée : " + title
        );
    }

    public List<RevisionFiche> getMyFiches(String username) {
        return ficheRepository.findByAuthorUsernameOrderByCreatedAtDesc(username);
    }

    public List<RevisionFiche> getRecentFiches(String username) {
        return ficheRepository.findTop3ByAuthorUsernameOrderByCreatedAtDesc(username);
    }

    public List<RevisionFiche> getFavoriteFiches(String username) {
        return ficheRepository.findByAuthorUsernameAndFavoriteTrueOrderByCreatedAtDesc(username);
    }

    public RevisionFiche getFicheForUser(Long ficheId, String username) {
        RevisionFiche fiche = ficheRepository.findById(ficheId)
                .orElseThrow(() -> new RuntimeException("Fiche introuvable"));

        if (!fiche.getAuthorUsername().equals(username)) {
            throw new RuntimeException("Tu ne peux pas accéder à cette fiche.");
        }

        return fiche;
    }

    public void updateFiche(
            Long ficheId,
            String username,
            String subject,
            String chapter,
            String theme,
            String content
    ) {
        RevisionFiche fiche = getFicheForUser(ficheId, username);

        fiche.setTitle(subject + " • " + theme);
        fiche.setSubject(subject);
        fiche.setChapter(chapter);
        fiche.setTheme(theme);
        fiche.setContent(content);

        ficheRepository.save(fiche);

        adminLogService.log(
                "FICHE_UPDATED",
                username,
                "Fiche modifiée : " + fiche.getTitle()
        );
    }

    @Transactional
    public void toggleFavorite(Long ficheId, String username) {
        RevisionFiche fiche = getFicheForUser(ficheId, username);
        fiche.setFavorite(!fiche.isFavorite());
        ficheRepository.saveAndFlush(fiche);

        adminLogService.log(
                fiche.isFavorite() ? "FICHE_FAVORITE_ADDED" : "FICHE_FAVORITE_REMOVED",
                username,
                "Favori modifié : " + fiche.getTitle()
        );
    }

    public void deleteFiche(Long ficheId, String username) {
        RevisionFiche fiche = getFicheForUser(ficheId, username);
        String title = fiche.getTitle();

        ficheRepository.delete(fiche);

        adminLogService.log(
                "FICHE_DELETED",
                username,
                "Fiche supprimée : " + title
        );
    }

    public long countMyFiches(String username) {
        return ficheRepository.countByAuthorUsername(username);
    }

    public long countFavoriteFiches(String username) {
        return ficheRepository.countByAuthorUsernameAndFavoriteTrue(username);
    }

    public long countSubjects(String username) {
        return ficheRepository.countDistinctSubjectsByUsername(username);
    }

    public long countCategories(String username) {
        return ficheRepository.countDistinctCategoriesByUsername(username);
    }
}