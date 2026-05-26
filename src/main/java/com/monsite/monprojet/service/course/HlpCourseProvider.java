package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(9)
public class HlpCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("hlp")
                || m.contains("humanites")
                || m.contains("litterature")
                || m.contains("philosophie");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("recherche de soi") || c.contains("education") || c.contains("transmission") || c.contains("emancipation")) {
            return rechercheDeSoi(matiere, chapitre);
        }

        if (c.contains("expressions de la sensibilite") || c.contains("sensibilite") || c.contains("metamorphoses du moi") || c.contains("moi")) {
            return sensibiliteMetamorphosesMoi(matiere, chapitre);
        }

        if (c.contains("humanite en question") || c.contains("creation") || c.contains("continuite") || c.contains("rupture")) {
            return humaniteEnQuestion(matiere, chapitre);
        }

        if (c.contains("histoire") && c.contains("violence") || c.contains("violence")) {
            return histoireViolence(matiere, chapitre);
        }

        if (c.contains("limites de l humain") || c.contains("humain") || c.contains("inhumain") || c.contains("transhumanisme")) {
            return limitesHumain(matiere, chapitre);
        }

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent rechercheDeSoi(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La recherche de soi : éducation, transmission et émancipation",
                "Ce thème interroge la manière dont un individu se construit. L’être humain ne naît pas immédiatement maître de lui-même : il se forme par l’éducation, les lectures, les rencontres, la culture, mais aussi par les conflits et les ruptures.",
                List.of(
                        "L’éducation transmet des savoirs, des valeurs et des manières de penser.",
                        "La transmission peut aider l’individu à se construire.",
                        "Mais elle peut aussi enfermer dans des normes ou des traditions.",
                        "L’émancipation consiste à devenir capable de penser et d’agir par soi-même.",
                        "La recherche de soi passe souvent par une tension entre héritage et liberté.",
                        "Les récits autobiographiques montrent comment un individu donne sens à son parcours."
                ),
                List.of(
                        "Définir les mots du sujet : éducation, transmission, émancipation, identité.",
                        "Se demander si l’éducation libère ou contraint.",
                        "Utiliser des exemples littéraires ou philosophiques.",
                        "Montrer que se construire suppose d’hériter, mais aussi de choisir.",
                        "Nuancer : on ne devient pas soi seul, mais on ne se réduit pas non plus à ce qu’on reçoit."
                ),
                List.of(
                        "Éducation : formation intellectuelle, morale et sociale d’un individu.",
                        "Transmission : passage d’un savoir, d’une culture ou d’une valeur d’une génération à une autre.",
                        "Émancipation : conquête d’une autonomie de pensée et d’action.",
                        "Identité : manière dont un individu se définit et se reconnaît.",
                        "Autobiographie : récit rétrospectif qu’une personne fait de sa propre vie.",
                        "Héritage culturel : ensemble des savoirs, valeurs et références reçus."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment une personne devient elle-même. Il montre que l’identité se construit à partir de ce que l’on reçoit, mais aussi à partir de ce que l’on refuse, transforme ou choisit."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans une dissertation ou une interprétation, il faut montrer la tension entre transmission et liberté. L’éducation peut libérer en donnant des outils pour penser, mais elle peut aussi imposer des modèles."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets comme : L’éducation rend-elle libre ? Peut-on se construire seul ? Faut-il rompre avec ce qu’on nous transmet pour devenir soi-même ?"
                        )
                ),
                List.of(
                        new QuizQuestion("Pourquoi l’éducation est-elle importante dans la construction de soi ?", "Parce qu’elle transmet des savoirs, des valeurs et des repères qui permettent de se former."),
                        new QuizQuestion("Qu’est-ce que l’émancipation ?", "C’est le fait de devenir autonome dans sa pensée et ses actions."),
                        new QuizQuestion("Pourquoi la transmission peut-elle être ambiguë ?", "Elle peut aider à se construire, mais aussi enfermer dans des normes."),
                        new QuizQuestion("Quel type de récit est souvent utile dans ce thème ?", "L’autobiographie, car elle montre comment un individu relit son propre parcours.")
                )
        );
    }

    private CourseContent sensibiliteMetamorphosesMoi(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Les expressions de la sensibilité et les métamorphoses du moi",
                "Ce thème étudie la manière dont les émotions, les sensations, les sentiments et l’imagination permettent d’exprimer l’intériorité. Il montre aussi que le moi n’est pas toujours stable : il peut changer, se chercher et se transformer.",
                List.of(
                        "La sensibilité désigne la capacité à ressentir et à être affecté.",
                        "Les émotions peuvent révéler une vérité intérieure.",
                        "La littérature permet d’exprimer ce qui est difficile à dire directement.",
                        "Le moi n’est pas toujours fixe : il évolue avec le temps, les expériences et les crises.",
                        "L’expression du moi peut passer par la poésie, le roman, l’autobiographie ou le théâtre.",
                        "L’écriture peut transformer la souffrance ou l’expérience intime en œuvre."
                ),
                List.of(
                        "Identifier quelle forme de sensibilité est exprimée.",
                        "Analyser les procédés d’écriture : images, rythme, point de vue, champs lexicaux.",
                        "Relier l’expression littéraire à une expérience intérieure.",
                        "Se demander si l’écriture révèle ou transforme le moi.",
                        "Montrer que le moi peut être fragmenté, instable ou en métamorphose."
                ),
                List.of(
                        "Sensibilité : capacité de ressentir émotions, sensations et affects.",
                        "Moi : conscience individuelle et identité personnelle.",
                        "Lyrique : expression personnelle des sentiments.",
                        "Introspection : observation de sa propre vie intérieure.",
                        "Métamorphose : transformation profonde d’un être ou d’une identité.",
                        "Subjectivité : point de vue propre à un sujet."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment la littérature donne une forme aux émotions et à l’identité. Il montre que les sentiments ne sont pas seulement privés : ils peuvent devenir une matière artistique."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans un texte, il faut repérer comment l’auteur fait sentir une émotion : choix des mots, images, rythme, pronoms, ponctuation. Ensuite, il faut expliquer ce que cela révèle du moi."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur l’expression des émotions, l’écriture de soi, la poésie lyrique, l’autobiographie, la transformation du moi ou le rapport entre souffrance et création."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que la sensibilité ?", "C’est la capacité à ressentir des émotions, sensations et affects."),
                        new QuizQuestion("Pourquoi la littérature est-elle utile pour exprimer le moi ?", "Parce qu’elle donne une forme aux expériences intérieures."),
                        new QuizQuestion("Que signifie métamorphose du moi ?", "Une transformation de l’identité ou de la perception de soi."),
                        new QuizQuestion("Qu’est-ce que le lyrisme ?", "L’expression personnelle des sentiments.")
                )
        );
    }

    private CourseContent humaniteEnQuestion(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "L’humanité en question : création, continuités et ruptures",
                "Ce thème interroge ce qui fait l’humanité et la manière dont les œuvres, les inventions, les crises et les révolutions transforment notre vision de l’homme. Il met en relation progrès, création, histoire et changement.",
                List.of(
                        "L’humanité se définit par sa capacité à créer, transmettre et transformer le monde.",
                        "Les œuvres littéraires et philosophiques questionnent ce que signifie être humain.",
                        "Les ruptures historiques modifient la représentation de l’homme.",
                        "Le progrès peut être source d’émancipation, mais aussi d’inquiétude.",
                        "La création permet d’imaginer d’autres mondes et d’autres formes d’existence.",
                        "Les continuités montrent que certaines questions humaines traversent les époques."
                ),
                List.of(
                        "Identifier ce qui est questionné : progrès, humanité, création, rupture.",
                        "Repérer le contexte historique ou culturel.",
                        "Analyser comment l’œuvre représente l’homme.",
                        "Montrer les tensions entre continuité et changement.",
                        "Utiliser des exemples littéraires, philosophiques, scientifiques ou historiques."
                ),
                List.of(
                        "Humanité : ensemble des êtres humains, mais aussi qualités propres à l’homme.",
                        "Création : production d’une œuvre ou d’une idée nouvelle.",
                        "Rupture : changement profond dans l’histoire ou la pensée.",
                        "Continuité : permanence d’une question ou d’une tradition.",
                        "Progrès : amélioration supposée des connaissances, techniques ou conditions de vie.",
                        "Modernité : période ou attitude marquée par le changement et la remise en question."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les grandes transformations historiques, techniques ou culturelles obligent les hommes à redéfinir ce qu’ils sont."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer que les œuvres ne parlent pas seulement d’une époque : elles posent aussi des questions générales sur l’homme, le progrès, la liberté, la violence ou la création."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur le progrès, la modernité, les crises de civilisation, les utopies, les dystopies, la création artistique ou les ruptures historiques."
                        )
                ),
                List.of(
                        new QuizQuestion("Pourquoi parle-t-on d’humanité en question ?", "Parce que certaines œuvres et événements obligent à réfléchir à ce qui définit l’humain."),
                        new QuizQuestion("Qu’est-ce qu’une rupture ?", "Un changement profond dans l’histoire, la pensée ou les formes artistiques."),
                        new QuizQuestion("Le progrès est-il toujours positif ?", "Non, il peut libérer mais aussi inquiéter ou produire de nouveaux dangers."),
                        new QuizQuestion("Pourquoi la création est-elle importante ?", "Elle permet d’imaginer, de représenter et de transformer notre vision du monde.")
                )
        );
    }

    private CourseContent histoireViolence(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Histoire et violence",
                "Ce thème analyse la violence dans l’histoire humaine : guerres, révolutions, massacres, domination, oppression, mais aussi témoignages et représentations de la violence. Il interroge la manière dont les hommes racontent et comprennent la violence.",
                List.of(
                        "La violence peut être physique, politique, sociale, symbolique ou psychologique.",
                        "L’histoire humaine est marquée par des conflits et des formes de domination.",
                        "Les œuvres littéraires peuvent témoigner de la violence ou la dénoncer.",
                        "Représenter la violence pose une question morale : montrer, dénoncer ou choquer.",
                        "Le témoignage peut lutter contre l’oubli.",
                        "La violence interroge les limites de l’humanité."
                ),
                List.of(
                        "Identifier la forme de violence étudiée.",
                        "Situer le texte ou le document dans son contexte.",
                        "Analyser le point de vue : victime, témoin, bourreau, historien, narrateur.",
                        "Repérer les procédés de dénonciation ou de mise à distance.",
                        "Se demander quel effet la représentation de la violence produit sur le lecteur."
                ),
                List.of(
                        "Violence physique : atteinte au corps.",
                        "Violence politique : usage de la force pour dominer ou contrôler.",
                        "Violence symbolique : domination invisible ou intériorisée.",
                        "Témoignage : récit d’une expérience vécue.",
                        "Mémoire : transmission d’un événement passé.",
                        "Dénonciation : critique explicite ou implicite d’une injustice."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment la violence traverse l’histoire et comment les textes peuvent la représenter, la dénoncer ou en conserver la mémoire."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut relier l’analyse du texte à la question morale : pourquoi montrer la violence ? Pour témoigner, faire comprendre, choquer, dénoncer ou empêcher l’oubli."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur la guerre, les génocides, la révolution, l’oppression, le témoignage, la mémoire ou la représentation du mal."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelles formes peut prendre la violence ?", "Elle peut être physique, politique, sociale, symbolique ou psychologique."),
                        new QuizQuestion("Pourquoi témoigner de la violence ?", "Pour transmettre, dénoncer et lutter contre l’oubli."),
                        new QuizQuestion("Quel problème pose la représentation de la violence ?", "Il faut montrer sans banaliser ni transformer la souffrance en spectacle."),
                        new QuizQuestion("Pourquoi la violence interroge-t-elle l’humanité ?", "Parce qu’elle montre ce que l’homme peut infliger à d’autres hommes.")
                )
        );
    }

    private CourseContent limitesHumain(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Les limites de l’humain",
                "Ce thème interroge les frontières de l’humain : animalité, machine, intelligence artificielle, transhumanisme, maladie, vieillesse, mort et inhumanité. Il pose la question de ce qui définit l’homme et de ce qui peut le dépasser ou le menacer.",
                List.of(
                        "L’humain peut être défini par la raison, le langage, la culture, la conscience ou la liberté.",
                        "Les limites de l’humain apparaissent face à l’animal, à la machine ou au divin.",
                        "Les progrès techniques modifient notre rapport au corps et à l’identité.",
                        "Le transhumanisme cherche à augmenter les capacités humaines.",
                        "L’inhumain désigne ce qui nie la dignité ou la valeur humaine.",
                        "La mort et la vulnérabilité rappellent les limites fondamentales de l’homme."
                ),
                List.of(
                        "Définir ce qui est entendu par humain.",
                        "Identifier la limite étudiée : animal, machine, technique, mort, violence.",
                        "Analyser si cette limite est dépassable ou non.",
                        "Se demander si dépasser les limites humaines est un progrès ou un danger.",
                        "Utiliser des exemples : IA, robot, médecine, science-fiction, guerre, vieillesse."
                ),
                List.of(
                        "Humain : être vivant doté de conscience, culture, langage et relations sociales.",
                        "Inhumain : ce qui nie la dignité humaine.",
                        "Transhumanisme : courant qui veut améliorer l’homme par la technique.",
                        "Vulnérabilité : fragilité constitutive de l’être humain.",
                        "Dignité : valeur propre reconnue à toute personne humaine.",
                        "Frontière humain/machine : question posée par l’IA et la robotique."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à réfléchir à ce qui fait vraiment l’humanité. Il devient très actuel avec l’intelligence artificielle, les biotechnologies et les projets d’augmentation de l’homme."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer que dépasser une limite peut être positif, par exemple soigner une maladie, mais peut aussi poser des problèmes éthiques si l’on transforme l’homme en objet technique."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur l’IA, le transhumanisme, la mort, l’animalité, la dignité humaine, les robots, la médecine ou l’inhumanité."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que le transhumanisme ?", "Un courant qui cherche à améliorer les capacités humaines par la technique."),
                        new QuizQuestion("Pourquoi l’IA interroge-t-elle les limites de l’humain ?", "Parce qu’elle imite certaines capacités intellectuelles humaines."),
                        new QuizQuestion("Que signifie inhumain ?", "Ce qui nie la dignité ou la valeur humaine."),
                        new QuizQuestion("Pourquoi la mort est-elle une limite fondamentale ?", "Parce qu’elle rappelle la vulnérabilité et la finitude de l’être humain.")
                )
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de HLP en préparation",
                "Ce chapitre de HLP n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les grands thèmes de spécialité HLP sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les notions principales en attendant.",
                        "S’entraîner à analyser un texte littéraire ou philosophique."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("HLP terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider HLP.")
                ),
                "hlp",
                List.of(
                        new ExplanationBlock(
                                "Cours en préparation",
                                "Ce chapitre sera ajouté avec un vrai résumé, des notions, une méthode, des exemples, des vidéos et un quiz."
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
            List<QuizQuestion> quiz
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
                        new VideoLink("Cours vidéo — " + title, youtube("HLP terminale " + title)),
                        new VideoLink("Méthode analyse de texte — " + title, youtube("méthode analyse de texte HLP terminale " + title)),
                        new VideoLink("Exemples littéraires — " + title, youtube("exemples textes HLP terminale " + title))
                ),
                quiz,
                "hlp",
                explanations
        );
    }
}