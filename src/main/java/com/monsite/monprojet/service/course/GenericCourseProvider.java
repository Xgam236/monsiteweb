package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(999)
public class GenericCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        return true;
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours en préparation",
                "Ce chapitre n’a pas encore été rédigé en version complète. Les matières principales vont être ajoutées une par une avec de vrais cours, des explications, des méthodes, des vidéos et un quiz.",
                List.of(
                        "Cours complet en cours de rédaction.",
                        "Le contenu sera bientôt remplacé par une vraie fiche détaillée.",
                        "Chaque chapitre aura son propre résumé, ses notions, sa méthode et son quiz."
                ),
                List.of(
                        "Revenir dans quelques instants après la mise à jour.",
                        "Le chapitre sera ajouté dans le prochain pack de cours."
                ),
                List.of(
                        "Aucune formule disponible pour le moment."
                ),
                List.of(),
                List.of(
                        new QuizQuestion(
                                "Pourquoi cette page n’affiche pas encore un vrai cours ?",
                                "Parce que ce chapitre n’a pas encore été ajouté dans son provider dédié."
                        )
                ),
                "generic"
        );
    }
}