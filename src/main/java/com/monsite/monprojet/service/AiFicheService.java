package com.monsite.monprojet.service;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class AiFicheService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String generateRevisionFiche(String subject, String chapter, String theme) {
        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            return generateFallbackFiche(subject, chapter, theme);
        }

        try {
            String prompt = buildPrompt(subject, chapter, theme);

            String jsonBody = objectMapper.writeValueAsString(
                    new OpenAiRequest(getModelName(), prompt)
            );

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/responses"))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody, StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)
            );

            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                return generateFallbackFiche(subject, chapter, theme);
            }

            String aiText = extractTextFromOpenAiResponse(response.body());

            if (aiText == null || aiText.isBlank()) {
                return generateFallbackFiche(subject, chapter, theme);
            }

            return aiText.trim();

        } catch (Exception e) {
            return generateFallbackFiche(subject, chapter, theme);
        }
    }

    private String getModelName() {
        String model = System.getenv("OPENAI_MODEL");

        if (model == null || model.isBlank()) {
            return "gpt-4.1-mini";
        }

        return model;
    }

    private String buildPrompt(String subject, String chapter, String theme) {
        return """
                Tu es un expert pédagogique qui génère une fiche de révision premium pour un lycéen.
                
                Tu dois retourner UNIQUEMENT du HTML propre, sans markdown, sans ```html.
                
                CONTEXTE :
                - Matière : %s
                - Chapitre : %s
                - Thème : %s
                
                OBJECTIF :
                Générer une fiche de révision magnifique, claire, très structurée, moderne et utile.
                
                CONTRAINTES IMPORTANTES :
                - Retourne uniquement du HTML.
                - Utilise des sections bien découpées.
                - Utilise des titres, sous-titres, listes, cartes visuelles et blocs.
                - Le contenu doit être pédagogique, exact, niveau lycée.
                - La fiche doit suivre précisément la matière, le chapitre et le thème.
                - Il faut une vraie qualité de contenu, pas une fiche vague.
                
                STRUCTURE HTML ATTENDUE :
                - un conteneur principal <div class="ai-fiche-content">
                - un header avec :
                  - <div class="fiche-header">
                  - titre principal
                  - matière
                  - chapitre
                  - thème
                - puis plusieurs sections :
                  1. <section class="fiche-block fiche-summary"> résumé du chapitre
                  2. <section class="fiche-block fiche-keypoints"> notions essentielles
                  3. <section class="fiche-block fiche-method"> méthode / raisonnement
                  4. <section class="fiche-block fiche-example"> exemple concret
                  5. <section class="fiche-block fiche-mistakes"> erreurs à éviter
                  6. <section class="fiche-block fiche-quiz"> mini quiz
                
                ADAPTATION PAR MATIÈRE :
                - Si la matière est mathématiques ou contient "math", inclure :
                  - plusieurs formules en LaTeX entre \\[ ... \\]
                  - une méthode pas à pas
                  - un exemple de calcul
                - Si la matière est physique, chimie ou contient "physique" / "chimie", inclure :
                  - formules
                  - unités
                  - explication des grandeurs
                - Si la matière est géographie ou contient "géo" / "géographie", inclure :
                  - une section visuelle avec <div class="geo-card-grid">
                  - plusieurs <div class="geo-card"> avec repères, acteurs, territoires, dynamiques
                  - une section "Croquis / carte à retenir"
                - Si la matière est histoire, inclure :
                  - dates clés
                  - acteurs
                  - contexte
                - Si la matière est philo, français, littérature, inclure :
                  - notions
                  - auteurs
                  - arguments / exemples
                - Si la matière est SVT, inclure :
                  - mécanismes
                  - vocabulaire scientifique
                  - exemples simples
                
                STYLE DU HTML :
                - Utilise les classes CSS suivantes quand c’est pertinent :
                  fiche-title
                  fiche-meta
                  fiche-block
                  fiche-list
                  fiche-highlight
                  fiche-formula
                  fiche-grid
                  geo-card-grid
                  geo-card
                  quiz-card
                  summary-box
                - Pas d'inline CSS.
                
                Le contenu doit être riche, beau, précis, et directement exploitable par un élève.
                """.formatted(
                safe(subject),
                safe(chapter),
                safe(theme)
        );
    }

    private String extractTextFromOpenAiResponse(String responseBody) {
        try {
            JsonNode root = objectMapper.readTree(responseBody);

            JsonNode outputText = root.get("output_text");
            if (outputText != null && outputText.isTextual()) {
                return outputText.asText();
            }

            StringBuilder result = new StringBuilder();
            JsonNode output = root.get("output");

            if (output != null && output.isArray()) {
                for (JsonNode outputItem : output) {
                    JsonNode content = outputItem.get("content");

                    if (content != null && content.isArray()) {
                        for (JsonNode contentItem : content) {
                            JsonNode text = contentItem.get("text");
                            if (text != null && text.isTextual()) {
                                result.append(text.asText()).append("\n");
                            }
                        }
                    }
                }
            }

            return result.toString();

        } catch (Exception e) {
            return null;
        }
    }

    private String generateFallbackFiche(String subject, String chapter, String theme) {
        boolean isMath = safe(subject).toLowerCase().contains("math");
        boolean isGeo = safe(subject).toLowerCase().contains("géo")
                || safe(subject).toLowerCase().contains("geo")
                || safe(subject).toLowerCase().contains("géographie")
                || safe(subject).toLowerCase().contains("geographie");

        if (isMath) {
            return """
                    <div class="ai-fiche-content">
                        <div class="fiche-header">
                            <h1 class="fiche-title">Fiche de révision : %s</h1>
                            <div class="fiche-meta">
                                <span>Matière : %s</span>
                                <span>Chapitre : %s</span>
                                <span>Thème : %s</span>
                            </div>
                        </div>

                        <section class="fiche-block fiche-summary">
                            <h2>Résumé</h2>
                            <div class="summary-box">
                                <p>Cette fiche présente les idées essentielles à connaître pour réviser efficacement ce thème.</p>
                            </div>
                        </section>

                        <section class="fiche-block fiche-keypoints">
                            <h2>Notions essentielles</h2>
                            <ul class="fiche-list">
                                <li>Identifier les notions importantes du chapitre.</li>
                                <li>Comprendre la logique de résolution.</li>
                                <li>Savoir reconnaître les formules à utiliser.</li>
                            </ul>
                        </section>

                        <section class="fiche-block">
                            <h2>Formules importantes</h2>
                            <div class="fiche-formula">\\[ a^2 + b^2 = c^2 \\]</div>
                            <div class="fiche-formula">\\[ \\Delta = b^2 - 4ac \\]</div>
                            <div class="fiche-formula">\\[ f'(x) = \\lim_{h \\to 0} \\frac{f(x+h)-f(x)}{h} \\]</div>
                        </section>

                        <section class="fiche-block fiche-method">
                            <h2>Méthode</h2>
                            <ol class="fiche-list">
                                <li>Lire attentivement l’énoncé.</li>
                                <li>Repérer les données utiles.</li>
                                <li>Choisir la formule adaptée.</li>
                                <li>Calculer étape par étape.</li>
                                <li>Vérifier le résultat final.</li>
                            </ol>
                        </section>

                        <section class="fiche-block fiche-example">
                            <h2>Exemple</h2>
                            <p class="fiche-highlight">Exemple guidé : appliquer la bonne formule puis détailler chaque étape de calcul.</p>
                        </section>

                        <section class="fiche-block fiche-mistakes">
                            <h2>Erreurs à éviter</h2>
                            <ul class="fiche-list">
                                <li>Confondre les formules.</li>
                                <li>Oublier les unités ou les conditions.</li>
                                <li>Sauter des étapes de raisonnement.</li>
                            </ul>
                        </section>

                        <section class="fiche-block fiche-quiz">
                            <h2>Mini quiz</h2>
                            <div class="fiche-grid">
                                <div class="quiz-card">1. Quelle formule faut-il utiliser ici ?</div>
                                <div class="quiz-card">2. Quelle est la première étape de résolution ?</div>
                                <div class="quiz-card">3. Comment vérifier ton résultat ?</div>
                            </div>
                        </section>
                    </div>
                    """.formatted(
                    safe(theme),
                    safe(subject),
                    safe(chapter),
                    safe(theme)
            );
        }

        if (isGeo) {
            return """
                    <div class="ai-fiche-content">
                        <div class="fiche-header">
                            <h1 class="fiche-title">Fiche de révision : %s</h1>
                            <div class="fiche-meta">
                                <span>Matière : %s</span>
                                <span>Chapitre : %s</span>
                                <span>Thème : %s</span>
                            </div>
                        </div>

                        <section class="fiche-block fiche-summary">
                            <h2>Résumé</h2>
                            <div class="summary-box">
                                <p>Cette fiche t’aide à retenir les dynamiques spatiales, les acteurs, les territoires et les repères essentiels.</p>
                            </div>
                        </section>

                        <section class="fiche-block fiche-keypoints">
                            <h2>Idées essentielles</h2>
                            <ul class="fiche-list">
                                <li>Identifier les espaces concernés.</li>
                                <li>Comprendre les dynamiques territoriales.</li>
                                <li>Repérer les acteurs et les enjeux.</li>
                            </ul>
                        </section>

                        <section class="fiche-block">
                            <h2>Repères géographiques</h2>
                            <div class="geo-card-grid">
                                <div class="geo-card">
                                    <h3>Territoires</h3>
                                    <p>Quels sont les espaces étudiés ?</p>
                                </div>
                                <div class="geo-card">
                                    <h3>Acteurs</h3>
                                    <p>États, entreprises, populations, institutions.</p>
                                </div>
                                <div class="geo-card">
                                    <h3>Dynamiques</h3>
                                    <p>Flux, mobilités, échanges, inégalités.</p>
                                </div>
                                <div class="geo-card">
                                    <h3>Enjeux</h3>
                                    <p>Développement, environnement, puissance, aménagement.</p>
                                </div>
                            </div>
                        </section>

                        <section class="fiche-block fiche-method">
                            <h2>Croquis / carte à retenir</h2>
                            <p class="fiche-highlight">Apprends à localiser les espaces majeurs, les flux et les pôles importants du chapitre.</p>
                        </section>

                        <section class="fiche-block fiche-example">
                            <h2>Exemple</h2>
                            <p>Choisis un territoire étudié et explique ses caractéristiques principales, ses atouts et ses limites.</p>
                        </section>

                        <section class="fiche-block fiche-mistakes">
                            <h2>Erreurs à éviter</h2>
                            <ul class="fiche-list">
                                <li>Parler d’un espace sans le localiser.</li>
                                <li>Oublier les acteurs.</li>
                                <li>Décrire sans expliquer les enjeux.</li>
                            </ul>
                        </section>

                        <section class="fiche-block fiche-quiz">
                            <h2>Mini quiz</h2>
                            <div class="fiche-grid">
                                <div class="quiz-card">1. Quels sont les acteurs principaux ?</div>
                                <div class="quiz-card">2. Quels flux structurent l’espace étudié ?</div>
                                <div class="quiz-card">3. Quels sont les enjeux majeurs ?</div>
                            </div>
                        </section>
                    </div>
                    """.formatted(
                    safe(theme),
                    safe(subject),
                    safe(chapter),
                    safe(theme)
            );
        }

        return """
                <div class="ai-fiche-content">
                    <div class="fiche-header">
                        <h1 class="fiche-title">Fiche de révision : %s</h1>
                        <div class="fiche-meta">
                            <span>Matière : %s</span>
                            <span>Chapitre : %s</span>
                            <span>Thème : %s</span>
                        </div>
                    </div>

                    <section class="fiche-block fiche-summary">
                        <h2>Résumé</h2>
                        <div class="summary-box">
                            <p>Voici une fiche de révision structurée pour revoir efficacement le thème demandé.</p>
                        </div>
                    </section>

                    <section class="fiche-block fiche-keypoints">
                        <h2>Notions essentielles</h2>
                        <ul class="fiche-list">
                            <li>Définitions importantes.</li>
                            <li>Idées principales à retenir.</li>
                            <li>Exemples utiles pour mieux comprendre.</li>
                        </ul>
                    </section>

                    <section class="fiche-block fiche-method">
                        <h2>Méthode de révision</h2>
                        <ol class="fiche-list">
                            <li>Lire les notions clés.</li>
                            <li>Reformuler avec ses mots.</li>
                            <li>Retenir un exemple concret.</li>
                            <li>Se tester avec le mini quiz.</li>
                        </ol>
                    </section>

                    <section class="fiche-block fiche-example">
                        <h2>Exemple</h2>
                        <p class="fiche-highlight">Ajoute ici un exemple précis lié à ton cours pour mémoriser plus facilement.</p>
                    </section>

                    <section class="fiche-block fiche-mistakes">
                        <h2>Erreurs à éviter</h2>
                        <ul class="fiche-list">
                            <li>Apprendre sans comprendre.</li>
                            <li>Oublier les définitions.</li>
                            <li>Ne pas s’entraîner.</li>
                        </ul>
                    </section>

                    <section class="fiche-block fiche-quiz">
                        <h2>Mini quiz</h2>
                        <div class="fiche-grid">
                            <div class="quiz-card">1. Quelle est l’idée principale du thème ?</div>
                            <div class="quiz-card">2. Quelles notions faut-il connaître ?</div>
                            <div class="quiz-card">3. Quel exemple permet d’illustrer ce cours ?</div>
                        </div>
                    </section>
                </div>
                """.formatted(
                safe(theme),
                safe(subject),
                safe(chapter),
                safe(theme)
        );
    }

    private String safe(String value) {
        return value == null || value.isBlank() ? "Non précisé" : value.trim();
    }

    private record OpenAiRequest(String model, String input) {
    }
}