package com.monsite.monprojet.service.course;

public interface CourseProvider {

    boolean supports(String matiere);

    CourseContent getCourse(String matiere, String chapitre);
}