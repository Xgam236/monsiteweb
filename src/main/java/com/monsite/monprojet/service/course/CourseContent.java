package com.monsite.monprojet.service.course;

import java.util.List;

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