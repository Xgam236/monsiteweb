package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(4)
public class SvtCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("svt")
                || m.contains("sciences de la vie")
                || m.contains("sciences de la terre");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("genetique") || c.contains("evolution")) return genetiqueEvolution(matiere, chapitre);
        if (c.contains("passe geologique") || c.contains("histoire geologique")) return passeGeologique(matiere, chapitre);
        if (c.contains("plante sauvage") || c.contains("plante domestiquee")) return planteDomestiquee(matiere, chapitre);
        if (c.contains("climats") || c.contains("climat")) return climatsTerre(matiere, chapitre);
        if (c.contains("systeme nerveux") || c.contains("mouvement") || c.contains("comportements")) return systemeNerveuxMouvement(matiere, chapitre);
        if (c.contains("contraction musculaire") || c.contains("muscle") || c.contains("energie musculaire")) return contractionMusculaire(matiere, chapitre);
        if (c.contains("stress")) return stress(matiere, chapitre);
        if (c.contains("variation genetique") || c.contains("sante")) return variationGenetiqueSante(matiere, chapitre);
        if (c.contains("immunite") || c.contains("vaccination")) return immuniteVaccination(matiere, chapitre);

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent genetiqueEvolution(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Génétique et évolution",
                "Ce chapitre explique comment l’information génétique se transmet, se modifie et participe à l’évolution des êtres vivants. Il relie l’ADN, les mutations, le brassage génétique, la sélection naturelle et la diversité du vivant.",
                List.of(
                        "L’ADN porte l’information génétique sous forme de séquences de nucléotides.",
                        "Les mutations créent de nouveaux allèles.",
                        "La méiose produit des gamètes génétiquement différents.",
                        "La fécondation réunit deux patrimoines génétiques.",
                        "Le brassage génétique augmente la diversité des individus.",
                        "La sélection naturelle favorise certains caractères selon l’environnement.",
                        "L’évolution résulte de plusieurs mécanismes : mutations, sélection, dérive génétique, migration."
                ),
                List.of(
                        "Identifier le mécanisme étudié : mutation, méiose, fécondation, sélection ou dérive.",
                        "Relier le mécanisme à la diversité génétique.",
                        "Utiliser un schéma de méiose ou un arbre de parenté si nécessaire.",
                        "Expliquer les conséquences à l’échelle de l’individu ou de la population.",
                        "Conclure sur l’évolution ou la diversité du vivant."
                ),
                List.of(
                        "ADN → gène → allèle → caractère.",
                        "Mutation → nouvel allèle → diversité génétique.",
                        "Méiose + fécondation → brassage génétique.",
                        "Sélection naturelle → modification de la fréquence des allèles.",
                        "Dérive génétique → évolution aléatoire des fréquences alléliques."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi les individus d’une même espèce sont différents et comment les espèces évoluent au cours du temps. Il explique l’origine de la diversité génétique."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans un exercice, il faut repérer l’échelle étudiée : ADN, cellule, individu ou population. Ensuite, on relie les mécanismes génétiques aux conséquences observées."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les exercices sur la méiose, les arbres généalogiques, les mutations, les fréquences alléliques, la sélection naturelle et l’évolution des populations."
                        )
                ),
                List.of(
                        new QuizQuestion("Quel est le rôle des mutations ?", "Elles créent de nouveaux allèles et augmentent la diversité génétique."),
                        new QuizQuestion("Pourquoi la méiose est-elle importante ?", "Elle produit des gamètes différents et participe au brassage génétique."),
                        new QuizQuestion("Qu’est-ce que la sélection naturelle ?", "C’est le fait que certains caractères favorisent la survie ou la reproduction dans un environnement donné."),
                        new QuizQuestion("Quelle différence entre sélection naturelle et dérive génétique ?", "La sélection dépend de l’avantage d’un caractère, alors que la dérive est liée au hasard.")
                )
        );
    }

    private CourseContent passeGeologique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "À la recherche du passé géologique de notre planète",
                "Ce chapitre montre comment les scientifiques reconstituent l’histoire de la Terre à partir des roches, des fossiles, des datations et des indices géologiques. Il permet de comprendre que la Terre a une histoire longue et dynamique.",
                List.of(
                        "Les roches conservent des traces du passé géologique.",
                        "Les fossiles renseignent sur les êtres vivants et les milieux anciens.",
                        "La datation relative permet de classer les événements dans le temps.",
                        "La datation absolue donne un âge chiffré grâce à la radioactivité.",
                        "Les crises biologiques marquent des changements importants de biodiversité.",
                        "Les continents et les océans évoluent avec la tectonique des plaques."
                ),
                List.of(
                        "Observer les indices géologiques fournis.",
                        "Identifier le type de datation demandé.",
                        "Utiliser les principes de superposition, recoupement ou inclusion.",
                        "Relier fossiles et environnement ancien.",
                        "Construire une chronologie cohérente des événements."
                ),
                List.of(
                        "Datation relative → ordre des événements.",
                        "Datation absolue → âge numérique.",
                        "Principe de superposition : une couche récente repose sur une couche plus ancienne.",
                        "Principe de recoupement : ce qui recoupe est plus récent.",
                        "Fossile stratigraphique → repère temporel."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment on peut connaître l’histoire de la Terre alors que personne ne l’a observée directement. Les roches et fossiles sont comme des archives naturelles."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut lire les documents comme une enquête. On repère les couches, les fossiles, les failles ou les roches, puis on déduit l’ordre des événements."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour dater des roches, reconstituer une chronologie, interpréter des fossiles, étudier des crises biologiques ou expliquer des changements géologiques."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert la datation relative ?", "À classer les événements géologiques les uns par rapport aux autres."),
                        new QuizQuestion("À quoi sert la datation absolue ?", "À donner un âge chiffré à une roche ou un événement."),
                        new QuizQuestion("Que permet un fossile stratigraphique ?", "Il permet de dater une couche géologique."),
                        new QuizQuestion("Pourquoi les roches sont-elles importantes ?", "Elles conservent des traces du passé de la Terre.")
                )
        );
    }

    private CourseContent planteDomestiquee(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "De la plante sauvage à la plante domestiquée",
                "Ce chapitre étudie comment les plantes sont organisées, comment elles se reproduisent et comment l’être humain les a transformées par la domestication pour répondre à ses besoins alimentaires, économiques ou culturels.",
                List.of(
                        "Les plantes possèdent des organes spécialisés : racines, tiges, feuilles, fleurs.",
                        "Elles réalisent la photosynthèse pour produire de la matière organique.",
                        "La reproduction sexuée des plantes à fleurs implique pollen, ovule, graine et fruit.",
                        "La domestication sélectionne des caractères utiles pour l’être humain.",
                        "Les plantes cultivées sont souvent différentes de leurs formes sauvages.",
                        "La sélection variétale et les biotechnologies modifient les plantes cultivées."
                ),
                List.of(
                        "Identifier les organes végétaux dans le document.",
                        "Relier structure et fonction : nutrition, reproduction, croissance.",
                        "Comparer une plante sauvage et une plante domestiquée.",
                        "Repérer les caractères sélectionnés par l’homme.",
                        "Expliquer les avantages et limites de la domestication."
                ),
                List.of(
                        "Photosynthèse : CO₂ + eau + lumière → matière organique + O₂.",
                        "Fleur → pollinisation → fécondation → graine et fruit.",
                        "Domestication → sélection de caractères favorables à l’homme.",
                        "Diversité cultivée → issue de la sélection et des mutations."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les plantes fonctionnent et comment l’être humain les a progressivement transformées pour produire plus, mieux conserver ou faciliter la récolte."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut relier les structures végétales à leur fonction : les feuilles pour la photosynthèse, les racines pour l’absorption, les fleurs pour la reproduction."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour analyser des schémas de fleurs, expliquer la photosynthèse, comparer plantes sauvages et cultivées, ou étudier la sélection artificielle."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle est la fonction principale des feuilles ?", "Elles réalisent la photosynthèse."),
                        new QuizQuestion("Que produit la fécondation chez les plantes à fleurs ?", "Elle conduit à la formation d’une graine et souvent d’un fruit."),
                        new QuizQuestion("Qu’est-ce que la domestication ?", "C’est la sélection par l’homme de caractères utiles chez une espèce."),
                        new QuizQuestion("Pourquoi les plantes cultivées diffèrent-elles des plantes sauvages ?", "Parce qu’elles ont été sélectionnées sur plusieurs générations.")
                )
        );
    }

    private CourseContent climatsTerre(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Les climats de la Terre : comprendre le passé pour agir aujourd’hui et demain",
                "Ce chapitre étudie les variations climatiques passées et actuelles. Il montre comment les scientifiques reconstituent les climats anciens et comment les activités humaines modifient le climat actuel.",
                List.of(
                        "Le climat correspond aux conditions moyennes d’une région sur une longue durée.",
                        "Les archives climatiques permettent de reconstituer les climats passés.",
                        "Les gaz à effet de serre influencent la température moyenne terrestre.",
                        "Les activités humaines augmentent la concentration en CO₂ et autres gaz à effet de serre.",
                        "Le réchauffement actuel a des conséquences sur les océans, les glaces, les écosystèmes et les sociétés.",
                        "Les modèles climatiques permettent d’anticiper plusieurs scénarios."
                ),
                List.of(
                        "Distinguer météo et climat.",
                        "Identifier les archives climatiques utilisées : glaces, sédiments, pollens, roches.",
                        "Relier les gaz à effet de serre à l’effet de serre.",
                        "Interpréter un graphique de température ou de CO₂.",
                        "Expliquer les conséquences et les scénarios possibles."
                ),
                List.of(
                        "Météo → court terme ; climat → long terme.",
                        "Archives climatiques → indices du passé.",
                        "CO₂, CH₄, N₂O → gaz à effet de serre.",
                        "Augmentation des GES → renforcement de l’effet de serre → réchauffement.",
                        "Modèles climatiques → projections futures."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre le changement climatique actuel en le comparant aux climats du passé. Il permet de distinguer les variations naturelles et l’impact des activités humaines."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans un exercice, il faut lire les graphiques avec précision : axes, unités, tendances. Ensuite, on relie les données aux mécanismes climatiques."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les analyses de graphiques de CO₂, températures, archives glaciaires, scénarios climatiques et conséquences du réchauffement."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle différence entre météo et climat ?", "La météo concerne le court terme, le climat correspond à des moyennes sur une longue durée."),
                        new QuizQuestion("Quel gaz est très important dans le réchauffement actuel ?", "Le dioxyde de carbone, CO₂."),
                        new QuizQuestion("À quoi servent les modèles climatiques ?", "À prévoir différents scénarios d’évolution du climat."),
                        new QuizQuestion("Pourquoi étudier les climats passés ?", "Pour comprendre les mécanismes climatiques et mieux interpréter le changement actuel.")
                )
        );
    }

    private CourseContent systemeNerveuxMouvement(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Comportements, mouvement et système nerveux",
                "Ce chapitre explique comment le système nerveux commande les mouvements et permet à l’organisme de répondre à son environnement. Il relie organes sensoriels, cerveau, moelle épinière, nerfs et muscles.",
                List.of(
                        "Le système nerveux reçoit des informations sensorielles.",
                        "Le cerveau et la moelle épinière traitent les informations.",
                        "Les nerfs transmettent des messages nerveux.",
                        "Les muscles effectuent la réponse motrice.",
                        "Un mouvement volontaire implique le cerveau.",
                        "Un réflexe est une réponse rapide impliquant souvent la moelle épinière."
                ),
                List.of(
                        "Identifier le stimulus et le récepteur sensoriel.",
                        "Repérer les voies nerveuses sensitives et motrices.",
                        "Distinguer mouvement volontaire et réflexe.",
                        "Relier message nerveux et contraction musculaire.",
                        "Expliquer la réponse de l’organisme."
                ),
                List.of(
                        "Stimulus → récepteur → nerf sensitif → centre nerveux → nerf moteur → muscle.",
                        "Message nerveux → information transmise par les neurones.",
                        "Réflexe → réponse rapide et automatique.",
                        "Mouvement volontaire → intervention du cerveau."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment le corps perçoit une information et produit une réponse, par exemple retirer sa main d’une source chaude ou réaliser un geste volontaire."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut suivre le trajet de l’information : réception du stimulus, transmission nerveuse, traitement par un centre nerveux, puis réponse motrice."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les schémas de réflexe, les expériences sur les nerfs, les messages nerveux, les mouvements volontaires et les réponses motrices."
                        )
                ),
                List.of(
                        new QuizQuestion("Quel organe commande les mouvements volontaires ?", "Le cerveau."),
                        new QuizQuestion("Qu’est-ce qu’un réflexe ?", "Une réponse rapide et automatique à un stimulus."),
                        new QuizQuestion("Quel est le rôle des nerfs ?", "Ils transmettent les messages nerveux."),
                        new QuizQuestion("Quel organe effectue le mouvement ?", "Le muscle.")
                )
        );
    }

    private CourseContent contractionMusculaire(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Produire le mouvement : contraction musculaire et apport d’énergie",
                "Ce chapitre explique comment les muscles produisent un mouvement et comment ils utilisent de l’énergie. Il relie contraction musculaire, cellules musculaires, ATP, respiration cellulaire et effort physique.",
                List.of(
                        "Le mouvement est produit par la contraction des muscles.",
                        "La contraction musculaire nécessite de l’énergie sous forme d’ATP.",
                        "L’ATP est régénérée grâce à la respiration cellulaire.",
                        "Les cellules musculaires utilisent du glucose et du dioxygène.",
                        "L’effort physique augmente les besoins en énergie.",
                        "Les systèmes respiratoire et cardiovasculaire participent à l’approvisionnement des muscles."
                ),
                List.of(
                        "Identifier le muscle ou le mouvement étudié.",
                        "Relier contraction musculaire et consommation d’ATP.",
                        "Expliquer l’origine de l’énergie utilisée.",
                        "Relier effort physique, respiration et circulation sanguine.",
                        "Interpréter les données expérimentales : fréquence cardiaque, consommation de O₂, glucose."
                ),
                List.of(
                        "Muscle → contraction → mouvement.",
                        "ATP → énergie directement utilisable par la cellule.",
                        "Glucose + O₂ → CO₂ + H₂O + énergie.",
                        "Effort → augmentation des besoins en O₂ et nutriments.",
                        "Respiration + circulation → approvisionnement des muscles."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment un mouvement est produit et pourquoi le corps respire plus vite et le cœur bat plus rapidement pendant un effort."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut relier l’échelle de l’organe, le muscle, à l’échelle cellulaire : les cellules musculaires consomment de l’ATP pour se contracter."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les exercices sur l’effort physique, la respiration cellulaire, la consommation de dioxygène, les muscles et l’énergie."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle molécule fournit directement l’énergie aux cellules ?", "L’ATP."),
                        new QuizQuestion("Pourquoi la respiration augmente pendant l’effort ?", "Pour apporter plus de dioxygène aux muscles."),
                        new QuizQuestion("Que consomment les cellules musculaires ?", "Du glucose, du dioxygène et de l’ATP."),
                        new QuizQuestion("Quel est le rôle de la circulation sanguine ?", "Transporter le dioxygène et les nutriments vers les muscles.")
                )
        );
    }

    private CourseContent stress(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Comportements et stress : vers une vision intégrée de l’organisme",
                "Ce chapitre étudie les réponses de l’organisme face à un agent stressant. Il montre que le stress implique le système nerveux, le système hormonal et peut avoir des effets différents selon sa durée.",
                List.of(
                        "Le stress est une réponse de l’organisme face à une situation perçue comme menaçante.",
                        "Le stress aigu permet une réaction rapide.",
                        "Le système nerveux sympathique intervient dans la réponse immédiate.",
                        "Des hormones comme l’adrénaline et le cortisol participent à la réponse au stress.",
                        "Un stress chronique peut avoir des effets négatifs sur la santé.",
                        "L’organisme cherche à retrouver un état d’équilibre."
                ),
                List.of(
                        "Identifier l’agent stressant.",
                        "Distinguer stress aigu et stress chronique.",
                        "Repérer les acteurs : système nerveux, hormones, organes cibles.",
                        "Expliquer les effets physiologiques : rythme cardiaque, vigilance, énergie.",
                        "Relier stress chronique et conséquences sur la santé."
                ),
                List.of(
                        "Agent stressant → perception → réponse nerveuse et hormonale.",
                        "Adrénaline → réponse rapide.",
                        "Cortisol → réponse plus durable.",
                        "Stress aigu → adaptation.",
                        "Stress chronique → risque pour la santé."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le corps réagit fortement en situation de danger ou de pression, et pourquoi un stress prolongé peut devenir mauvais pour la santé."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut suivre la chaîne : agent stressant, perception par le système nerveux, activation hormonale, effets sur les organes, puis retour ou non à l’équilibre."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les documents sur l’adrénaline, le cortisol, le rythme cardiaque, le stress chronique, les comportements et la santé."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un agent stressant ?", "Un élément qui déclenche une réponse de stress."),
                        new QuizQuestion("Quelle hormone intervient dans la réponse rapide ?", "L’adrénaline."),
                        new QuizQuestion("Pourquoi le stress chronique est-il dangereux ?", "Parce qu’il maintient l’organisme dans un état d’alerte prolongé."),
                        new QuizQuestion("Quel est le but de la réponse au stress ?", "Permettre à l’organisme de s’adapter à une situation difficile.")
                )
        );
    }

    private CourseContent variationGenetiqueSante(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Variation génétique et santé",
                "Ce chapitre montre comment les variations génétiques peuvent influencer la santé. Certaines mutations peuvent provoquer des maladies, mais l’environnement et le mode de vie jouent aussi un rôle important.",
                List.of(
                        "Les mutations peuvent modifier l’information génétique.",
                        "Certaines mutations sont sans effet, d’autres peuvent causer des maladies.",
                        "Une maladie génétique peut être liée à un allèle particulier.",
                        "Le risque de maladie dépend parfois de plusieurs gènes et de l’environnement.",
                        "Les tests génétiques permettent d’identifier certains risques.",
                        "La médecine moderne utilise les connaissances génétiques pour diagnostiquer et parfois traiter."
                ),
                List.of(
                        "Identifier la variation génétique étudiée.",
                        "Relier génotype et phénotype.",
                        "Analyser un arbre généalogique ou des données moléculaires.",
                        "Distinguer prédisposition et maladie certaine.",
                        "Prendre en compte l’environnement et les facteurs de risque."
                ),
                List.of(
                        "Mutation → modification de l’ADN.",
                        "Génotype → ensemble des allèles.",
                        "Phénotype → caractères observables.",
                        "Allèle pathogène → risque de maladie.",
                        "Prédisposition ≠ certitude."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre le lien entre ADN, mutations et santé. Il montre qu’une variation génétique peut influencer un caractère ou un risque de maladie."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut relier les documents à plusieurs échelles : séquence d’ADN, protéine, cellule, individu et famille."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les arbres généalogiques, les maladies génétiques, les mutations, les tests ADN et les facteurs de risque."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une mutation ?", "Une modification de la séquence d’ADN."),
                        new QuizQuestion("Une mutation provoque-t-elle toujours une maladie ?", "Non, elle peut être neutre, défavorable ou parfois avantageuse."),
                        new QuizQuestion("Quelle différence entre génotype et phénotype ?", "Le génotype correspond aux allèles, le phénotype aux caractères observables."),
                        new QuizQuestion("Une prédisposition génétique signifie-t-elle une certitude ?", "Non, elle indique seulement un risque plus élevé.")
                )
        );
    }

    private CourseContent immuniteVaccination(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Immunité et vaccination",
                "Ce chapitre explique comment le système immunitaire protège l’organisme contre les agents pathogènes et comment la vaccination prépare le corps à réagir plus efficacement lors d’une infection.",
                List.of(
                        "Le système immunitaire reconnaît des éléments étrangers appelés antigènes.",
                        "Les lymphocytes participent à la réponse immunitaire adaptative.",
                        "Les anticorps se fixent spécifiquement à des antigènes.",
                        "Après une infection ou une vaccination, des cellules mémoire peuvent persister.",
                        "La vaccination déclenche une mémoire immunitaire sans provoquer la maladie grave.",
                        "L’immunité collective limite la circulation d’un agent infectieux."
                ),
                List.of(
                        "Identifier l’agent pathogène ou l’antigène.",
                        "Distinguer réponse innée et réponse adaptative.",
                        "Relier anticorps, lymphocytes et antigènes.",
                        "Expliquer le rôle des cellules mémoire.",
                        "Interpréter l’effet d’un vaccin à l’échelle individuelle et collective."
                ),
                List.of(
                        "Antigène → reconnaissance immunitaire.",
                        "Lymphocytes B → production d’anticorps.",
                        "Lymphocytes T → destruction de cellules infectées ou coordination.",
                        "Vaccin → mémoire immunitaire.",
                        "Mémoire immunitaire → réponse plus rapide et efficace."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment le corps se défend contre les microbes et pourquoi les vaccins permettent de prévenir certaines maladies."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut suivre les étapes de la réponse immunitaire : reconnaissance, activation des lymphocytes, production d’anticorps, élimination puis mémoire."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les schémas immunitaires, les graphiques d’anticorps, les vaccins, les infections et l’immunité collective."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un antigène ?", "Un élément reconnu comme étranger par le système immunitaire."),
                        new QuizQuestion("Quel est le rôle d’un vaccin ?", "Préparer le système immunitaire grâce à une mémoire immunitaire."),
                        new QuizQuestion("Pourquoi la deuxième réponse immunitaire est-elle plus rapide ?", "Grâce aux cellules mémoire."),
                        new QuizQuestion("Qu’est-ce que l’immunité collective ?", "Une protection de groupe lorsque beaucoup d’individus sont immunisés.")
                )
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de SVT en préparation",
                "Ce chapitre de SVT n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les principaux chapitres de spécialité SVT sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les notions principales en attendant.",
                        "S’entraîner à exploiter des documents."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("SVT terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider SVT.")
                ),
                "svt",
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
                        new VideoLink("Cours vidéo — " + title, youtube("SVT terminale " + title)),
                        new VideoLink("Méthode bac SVT — " + title, youtube("méthode bac SVT terminale " + title)),
                        new VideoLink("Exercices corrigés — " + title, youtube("exercices corrigés SVT terminale " + title))
                ),
                quiz,
                "svt",
                explanations
        );
    }
}