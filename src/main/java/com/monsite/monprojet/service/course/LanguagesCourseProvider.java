package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(10)
public class LanguagesCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("llce")
                || m.contains("amc")
                || m.contains("anglais")
                || m.contains("langues")
                || m.contains("litterature etrangere")
                || m.contains("monde contemporain");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("arts") || c.contains("debats d idees") || c.contains("debat")) {
            return artsEtDebatsIdees(matiere, chapitre);
        }

        if (c.contains("expression") || c.contains("construction de soi") || c.contains("identite")) {
            return expressionConstructionSoi(matiere, chapitre);
        }

        if (c.contains("voyages") || c.contains("territoires") || c.contains("frontieres")) {
            return voyagesTerritoiresFrontieres(matiere, chapitre);
        }

        if (c.contains("faire societe") || c.contains("societe")) {
            return faireSociete(matiere, chapitre);
        }

        if (c.contains("environnements") || c.contains("mutation") || c.contains("climat")) {
            return environnementsMutation(matiere, chapitre);
        }

        if (c.contains("relation au monde") || c.contains("monde") || c.contains("puissance") || c.contains("mondialisation")) {
            return relationAuMonde(matiere, chapitre);
        }

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent artsEtDebatsIdees(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Arts et débats d’idées",
                "Ce thème étudie la manière dont les œuvres artistiques et littéraires participent aux débats d’une société. L’art ne sert pas seulement à divertir : il peut dénoncer, convaincre, provoquer, représenter une époque ou défendre une cause.",
                List.of(
                        "L’art peut être un moyen d’expression personnelle et collective.",
                        "Une œuvre peut défendre une idée politique, sociale ou morale.",
                        "Les artistes peuvent critiquer la société de leur temps.",
                        "Les débats d’idées passent par les romans, le théâtre, la poésie, le cinéma, la peinture ou la musique.",
                        "Une œuvre engagée cherche souvent à faire réfléchir ou réagir le public.",
                        "L’interprétation d’une œuvre dépend du contexte historique et culturel."
                ),
                List.of(
                        "Identifier le type d’œuvre étudiée.",
                        "Situer l’œuvre dans son contexte historique et culturel.",
                        "Repérer l’idée ou la cause défendue.",
                        "Analyser les procédés utilisés : images, symboles, narration, ton, contraste.",
                        "Expliquer l’effet produit sur le lecteur ou spectateur.",
                        "Relier l’œuvre à un débat de société."
                ),
                List.of(
                        "Committed art → art engagé.",
                        "A debate of ideas → un débat d’idées.",
                        "To denounce → dénoncer.",
                        "To challenge society → remettre en question la société.",
                        "A social issue → un problème de société.",
                        "A symbol → un symbole.",
                        "The historical context → le contexte historique.",
                        "A work of art can inform, move and persuade."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment une œuvre peut participer à un débat. En LLCE, il ne faut pas seulement raconter une œuvre : il faut expliquer ce qu’elle dit de la société et pourquoi elle est importante."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On analyse le message de l’œuvre, les procédés utilisés et le contexte. Il faut montrer comment l’artiste cherche à convaincre, dénoncer, émouvoir ou faire réfléchir."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les analyses de textes, d’images, de films, de discours, d’œuvres engagées, et pour les sujets sur censure, liberté d’expression, art politique ou critique sociale."
                        )
                ),
                List.of(
                        new QuizQuestion("Pourquoi l’art peut-il être politique ?", "Parce qu’il peut défendre une idée, dénoncer une injustice ou critiquer une société."),
                        new QuizQuestion("Pourquoi le contexte est-il important ?", "Parce qu’il aide à comprendre le sens et les enjeux d’une œuvre."),
                        new QuizQuestion("Que signifie committed art ?", "L’art engagé."),
                        new QuizQuestion("Que faut-il éviter dans une analyse ?", "Se contenter de résumer l’œuvre sans analyser son message ni ses procédés.")
                ),
                "languages"
        );
    }

    private CourseContent expressionConstructionSoi(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Expression et construction de soi",
                "Ce thème interroge la manière dont l’individu construit son identité à travers la parole, l’écriture, la mémoire, les expériences personnelles et le regard des autres. Les œuvres permettent souvent de raconter une quête de soi.",
                List.of(
                        "L’identité se construit à partir de l’histoire personnelle, familiale et sociale.",
                        "L’écriture de soi permet de raconter, comprendre ou reconstruire son parcours.",
                        "La langue peut être un moyen d’affirmation de soi.",
                        "Le regard des autres influence la manière dont un individu se perçoit.",
                        "L’exil, la différence ou la marginalité peuvent transformer l’identité.",
                        "La littérature donne une voix aux expériences intimes ou minoritaires."
                ),
                List.of(
                        "Identifier qui parle dans le document.",
                        "Repérer les marques de subjectivité : pronoms, émotions, souvenirs, jugements.",
                        "Analyser le rapport entre individu et société.",
                        "Montrer comment la langue ou l’écriture permet de se construire.",
                        "Utiliser des exemples précis issus de textes, autobiographies, romans ou poèmes.",
                        "Conclure sur la transformation ou l’affirmation du moi."
                ),
                List.of(
                        "Identity → identité.",
                        "Self-expression → expression de soi.",
                        "Belonging → appartenance.",
                        "Otherness → altérité.",
                        "A personal narrative → un récit personnel.",
                        "Memory → mémoire.",
                        "To assert oneself → s’affirmer.",
                        "To feel excluded → se sentir exclu."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment une personne devient elle-même. En langue, littérature et culture étrangère, on étudie souvent des personnages ou auteurs qui cherchent leur place."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut repérer les indices de subjectivité et expliquer comment l’écriture, la parole ou l’expérience permet au personnage ou à l’auteur de construire son identité."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les autobiographies, récits d’exil, romans d’apprentissage, textes sur l’identité, minorités, mémoire familiale ou affirmation de soi."
                        )
                ),
                List.of(
                        new QuizQuestion("Pourquoi l’écriture de soi est-elle importante ?", "Elle permet de comprendre, raconter et parfois reconstruire son identité."),
                        new QuizQuestion("Que signifie belonging ?", "L’appartenance."),
                        new QuizQuestion("Pourquoi le regard des autres compte-t-il ?", "Parce qu’il influence la manière dont une personne se définit."),
                        new QuizQuestion("Que faut-il analyser dans un texte à la première personne ?", "La subjectivité, les émotions, les souvenirs et la construction du moi.")
                ),
                "languages"
        );
    }

    private CourseContent voyagesTerritoiresFrontieres(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Voyages, territoires, frontières",
                "Ce thème étudie les déplacements, les migrations, les découvertes et les frontières. Le voyage peut être une aventure, une fuite, un exil, une conquête ou une transformation personnelle.",
                List.of(
                        "Le voyage permet la découverte de nouveaux lieux et de nouvelles cultures.",
                        "La frontière peut être géographique, politique, sociale, culturelle ou symbolique.",
                        "Le déplacement peut enrichir l’identité mais aussi provoquer déracinement et exclusion.",
                        "Les migrations révèlent des inégalités et des tensions mondiales.",
                        "Les récits de voyage interrogent souvent le regard porté sur l’autre.",
                        "Le territoire est lié à l’appartenance, à la mémoire et au pouvoir."
                ),
                List.of(
                        "Identifier le type de déplacement : voyage, migration, exil, conquête.",
                        "Analyser la représentation du territoire.",
                        "Repérer les frontières visibles ou invisibles.",
                        "Étudier le rapport à l’autre et à l’étranger.",
                        "Montrer les effets du déplacement sur l’identité.",
                        "Relier le document à un contexte historique ou géopolitique."
                ),
                List.of(
                        "Journey → voyage.",
                        "Migration → migration.",
                        "Exile → exil.",
                        "Border / frontier → frontière.",
                        "Homeland → patrie / terre d’origine.",
                        "Displacement → déplacement / déracinement.",
                        "Encountering otherness → rencontrer l’altérité.",
                        "A sense of belonging → sentiment d’appartenance."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre que voyager ou franchir une frontière ne signifie pas seulement changer de lieu. Cela peut transformer l’identité, le regard sur le monde et le rapport aux autres."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut analyser le déplacement comme une expérience humaine. On regarde d’où part le personnage, où il va, ce qu’il découvre, ce qu’il perd et ce qu’il devient."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les récits de voyage, textes sur l’exil, migrations, frontières, colonisation, mondialisation, territoires et rencontres culturelles."
                        )
                ),
                List.of(
                        new QuizQuestion("Une frontière est-elle seulement géographique ?", "Non, elle peut aussi être sociale, culturelle, politique ou symbolique."),
                        new QuizQuestion("Pourquoi le voyage transforme-t-il l’individu ?", "Parce qu’il confronte à l’altérité et remet en question les repères."),
                        new QuizQuestion("Que signifie exile ?", "L’exil."),
                        new QuizQuestion("Que faut-il analyser dans un récit de voyage ?", "Le déplacement, le regard sur l’autre et la transformation du personnage.")
                ),
                "languages"
        );
    }

    private CourseContent faireSociete(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Faire société",
                "En AMC, le thème Faire société interroge les liens qui unissent ou divisent les individus dans les sociétés anglophones contemporaines. Il traite des institutions, des inégalités, de la citoyenneté, des identités et des tensions sociales.",
                List.of(
                        "Une société se construit autour de règles, valeurs, institutions et récits communs.",
                        "Les sociétés anglophones sont marquées par la diversité culturelle et sociale.",
                        "Les inégalités peuvent concerner la classe sociale, l’origine, le genre ou le territoire.",
                        "La citoyenneté implique des droits, des devoirs et une participation à la vie collective.",
                        "Les médias et réseaux sociaux influencent le débat public.",
                        "Les mouvements sociaux cherchent à transformer la société."
                ),
                List.of(
                        "Identifier le problème social ou politique du document.",
                        "Repérer les acteurs : citoyens, institutions, médias, minorités, associations.",
                        "Analyser les tensions : inclusion, exclusion, égalité, discrimination.",
                        "Relier le document à une société anglophone précise.",
                        "Utiliser un vocabulaire politique et social adapté.",
                        "Construire une réponse nuancée sur la cohésion sociale."
                ),
                List.of(
                        "Society → société.",
                        "Citizenship → citoyenneté.",
                        "Inequality → inégalité.",
                        "Diversity → diversité.",
                        "Inclusion / exclusion → inclusion / exclusion.",
                        "Civil rights → droits civiques.",
                        "Social movement → mouvement social.",
                        "Public debate → débat public."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre les grands débats des sociétés anglophones : diversité, droits civiques, immigration, inégalités, discriminations, citoyenneté ou polarisation politique."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On part d’un fait social ou politique, puis on identifie les acteurs et les tensions. Il faut montrer comment une société tente de rester unie malgré ses divisions."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les documents sur les États-Unis, le Royaume-Uni, les minorités, les droits civiques, les mouvements sociaux, les élections ou les médias."
                        )
                ),
                List.of(
                        new QuizQuestion("Que signifie citizenship ?", "La citoyenneté."),
                        new QuizQuestion("Pourquoi la diversité peut-elle créer des débats ?", "Parce qu’elle interroge l’intégration, l’égalité et les identités."),
                        new QuizQuestion("Que sont les civil rights ?", "Les droits civiques."),
                        new QuizQuestion("Que faut-il éviter en AMC ?", "Parler de manière vague sans relier le sujet à un contexte anglophone précis.")
                ),
                "amc"
        );
    }

    private CourseContent environnementsMutation(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Environnements en mutation",
                "Ce thème d’AMC étudie les transformations environnementales, économiques, urbaines, technologiques et sociales dans les pays anglophones. Il interroge la manière dont les sociétés s’adaptent aux changements et aux crises.",
                List.of(
                        "L’environnement peut désigner le milieu naturel, urbain, social ou numérique.",
                        "Le changement climatique transforme les sociétés et les territoires.",
                        "Les villes anglophones font face à des défis de logement, transport, pollution et inégalités.",
                        "Les nouvelles technologies modifient le travail, l’information et les relations sociales.",
                        "Les sociétés doivent arbitrer entre croissance, innovation et protection.",
                        "Les citoyens, États, entreprises et ONG participent aux réponses aux mutations."
                ),
                List.of(
                        "Identifier le type de mutation : environnementale, urbaine, sociale, technologique.",
                        "Repérer les causes du changement.",
                        "Analyser les conséquences sur les populations.",
                        "Identifier les acteurs et leurs réponses.",
                        "Comparer les avantages et les limites des solutions.",
                        "Relier le sujet à un exemple du monde anglophone."
                ),
                List.of(
                        "Changing environments → environnements en mutation.",
                        "Climate change → changement climatique.",
                        "Urbanisation → urbanisation.",
                        "Sustainability → durabilité.",
                        "Innovation → innovation.",
                        "Adaptation → adaptation.",
                        "Resilience → résilience.",
                        "Environmental justice → justice environnementale."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les sociétés anglophones réagissent aux transformations du monde : climat, villes, technologies, inégalités et nouveaux modes de vie."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer les causes, les conséquences et les réponses. Une bonne analyse explique qui subit la mutation, qui agit, et quelles solutions sont proposées."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les documents sur changement climatique, villes américaines ou britanniques, justice environnementale, nouvelles technologies, écologie ou innovation."
                        )
                ),
                List.of(
                        new QuizQuestion("Que signifie sustainability ?", "La durabilité."),
                        new QuizQuestion("Pourquoi parler de justice environnementale ?", "Parce que les populations ne subissent pas toutes les risques environnementaux de la même manière."),
                        new QuizQuestion("Quels acteurs peuvent agir face aux mutations ?", "Les États, citoyens, entreprises, ONG et collectivités."),
                        new QuizQuestion("Que faut-il toujours relier en AMC ?", "Le thème à un exemple concret du monde anglophone.")
                ),
                "amc"
        );
    }

    private CourseContent relationAuMonde(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Relation au monde",
                "Le thème Relation au monde étudie la place des sociétés anglophones dans la mondialisation. Il interroge la puissance, l’influence culturelle, les relations internationales, les médias, les échanges et les représentations du monde.",
                List.of(
                        "Les pays anglophones occupent une place importante dans la mondialisation.",
                        "La puissance peut être militaire, économique, diplomatique, culturelle ou numérique.",
                        "L’anglais est une langue mondiale qui facilite les échanges mais soulève aussi des enjeux culturels.",
                        "Le soft power repose sur l’attractivité culturelle, médiatique et éducative.",
                        "Les médias façonnent la perception du monde.",
                        "Les relations internationales révèlent rivalités, alliances et interdépendances."
                ),
                List.of(
                        "Identifier l’acteur anglophone étudié : État, entreprise, média, institution, artiste.",
                        "Déterminer le type d’influence : économique, culturelle, politique, militaire.",
                        "Analyser les outils de cette influence : langue, cinéma, universités, technologies, diplomatie.",
                        "Montrer les limites ou contestations de cette puissance.",
                        "Relier le document à la mondialisation.",
                        "Construire une réponse équilibrée entre influence et dépendance."
                ),
                List.of(
                        "Globalisation → mondialisation.",
                        "Soft power → puissance d’influence culturelle.",
                        "Hard power → puissance militaire ou coercitive.",
                        "Influence → influence.",
                        "Media coverage → couverture médiatique.",
                        "International relations → relations internationales.",
                        "Cultural dominance → domination culturelle.",
                        "Interdependence → interdépendance."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les pays et cultures anglophones influencent le monde, notamment par la langue anglaise, les médias, les technologies, le cinéma ou la diplomatie."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut identifier la forme de puissance étudiée. Par exemple, Hollywood relève du soft power, tandis qu’une intervention militaire relève davantage du hard power."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les documents sur les États-Unis, le Commonwealth, Hollywood, la BBC, les GAFAM, l’anglais mondial, la diplomatie ou les relations internationales."
                        )
                ),
                List.of(
                        new QuizQuestion("Que signifie soft power ?", "Une puissance d’influence fondée sur l’attraction culturelle, médiatique ou idéologique."),
                        new QuizQuestion("Que signifie globalisation ?", "La mondialisation."),
                        new QuizQuestion("Pourquoi l’anglais est-il un outil de puissance ?", "Parce qu’il facilite les échanges et diffuse une influence culturelle."),
                        new QuizQuestion("Quelle différence entre hard power et soft power ?", "Le hard power repose sur la contrainte ; le soft power sur l’attraction.")
                ),
                "amc"
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de langues en préparation",
                "Ce chapitre de LLCE ou AMC n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les grands thèmes de LLCE et AMC sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser le vocabulaire du thème.",
                        "S’entraîner à analyser un document en langue étrangère."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("LLCE AMC terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider LLCE / AMC.")
                ),
                "languages",
                List.of(
                        new ExplanationBlock(
                                "Cours en préparation",
                                "Ce chapitre sera ajouté avec un vrai résumé, du vocabulaire utile, une méthode, des vidéos et un quiz."
                        )
                )
        );
    }

    private CourseContent build(
            String matiere,
            String chapitre,
            String title,
            String resume,
            List<String> keyPoints,
            List<String> methodSteps,
            List<String> formulas,
            List<ExplanationBlock> explanations,
            List<QuizQuestion> quiz,
            String type
    ) {
        return new CourseContent(
                matiere,
                chapitre,
                title,
                resume,
                keyPoints,
                methodSteps,
                formulas,
                List.of(
                        new VideoLink("Cours vidéo — " + title, youtube("LLCE AMC terminale " + title)),
                        new VideoLink("Méthode analyse document — " + title, youtube("méthode analyse document anglais terminale " + title)),
                        new VideoLink("Vocabulaire — " + title, youtube("vocabulaire anglais terminale " + title))
                ),
                quiz,
                type,
                explanations
        );
    }
}