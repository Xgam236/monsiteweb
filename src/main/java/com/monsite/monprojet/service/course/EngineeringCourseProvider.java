package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(6)
public class EngineeringCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("sciences de l ingenieur")
                || m.contains("sciences de l'ingénieur")
                || m.contains("ingenieur")
                || m.contains("si");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("systemes") || c.contains("produits") || c.contains("besoin")) {
            return systemesEtBesoin(matiere, chapitre);
        }

        if (c.contains("chaine d information") || c.contains("information")) {
            return chaineInformation(matiere, chapitre);
        }

        if (c.contains("chaine d energie") || c.contains("energie")) {
            return chaineEnergie(matiere, chapitre);
        }

        if (c.contains("modelisation") || c.contains("simulation")) {
            return modelisationSimulation(matiere, chapitre);
        }

        if (c.contains("asservissement") || c.contains("commande") || c.contains("controle")) {
            return asservissementCommande(matiere, chapitre);
        }

        if (c.contains("mecanique") || c.contains("mouvement") || c.contains("forces")) {
            return mecaniqueSystemes(matiere, chapitre);
        }

        if (c.contains("materiaux") || c.contains("resistance")) {
            return materiauxResistance(matiere, chapitre);
        }

        if (c.contains("capteurs") || c.contains("mesure")) {
            return capteursMesure(matiere, chapitre);
        }

        if (c.contains("communication") || c.contains("reseaux")) {
            return communicationReseaux(matiere, chapitre);
        }

        if (c.contains("developpement durable") || c.contains("ecoconception") || c.contains("cycle de vie")) {
            return developpementDurable(matiere, chapitre);
        }

        if (c.contains("projet") || c.contains("innovation")) {
            return demarcheProjetInnovation(matiere, chapitre);
        }

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent systemesEtBesoin(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Systèmes, produits et besoin",
                "Ce chapitre permet de comprendre comment un objet technique ou un système répond à un besoin. En sciences de l’ingénieur, on analyse un produit à partir de sa fonction d’usage, de ses contraintes et de son environnement.",
                List.of(
                        "Un système technique répond à un besoin exprimé par un utilisateur.",
                        "La fonction d’usage correspond à ce que le système permet de faire.",
                        "Les contraintes peuvent être économiques, techniques, environnementales, ergonomiques ou de sécurité.",
                        "Un cahier des charges exprime les performances attendues.",
                        "L’analyse fonctionnelle permet de comprendre le rôle de chaque partie du système."
                ),
                List.of(
                        "Identifier le besoin principal.",
                        "Déterminer la fonction d’usage du système.",
                        "Repérer les contraintes imposées.",
                        "Lire ou construire un cahier des charges.",
                        "Relier les solutions techniques aux fonctions attendues."
                ),
                List.of(
                        "Besoin → fonction d’usage → cahier des charges.",
                        "Fonction principale : service rendu par le système.",
                        "Fonction contrainte : condition à respecter.",
                        "Performance attendue → critère + niveau.",
                        "Système technique → matière, énergie, information."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi un objet technique existe et comment il répond à un besoin réel. Avant de concevoir ou améliorer un système, il faut savoir ce qu’il doit faire."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On commence par identifier l’utilisateur et le besoin. Ensuite, on liste les fonctions du système et les contraintes à respecter, puis on vérifie si les solutions techniques répondent au cahier des charges."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour analyser un drone, une voiture électrique, un ascenseur, un robot, un portail automatique, une prothèse ou n’importe quel système technique."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un besoin ?", "C’est ce que l’utilisateur attend du système."),
                        new QuizQuestion("À quoi sert un cahier des charges ?", "À définir les fonctions, contraintes et performances attendues."),
                        new QuizQuestion("Quelle différence entre fonction principale et contrainte ?", "La fonction principale rend le service attendu, la contrainte impose une condition à respecter."),
                        new QuizQuestion("Pourquoi faire une analyse fonctionnelle ?", "Pour comprendre le rôle du système et de ses composants.")
                )
        );
    }

    private CourseContent chaineInformation(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Chaîne d’information",
                "La chaîne d’information regroupe les fonctions qui permettent à un système d’acquérir, traiter et communiquer des informations. Elle est essentielle dans les systèmes automatisés.",
                List.of(
                        "Un système automatisé doit recevoir des informations de son environnement.",
                        "Les capteurs permettent d’acquérir une grandeur physique.",
                        "Le traitement est souvent réalisé par un microcontrôleur, un automate ou un programme.",
                        "La communication permet de transmettre un ordre, une alerte ou une donnée.",
                        "La chaîne d’information pilote souvent la chaîne d’énergie."
                ),
                List.of(
                        "Identifier les informations nécessaires au système.",
                        "Repérer les capteurs utilisés.",
                        "Déterminer comment les données sont traitées.",
                        "Identifier les sorties : affichage, signal, ordre, message.",
                        "Relier la chaîne d’information à la chaîne d’énergie."
                ),
                List.of(
                        "Acquérir → traiter → communiquer.",
                        "Capteur → grandeur physique transformée en signal.",
                        "Signal analogique → valeur continue.",
                        "Signal numérique → valeurs discrètes.",
                        "Microcontrôleur → traitement de l’information.",
                        "Ordre de commande → action envoyée vers la chaîne d’énergie."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment un système perçoit son environnement et prend une décision. Par exemple, un portail automatique détecte une télécommande, traite le signal, puis commande le moteur."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On suit le chemin de l’information : elle est d’abord captée, puis traitée, puis transmise. Il faut toujours identifier les capteurs, le traitement et les sorties."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les robots, alarmes, voitures autonomes, thermostats, drones, ascenseurs et systèmes automatisés."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelles sont les trois fonctions de la chaîne d’information ?", "Acquérir, traiter et communiquer."),
                        new QuizQuestion("À quoi sert un capteur ?", "À transformer une grandeur physique en signal exploitable."),
                        new QuizQuestion("Quel élément traite souvent l’information ?", "Un microcontrôleur, un automate ou un programme."),
                        new QuizQuestion("Quel lien avec la chaîne d’énergie ?", "La chaîne d’information peut envoyer des ordres à la chaîne d’énergie.")
                )
        );
    }

    private CourseContent chaineEnergie(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Chaîne d’énergie",
                "La chaîne d’énergie regroupe les fonctions qui permettent à un système d’alimenter, distribuer, convertir et transmettre l’énergie pour réaliser une action.",
                List.of(
                        "Un système a besoin d’énergie pour agir.",
                        "L’énergie doit être alimentée, distribuée, convertie puis transmise.",
                        "Un actionneur convertit l’énergie en action mécanique, lumineuse, thermique ou autre.",
                        "Les pertes d’énergie diminuent le rendement.",
                        "L’analyse énergétique permet d’améliorer les performances d’un système."
                ),
                List.of(
                        "Identifier la source d’énergie.",
                        "Repérer les composants qui distribuent l’énergie.",
                        "Identifier l’actionneur qui convertit l’énergie.",
                        "Étudier la transmission du mouvement ou de l’effort.",
                        "Calculer rendement, puissance ou énergie si nécessaire."
                ),
                List.of(
                        "Alimenter → distribuer → convertir → transmettre → agir.",
                        "Actionneur → convertit l’énergie en action.",
                        "Puissance : \\[ P=\\frac{E}{\\Delta t} \\]",
                        "Énergie électrique : \\[ E=P\\times t \\]",
                        "Rendement : \\[ \\eta=\\frac{P_{utile}}{P_{absorbée}} \\times 100 \\]",
                        "Aucune conversion réelle n’a un rendement de 100%."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment un système produit une action concrète : ouvrir un portail, faire avancer un robot, lever une charge ou faire tourner une hélice."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On suit le trajet de l’énergie depuis la source jusqu’à l’action finale. Il faut identifier chaque bloc : alimentation, distribution, conversion et transmission."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les moteurs, batteries, panneaux solaires, transmissions mécaniques, vérins, robots, véhicules et systèmes automatisés."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelles sont les fonctions de la chaîne d’énergie ?", "Alimenter, distribuer, convertir, transmettre et agir."),
                        new QuizQuestion("À quoi sert un actionneur ?", "À convertir l’énergie en action."),
                        new QuizQuestion("Pourquoi le rendement est-il inférieur à 100% ?", "Parce qu’il existe toujours des pertes."),
                        new QuizQuestion("Quelle formule relie énergie, puissance et temps ?", "E = P × t.")
                )
        );
    }

    private CourseContent modelisationSimulation(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Modélisation et simulation",
                "La modélisation consiste à représenter un système réel de manière simplifiée pour l’étudier. La simulation permet ensuite de prévoir son comportement sans forcément construire ou tester directement le système réel.",
                List.of(
                        "Un modèle simplifie la réalité pour la rendre étudiable.",
                        "Une simulation permet de tester virtuellement le comportement d’un système.",
                        "Un modèle doit être validé par comparaison avec le réel.",
                        "Plus un modèle est précis, plus il peut être complexe.",
                        "La simulation aide à optimiser les performances et réduire les coûts."
                ),
                List.of(
                        "Identifier le système réel étudié.",
                        "Choisir les grandeurs importantes.",
                        "Faire des hypothèses simplificatrices.",
                        "Construire ou lire le modèle.",
                        "Comparer les résultats simulés aux mesures réelles.",
                        "Modifier le modèle si l’écart est trop grand."
                ),
                List.of(
                        "Système réel → modèle → simulation → comparaison.",
                        "Hypothèse → simplification du réel.",
                        "Écart = résultat réel - résultat simulé.",
                        "Validation → modèle suffisamment proche du réel.",
                        "Simulation → outil d’aide à la décision."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à prévoir le comportement d’un système avant de le fabriquer ou de le modifier. Cela permet de gagner du temps, d’éviter des erreurs et de réduire les coûts."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On construit un modèle avec les grandeurs utiles, puis on simule le fonctionnement. Ensuite, on compare avec des mesures pour vérifier si le modèle est fiable."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les courbes simulées, les écarts entre modèle et expérience, les hypothèses, les performances et les optimisations de systèmes."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un modèle ?", "Une représentation simplifiée d’un système réel."),
                        new QuizQuestion("À quoi sert une simulation ?", "À prévoir le comportement d’un système."),
                        new QuizQuestion("Pourquoi comparer simulation et réalité ?", "Pour valider ou corriger le modèle."),
                        new QuizQuestion("Pourquoi faire des hypothèses ?", "Pour simplifier le système et pouvoir l’étudier.")
                )
        );
    }

    private CourseContent asservissementCommande(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Commande et asservissement",
                "Un système asservi compare une consigne à une mesure pour corriger automatiquement son comportement. L’objectif est d’atteindre ou maintenir une valeur souhaitée malgré les perturbations.",
                List.of(
                        "Une consigne est la valeur souhaitée.",
                        "Un capteur mesure la valeur réelle.",
                        "L’écart entre consigne et mesure permet de corriger le système.",
                        "Un système asservi fonctionne avec une boucle de retour.",
                        "La précision, la rapidité et la stabilité sont des critères importants.",
                        "Un correcteur améliore le comportement du système."
                ),
                List.of(
                        "Identifier la grandeur contrôlée.",
                        "Repérer la consigne.",
                        "Repérer la mesure fournie par le capteur.",
                        "Calculer ou interpréter l’écart.",
                        "Analyser la réponse du système : rapidité, dépassement, précision.",
                        "Conclure sur les performances de l’asservissement."
                ),
                List.of(
                        "Consigne → valeur demandée.",
                        "Mesure → valeur réelle.",
                        "Erreur : \\[ e = consigne - mesure \\]",
                        "Boucle fermée → retour de mesure.",
                        "Précision → faible erreur finale.",
                        "Stabilité → réponse sans oscillations incontrôlées."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment un système se corrige tout seul. Par exemple, un régulateur de vitesse compare la vitesse demandée à la vitesse réelle et ajuste le moteur."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère la consigne, la mesure et l’erreur. Ensuite, on analyse la manière dont le système réagit pour réduire l’écart."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les régulateurs de vitesse, drones stabilisés, chauffage automatique, robots, moteurs, asservissements de position ou de température."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une consigne ?", "La valeur que le système doit atteindre ou maintenir."),
                        new QuizQuestion("À quoi sert le capteur dans un asservissement ?", "À mesurer la valeur réelle."),
                        new QuizQuestion("Que représente l’erreur ?", "La différence entre la consigne et la mesure."),
                        new QuizQuestion("Quel est l’intérêt d’une boucle de retour ?", "Permettre au système de se corriger automatiquement.")
                )
        );
    }

    private CourseContent mecaniqueSystemes(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Mécanique des systèmes",
                "La mécanique des systèmes étudie les mouvements, les efforts et les transmissions dans les objets techniques. Elle permet de comprendre comment un mécanisme bouge et comment les forces se transmettent.",
                List.of(
                        "Un système mécanique transforme ou transmet un mouvement.",
                        "Un mouvement peut être une translation ou une rotation.",
                        "Les forces modifient le mouvement ou déforment les pièces.",
                        "Les liaisons mécaniques limitent les mouvements possibles.",
                        "Les transmissions permettent d’adapter vitesse, couple ou direction.",
                        "L’étude mécanique permet de vérifier la performance et la sécurité."
                ),
                List.of(
                        "Identifier les pièces du mécanisme.",
                        "Repérer les mouvements possibles.",
                        "Identifier les liaisons mécaniques.",
                        "Faire le bilan des efforts si demandé.",
                        "Étudier la transmission du mouvement.",
                        "Conclure sur la fonction du mécanisme."
                ),
                List.of(
                        "Translation → mouvement en ligne droite.",
                        "Rotation → mouvement autour d’un axe.",
                        "Vitesse angulaire : \\[ \\omega=\\frac{\\theta}{t} \\]",
                        "Couple : effort de rotation.",
                        "Puissance mécanique : \\[ P=C\\times\\omega \\]",
                        "Transmission → adapter mouvement et effort."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les objets techniques bougent : bras de robot, vélo, moteur, engrenage, porte automatique ou mécanisme de levage."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On commence par repérer les pièces et leurs mouvements. Ensuite, on analyse les liaisons, les forces et les transmissions."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les mécanismes, engrenages, leviers, mouvements de rotation, transmissions, efforts et calculs de puissance mécanique."
                        )
                ),
                List.of(
                        new QuizQuestion("Quels sont deux grands types de mouvement ?", "La translation et la rotation."),
                        new QuizQuestion("À quoi sert une liaison mécanique ?", "À limiter ou guider les mouvements entre deux pièces."),
                        new QuizQuestion("Que permet une transmission ?", "Adapter ou transmettre un mouvement et un effort."),
                        new QuizQuestion("Quelle formule donne la puissance mécanique en rotation ?", "P = C × ω.")
                )
        );
    }

    private CourseContent materiauxResistance(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Matériaux et résistance",
                "Ce chapitre étudie le choix des matériaux et leur capacité à résister aux contraintes mécaniques. Un matériau est choisi selon ses propriétés, son coût, sa masse, sa durabilité et son impact environnemental.",
                List.of(
                        "Un matériau possède des propriétés mécaniques, thermiques, électriques et environnementales.",
                        "La résistance mécanique dépend des efforts appliqués.",
                        "Une pièce peut subir traction, compression, flexion, torsion ou cisaillement.",
                        "Le choix d’un matériau dépend du cahier des charges.",
                        "La masse et le coût sont souvent des contraintes importantes.",
                        "L’impact environnemental devient un critère majeur de conception."
                ),
                List.of(
                        "Identifier la fonction de la pièce.",
                        "Repérer les efforts qu’elle subit.",
                        "Lister les critères du cahier des charges.",
                        "Comparer plusieurs matériaux.",
                        "Choisir le matériau le plus adapté.",
                        "Justifier le choix avec des propriétés mesurables."
                ),
                List.of(
                        "Contrainte : \\[ \\sigma=\\frac{F}{S} \\]",
                        "Masse volumique : \\[ \\rho=\\frac{m}{V} \\]",
                        "Traction → étirement.",
                        "Compression → écrasement.",
                        "Flexion → courbure.",
                        "Matériau adapté → compromis entre performance, coût et impact."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi on choisit un matériau plutôt qu’un autre. Par exemple, un avion doit être léger et résistant, tandis qu’un pont doit supporter de fortes charges."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On analyse les contraintes que subit la pièce, puis on compare les propriétés des matériaux. Le choix doit répondre au cahier des charges."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour choisir un matériau, comparer des masses volumiques, calculer une contrainte ou expliquer une rupture mécanique."
                        )
                ),
                List.of(
                        new QuizQuestion("Pourquoi choisir un matériau avec soin ?", "Parce qu’il doit respecter les contraintes du système."),
                        new QuizQuestion("Que représente la contrainte mécanique ?", "Une force rapportée à une surface."),
                        new QuizQuestion("Pourquoi la masse volumique est-elle importante ?", "Elle influence la masse de la pièce."),
                        new QuizQuestion("Quels critères peuvent guider le choix ?", "Résistance, masse, coût, durabilité et impact environnemental.")
                )
        );
    }

    private CourseContent capteursMesure(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Capteurs et mesures",
                "Un capteur transforme une grandeur physique en signal exploitable par un système. Les mesures permettent de connaître l’état du système et de prendre des décisions.",
                List.of(
                        "Un capteur mesure une grandeur physique.",
                        "La grandeur mesurée peut être température, distance, vitesse, pression, lumière, position...",
                        "Le signal de sortie peut être analogique ou numérique.",
                        "Une mesure possède une précision et une incertitude.",
                        "Le choix du capteur dépend de la grandeur, de la plage de mesure et de l’environnement.",
                        "Les capteurs sont essentiels dans les systèmes automatisés."
                ),
                List.of(
                        "Identifier la grandeur à mesurer.",
                        "Choisir un capteur adapté.",
                        "Repérer le type de signal fourni.",
                        "Interpréter la valeur mesurée.",
                        "Tenir compte de la précision et de l’incertitude.",
                        "Utiliser la mesure pour commander ou surveiller le système."
                ),
                List.of(
                        "Grandeur physique → capteur → signal.",
                        "Signal analogique → continu.",
                        "Signal numérique → discret.",
                        "Erreur de mesure = valeur mesurée - valeur vraie.",
                        "Incertitude → intervalle de confiance.",
                        "Étalonnage → relation entre grandeur et signal."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment un système connaît son environnement. Sans capteurs, un robot ou un système automatique ne peut pas réagir correctement."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On part de la grandeur à mesurer puis on choisit un capteur adapté. Ensuite, on analyse le signal fourni et on l’utilise dans la chaîne d’information."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les capteurs de distance, température, position, vitesse, luminosité, pression, ainsi que les courbes d’étalonnage et incertitudes."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert un capteur ?", "À transformer une grandeur physique en signal exploitable."),
                        new QuizQuestion("Quelle différence entre signal analogique et numérique ?", "L’analogique est continu, le numérique est discret."),
                        new QuizQuestion("Pourquoi tenir compte de l’incertitude ?", "Parce qu’une mesure n’est jamais parfaitement exacte."),
                        new QuizQuestion("À quoi sert l’étalonnage ?", "À relier le signal mesuré à la grandeur physique.")
                )
        );
    }

    private CourseContent communicationReseaux(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Communication et réseaux dans les systèmes",
                "Les systèmes modernes communiquent entre eux pour échanger des informations. Cette communication peut être filaire ou sans fil, locale ou distante, et repose sur des protocoles.",
                List.of(
                        "Un système communicant échange des données avec d’autres systèmes.",
                        "La communication peut être filaire ou sans fil.",
                        "Un protocole définit les règles d’échange.",
                        "Les réseaux permettent de relier capteurs, actionneurs, interfaces et serveurs.",
                        "Les données doivent être transmises de manière fiable et parfois sécurisée.",
                        "La communication est essentielle dans les objets connectés."
                ),
                List.of(
                        "Identifier les éléments qui communiquent.",
                        "Déterminer le type de liaison : filaire ou sans fil.",
                        "Repérer les données échangées.",
                        "Associer le protocole à son rôle.",
                        "Analyser la fiabilité, la portée, le débit ou la sécurité.",
                        "Conclure sur la solution de communication."
                ),
                List.of(
                        "Émetteur → message → récepteur.",
                        "Protocole → règles de communication.",
                        "Débit → quantité de données par seconde.",
                        "Latence → délai de transmission.",
                        "Objets connectés → capteurs + communication + traitement.",
                        "Communication sécurisée → protection des données."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les systèmes techniques échangent des informations : smartphone, voiture connectée, maison intelligente, robot ou système industriel."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On identifie qui envoie l’information, qui la reçoit, quel support est utilisé et quelles contraintes doivent être respectées : débit, portée, énergie, sécurité."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les objets connectés, réseaux de capteurs, protocoles, transmissions sans fil, interfaces homme-machine et systèmes communicants."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un protocole ?", "Un ensemble de règles pour communiquer."),
                        new QuizQuestion("Quelle différence entre filaire et sans fil ?", "Le filaire utilise un câble, le sans fil utilise des ondes."),
                        new QuizQuestion("Que représente le débit ?", "La quantité de données transmise par seconde."),
                        new QuizQuestion("Pourquoi sécuriser une communication ?", "Pour protéger les données échangées.")
                )
        );
    }

    private CourseContent developpementDurable(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Développement durable et écoconception",
                "L’écoconception consiste à concevoir un produit en limitant son impact environnemental sur l’ensemble de son cycle de vie, depuis l’extraction des matières premières jusqu’au recyclage.",
                List.of(
                        "Un produit a un impact environnemental sur tout son cycle de vie.",
                        "Le cycle de vie comprend extraction, fabrication, transport, utilisation et fin de vie.",
                        "L’écoconception cherche à réduire consommation d’énergie, pollution et déchets.",
                        "Un choix technique doit tenir compte des performances et de l’environnement.",
                        "Le recyclage, la réparabilité et la durabilité sont des critères importants.",
                        "Le développement durable combine aspects environnementaux, économiques et sociaux."
                ),
                List.of(
                        "Identifier les étapes du cycle de vie.",
                        "Repérer les impacts principaux.",
                        "Comparer plusieurs solutions techniques.",
                        "Prendre en compte énergie, matériaux, transport et fin de vie.",
                        "Proposer une amélioration réaliste.",
                        "Justifier avec des critères mesurables."
                ),
                List.of(
                        "Cycle de vie : extraction → fabrication → transport → utilisation → fin de vie.",
                        "Impact environnemental → énergie, CO₂, déchets, ressources.",
                        "Écoconception → réduire l’impact dès la conception.",
                        "Durabilité → durée d’utilisation plus longue.",
                        "Réparabilité → prolonger la vie du produit."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à concevoir des systèmes plus responsables. Un produit ne doit pas seulement fonctionner : il doit aussi limiter son impact sur les ressources et l’environnement."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On analyse toutes les étapes du cycle de vie du produit. Ensuite, on cherche les points où réduire l’impact : choix des matériaux, énergie consommée, transport, recyclage."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour comparer deux solutions techniques, analyser un bilan carbone, proposer une amélioration écologique ou étudier le cycle de vie d’un produit."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que le cycle de vie d’un produit ?", "L’ensemble des étapes de son existence, de l’extraction des matières à la fin de vie."),
                        new QuizQuestion("À quoi sert l’écoconception ?", "À réduire l’impact environnemental dès la conception."),
                        new QuizQuestion("Pourquoi la réparabilité est-elle importante ?", "Elle prolonge la durée de vie du produit."),
                        new QuizQuestion("Quels sont les trois piliers du développement durable ?", "Environnemental, économique et social.")
                )
        );
    }

    private CourseContent demarcheProjetInnovation(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Démarche de projet et innovation",
                "La démarche de projet consiste à concevoir, organiser, tester et améliorer une solution technique pour répondre à un besoin. Elle est au cœur des sciences de l’ingénieur.",
                List.of(
                        "Un projet part d’un besoin ou d’un problème à résoudre.",
                        "Le cahier des charges fixe les objectifs et contraintes.",
                        "La conception propose des solutions techniques.",
                        "Le prototype permet de tester une solution.",
                        "Les essais servent à valider ou améliorer le système.",
                        "L’innovation consiste à apporter une solution nouvelle ou meilleure."
                ),
                List.of(
                        "Définir le besoin.",
                        "Écrire ou lire le cahier des charges.",
                        "Rechercher plusieurs solutions.",
                        "Choisir une solution adaptée.",
                        "Réaliser ou étudier un prototype.",
                        "Tester, mesurer et améliorer."
                ),
                List.of(
                        "Besoin → cahier des charges → conception → prototype → tests → amélioration.",
                        "Prototype → version testable d’une solution.",
                        "Validation → comparaison avec le cahier des charges.",
                        "Innovation → réponse nouvelle à un besoin.",
                        "Itération → améliorer progressivement."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment on passe d’une idée à un objet ou système réel. Il montre que concevoir, c’est tester, corriger et améliorer."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On suit les étapes du projet : besoin, cahier des charges, solutions, prototype, tests et amélioration. Chaque décision doit être justifiée par rapport aux contraintes."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les projets de robotique, objets connectés, systèmes automatisés, innovation technique, prototypes et choix de solutions."
                        )
                ),
                List.of(
                        new QuizQuestion("Par quoi commence un projet ?", "Par l’identification d’un besoin."),
                        new QuizQuestion("À quoi sert un prototype ?", "À tester une solution avant la version finale."),
                        new QuizQuestion("Comment valide-t-on une solution ?", "En la comparant au cahier des charges."),
                        new QuizQuestion("Qu’est-ce qu’une innovation ?", "Une solution nouvelle ou améliorée qui répond à un besoin.")
                )
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de sciences de l’ingénieur en préparation",
                "Ce chapitre de sciences de l’ingénieur n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les principaux chapitres de spécialité Sciences de l’ingénieur sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les notions principales en attendant.",
                        "S’entraîner sur des analyses de systèmes."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("sciences de l ingénieur terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider Sciences de l’ingénieur.")
                ),
                "engineering",
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
                        new VideoLink("Cours vidéo — " + title, youtube("sciences de l ingénieur terminale " + title)),
                        new VideoLink("Méthode bac SI — " + title, youtube("méthode bac sciences de l ingénieur terminale " + title)),
                        new VideoLink("Exercices corrigés — " + title, youtube("exercices corrigés sciences de l ingénieur terminale " + title))
                ),
                quiz,
                "engineering",
                explanations
        );
    }
}