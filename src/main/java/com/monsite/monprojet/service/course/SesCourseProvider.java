package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(7)
public class SesCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("ses")
                || m.contains("sciences economiques")
                || m.contains("sciences sociales")
                || m.contains("economique")
                || m.contains("sociales");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("croissance")) return croissanceEconomique(matiere, chapitre);
        if (c.contains("commerce international") || c.contains("internationalisation")) return commerceInternational(matiere, chapitre);
        if (c.contains("chomage") || c.contains("emploi")) return chomageEmploi(matiere, chapitre);
        if (c.contains("crises financieres") || c.contains("regulation financiere")) return crisesFinancieres(matiere, chapitre);
        if (c.contains("politiques economiques") || c.contains("union europeenne") || c.contains("ue")) return politiquesEconomiquesEuropeennes(matiere, chapitre);

        if (c.contains("structure sociale") || c.contains("societe francaise")) return structureSociale(matiere, chapitre);
        if (c.contains("ecole") || c.contains("destins individuels")) return ecoleDestinsIndividuels(matiere, chapitre);
        if (c.contains("mobilite sociale")) return mobiliteSociale(matiere, chapitre);
        if (c.contains("mutations du travail") || c.contains("travail et emploi")) return mutationsTravailEmploi(matiere, chapitre);

        if (c.contains("engagement politique")) return engagementPolitique(matiere, chapitre);
        if (c.contains("action publique") || c.contains("environnement")) return actionPubliqueEnvironnement(matiere, chapitre);

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent croissanceEconomique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Sources et défis de la croissance économique",
                "La croissance économique désigne l’augmentation durable de la production de richesses dans une économie. Elle est généralement mesurée par le PIB réel. Ce chapitre étudie ses sources, ses limites et ses conséquences.",
                List.of(
                        "La croissance est mesurée par l’augmentation du PIB réel.",
                        "Elle peut venir de l’augmentation du travail, du capital ou de la productivité.",
                        "La productivité globale des facteurs est liée au progrès technique.",
                        "L’innovation joue un rôle central dans la croissance de long terme.",
                        "Les institutions peuvent favoriser ou freiner la croissance.",
                        "La croissance pose aussi des problèmes environnementaux et sociaux."
                ),
                List.of(
                        "Définir la croissance et le PIB.",
                        "Identifier les facteurs de production mobilisés.",
                        "Repérer le rôle du progrès technique.",
                        "Expliquer le rôle des institutions.",
                        "Montrer les limites de la croissance, notamment environnementales.",
                        "Nuancer avec les inégalités et la soutenabilité."
                ),
                List.of(
                        "Croissance économique → augmentation durable du PIB réel.",
                        "PIB → valeur des richesses produites sur un territoire.",
                        "Productivité → efficacité de la production.",
                        "Progrès technique → innovations améliorant la production.",
                        "Croissance extensive → plus de facteurs de production.",
                        "Croissance intensive → gains de productivité."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi certaines économies produisent de plus en plus de richesses et pourquoi cette croissance peut améliorer le niveau de vie, mais aussi créer des problèmes environnementaux."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans une dissertation ou une EC3, il faut expliquer les sources de la croissance : travail, capital, productivité, innovation et institutions. Ensuite, il faut montrer que la croissance a aussi des limites."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour analyser des graphiques de PIB, des gains de productivité, des documents sur l’innovation, le développement durable ou les inégalités."
                        )
                ),
                List.of(
                        new QuizQuestion("Comment mesure-t-on généralement la croissance ?", "Par l’augmentation du PIB réel."),
                        new QuizQuestion("Quelle différence entre croissance extensive et intensive ?", "L’extensive vient de plus de facteurs, l’intensive vient de gains de productivité."),
                        new QuizQuestion("Pourquoi l’innovation est-elle importante ?", "Elle permet d’améliorer la productivité et de créer de nouveaux produits."),
                        new QuizQuestion("Quelle limite majeure de la croissance ?", "Son impact environnemental et la question de la soutenabilité.")
                )
        );
    }

    private CourseContent commerceInternational(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Commerce international et internationalisation de la production",
                "Ce chapitre étudie les échanges de biens, services, capitaux et activités productives entre pays. Il explique pourquoi les pays échangent, comment les firmes organisent leur production mondialement et quels sont les effets de la mondialisation.",
                List.of(
                        "Le commerce international désigne les échanges entre pays.",
                        "Les pays se spécialisent selon leurs avantages comparatifs.",
                        "Les firmes multinationales organisent la production à l’échelle mondiale.",
                        "La fragmentation de la chaîne de valeur permet de produire dans plusieurs pays.",
                        "Le libre-échange peut favoriser la croissance et la baisse des prix.",
                        "Mais il peut aussi accentuer les inégalités et fragiliser certains emplois."
                ),
                List.of(
                        "Définir commerce international et mondialisation.",
                        "Expliquer la spécialisation des pays.",
                        "Identifier le rôle des firmes multinationales.",
                        "Analyser les effets du libre-échange.",
                        "Présenter les limites : inégalités, dépendances, délocalisations.",
                        "Nuancer avec les politiques protectionnistes."
                ),
                List.of(
                        "Avantage comparatif → spécialisation dans la production relativement la plus efficace.",
                        "Libre-échange → suppression ou réduction des obstacles aux échanges.",
                        "Protectionnisme → mesures limitant les importations.",
                        "FMN → firme possédant des filiales dans plusieurs pays.",
                        "Chaîne de valeur mondiale → étapes de production réparties dans plusieurs pays."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi les produits que nous consommons viennent souvent de plusieurs pays et pourquoi les entreprises répartissent leur production dans le monde entier."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut expliquer les avantages du commerce international, comme la spécialisation et la baisse des prix, mais aussi ses limites : concurrence, délocalisations et dépendances."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur libre-échange, protectionnisme, firmes multinationales, délocalisations, chaîne de valeur et mondialisation."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un avantage comparatif ?", "C’est l’avantage d’un pays dans la production où il est relativement le plus efficace."),
                        new QuizQuestion("Qu’est-ce qu’une firme multinationale ?", "Une entreprise qui possède des filiales dans plusieurs pays."),
                        new QuizQuestion("Qu’est-ce que le protectionnisme ?", "Un ensemble de mesures qui limitent les importations."),
                        new QuizQuestion("Quelle limite du libre-échange peut-on citer ?", "Il peut fragiliser certains emplois et accroître des inégalités.")
                )
        );
    }

    private CourseContent chomageEmploi(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Lutter contre le chômage",
                "Le chômage désigne la situation d’une personne sans emploi, disponible pour travailler et recherchant activement un emploi. Ce chapitre étudie les différentes formes de chômage et les politiques pour le réduire.",
                List.of(
                        "Le chômage peut être conjoncturel, structurel ou frictionnel.",
                        "Le chômage conjoncturel dépend du niveau d’activité économique.",
                        "Le chômage structurel vient d’inadéquations profondes sur le marché du travail.",
                        "Les politiques de relance peuvent agir sur la demande.",
                        "Les politiques de formation peuvent agir sur les qualifications.",
                        "Le coût du travail, les institutions et la demande influencent l’emploi."
                ),
                List.of(
                        "Définir chômage et emploi.",
                        "Identifier le type de chômage dans le document.",
                        "Expliquer les causes économiques ou sociales.",
                        "Présenter les politiques possibles.",
                        "Distinguer politiques de demande et politiques d’offre.",
                        "Nuancer les effets et limites des politiques."
                ),
                List.of(
                        "Chômage conjoncturel → lié à une demande insuffisante.",
                        "Chômage structurel → lié à l’organisation du marché du travail.",
                        "Chômage frictionnel → temps de recherche entre deux emplois.",
                        "Politiques de relance → stimuler la demande.",
                        "Formation → réduire l’inadéquation des qualifications.",
                        "Coût du travail → influence la demande de travail."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le chômage existe et pourquoi il ne se résout pas toujours avec une seule solution. Les causes peuvent être très différentes selon les situations."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut d’abord identifier le type de chômage. Ensuite, on associe une politique adaptée : relance de la demande, baisse du coût du travail, formation ou accompagnement."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur marché du travail, emploi, politiques publiques, formation, coût du travail et demande globale."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que le chômage conjoncturel ?", "Un chômage lié à une activité économique insuffisante."),
                        new QuizQuestion("Qu’est-ce que le chômage structurel ?", "Un chômage lié à des problèmes profonds du marché du travail."),
                        new QuizQuestion("À quoi sert la formation ?", "À adapter les qualifications aux besoins des entreprises."),
                        new QuizQuestion("Quelle politique agit sur la demande ?", "Une politique de relance.")
                )
        );
    }

    private CourseContent crisesFinancieres(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Crises financières et régulation du système financier",
                "Ce chapitre explique comment les crises financières apparaissent, se propagent et pourquoi les pouvoirs publics cherchent à réguler le système financier. Il étudie les bulles spéculatives, les paniques bancaires et les risques systémiques.",
                List.of(
                        "Une crise financière correspond à un dysfonctionnement brutal des marchés financiers ou bancaires.",
                        "Une bulle spéculative apparaît quand le prix d’un actif augmente fortement sans lien avec sa valeur réelle.",
                        "L’éclatement d’une bulle peut provoquer des pertes et une crise de confiance.",
                        "Les banques sont exposées au risque de panique bancaire.",
                        "La crise peut se transmettre à toute l’économie réelle.",
                        "La régulation vise à limiter les risques et protéger le système."
                ),
                List.of(
                        "Définir crise financière et système financier.",
                        "Identifier les mécanismes de bulle ou de panique.",
                        "Expliquer la propagation de la crise.",
                        "Relier finance et économie réelle.",
                        "Présenter les outils de régulation.",
                        "Montrer les limites de la régulation."
                ),
                List.of(
                        "Bulle spéculative → hausse excessive du prix d’un actif.",
                        "Krach → chute brutale des prix.",
                        "Risque systémique → risque de crise généralisée.",
                        "Panique bancaire → retrait massif des dépôts.",
                        "Régulation financière → règles limitant les risques.",
                        "Banque centrale → prêteur en dernier ressort."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi une crise financière peut toucher toute l’économie : entreprises, banques, États et ménages."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer la chaîne : spéculation, bulle, éclatement, crise de confiance, difficultés bancaires, baisse du crédit, ralentissement économique."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur crise de 1929, crise de 2008, banques, bulles spéculatives, régulation, banques centrales et risque systémique."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une bulle spéculative ?", "Une hausse excessive du prix d’un actif sans lien solide avec sa valeur réelle."),
                        new QuizQuestion("Qu’est-ce que le risque systémique ?", "Le risque qu’une difficulté se propage à tout le système financier."),
                        new QuizQuestion("Pourquoi réguler la finance ?", "Pour limiter les risques de crise et protéger l’économie."),
                        new QuizQuestion("Quel rôle peut jouer une banque centrale ?", "Elle peut intervenir comme prêteur en dernier ressort.")
                )
        );
    }

    private CourseContent politiquesEconomiquesEuropeennes(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Politiques économiques dans le cadre européen",
                "Ce chapitre étudie les politiques économiques menées dans l’Union européenne, notamment dans la zone euro. Il montre que les États partagent certaines contraintes et que la politique monétaire est menée par la Banque centrale européenne.",
                List.of(
                        "La zone euro regroupe les pays utilisant l’euro.",
                        "La Banque centrale européenne mène la politique monétaire.",
                        "La politique budgétaire reste principalement nationale.",
                        "Les États doivent respecter certaines règles européennes.",
                        "La coordination est nécessaire mais parfois difficile.",
                        "Les politiques économiques cherchent à agir sur l’inflation, la croissance, l’emploi et les déséquilibres."
                ),
                List.of(
                        "Distinguer politique monétaire et politique budgétaire.",
                        "Identifier les acteurs : BCE, États, Union européenne.",
                        "Expliquer les objectifs économiques.",
                        "Analyser les contraintes de la zone euro.",
                        "Montrer les difficultés de coordination.",
                        "Nuancer selon les situations économiques des pays."
                ),
                List.of(
                        "Politique monétaire → action sur la monnaie, les taux et le crédit.",
                        "Politique budgétaire → dépenses publiques et prélèvements.",
                        "BCE → stabilité des prix dans la zone euro.",
                        "Taux directeur → outil de politique monétaire.",
                        "Coordination → action commune ou cohérente entre États."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi les pays européens ne peuvent pas toujours mener seuls les politiques qu’ils veulent, surtout lorsqu’ils partagent la même monnaie."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut distinguer ce qui dépend de la BCE et ce qui dépend des États. La politique monétaire est commune, tandis que les budgets nationaux restent encadrés."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur zone euro, BCE, inflation, dette publique, coordination économique et politiques de relance."
                        )
                ),
                List.of(
                        new QuizQuestion("Qui mène la politique monétaire dans la zone euro ?", "La Banque centrale européenne."),
                        new QuizQuestion("Quelle différence entre politique monétaire et budgétaire ?", "La monétaire agit sur la monnaie et les taux ; la budgétaire agit sur dépenses et recettes publiques."),
                        new QuizQuestion("Pourquoi la coordination européenne est-elle difficile ?", "Parce que les pays ont des situations économiques différentes."),
                        new QuizQuestion("Quel est un objectif important de la BCE ?", "La stabilité des prix.")
                )
        );
    }

    private CourseContent structureSociale(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Structure sociale de la société française actuelle",
                "La structure sociale désigne la manière dont une société est composée et hiérarchisée. Elle dépend de critères économiques, sociaux, culturels, professionnels, générationnels et de genre.",
                List.of(
                        "La société est structurée par plusieurs facteurs : revenu, diplôme, profession, genre, âge, lieu de vie.",
                        "Les PCS permettent de classer les individus selon leur position professionnelle.",
                        "Les inégalités sont économiques, sociales et culturelles.",
                        "La moyennisation a pu réduire certaines distances sociales.",
                        "Mais de nouvelles fractures sociales persistent ou apparaissent.",
                        "Les classes sociales restent un outil d’analyse débattu."
                ),
                List.of(
                        "Définir structure sociale et inégalités.",
                        "Identifier les critères de différenciation sociale.",
                        "Utiliser les PCS si le document les mobilise.",
                        "Analyser les inégalités économiques et sociales.",
                        "Montrer les évolutions de la société française.",
                        "Nuancer le rôle des classes sociales aujourd’hui."
                ),
                List.of(
                        "Structure sociale → organisation hiérarchisée de la société.",
                        "PCS → professions et catégories socioprofessionnelles.",
                        "Inégalités économiques → revenus, patrimoine.",
                        "Inégalités sociales → accès au diplôme, santé, logement, culture.",
                        "Moyennisation → rapprochement de certaines conditions de vie.",
                        "Classe sociale → groupe partageant une position sociale proche."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment la société française est organisée et pourquoi les individus n’ont pas tous les mêmes conditions de vie ni les mêmes chances."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer que la position sociale dépend de plusieurs critères. Le revenu compte, mais aussi le diplôme, la profession, le genre, l’âge ou le territoire."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour analyser les inégalités, les PCS, les classes sociales, la moyennisation, les fractures sociales et les documents statistiques."
                        )
                ),
                List.of(
                        new QuizQuestion("Que désigne la structure sociale ?", "L’organisation et la hiérarchisation d’une société."),
                        new QuizQuestion("À quoi servent les PCS ?", "À classer les individus selon leur position professionnelle."),
                        new QuizQuestion("Donne un exemple d’inégalité sociale.", "L’accès différencié aux études, à la santé ou au logement."),
                        new QuizQuestion("Les classes sociales ont-elles totalement disparu ?", "Non, leur rôle est débattu mais elles restent utiles pour analyser certaines inégalités.")
                )
        );
    }

    private CourseContent ecoleDestinsIndividuels(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "L’école et les destins individuels",
                "Ce chapitre étudie le rôle de l’école dans la formation, la qualification, l’intégration sociale et la mobilité. Il interroge aussi les inégalités scolaires liées à l’origine sociale, au genre ou au territoire.",
                List.of(
                        "L’école transmet des savoirs et des normes communes.",
                        "Elle délivre des diplômes utiles sur le marché du travail.",
                        "Elle peut favoriser la mobilité sociale.",
                        "Mais les parcours scolaires restent marqués par des inégalités.",
                        "L’origine sociale influence les chances de réussite.",
                        "Le capital culturel familial joue un rôle important."
                ),
                List.of(
                        "Définir socialisation, qualification et mobilité.",
                        "Expliquer les fonctions de l’école.",
                        "Identifier les facteurs d’inégalités scolaires.",
                        "Mobiliser le rôle du capital culturel.",
                        "Analyser les données sur diplôme et origine sociale.",
                        "Nuancer entre méritocratie et reproduction sociale."
                ),
                List.of(
                        "École → socialisation + qualification + certification.",
                        "Diplôme → signal de compétence sur le marché du travail.",
                        "Capital culturel → ressources culturelles transmises par la famille.",
                        "Méritocratie → réussite fondée sur le mérite.",
                        "Reproduction sociale → maintien des positions sociales entre générations."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi l’école est centrale dans les parcours individuels, mais aussi pourquoi elle ne donne pas toujours les mêmes chances à tous."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer l’ambivalence de l’école : elle peut permettre l’ascension sociale, mais elle peut aussi reproduire des inégalités liées au milieu social."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur diplôme, réussite scolaire, origine sociale, capital culturel, méritocratie et reproduction sociale."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelles fonctions remplit l’école ?", "Socialisation, transmission de savoirs, qualification et certification."),
                        new QuizQuestion("Qu’est-ce que le capital culturel ?", "Des ressources culturelles transmises notamment par la famille."),
                        new QuizQuestion("Pourquoi l’école peut-elle réduire les inégalités ?", "Elle donne accès à des savoirs et diplômes."),
                        new QuizQuestion("Pourquoi peut-elle aussi les reproduire ?", "Parce que les élèves n’arrivent pas avec les mêmes ressources familiales.")
                )
        );
    }

    private CourseContent mobiliteSociale(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Mobilité sociale",
                "La mobilité sociale désigne le changement de position sociale d’un individu ou d’un groupe. Elle peut être ascendante, descendante, intergénérationnelle ou intragénérationnelle.",
                List.of(
                        "La mobilité sociale mesure les changements de position sociale.",
                        "La mobilité intergénérationnelle compare la position des enfants à celle des parents.",
                        "La mobilité intragénérationnelle concerne la trajectoire d’un individu au cours de sa vie.",
                        "La mobilité ascendante correspond à une position sociale plus élevée.",
                        "La mobilité descendante correspond à une position moins favorisée.",
                        "L’école, l’emploi et la structure sociale influencent la mobilité."
                ),
                List.of(
                        "Définir le type de mobilité étudié.",
                        "Lire correctement une table de mobilité.",
                        "Distinguer mobilité observée et fluidité sociale.",
                        "Expliquer les facteurs de mobilité.",
                        "Analyser le rôle de l’école et du marché du travail.",
                        "Nuancer selon les groupes sociaux."
                ),
                List.of(
                        "Mobilité sociale → changement de position sociale.",
                        "Mobilité ascendante → position plus élevée.",
                        "Mobilité descendante → position plus basse.",
                        "Mobilité intergénérationnelle → comparaison parents/enfants.",
                        "Fluidité sociale → indépendance entre origine et position sociale.",
                        "Déclassement → position inférieure à celle attendue ou à celle des parents."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre si une société permet réellement aux individus de changer de position sociale par rapport à leurs parents ou au cours de leur vie."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut bien lire les tables de mobilité et distinguer les différents types de mobilité. Ensuite, on explique les causes : diplôme, emploi, transformations économiques."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les tables de mobilité, l’analyse de l’ascension sociale, du déclassement, de la reproduction sociale et du rôle de l’école."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que la mobilité sociale ?", "Un changement de position sociale."),
                        new QuizQuestion("Qu’est-ce que la mobilité intergénérationnelle ?", "La comparaison entre la position des enfants et celle des parents."),
                        new QuizQuestion("Qu’est-ce que la mobilité ascendante ?", "Une position sociale plus élevée que celle d’origine."),
                        new QuizQuestion("Que signifie déclassement ?", "Une position sociale moins favorable que celle attendue ou que celle des parents.")
                )
        );
    }

    private CourseContent mutationsTravailEmploi(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Mutations du travail et de l’emploi",
                "Ce chapitre étudie les transformations du travail et de l’emploi : salarisation, tertiarisation, flexibilité, précarisation, numérisation, qualification et nouvelles formes d’organisation.",
                List.of(
                        "Le travail désigne une activité productive.",
                        "L’emploi désigne une activité déclarée et rémunérée.",
                        "La salarisation a transformé les relations de travail.",
                        "La tertiarisation augmente le poids des services.",
                        "La flexibilité peut améliorer l’adaptation des entreprises mais fragiliser certains travailleurs.",
                        "Le numérique modifie les métiers, les compétences et l’organisation du travail."
                ),
                List.of(
                        "Distinguer travail et emploi.",
                        "Identifier la transformation étudiée.",
                        "Expliquer ses causes : technologie, mondialisation, organisation.",
                        "Analyser ses effets sur les travailleurs.",
                        "Montrer les conséquences sur les qualifications et les conditions de travail.",
                        "Nuancer entre opportunités et précarisation."
                ),
                List.of(
                        "Travail → activité productive.",
                        "Emploi → travail rémunéré et déclaré.",
                        "Salarisation → développement du salariat.",
                        "Tertiarisation → hausse des emplois dans les services.",
                        "Précarité → instabilité de l’emploi.",
                        "Flexibilité → adaptation du travail aux besoins économiques."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le monde du travail change : nouveaux métiers, plateformes, télétravail, automatisation et précarité."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut toujours distinguer ce qui change pour les entreprises et ce qui change pour les travailleurs. Une mutation peut créer des opportunités mais aussi des risques."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur emploi, chômage, précarité, flexibilité, numérique, qualification, télétravail et conditions de travail."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle différence entre travail et emploi ?", "Le travail est une activité productive, l’emploi est une activité rémunérée et déclarée."),
                        new QuizQuestion("Qu’est-ce que la tertiarisation ?", "La hausse du poids des services dans l’économie."),
                        new QuizQuestion("Qu’est-ce que la précarité de l’emploi ?", "Une instabilité ou incertitude liée à l’emploi."),
                        new QuizQuestion("Quel effet peut avoir le numérique ?", "Transformer les métiers et l’organisation du travail.")
                )
        );
    }

    private CourseContent engagementPolitique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Engagement politique",
                "L’engagement politique désigne l’ensemble des formes de participation visant à influencer la vie collective. Il ne se limite pas au vote : il peut aussi passer par les partis, syndicats, associations, manifestations, pétitions ou actions numériques.",
                List.of(
                        "Le vote est une forme classique de participation politique.",
                        "L’engagement peut être partisan, syndical, associatif ou militant.",
                        "Les répertoires d’action collective évoluent avec le temps.",
                        "Les individus s’engagent pour défendre des intérêts, des valeurs ou une identité.",
                        "Les ressources sociales influencent la probabilité de s’engager.",
                        "Le numérique transforme certaines formes de mobilisation."
                ),
                List.of(
                        "Définir engagement politique et participation politique.",
                        "Identifier la forme d’engagement étudiée.",
                        "Expliquer les motivations de l’engagement.",
                        "Analyser les ressources nécessaires : temps, diplôme, réseau, argent.",
                        "Présenter l’évolution des formes de mobilisation.",
                        "Nuancer selon les groupes sociaux et les générations."
                ),
                List.of(
                        "Engagement politique → action pour influencer la vie collective.",
                        "Participation conventionnelle → vote, parti.",
                        "Participation protestataire → manifestation, grève, pétition.",
                        "Action collective → mobilisation d’un groupe autour d’une cause.",
                        "Répertoire d’action → ensemble des moyens utilisés pour agir politiquement.",
                        "Militantisme numérique → mobilisation via Internet et réseaux sociaux."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les citoyens peuvent agir dans une démocratie, même en dehors des élections."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer que l’engagement prend plusieurs formes et qu’il dépend des ressources, des valeurs, des intérêts et du contexte social."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur vote, abstention, militantisme, syndicats, associations, manifestations, mouvements sociaux et engagement numérique."
                        )
                ),
                List.of(
                        new QuizQuestion("Le vote est-il la seule forme d’engagement politique ?", "Non, il existe aussi manifestations, pétitions, syndicats, associations, partis, actions numériques."),
                        new QuizQuestion("Qu’est-ce qu’une action collective ?", "Une action menée par un groupe pour défendre une cause ou un intérêt."),
                        new QuizQuestion("Qu’est-ce qu’un répertoire d’action ?", "L’ensemble des moyens utilisés pour agir politiquement."),
                        new QuizQuestion("Pourquoi le numérique change-t-il l’engagement ?", "Il facilite la diffusion d’informations et l’organisation rapide de mobilisations.")
                )
        );
    }

    private CourseContent actionPubliqueEnvironnement(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Action publique pour l’environnement",
                "Ce chapitre étudie comment les pouvoirs publics agissent pour protéger l’environnement. Il montre que les problèmes environnementaux nécessitent une action collective, des instruments économiques et une coordination entre acteurs.",
                List.of(
                        "Les problèmes environnementaux sont souvent des problèmes collectifs.",
                        "Les externalités négatives justifient une intervention publique.",
                        "Les pouvoirs publics peuvent utiliser normes, taxes, subventions ou marchés de quotas.",
                        "La transition écologique implique des changements économiques et sociaux.",
                        "Les acteurs sont nombreux : États, entreprises, citoyens, ONG, organisations internationales.",
                        "La coopération internationale est nécessaire mais difficile."
                ),
                List.of(
                        "Identifier le problème environnemental étudié.",
                        "Expliquer pourquoi le marché seul ne suffit pas.",
                        "Présenter les instruments de politique environnementale.",
                        "Comparer leurs avantages et limites.",
                        "Analyser le rôle des différents acteurs.",
                        "Montrer les difficultés de coordination."
                ),
                List.of(
                        "Externalité négative → coût imposé à autrui sans compensation.",
                        "Taxe environnementale → faire payer le pollueur.",
                        "Subvention → encourager un comportement vertueux.",
                        "Norme → règle obligatoire.",
                        "Marché de quotas → limitation et échange de droits à polluer.",
                        "Bien commun → ressource difficile à exclure et rivale."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les sociétés peuvent agir face au changement climatique, à la pollution et à la surexploitation des ressources."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut partir du problème : pollution, émission de CO₂, ressource commune. Ensuite, on explique les instruments possibles : taxes, normes, quotas ou subventions."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les sujets sur climat, pollution, taxe carbone, quotas d’émission, normes environnementales, biens communs et coopération internationale."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une externalité négative ?", "Un coût imposé à autrui sans compensation."),
                        new QuizQuestion("À quoi sert une taxe environnementale ?", "À faire payer le coût de la pollution et inciter à polluer moins."),
                        new QuizQuestion("Quelle différence entre norme et taxe ?", "La norme impose une règle, la taxe modifie les incitations."),
                        new QuizQuestion("Pourquoi la coopération internationale est-elle difficile ?", "Parce que les pays ont des intérêts et niveaux de développement différents.")
                )
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de SES en préparation",
                "Ce chapitre de SES n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les principaux chapitres de spécialité SES sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les notions principales en attendant.",
                        "S’entraîner sur des documents statistiques."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("SES terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider SES.")
                ),
                "ses",
                List.of(
                        new ExplanationBlock(
                                "Cours en préparation",
                                "Ce chapitre sera ajouté avec un vrai résumé, des notions, une méthode, des vidéos et un quiz."
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
                        new VideoLink("Cours vidéo — " + title, youtube("SES terminale " + title)),
                        new VideoLink("Méthode bac SES — " + title, youtube("méthode bac SES terminale " + title)),
                        new VideoLink("Exercices corrigés — " + title, youtube("exercices corrigés SES terminale " + title))
                ),
                quiz,
                "ses",
                explanations
        );
    }
}