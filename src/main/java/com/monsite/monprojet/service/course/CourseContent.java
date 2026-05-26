package com.monsite.monprojet.service.course;

import java.util.List;

public class CourseContent {

    private final String matiere;
    private final String chapitre;
    private final String title;
    private final String resume;
    private final List<String> keyPoints;
    private final List<String> methodSteps;
    private final List<String> formulas;
    private final List<VideoLink> videos;
    private final List<QuizQuestion> quiz;
    private final String type;
    private final List<ExplanationBlock> explanations;

    public CourseContent(
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
        this(
                matiere,
                chapitre,
                title,
                resume,
                keyPoints,
                methodSteps,
                formulas,
                videos,
                quiz,
                type,
                buildAutoExplanations(title, resume, keyPoints, methodSteps)
        );
    }

    public CourseContent(
            String matiere,
            String chapitre,
            String title,
            String resume,
            List<String> keyPoints,
            List<String> methodSteps,
            List<String> formulas,
            List<VideoLink> videos,
            List<QuizQuestion> quiz,
            String type,
            List<ExplanationBlock> explanations
    ) {
        this.matiere = matiere;
        this.chapitre = chapitre;
        this.title = title;
        this.resume = resume;
        this.keyPoints = keyPoints;
        this.methodSteps = methodSteps;
        this.formulas = formulas;
        this.videos = videos;
        this.quiz = quiz;
        this.type = type;
        this.explanations = explanations;
    }

    private static List<ExplanationBlock> buildAutoExplanations(
            String title,
            String resume,
            List<String> keyPoints,
            List<String> methodSteps
    ) {
        String firstKeyPoint = keyPoints != null && !keyPoints.isEmpty()
                ? keyPoints.get(0)
                : "Ce chapitre présente une notion importante du programme.";

        String firstMethod = methodSteps != null && !methodSteps.isEmpty()
                ? methodSteps.get(0)
                : "Il faut d’abord comprendre la notion puis l’appliquer dans des exercices.";

        return List.of(
                new ExplanationBlock(
                        "À quoi ça sert ?",
                        resume
                ),
                new ExplanationBlock(
                        "Comment l’utiliser ?",
                        "Pour utiliser ce chapitre, il faut d’abord repérer la situation dans l’exercice, puis appliquer la bonne méthode. " +
                                "L’idée principale est : " + firstKeyPoint
                ),
                new ExplanationBlock(
                        "Méthode en exercice",
                        "La première étape est : " + firstMethod +
                                " Ensuite, il faut justifier chaque étape et terminer par une conclusion claire."
                )
        );
    }

    public String getMatiere() {
        return matiere;
    }

    public String getChapitre() {
        return chapitre;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public List<String> getKeyPoints() {
        return keyPoints;
    }

    public List<String> getMethodSteps() {
        return methodSteps;
    }

    public List<String> getFormulas() {
        return formulas;
    }

    public List<VideoLink> getVideos() {
        return videos;
    }

    public List<QuizQuestion> getQuiz() {
        return quiz;
    }

    public String getType() {
        return type;
    }

    public List<ExplanationBlock> getExplanations() {
        return explanations;
    }
}