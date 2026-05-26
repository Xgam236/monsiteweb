package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.youtube;

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
                "Cours de révision",
                "Ce chapitre présente les notions essentielles à connaître. L’objectif est de comprendre le sujet, retenir les idées importantes, savoir les expliquer et s’entraîner avec un quiz.",
                List.of(
                        "Comprendre les notions principales du chapitre.",
                        "Retenir les définitions importantes.",
                        "Savoir expliquer avec ses propres mots.",
                        "Utiliser des exemples précis.",
                        "S’entraîner avec des questions."
                ),
                List.of(
                        "Lire le cours une première fois.",
                        "Repérer les mots-clés.",
                        "Faire une fiche courte.",
                        "Apprendre les définitions.",
                        "Faire le quiz et corriger ses erreurs."
                ),
                List.of(
                        "Définition → exemple → application.",
                        "Cours → fiche → entraînement.",
                        "Notion → méthode → exercice."
                ),
                List.of(
                        new VideoLink(
                                "Recherche vidéo — " + chapitre,
                                youtube("terminale " + matiere + " " + chapitre)
                        ),
                        new VideoLink(
                                "Méthode bac — " + matiere,
                                youtube("méthode bac terminale " + matiere)
                        )
                ),
                List.of(
                        new QuizQuestion(
                                "Quelle est l’idée principale du chapitre ?",
                                "Elle dépend du sujet étudié, mais elle doit pouvoir être résumée simplement."
                        ),
                        new QuizQuestion(
                                "Comment bien réviser ce chapitre ?",
                                "En comprenant les notions, en faisant une fiche et en s’entraînant."
                        ),
                        new QuizQuestion(
                                "Pourquoi faire un quiz ?",
                                "Pour vérifier ce qu’on a réellement retenu."
                        )
                ),
                "generic"
        );
    }
}