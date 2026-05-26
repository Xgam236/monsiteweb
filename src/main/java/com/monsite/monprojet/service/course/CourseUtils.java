package com.monsite.monprojet.service.course;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

public final class CourseUtils {

    private CourseUtils() {
    }

    public static String safe(String value) {
        return value == null || value.isBlank() ? "Non précisé" : value.trim();
    }

    public static String normalize(String value) {
        String text = safe(value).toLowerCase();

        text = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        return text
                .replace("’", "'")
                .replace("œ", "oe")
                .replace("æ", "ae");
    }

    public static String youtube(String query) {
        return "https://www.youtube.com/results?search_query=" + url(query);
    }

    public static String url(String value) {
        return URLEncoder.encode(safe(value), StandardCharsets.UTF_8);
    }
}