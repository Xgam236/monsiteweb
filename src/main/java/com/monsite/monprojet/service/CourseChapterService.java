package com.monsite.monprojet.service;

import com.monsite.monprojet.service.course.CourseContent;
import com.monsite.monprojet.service.course.CourseProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.safe;

@Service
public class CourseChapterService {

    private final List<CourseProvider> providers;

    public CourseChapterService(List<CourseProvider> providers) {
        this.providers = providers;
    }

    public CourseContent generateChapter(String matiere, String chapitre) {
        String safeMatiere = safe(matiere);
        String safeChapitre = safe(chapitre);

        String normalizedMatiere = normalize(safeMatiere);

        return providers.stream()
                .filter(provider -> provider.supports(normalizedMatiere))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Aucun fournisseur de cours trouvé."))
                .getCourse(safeMatiere, safeChapitre);
    }
}