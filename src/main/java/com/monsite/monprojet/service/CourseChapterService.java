package com.monsite.monprojet.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseChapterService {

    public CourseContent generateChapter(String matiere, String chapitre) {
        String safeMatiere = safe(matiere);
        String safeChapitre = safe(chapitre);

        String lower = (safeMatiere + " " + safeChapitre).toLowerCase();

        if (lower.contains("math")) {
            return mathChapter(safeMatiere, safeChapitre);
        }

        if (lower.contains("physique") || lower.contains("chimie")) {
            return physicsChapter(safeMatiere, safeChapitre);
        }

        if (lower.contains("svt")) {
            return svtChapter(safeMatiere, safeChapitre);
        }

        if (lower.contains("histoire")
                || lower.contains("géographie")
                || lower.contains("geo")
                || lower.contains("hggsp")) {
            return historyGeoChapter(safeMatiere, safeChapitre);
        }

        if (lower.contains("philo")) {
            return philosophyChapter(safeMatiere, safeChapitre);
        }

        if (lower.contains("ses")) {
            return sesChapter(safeMatiere, safeChapitre);
        }

        if (lower.contains("nsi")) {
            return nsiChapter(safeMatiere, safeChapitre);
        }

        return genericChapter(safeMatiere, safeChapitre);
    }

    private CourseContent mathChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de mathématiques",
                "Ce chapitre permet de comprendre les méthodes, les formules et les raisonnements essentiels. L’objectif est de savoir reconnaître le type d’exercice, appliquer la bonne propriété et rédiger clairement.",
                List.of(
                        "Comprendre la définition principale du chapitre.",
                        "Savoir reconnaître les situations où utiliser la formule.",
                        "Rédiger les calculs étape par étape.",
                        "Vérifier la cohérence du résultat."
                ),
                List.of(
                        "Lire attentivement l’énoncé.",
                        "Repérer les données utiles.",
                        "Choisir la formule ou la propriété adaptée.",
                        "Effectuer les calculs proprement.",
                        "Conclure avec une phrase claire."
                ),
                List.of(
                        "\\[ f'(x)=\\lim_{h \\to 0}\\frac{f(x+h)-f(x)}{h} \\]",
                        "\\[ \\int_a^b f(x)\\,dx = F(b)-F(a) \\]",
                        "\\[ \\mathbb{E}(X)=\\sum x_i p_i \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Recherche sur ce chapitre", "https://www.youtube.com/results?search_query=Yvan+Monka+terminale+" + url(chapitre)),
                        new VideoLink("Yvan Monka — Terminale spécialité maths", "https://www.youtube.com/results?search_query=Yvan+Monka+terminale+spécialité+maths"),
                        new VideoLink("Méthode bac maths Terminale", "https://www.youtube.com/results?search_query=méthode+bac+maths+terminale+" + url(chapitre))
                ),
                List.of(
                        new QuizQuestion("Quelle est la première chose à faire face à un exercice ?", "Lire l’énoncé et repérer les données utiles."),
                        new QuizQuestion("Pourquoi faut-il justifier ses calculs ?", "Pour montrer le raisonnement et éviter une réponse sans méthode."),
                        new QuizQuestion("Comment vérifier un résultat ?", "On regarde s’il est cohérent avec l’énoncé et les unités ou conditions données.")
                ),
                "math"
        );
    }

    private CourseContent physicsChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de physique-chimie",
                "Ce chapitre explique un phénomène scientifique à partir de grandeurs, de lois, d’expériences et de modèles. Il faut toujours faire attention aux unités, aux conditions d’application et au sens du résultat.",
                List.of(
                        "Identifier le système étudié.",
                        "Connaître les grandeurs physiques importantes.",
                        "Utiliser les bonnes unités.",
                        "Relier formule, expérience et interprétation."
                ),
                List.of(
                        "Identifier les données de l’énoncé.",
                        "Convertir les unités si nécessaire.",
                        "Choisir la relation adaptée.",
                        "Faire l’application numérique.",
                        "Interpréter le résultat obtenu."
                ),
                List.of(
                        "\\[ v=\\frac{d}{t} \\]",
                        "\\[ E=P\\times t \\]",
                        "\\[ F=m\\times a \\]",
                        "\\[ c=\\lambda \\times f \\]"
                ),
                List.of(
                        new VideoLink("Physique-chimie Terminale — Recherche chapitre", "https://www.youtube.com/results?search_query=physique+chimie+terminale+" + url(chapitre)),
                        new VideoLink("Méthode bac physique-chimie", "https://www.youtube.com/results?search_query=méthode+bac+physique+chimie+terminale")
                ),
                List.of(
                        new QuizQuestion("Pourquoi les unités sont importantes ?", "Parce qu’elles donnent du sens au résultat et évitent les erreurs de calcul."),
                        new QuizQuestion("Que doit contenir une réponse scientifique ?", "Une formule, un calcul, une unité et une interprétation."),
                        new QuizQuestion("À quoi sert un modèle ?", "À représenter simplement un phénomène réel pour pouvoir l’étudier.")
                ),
                "science"
        );
    }

    private CourseContent svtChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de SVT",
                "Ce chapitre permet de comprendre un mécanisme du vivant, de la Terre, de l’environnement ou de la santé. Il faut retenir le vocabulaire scientifique et être capable d’expliquer les relations de cause à conséquence.",
                List.of(
                        "Maîtriser les mots-clés du chapitre.",
                        "Comprendre les mécanismes étape par étape.",
                        "Savoir utiliser un schéma.",
                        "Relier une observation à une explication scientifique."
                ),
                List.of(
                        "Lire les définitions importantes.",
                        "Identifier le phénomène étudié.",
                        "Décomposer le mécanisme en étapes.",
                        "Associer un exemple précis.",
                        "Réviser avec un schéma ou un bilan."
                ),
                List.of(
                        "Observation → hypothèse → mécanisme → conclusion.",
                        "Cause → conséquence → bilan.",
                        "Molécule → cellule → organisme → écosystème."
                ),
                List.of(
                        new VideoLink("SVT Terminale — Recherche chapitre", "https://www.youtube.com/results?search_query=SVT+terminale+" + url(chapitre)),
                        new VideoLink("Méthode bac SVT Terminale", "https://www.youtube.com/results?search_query=méthode+bac+SVT+terminale")
                ),
                List.of(
                        new QuizQuestion("Pourquoi faut-il maîtriser le vocabulaire en SVT ?", "Parce qu’il permet d’expliquer précisément les mécanismes."),
                        new QuizQuestion("Comment retenir un mécanisme ?", "En le découpant en étapes simples."),
                        new QuizQuestion("Que doit contenir une bonne réponse en SVT ?", "Des notions précises, un exemple et une explication logique.")
                ),
                "svt"
        );
    }

    private CourseContent historyGeoChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours d’histoire-géographie",
                "Ce chapitre permet de comprendre des événements, des territoires, des acteurs et des enjeux. Il faut savoir organiser ses idées, utiliser des exemples précis et localiser les phénomènes.",
                List.of(
                        "Connaître les dates, lieux et acteurs importants.",
                        "Comprendre les causes et conséquences.",
                        "Utiliser des exemples précis.",
                        "Construire un raisonnement organisé."
                ),
                List.of(
                        "Présenter le contexte.",
                        "Identifier les acteurs.",
                        "Expliquer les dynamiques.",
                        "Illustrer avec des exemples.",
                        "Conclure sur les enjeux."
                ),
                List.of(
                        "Acteurs → territoires → dynamiques → enjeux.",
                        "Cause → événement → conséquence.",
                        "Localiser → décrire → expliquer."
                ),
                List.of(
                        new VideoLink("Histoire-géographie Terminale — Recherche chapitre", "https://www.youtube.com/results?search_query=histoire+géographie+terminale+" + url(chapitre)),
                        new VideoLink("Méthode bac histoire-géographie", "https://www.youtube.com/results?search_query=méthode+bac+histoire+géographie+terminale")
                ),
                List.of(
                        new QuizQuestion("Pourquoi utiliser des exemples précis ?", "Pour rendre l’argumentation plus solide."),
                        new QuizQuestion("Que faut-il toujours faire en géographie ?", "Localiser les espaces étudiés."),
                        new QuizQuestion("Que faut-il retenir en histoire ?", "Le contexte, les acteurs, les dates et les conséquences.")
                ),
                "geo"
        );
    }

    private CourseContent philosophyChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de philosophie",
                "Ce chapitre aide à comprendre une notion philosophique, les problèmes qu’elle pose et les arguments possibles. L’objectif n’est pas de réciter, mais de problématiser et d’argumenter.",
                List.of(
                        "Définir précisément la notion.",
                        "Identifier le problème philosophique.",
                        "Connaître quelques auteurs utiles.",
                        "Construire une argumentation claire."
                ),
                List.of(
                        "Définir la notion.",
                        "Trouver une opposition ou une difficulté.",
                        "Formuler une problématique.",
                        "Construire des arguments.",
                        "Illustrer avec des exemples ou auteurs."
                ),
                List.of(
                        "Notion → problème → thèse → argument → exemple.",
                        "Une dissertation oppose plusieurs points de vue.",
                        "Une bonne copie explique les concepts au lieu de réciter."
                ),
                List.of(
                        new VideoLink("Philosophie Terminale — Recherche chapitre", "https://www.youtube.com/results?search_query=philosophie+terminale+" + url(chapitre)),
                        new VideoLink("Méthode dissertation philosophie", "https://www.youtube.com/results?search_query=méthode+dissertation+philosophie+terminale")
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une problématique ?", "Une question qui fait apparaître une difficulté de pensée."),
                        new QuizQuestion("Pourquoi définir les termes ?", "Pour éviter les hors-sujets."),
                        new QuizQuestion("À quoi sert un auteur ?", "À soutenir ou discuter une idée.")
                ),
                "philo"
        );
    }

    private CourseContent sesChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de SES",
                "Ce chapitre permet d’analyser des phénomènes économiques, sociaux ou politiques. Il faut maîtriser les définitions, les mécanismes, les données et les exemples.",
                List.of(
                        "Définir les notions clés.",
                        "Comprendre les mécanismes économiques ou sociaux.",
                        "Utiliser des exemples et des données.",
                        "Rédiger une réponse structurée."
                ),
                List.of(
                        "Présenter la notion.",
                        "Expliquer le mécanisme.",
                        "Illustrer avec un exemple.",
                        "Nuancer l’analyse.",
                        "Conclure clairement."
                ),
                List.of(
                        "Notion → mécanisme → exemple → nuance.",
                        "Donnée statistique → lecture → interprétation.",
                        "Cause → effet → limite."
                ),
                List.of(
                        new VideoLink("SES Terminale — Recherche chapitre", "https://www.youtube.com/results?search_query=SES+terminale+" + url(chapitre)),
                        new VideoLink("Méthode bac SES Terminale", "https://www.youtube.com/results?search_query=méthode+bac+SES+terminale")
                ),
                List.of(
                        new QuizQuestion("Que faut-il faire avec une donnée statistique ?", "La lire puis l’interpréter."),
                        new QuizQuestion("Pourquoi nuancer une réponse ?", "Parce que les phénomènes sociaux et économiques sont complexes."),
                        new QuizQuestion("Que doit contenir une réponse de SES ?", "Définition, mécanisme, exemple et conclusion.")
                ),
                "ses"
        );
    }

    private CourseContent nsiChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de NSI",
                "Ce chapitre aide à comprendre un concept informatique : données, algorithmes, programmation, réseaux ou machines. Il faut savoir expliquer le principe et l’appliquer dans un exemple concret.",
                List.of(
                        "Comprendre le concept informatique principal.",
                        "Savoir l’utiliser dans un programme ou un schéma.",
                        "Identifier les erreurs fréquentes.",
                        "S’entraîner avec des exemples simples."
                ),
                List.of(
                        "Lire la définition.",
                        "Observer un exemple.",
                        "Reproduire la méthode.",
                        "Modifier l’exemple.",
                        "Tester et corriger."
                ),
                List.of(
                        "Entrée → traitement → sortie.",
                        "Algorithme → code → test.",
                        "Donnée → structure → opération."
                ),
                List.of(
                        new VideoLink("NSI Terminale — Recherche chapitre", "https://www.youtube.com/results?search_query=NSI+terminale+" + url(chapitre)),
                        new VideoLink("Méthode bac NSI", "https://www.youtube.com/results?search_query=méthode+bac+NSI+terminale")
                ),
                List.of(
                        new QuizQuestion("Pourquoi tester son code ?", "Pour vérifier qu’il fonctionne dans plusieurs cas."),
                        new QuizQuestion("À quoi sert une structure de données ?", "À organiser les informations pour les traiter efficacement."),
                        new QuizQuestion("Que doit contenir une bonne explication en NSI ?", "Le principe, un exemple et les étapes de fonctionnement.")
                ),
                "nsi"
        );
    }

    private CourseContent genericChapter(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours résumé",
                "Ce chapitre présente les idées essentielles à connaître. L’objectif est de comprendre les notions principales, de retenir les exemples importants et de savoir répondre à des questions.",
                List.of(
                        "Comprendre les notions principales.",
                        "Retenir les définitions.",
                        "Savoir donner des exemples.",
                        "S’entraîner avec un quiz."
                ),
                List.of(
                        "Lire le cours.",
                        "Repérer les mots importants.",
                        "Faire une fiche courte.",
                        "S’entraîner avec des questions."
                ),
                List.of(
                        "Définition → exemple → application.",
                        "Cours → fiche → entraînement."
                ),
                List.of(
                        new VideoLink("Recherche YouTube", "https://www.youtube.com/results?search_query=terminale+" + url(matiere) + "+" + url(chapitre))
                ),
                List.of(
                        new QuizQuestion("Quelle est l’idée principale du chapitre ?", "Elle dépend du cours étudié."),
                        new QuizQuestion("Comment bien réviser ?", "En comprenant, en résumant et en s’entraînant."),
                        new QuizQuestion("Pourquoi faire un quiz ?", "Pour vérifier ce qu’on a retenu.")
                ),
                "generic"
        );
    }

    private String safe(String value) {
        return value == null || value.isBlank() ? "Non précisé" : value.trim();
    }

    private String url(String value) {
        return safe(value)
                .replace(" ", "+")
                .replace("’", "")
                .replace("'", "");
    }

    public record CourseContent(
            String matiere,
            String chapitre,
            String title,
            String resume,
            List<String> keyPoints,
            List<String> methodSteps,
            List<String> formulas,
            List<VideoLink> videos,
            List<QuizQuestion> quiz,
            String type
    ) {
    }

    public record VideoLink(
            String title,
            String url
    ) {
    }

    public record QuizQuestion(
            String question,
            String answer
    ) {
    }
}