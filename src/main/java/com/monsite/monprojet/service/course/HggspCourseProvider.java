package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(8)
public class HggspCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("hggsp")
                || m.contains("histoire geographie geopolitique")
                || m.contains("geopolitique")
                || m.contains("sciences politiques");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("nouveaux espaces de conquete") || c.contains("espace") || c.contains("ocean")) {
            return nouveauxEspacesConquete(matiere, chapitre);
        }

        if (c.contains("faire la guerre") || c.contains("faire la paix") || c.contains("formes de conflits")) {
            return guerrePaix(matiere, chapitre);
        }

        if (c.contains("histoire") && c.contains("memoire") || c.contains("memoires")) {
            return histoireMemoires(matiere, chapitre);
        }

        if (c.contains("patrimoine")) {
            return patrimoine(matiere, chapitre);
        }

        if (c.contains("environnement")) {
            return environnement(matiere, chapitre);
        }

        if (c.contains("connaissance")) {
            return connaissance(matiere, chapitre);
        }

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent nouveauxEspacesConquete(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "De nouveaux espaces de conquête",
                "Ce thème étudie les espaces maritimes et l’espace extra-atmosphérique comme nouveaux lieux de puissance, de rivalités et de coopération. Les océans et l’espace sont à la fois des ressources, des routes, des territoires stratégiques et des espaces difficiles à contrôler.",
                List.of(
                        "Les océans sont essentiels pour le commerce mondial, les ressources et la puissance militaire.",
                        "L’espace extra-atmosphérique est devenu un enjeu stratégique, scientifique, économique et militaire.",
                        "Les grandes puissances cherchent à contrôler ou influencer ces espaces.",
                        "Les espaces maritimes et spatiaux posent des problèmes de droit international.",
                        "Ils sont à la fois des espaces de coopération et de rivalités.",
                        "Les nouvelles technologies renforcent la compétition entre États et entreprises privées."
                ),
                List.of(
                        "Définir l’espace étudié : maritime ou spatial.",
                        "Identifier les acteurs : États, organisations internationales, entreprises, armées.",
                        "Repérer les enjeux : ressources, routes, souveraineté, sécurité, prestige.",
                        "Montrer les rivalités entre puissances.",
                        "Montrer aussi les formes de coopération.",
                        "Utiliser des exemples précis : ZEE, Arctique, satellites, Lune, SpaceX, Chine, États-Unis."
                ),
                List.of(
                        "ZEE : zone économique exclusive, jusqu’à 200 milles nautiques.",
                        "Thalassocratie : puissance fondée sur la maîtrise des mers.",
                        "Espace extra-atmosphérique : espace situé au-delà de l’atmosphère terrestre.",
                        "Militarisation : utilisation stratégique ou militaire d’un espace.",
                        "Gouvernance mondiale : ensemble de règles et d’acteurs organisant un espace commun.",
                        "Bien commun mondial : espace ou ressource concernant l’humanité entière."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi les mers, les océans et l’espace sont devenus des lieux majeurs de puissance. Celui qui contrôle les routes maritimes, les satellites ou certaines ressources possède un avantage stratégique."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans une copie, il faut toujours montrer la tension entre coopération et rivalité. Ces espaces sont parfois présentés comme communs, mais ils sont aussi dominés par les grandes puissances."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur la conquête spatiale, les océans, les ZEE, l’Arctique, la militarisation de l’espace, les routes maritimes ou les rivalités sino-américaines."
                        )
                ),
                List.of(
                        new QuizQuestion("Pourquoi les océans sont-ils stratégiques ?", "Ils concentrent des routes commerciales, des ressources et des enjeux militaires."),
                        new QuizQuestion("Qu’est-ce qu’une ZEE ?", "Une zone économique exclusive où un État dispose de droits d’exploitation sur les ressources."),
                        new QuizQuestion("Pourquoi l’espace devient-il un enjeu de puissance ?", "Parce qu’il permet la surveillance, la communication, le prestige et des usages militaires."),
                        new QuizQuestion("Quelle tension traverse ce thème ?", "La tension entre coopération internationale et rivalités de puissance.")
                )
        );
    }

    private CourseContent guerrePaix(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Faire la guerre, faire la paix : formes de conflits et modes de résolution",
                "Ce thème étudie l’évolution des formes de guerre et les moyens de construire la paix. Il montre que les conflits ne se limitent pas aux guerres classiques entre États : ils peuvent être asymétriques, civils, terroristes, hybrides ou mondialisés.",
                List.of(
                        "La guerre peut opposer des États, mais aussi des groupes armés non étatiques.",
                        "Les conflits contemporains sont souvent asymétriques.",
                        "La guerre peut avoir des causes territoriales, politiques, économiques, identitaires ou religieuses.",
                        "La paix peut être imposée, négociée ou construite progressivement.",
                        "Les organisations internationales jouent un rôle important dans la résolution des conflits.",
                        "La paix durable nécessite souvent justice, sécurité, reconstruction et réconciliation."
                ),
                List.of(
                        "Identifier le type de conflit étudié.",
                        "Repérer les acteurs : États, groupes armés, organisations internationales, civils.",
                        "Expliquer les causes du conflit.",
                        "Analyser les formes de violence utilisées.",
                        "Étudier les moyens de résolution : négociation, traité, intervention, justice internationale.",
                        "Conclure sur la difficulté à construire une paix durable."
                ),
                List.of(
                        "Guerre interétatique : guerre entre États.",
                        "Guerre civile : conflit armé à l’intérieur d’un État.",
                        "Guerre asymétrique : conflit entre acteurs de puissance très différente.",
                        "Terrorisme : violence politique visant à produire la peur.",
                        "Paix négative : absence de guerre.",
                        "Paix positive : construction durable fondée sur justice, sécurité et coopération.",
                        "ONU : organisation internationale chargée de maintenir la paix et la sécurité."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi les guerres changent de forme et pourquoi faire la paix est souvent plus compliqué que simplement arrêter les combats."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut analyser à la fois les acteurs, les causes, les formes de violence et les tentatives de résolution. Une bonne copie montre que la paix est un processus politique et diplomatique."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur Clausewitz, les guerres napoléoniennes, les conflits contemporains, le terrorisme, l’ONU, les traités de paix ou le Moyen-Orient."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une guerre asymétrique ?", "Un conflit entre acteurs de puissance très différente."),
                        new QuizQuestion("Quelle différence entre paix négative et paix positive ?", "La paix négative est l’absence de guerre ; la paix positive implique une construction durable."),
                        new QuizQuestion("Pourquoi l’ONU intervient-elle dans les conflits ?", "Pour maintenir ou rétablir la paix et la sécurité internationales."),
                        new QuizQuestion("Pourquoi la paix est-elle difficile à construire ?", "Parce qu’il faut résoudre les causes profondes du conflit et reconstruire la confiance.")
                )
        );
    }

    private CourseContent histoireMemoires(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Histoire et mémoires",
                "Ce thème distingue l’histoire, qui cherche une connaissance critique du passé, et les mémoires, qui sont des souvenirs vécus, transmis et parfois concurrents. Il montre comment les sociétés se souviennent des événements traumatiques.",
                List.of(
                        "L’histoire est une démarche scientifique fondée sur des sources et une méthode critique.",
                        "La mémoire est subjective, affective et portée par des individus ou groupes.",
                        "Plusieurs mémoires peuvent coexister et entrer en conflit.",
                        "Les États peuvent reconnaître, commémorer ou instrumentaliser le passé.",
                        "Les procès, monuments et commémorations participent à la construction mémorielle.",
                        "Les historiens aident à comprendre les faits au-delà des souvenirs et des émotions."
                ),
                List.of(
                        "Distinguer clairement histoire et mémoire.",
                        "Identifier les groupes porteurs de mémoire.",
                        "Repérer les enjeux politiques ou sociaux du souvenir.",
                        "Analyser le rôle de l’historien.",
                        "Utiliser des exemples : Seconde Guerre mondiale, Shoah, guerre d’Algérie, génocides.",
                        "Montrer les tensions entre oubli, reconnaissance et justice."
                ),
                List.of(
                        "Histoire : connaissance critique du passé.",
                        "Mémoire : souvenir vécu ou transmis d’un événement.",
                        "Mémoire collective : souvenir partagé par un groupe.",
                        "Conflit mémoriel : opposition entre plusieurs lectures du passé.",
                        "Devoir de mémoire : obligation morale de se souvenir.",
                        "Commemoration : cérémonie officielle de souvenir.",
                        "Source historique : document permettant d’étudier le passé."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le passé reste un enjeu du présent. Les sociétés ne se contentent pas de connaître le passé : elles le commémorent, le discutent et parfois se disputent autour de lui."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut éviter de confondre histoire et mémoire. La mémoire est importante, mais l’histoire cherche à vérifier, croiser les sources et prendre de la distance."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur la Shoah, la guerre d’Algérie, les génocides, les procès historiques, les commémorations ou les conflits de mémoire."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle différence entre histoire et mémoire ?", "L’histoire cherche une connaissance critique ; la mémoire est un souvenir subjectif et transmis."),
                        new QuizQuestion("Qu’est-ce qu’un conflit mémoriel ?", "Une opposition entre plusieurs mémoires d’un même événement."),
                        new QuizQuestion("Quel est le rôle de l’historien ?", "Étudier le passé avec méthode, sources et esprit critique."),
                        new QuizQuestion("Pourquoi les commémorations sont-elles importantes ?", "Elles transmettent un souvenir collectif et donnent une signification politique ou morale au passé.")
                )
        );
    }

    private CourseContent patrimoine(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Identifier, protéger et valoriser le patrimoine",
                "Ce thème étudie le patrimoine comme héritage culturel, historique ou naturel qu’une société choisit de conserver et de transmettre. Le patrimoine est aussi un enjeu politique, économique, touristique et identitaire.",
                List.of(
                        "Le patrimoine est une construction sociale : tout héritage n’est pas automatiquement patrimoine.",
                        "Il peut être matériel, immatériel, naturel, culturel, local, national ou mondial.",
                        "La patrimonialisation transforme un objet, un lieu ou une pratique en patrimoine reconnu.",
                        "Le patrimoine peut renforcer l’identité d’un groupe ou d’un État.",
                        "Il peut générer des revenus touristiques, mais aussi des tensions.",
                        "Protéger le patrimoine suppose des choix, des financements et parfois des conflits d’usage."
                ),
                List.of(
                        "Définir le type de patrimoine étudié.",
                        "Identifier les acteurs : État, UNESCO, collectivités, habitants, touristes, entreprises.",
                        "Expliquer le processus de patrimonialisation.",
                        "Montrer les enjeux : identité, mémoire, économie, tourisme, diplomatie.",
                        "Analyser les tensions entre protection et exploitation.",
                        "Utiliser des exemples précis : Versailles, Venise, patrimoine mondial, Notre-Dame, gastronomie."
                ),
                List.of(
                        "Patrimoine : héritage reconnu comme ayant une valeur à transmettre.",
                        "Patrimonialisation : processus qui transforme un élément en patrimoine.",
                        "UNESCO : organisation qui classe certains sites au patrimoine mondial.",
                        "Patrimoine matériel : monuments, objets, sites.",
                        "Patrimoine immatériel : pratiques, savoir-faire, traditions.",
                        "Valorisation : mise en valeur culturelle, touristique ou économique.",
                        "Conflit d’usage : opposition entre différentes manières d’utiliser un lieu."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi certaines œuvres, monuments, paysages ou pratiques deviennent importants pour une société. Le patrimoine sert à transmettre, mais aussi à affirmer une identité."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer que le patrimoine n’est pas seulement culturel : il est aussi politique, économique et parfois conflictuel. Protéger un site peut s’opposer au tourisme ou aux intérêts locaux."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur l’UNESCO, Venise, Versailles, Notre-Dame de Paris, la patrimonialisation, le tourisme, l’identité nationale ou les conflits autour du patrimoine."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que la patrimonialisation ?", "Le processus par lequel un élément est reconnu comme patrimoine à protéger et transmettre."),
                        new QuizQuestion("Quelle différence entre patrimoine matériel et immatériel ?", "Le matériel est concret, comme un monument ; l’immatériel concerne des pratiques ou savoir-faire."),
                        new QuizQuestion("Pourquoi le patrimoine peut-il créer des tensions ?", "Parce qu’il faut concilier protection, tourisme, économie et usages locaux."),
                        new QuizQuestion("Quel est le rôle de l’UNESCO ?", "Classer et protéger certains patrimoines considérés comme importants pour l’humanité.")
                )
        );
    }

    private CourseContent environnement(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "L’environnement, entre exploitation et protection",
                "Ce thème étudie les relations entre les sociétés humaines et leur environnement. Il montre que les milieux sont à la fois exploités, transformés, protégés et parfois menacés par les activités humaines.",
                List.of(
                        "L’environnement est l’ensemble des milieux dans lesquels vivent les sociétés.",
                        "Les sociétés exploitent les ressources naturelles pour se développer.",
                        "Cette exploitation peut provoquer dégradation, pollution et conflits.",
                        "La protection de l’environnement devient un enjeu politique majeur.",
                        "Les changements climatiques transforment les équilibres géopolitiques.",
                        "La gouvernance environnementale implique États, ONG, entreprises, citoyens et organisations internationales."
                ),
                List.of(
                        "Identifier le milieu ou la ressource étudiée.",
                        "Repérer les formes d’exploitation.",
                        "Analyser les dégradations ou risques.",
                        "Identifier les acteurs concernés.",
                        "Montrer les politiques de protection ou de gestion.",
                        "Nuancer entre développement économique et préservation environnementale."
                ),
                List.of(
                        "Environnement : milieu de vie des sociétés.",
                        "Anthropisation : transformation d’un milieu par l’homme.",
                        "Ressource : élément du milieu utilisé par les sociétés.",
                        "Développement durable : concilier économie, social et environnement.",
                        "Transition écologique : transformation des modes de production et consommation.",
                        "Gouvernance environnementale : règles et acteurs gérant les problèmes environnementaux.",
                        "Risque : danger potentiel pour les sociétés et les milieux."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre que l’environnement n’est pas seulement naturel : il est transformé par les sociétés. Il permet de réfléchir aux limites de l’exploitation des ressources."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut toujours montrer la tension entre exploitation et protection. Les sociétés ont besoin des ressources, mais leur utilisation peut créer des risques et des conflits."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur le climat, les ressources, les forêts, l’eau, l’Arctique, la biodiversité, les politiques environnementales ou le développement durable."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que l’anthropisation ?", "La transformation d’un milieu par les activités humaines."),
                        new QuizQuestion("Pourquoi l’environnement est-il un enjeu géopolitique ?", "Parce que les ressources, les risques et les politiques de protection opposent différents acteurs."),
                        new QuizQuestion("Que signifie développement durable ?", "Un développement qui concilie enjeux économiques, sociaux et environnementaux."),
                        new QuizQuestion("Pourquoi parle-t-on de tension entre exploitation et protection ?", "Parce que les sociétés utilisent les ressources mais doivent aussi préserver les milieux.")
                )
        );
    }

    private CourseContent connaissance(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "L’enjeu de la connaissance",
                "Ce thème étudie la connaissance comme facteur de puissance, de développement et de compétition. Produire, diffuser et contrôler les savoirs devient un enjeu central dans les sociétés contemporaines.",
                List.of(
                        "La connaissance est une ressource stratégique pour les États, entreprises et sociétés.",
                        "L’éducation et la recherche favorisent le développement économique et la puissance.",
                        "La circulation des savoirs dépend des universités, réseaux, médias et technologies numériques.",
                        "Les États cherchent à attirer les chercheurs, étudiants et talents.",
                        "La connaissance peut être partagée, mais aussi contrôlée ou utilisée comme instrument de domination.",
                        "Le numérique transforme l’accès à l’information et pose des problèmes de fiabilité."
                ),
                List.of(
                        "Définir le type de connaissance étudié : scientifique, technique, scolaire, stratégique.",
                        "Identifier les acteurs : États, universités, entreprises, chercheurs, médias.",
                        "Analyser les moyens de production et diffusion du savoir.",
                        "Montrer les enjeux de puissance.",
                        "Étudier les inégalités d’accès à la connaissance.",
                        "Questionner la fiabilité de l’information."
                ),
                List.of(
                        "Connaissance : ensemble de savoirs produits, transmis et utilisés.",
                        "Innovation : application nouvelle d’une connaissance.",
                        "Soft power : capacité d’influence par l’attraction culturelle ou intellectuelle.",
                        "Brain drain : fuite des cerveaux vers des pays plus attractifs.",
                        "Société de la connaissance : société où savoir et innovation jouent un rôle central.",
                        "Désinformation : diffusion volontaire d’informations fausses.",
                        "Open data / open science : accès ouvert aux données ou savoirs."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le savoir est une forme de puissance. Un pays qui maîtrise la recherche, les technologies et l’éducation possède un avantage économique et géopolitique."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer que la connaissance circule, mais qu’elle est aussi source de rivalités. Les États veulent former, attirer, protéger et parfois contrôler les savoirs."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On l’utilise pour des sujets sur les universités, la recherche, Internet, la désinformation, la puissance scientifique, la Chine, les États-Unis ou la compétition technologique."
                        )
                ),
                List.of(
                        new QuizQuestion("Pourquoi la connaissance est-elle un enjeu de puissance ?", "Parce qu’elle permet l’innovation, le développement économique et l’influence."),
                        new QuizQuestion("Qu’est-ce que le brain drain ?", "La fuite des cerveaux vers des pays plus attractifs."),
                        new QuizQuestion("Quel problème pose le numérique ?", "Il facilite l’accès à l’information mais aussi la désinformation."),
                        new QuizQuestion("Pourquoi les États investissent-ils dans la recherche ?", "Pour développer leur puissance scientifique, économique et stratégique.")
                )
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de HGGSP en préparation",
                "Ce chapitre de HGGSP n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les grands thèmes de Terminale HGGSP sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les notions principales en attendant.",
                        "S’entraîner à construire un plan argumenté."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("HGGSP terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider HGGSP.")
                ),
                "geo",
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
                        new VideoLink("Cours vidéo — " + title, youtube("HGGSP terminale " + title)),
                        new VideoLink("Méthode dissertation HGGSP — " + title, youtube("méthode dissertation HGGSP terminale " + title)),
                        new VideoLink("Exemples et cartes — " + title, youtube("exemples cartes HGGSP terminale " + title))
                ),
                quiz,
                "geo",
                explanations
        );
    }
}