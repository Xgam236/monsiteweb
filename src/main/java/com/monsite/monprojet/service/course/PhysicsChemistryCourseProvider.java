package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(3)
public class PhysicsChemistryCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("physique") || m.contains("chimie");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("transformations acide-base")) return transformationsAcideBase(matiere, chapitre);
        if (c.contains("methodes physiques") || c.contains("analyse")) return methodesPhysiquesAnalyse(matiere, chapitre);
        if (c.contains("cinetique chimique")) return cinetiqueChimique(matiere, chapitre);
        if (c.contains("equilibres chimiques")) return equilibresChimiques(matiere, chapitre);
        if (c.contains("strategie de synthese")) return strategieSyntheseOrganique(matiere, chapitre);

        if (c.contains("cinematique")) return cinematiquePoint(matiere, chapitre);
        if (c.contains("lois de newton")) return loisNewton(matiere, chapitre);
        if (c.contains("champ uniforme")) return mouvementChampUniforme(matiere, chapitre);
        if (c.contains("satellites") || c.contains("planetes")) return satellitesPlanetes(matiere, chapitre);
        if (c.contains("fluides") || c.contains("pression")) return fluidesPression(matiere, chapitre);

        if (c.contains("travail")) return travailForce(matiere, chapitre);
        if (c.contains("energie mecanique")) return energieMecanique(matiere, chapitre);
        if (c.contains("premier principe")) return premierPrincipeThermodynamique(matiere, chapitre);
        if (c.contains("transferts thermiques")) return transfertsThermiques(matiere, chapitre);

        if (c.contains("lunette astronomique")) return lunetteAstronomique(matiere, chapitre);
        if (c.contains("diffraction") || c.contains("interferences")) return diffractionInterferences(matiere, chapitre);
        if (c.contains("effet doppler")) return effetDoppler(matiere, chapitre);
        if (c.contains("condensateur") || c.contains("circuits electriques")) return condensateurCircuits(matiere, chapitre);

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent transformationsAcideBase(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Transformations acide-base",
                "Les transformations acide-base étudient les réactions où une espèce chimique donne ou capte un ion hydrogène H+. Elles permettent de comprendre le pH, les couples acide/base et les dosages acido-basiques.",
                List.of(
                        "Un acide est une espèce capable de céder un ion H+.",
                        "Une base est une espèce capable de capter un ion H+.",
                        "Un couple acide/base s’écrit AH/A− ou BH+/B.",
                        "Le pH mesure l’acidité d’une solution.",
                        "Un dosage acide-base permet de déterminer une concentration inconnue."
                ),
                List.of(
                        "Identifier les couples acide/base présents.",
                        "Écrire les demi-équations acide-base.",
                        "Écrire l’équation de réaction.",
                        "Utiliser le pH ou les quantités de matière selon l’exercice.",
                        "Pour un dosage, repérer l’équivalence et exploiter la relation stœchiométrique."
                ),
                List.of(
                        "\\[ pH=-\\log[H_3O^+] \\]",
                        "\\[ [H_3O^+]=10^{-pH} \\]",
                        "\\[ AH + B \\rightleftharpoons A^- + BH^+ \\]",
                        "\\[ n=C\\times V \\]",
                        "\\[ \\text{À l’équivalence : proportions stœchiométriques respectées} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi une solution est acide ou basique, comment calculer un pH et comment déterminer une concentration par dosage."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On commence par identifier l’acide, la base et les couples associés. Ensuite, on écrit l’équation de réaction, puis on utilise le pH, les concentrations ou les quantités de matière."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les calculs de pH, les dosages acido-basiques, les équations de réaction, les tableaux d’avancement et les questions d’équivalence."
                        )
                ),
                List.of(
                        new QuizQuestion("Que fait un acide ?", "Un acide peut céder un ion H+."),
                        new QuizQuestion("Que mesure le pH ?", "Il mesure l’acidité d’une solution."),
                        new QuizQuestion("À quoi sert un dosage acide-base ?", "À déterminer une concentration inconnue.")
                )
        );
    }

    private CourseContent methodesPhysiquesAnalyse(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Méthodes physiques d’analyse",
                "Les méthodes physiques d’analyse permettent d’identifier ou de doser une espèce chimique grâce à des mesures physiques comme l’absorbance, la conductivité, le spectre ou la couleur.",
                List.of(
                        "Une espèce chimique peut être identifiée par ses propriétés physiques.",
                        "La spectrophotométrie utilise l’absorbance d’une solution colorée.",
                        "La conductimétrie mesure la capacité d’une solution à conduire le courant.",
                        "Une courbe d’étalonnage permet de déterminer une concentration.",
                        "Ces méthodes sont rapides, précises et souvent non destructives."
                ),
                List.of(
                        "Identifier la grandeur mesurée : absorbance, conductivité, longueur d’onde...",
                        "Relier la grandeur à la concentration.",
                        "Utiliser une courbe d’étalonnage ou une loi physique.",
                        "Lire graphiquement ou calculer la concentration.",
                        "Vérifier les unités et la cohérence du résultat."
                ),
                List.of(
                        "\\[ A=k\\times C \\quad \\text{relation d’étalonnage} \\]",
                        "\\[ A=\\varepsilon \\ell C \\quad \\text{loi de Beer-Lambert} \\]",
                        "\\[ n=C\\times V \\]",
                        "\\[ \\lambda \\text{ en m ou nm selon le contexte} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à analyser une solution sans forcément faire une réaction chimique complète. On peut identifier une substance ou trouver sa concentration grâce à une mesure."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On mesure une grandeur physique, puis on l’exploite avec une courbe d’étalonnage ou une relation. Il faut toujours faire attention aux unités et au domaine de validité."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les dosages par étalonnage, les lectures graphiques, la spectrophotométrie, la conductimétrie et l’identification d’espèces chimiques."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert une courbe d’étalonnage ?", "À déterminer une concentration à partir d’une mesure."),
                        new QuizQuestion("Quelle grandeur utilise la spectrophotométrie ?", "L’absorbance."),
                        new QuizQuestion("Pourquoi vérifier les unités ?", "Parce qu’une erreur d’unité fausse le résultat.")
                )
        );
    }

    private CourseContent cinetiqueChimique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Cinétique chimique",
                "La cinétique chimique étudie la vitesse des transformations chimiques. Certaines réactions sont très rapides, d’autres très lentes. On cherche à comprendre les facteurs qui influencent cette vitesse.",
                List.of(
                        "La cinétique étudie l’évolution d’un système chimique au cours du temps.",
                        "La vitesse dépend de la concentration des réactifs.",
                        "La température peut accélérer une transformation.",
                        "Un catalyseur accélère une réaction sans être consommé.",
                        "Le temps de demi-réaction permet de caractériser la durée d’une transformation."
                ),
                List.of(
                        "Identifier la grandeur suivie au cours du temps.",
                        "Exploiter un graphique ou un tableau de valeurs.",
                        "Repérer l’état initial, l’évolution et l’état final.",
                        "Déterminer un temps de demi-réaction si demandé.",
                        "Interpréter l’influence de la température, concentration ou catalyseur."
                ),
                List.of(
                        "\\[ v \\approx \\frac{\\Delta x}{\\Delta t} \\]",
                        "\\[ t_{1/2} : \\text{durée pour atteindre la moitié de l’avancement final} \\]",
                        "\\[ x(t) \\rightarrow x_f \\quad \\text{quand la réaction se termine} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi certaines réactions prennent du temps et comment on peut les accélérer ou les suivre expérimentalement."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On suit une grandeur qui change avec le temps, puis on exploite un graphique ou un tableau pour comprendre l’évolution de la réaction."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les suivis temporels, les graphiques d’avancement, les temps de demi-réaction et les questions sur les facteurs cinétiques."
                        )
                ),
                List.of(
                        new QuizQuestion("Que signifie cinétique chimique ?", "L’étude de la vitesse d’une transformation chimique."),
                        new QuizQuestion("Que fait un catalyseur ?", "Il accélère une réaction sans être consommé."),
                        new QuizQuestion("À quoi sert le temps de demi-réaction ?", "À caractériser la durée d’une transformation.")
                )
        );
    }

    private CourseContent equilibresChimiques(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Équilibres chimiques",
                "Un équilibre chimique est atteint lorsqu’une transformation réversible n’évolue plus à l’échelle macroscopique. Les réactifs et produits restent présents, mais leurs concentrations deviennent constantes.",
                List.of(
                        "Certaines réactions ne sont pas totales : elles atteignent un équilibre.",
                        "À l’équilibre, les concentrations ne varient plus.",
                        "Le quotient de réaction permet de prévoir le sens d’évolution.",
                        "La constante d’équilibre caractérise l’état final à température donnée.",
                        "Un changement de conditions peut déplacer l’équilibre."
                ),
                List.of(
                        "Écrire l’équation de la réaction.",
                        "Identifier les espèces présentes.",
                        "Écrire le quotient de réaction.",
                        "Comparer le quotient à la constante d’équilibre si nécessaire.",
                        "Conclure sur le sens d’évolution ou l’état d’équilibre."
                ),
                List.of(
                        "\\[ Q_r=\\frac{\\text{activité des produits}}{\\text{activité des réactifs}} \\]",
                        "\\[ Q_r=K \\Rightarrow \\text{système à l’équilibre} \\]",
                        "\\[ Q_r<K \\Rightarrow \\text{évolution dans le sens direct} \\]",
                        "\\[ Q_r>K \\Rightarrow \\text{évolution dans le sens inverse} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi certaines réactions ne vont pas jusqu’au bout et pourquoi il reste parfois des réactifs et des produits en même temps."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On écrit le quotient de réaction, puis on le compare à la constante d’équilibre. Cela permet de savoir si le système est déjà à l’équilibre ou dans quel sens il va évoluer."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les réactions non totales, les acides faibles, les équilibres en solution et les comparaisons entre quotient et constante."
                        )
                ),
                List.of(
                        new QuizQuestion("Une réaction à l’équilibre est-elle forcément terminée ?", "Non, les deux sens peuvent continuer mais les concentrations restent constantes."),
                        new QuizQuestion("Que signifie Qr = K ?", "Le système est à l’équilibre."),
                        new QuizQuestion("À quoi sert le quotient de réaction ?", "À prévoir le sens d’évolution.")
                )
        );
    }

    private CourseContent strategieSyntheseOrganique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Stratégie de synthèse organique",
                "La synthèse organique consiste à fabriquer une molécule en choisissant des réactifs, des conditions expérimentales et des étapes adaptées. On cherche à obtenir le meilleur rendement avec une méthode sûre et efficace.",
                List.of(
                        "Une synthèse vise à fabriquer une espèce chimique cible.",
                        "Il faut choisir les réactifs et les conditions expérimentales.",
                        "Les étapes peuvent inclure chauffage, reflux, extraction, purification et identification.",
                        "Le rendement mesure l’efficacité de la synthèse.",
                        "La sécurité et l’impact environnemental sont importants."
                ),
                List.of(
                        "Identifier la molécule à synthétiser.",
                        "Repérer les groupes caractéristiques.",
                        "Choisir les transformations nécessaires.",
                        "Analyser les étapes expérimentales.",
                        "Calculer le rendement si demandé."
                ),
                List.of(
                        "\\[ \\eta=\\frac{n_{\\text{obtenu}}}{n_{\\text{max}}}\\times100 \\]",
                        "\\[ n=\\frac{m}{M} \\]",
                        "\\[ n=C\\times V \\]",
                        "\\[ \\text{rendement réel} < 100\\% \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les chimistes fabriquent des molécules utiles : médicaments, arômes, matériaux ou produits du quotidien."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On analyse les groupes fonctionnels, les étapes de transformation, puis on vérifie la quantité obtenue avec le rendement."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les protocoles expérimentaux, les calculs de rendement, l’identification de molécules et les questions de sécurité."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert le rendement ?", "À mesurer l’efficacité d’une synthèse."),
                        new QuizQuestion("Pourquoi purifier un produit ?", "Pour éliminer les impuretés."),
                        new QuizQuestion("Pourquoi identifier le produit ?", "Pour vérifier qu’on a bien obtenu l’espèce attendue.")
                )
        );
    }

    private CourseContent cinematiquePoint(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Cinématique du point",
                "La cinématique décrit le mouvement d’un point sans s’intéresser aux causes du mouvement. Elle étudie la position, la vitesse et l’accélération dans un référentiel donné.",
                List.of(
                        "Un mouvement se décrit toujours dans un référentiel.",
                        "La position dépend du temps.",
                        "La vitesse décrit la variation de la position.",
                        "L’accélération décrit la variation de la vitesse.",
                        "Les vecteurs vitesse et accélération donnent des informations sur la trajectoire."
                ),
                List.of(
                        "Définir le système étudié et le référentiel.",
                        "Repérer la trajectoire.",
                        "Utiliser les données de position, vitesse ou accélération.",
                        "Interpréter les vecteurs.",
                        "Conclure sur le type de mouvement."
                ),
                List.of(
                        "\\[ \\vec{v}=\\frac{d\\vec{OM}}{dt} \\]",
                        "\\[ \\vec{a}=\\frac{d\\vec{v}}{dt} \\]",
                        "\\[ v=\\frac{d}{\\Delta t} \\quad \\text{si vitesse moyenne} \\]",
                        "\\[ \\text{mouvement uniforme} \\Rightarrow \\vec{a}=\\vec{0} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à décrire précisément comment un objet se déplace : sa trajectoire, sa vitesse et son accélération."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On choisit un référentiel, on repère la position au cours du temps, puis on exploite les vecteurs vitesse et accélération."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les mouvements rectilignes, circulaires, les graphes position-vitesse et les études de trajectoire."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un référentiel ?", "Un objet de référence par rapport auquel on décrit le mouvement."),
                        new QuizQuestion("Que décrit la vitesse ?", "La variation de la position au cours du temps."),
                        new QuizQuestion("Que décrit l’accélération ?", "La variation de la vitesse au cours du temps.")
                )
        );
    }

    private CourseContent loisNewton(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Lois de Newton",
                "Les lois de Newton expliquent le lien entre les forces appliquées à un système et son mouvement. Elles sont fondamentales pour comprendre la dynamique.",
                List.of(
                        "Un système conserve son mouvement si les forces se compensent.",
                        "La somme des forces est liée à l’accélération.",
                        "Plus la masse est grande, plus il est difficile de modifier le mouvement.",
                        "Une force se modélise par un vecteur.",
                        "L’étude se fait toujours dans un référentiel galiléen."
                ),
                List.of(
                        "Définir le système étudié.",
                        "Choisir un référentiel.",
                        "Faire le bilan des forces.",
                        "Représenter les forces avec des vecteurs.",
                        "Appliquer la deuxième loi de Newton."
                ),
                List.of(
                        "\\[ \\sum \\vec{F}=m\\vec{a} \\]",
                        "\\[ \\vec{P}=m\\vec{g} \\]",
                        "\\[ \\sum \\vec{F}=\\vec{0} \\Rightarrow \\vec{v} \\text{ constante} \\]",
                        "\\[ 1\\,N=1\\,kg\\cdot m\\cdot s^{-2} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi un objet accélère, ralentit, tombe, tourne ou reste en mouvement."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On commence toujours par isoler le système, faire le bilan des forces, puis appliquer la relation entre somme des forces et accélération."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les chutes, les mouvements de projectiles, les systèmes soumis à plusieurs forces et les problèmes de dynamique."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle est la deuxième loi de Newton ?", "La somme des forces vaut m fois l’accélération."),
                        new QuizQuestion("Pourquoi faire un bilan des forces ?", "Pour savoir quelles actions mécaniques agissent sur le système."),
                        new QuizQuestion("Que se passe-t-il si les forces se compensent ?", "Le vecteur vitesse reste constant.")
                )
        );
    }

    private CourseContent mouvementChampUniforme(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Mouvement dans un champ uniforme",
                "Un champ uniforme a la même direction, le même sens et la même valeur en tout point. Dans un champ de pesanteur ou électrique uniforme, un système subit une accélération constante.",
                List.of(
                        "Un champ uniforme est constant dans une zone donnée.",
                        "Dans le champ de pesanteur, l’accélération est souvent égale à g.",
                        "Le mouvement peut être décomposé selon deux axes.",
                        "La trajectoire d’un projectile est souvent parabolique.",
                        "Les équations horaires décrivent la position au cours du temps."
                ),
                List.of(
                        "Choisir un repère adapté.",
                        "Identifier le champ et l’accélération.",
                        "Projeter le mouvement sur les axes.",
                        "Écrire les équations horaires.",
                        "Utiliser les conditions initiales."
                ),
                List.of(
                        "\\[ \\vec{a}=\\vec{g} \\quad \\text{dans le champ de pesanteur} \\]",
                        "\\[ v_x(t)=v_{0x} \\]",
                        "\\[ v_y(t)=v_{0y}-gt \\]",
                        "\\[ y(t)=y_0+v_{0y}t-\\frac{1}{2}gt^2 \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à prévoir la trajectoire d’un objet soumis à un champ constant, comme une balle lancée ou une particule chargée."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On décompose le mouvement selon les axes, puis on utilise les équations horaires avec les conditions initiales."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les projectiles, les chutes, les tirs, les mouvements paraboliques et les particules dans un champ électrique."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un champ uniforme ?", "Un champ qui garde la même valeur, direction et sens dans la zone étudiée."),
                        new QuizQuestion("Quelle est la forme typique de la trajectoire d’un projectile ?", "Une parabole."),
                        new QuizQuestion("Pourquoi projeter sur les axes ?", "Pour simplifier l’étude du mouvement.")
                )
        );
    }

    private CourseContent satellitesPlanetes(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Mouvement des satellites et planètes",
                "Le mouvement des satellites et planètes s’explique par l’attraction gravitationnelle. Un satellite reste en orbite car la gravitation joue le rôle de force centripète.",
                List.of(
                        "Deux masses s’attirent par gravitation.",
                        "Un satellite en orbite est en chute permanente autour de l’astre.",
                        "La force gravitationnelle est dirigée vers le centre de l’astre.",
                        "Le mouvement circulaire uniforme nécessite une accélération centripète.",
                        "La période dépend du rayon de l’orbite et de la masse de l’astre."
                ),
                List.of(
                        "Identifier l’astre attracteur et le satellite.",
                        "Écrire la force gravitationnelle.",
                        "Relier cette force à l’accélération centripète.",
                        "Simplifier pour trouver vitesse ou période.",
                        "Vérifier les unités."
                ),
                List.of(
                        "\\[ F=G\\frac{m_1m_2}{r^2} \\]",
                        "\\[ a=\\frac{v^2}{r} \\]",
                        "\\[ v=\\sqrt{\\frac{GM}{r}} \\]",
                        "\\[ T=\\frac{2\\pi r}{v} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les planètes tournent autour du Soleil et comment les satellites restent en orbite autour de la Terre."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On utilise la gravitation comme force responsable du mouvement circulaire. Ensuite, on relie cette force à l’accélération centripète."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour calculer une vitesse orbitale, une période, une force gravitationnelle ou expliquer le mouvement d’un satellite."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle force maintient un satellite en orbite ?", "La force gravitationnelle."),
                        new QuizQuestion("Vers où est dirigée l’accélération centripète ?", "Vers le centre de la trajectoire."),
                        new QuizQuestion("Que représente T ?", "La période du mouvement orbital.")
                )
        );
    }

    private CourseContent fluidesPression(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Fluides et pression",
                "Ce chapitre étudie les fluides au repos ou en mouvement. La pression décrit l’action exercée par un fluide sur une surface et dépend notamment de la profondeur dans un liquide.",
                List.of(
                        "Un fluide peut être un liquide ou un gaz.",
                        "La pression est une force exercée par unité de surface.",
                        "Dans un liquide au repos, la pression augmente avec la profondeur.",
                        "La poussée d’Archimède explique la flottabilité.",
                        "Les fluides permettent de comprendre de nombreux phénomènes du quotidien."
                ),
                List.of(
                        "Identifier le fluide étudié.",
                        "Repérer les grandeurs : pression, profondeur, surface, masse volumique.",
                        "Choisir la relation adaptée.",
                        "Faire attention aux unités.",
                        "Interpréter le résultat physiquement."
                ),
                List.of(
                        "\\[ P=\\frac{F}{S} \\]",
                        "\\[ P=P_0+\\rho gh \\]",
                        "\\[ F_A=\\rho_{fluide}Vg \\]",
                        "\\[ 1\\,Pa=1\\,N\\cdot m^{-2} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi la pression augmente sous l’eau, pourquoi certains objets flottent et comment les fluides exercent des forces."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On identifie la profondeur, la surface ou le volume déplacé, puis on applique la relation adaptée en vérifiant les unités."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour la pression hydrostatique, la plongée, les barrages, la poussée d’Archimède et la flottabilité."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelle est l’unité de la pression ?", "Le pascal, noté Pa."),
                        new QuizQuestion("Comment évolue la pression avec la profondeur ?", "Elle augmente."),
                        new QuizQuestion("À quoi sert la poussée d’Archimède ?", "À expliquer la flottabilité.")
                )
        );
    }

    private CourseContent travailForce(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Travail d’une force",
                "Le travail d’une force mesure l’énergie transférée par cette force lorsqu’un objet se déplace. Il dépend de la force, du déplacement et de l’angle entre les deux.",
                List.of(
                        "Une force peut fournir ou retirer de l’énergie à un système.",
                        "Le travail dépend du déplacement.",
                        "Le travail est moteur s’il favorise le mouvement.",
                        "Le travail est résistant s’il s’oppose au mouvement.",
                        "Le travail s’exprime en joules."
                ),
                List.of(
                        "Identifier la force étudiée.",
                        "Identifier le déplacement.",
                        "Déterminer l’angle entre force et déplacement.",
                        "Appliquer la formule du travail.",
                        "Interpréter le signe du résultat."
                ),
                List.of(
                        "\\[ W_{AB}(\\vec{F})=F\\times AB\\times \\cos(\\theta) \\]",
                        "\\[ W>0 \\Rightarrow \\text{travail moteur} \\]",
                        "\\[ W<0 \\Rightarrow \\text{travail résistant} \\]",
                        "\\[ 1\\,J=1\\,N\\cdot m \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment une force peut transférer de l’énergie à un objet pendant son déplacement."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère la force, la distance parcourue et l’angle entre les deux. Le signe du travail permet ensuite de savoir si la force aide ou freine le mouvement."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les frottements, le poids, les forces motrices, les plans inclinés et les bilans énergétiques."
                        )
                ),
                List.of(
                        new QuizQuestion("En quelle unité s’exprime le travail ?", "En joules."),
                        new QuizQuestion("Quand un travail est-il moteur ?", "Quand il est positif."),
                        new QuizQuestion("De quoi dépend le travail ?", "De la force, du déplacement et de l’angle.")
                )
        );
    }

    private CourseContent energieMecanique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Énergie mécanique",
                "L’énergie mécanique est la somme de l’énergie cinétique et de l’énergie potentielle. Elle permet d’étudier les mouvements en reliant vitesse, position et conservation d’énergie.",
                List.of(
                        "L’énergie cinétique dépend de la masse et de la vitesse.",
                        "L’énergie potentielle dépend de la position.",
                        "L’énergie mécanique est la somme des deux.",
                        "Sans frottements, l’énergie mécanique se conserve.",
                        "Avec frottements, l’énergie mécanique diminue."
                ),
                List.of(
                        "Identifier les formes d’énergie présentes.",
                        "Calculer l’énergie cinétique.",
                        "Calculer l’énergie potentielle.",
                        "Additionner pour obtenir l’énergie mécanique.",
                        "Utiliser la conservation ou la variation selon la situation."
                ),
                List.of(
                        "\\[ E_c=\\frac{1}{2}mv^2 \\]",
                        "\\[ E_p=mgh \\]",
                        "\\[ E_m=E_c+E_p \\]",
                        "\\[ \\Delta E_m=0 \\quad \\text{si pas de frottements} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à étudier un mouvement sans forcément passer par toutes les forces, en utilisant les échanges entre énergie cinétique et énergie potentielle."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On calcule les énergies au début et à la fin. Si l’énergie mécanique se conserve, on peut trouver une vitesse ou une hauteur."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les chutes, les montagnes russes, les pendules, les frottements et les mouvements verticaux."
                        )
                ),
                List.of(
                        new QuizQuestion("De quoi dépend l’énergie cinétique ?", "De la masse et de la vitesse."),
                        new QuizQuestion("Que vaut l’énergie mécanique ?", "Ec + Ep."),
                        new QuizQuestion("Quand l’énergie mécanique se conserve-t-elle ?", "Lorsqu’il n’y a pas de forces dissipatives comme les frottements.")
                )
        );
    }

    private CourseContent premierPrincipeThermodynamique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Premier principe de la thermodynamique",
                "Le premier principe de la thermodynamique exprime la conservation de l’énergie pour un système. La variation d’énergie interne dépend des transferts thermiques et du travail reçu.",
                List.of(
                        "L’énergie interne est liée à l’état microscopique du système.",
                        "Un système peut échanger de l’énergie par chaleur ou par travail.",
                        "Le premier principe traduit une conservation de l’énergie.",
                        "Un transfert thermique peut augmenter ou diminuer l’énergie interne.",
                        "Le signe des échanges dépend de la convention utilisée."
                ),
                List.of(
                        "Définir le système étudié.",
                        "Identifier les échanges d’énergie.",
                        "Repérer le travail et le transfert thermique.",
                        "Appliquer le premier principe.",
                        "Interpréter le signe de la variation d’énergie interne."
                ),
                List.of(
                        "\\[ \\Delta U=W+Q \\]",
                        "\\[ Q>0 \\Rightarrow \\text{énergie thermique reçue} \\]",
                        "\\[ W>0 \\Rightarrow \\text{travail reçu par le système} \\]",
                        "\\[ \\Delta U=U_f-U_i \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment l’énergie d’un système change lorsqu’il reçoit ou cède de la chaleur et du travail."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On choisit le système, on identifie les échanges avec l’extérieur, puis on applique ΔU = W + Q."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les gaz, les moteurs, les chauffages, les transformations thermiques et les bilans d’énergie."
                        )
                ),
                List.of(
                        new QuizQuestion("Que dit le premier principe ?", "La variation d’énergie interne dépend du travail et de la chaleur échangés."),
                        new QuizQuestion("Quelle est la relation principale ?", "ΔU = W + Q."),
                        new QuizQuestion("Que représente Q ?", "Un transfert thermique.")
                )
        );
    }

    private CourseContent transfertsThermiques(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Transferts thermiques",
                "Les transferts thermiques correspondent aux échanges d’énergie dus à une différence de température. Ils peuvent se faire par conduction, convection ou rayonnement.",
                List.of(
                        "La chaleur se transfère spontanément du chaud vers le froid.",
                        "La conduction se fait à travers la matière sans déplacement global.",
                        "La convection implique un déplacement de fluide.",
                        "Le rayonnement peut se propager même dans le vide.",
                        "La capacité thermique mesure l’énergie nécessaire pour élever la température."
                ),
                List.of(
                        "Identifier les corps en échange thermique.",
                        "Repérer les températures initiales et finales.",
                        "Choisir le mode de transfert.",
                        "Utiliser la relation énergétique adaptée.",
                        "Interpréter le sens du transfert."
                ),
                List.of(
                        "\\[ Q=m c \\Delta T \\]",
                        "\\[ \\Delta T=T_f-T_i \\]",
                        "\\[ \\Phi=\\frac{Q}{\\Delta t} \\]",
                        "\\[ \\text{transfert spontané : chaud} \\rightarrow \\text{froid} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment la chaleur se déplace et comment la température d’un système peut changer."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On identifie le système chaud et le système froid, puis on calcule l’énergie thermique échangée avec Q = mcΔT."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les calorimètres, les changements de température, l’isolation thermique, les flux thermiques et les bilans d’énergie."
                        )
                ),
                List.of(
                        new QuizQuestion("Dans quel sens se fait un transfert thermique spontané ?", "Du corps chaud vers le corps froid."),
                        new QuizQuestion("Quels sont les trois modes de transfert ?", "Conduction, convection et rayonnement."),
                        new QuizQuestion("Que signifie Q = mcΔT ?", "L’énergie thermique échangée lors d’une variation de température.")
                )
        );
    }

    private CourseContent lunetteAstronomique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Lunette astronomique",
                "La lunette astronomique est un instrument optique qui permet d’observer des objets lointains grâce à deux lentilles : l’objectif et l’oculaire.",
                List.of(
                        "L’objectif forme une image intermédiaire de l’objet lointain.",
                        "L’oculaire joue le rôle de loupe pour observer cette image.",
                        "Une lunette afocale donne une image finale à l’infini.",
                        "Le grossissement dépend des focales de l’objectif et de l’oculaire.",
                        "Les constructions de rayons permettent de comprendre la formation des images."
                ),
                List.of(
                        "Identifier l’objectif et l’oculaire.",
                        "Repérer les distances focales.",
                        "Construire les rayons principaux.",
                        "Utiliser la condition afocale si nécessaire.",
                        "Calculer le grossissement."
                ),
                List.of(
                        "\\[ G=\\frac{f'_{objectif}}{f'_{oculaire}} \\]",
                        "\\[ \\text{lunette afocale : image finale à l’infini} \\]",
                        "\\[ O_1O_2=f'_1+f'_2 \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment un instrument optique peut grossir l’image d’un objet très éloigné, comme une planète ou une étoile."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On étudie le trajet des rayons lumineux à travers l’objectif puis l’oculaire. Ensuite, on utilise les distances focales pour calculer le grossissement."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les schémas optiques, les calculs de grossissement, les lentilles minces et les conditions d’observation afocale."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelles sont les deux lentilles d’une lunette ?", "L’objectif et l’oculaire."),
                        new QuizQuestion("Que fait l’oculaire ?", "Il joue le rôle de loupe."),
                        new QuizQuestion("De quoi dépend le grossissement ?", "Des distances focales.")
                )
        );
    }

    private CourseContent diffractionInterferences(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Diffraction et interférences",
                "La diffraction et les interférences sont des phénomènes caractéristiques des ondes. Elles montrent que la lumière peut se comporter comme une onde.",
                List.of(
                        "La diffraction apparaît lorsqu’une onde rencontre une ouverture ou un obstacle.",
                        "Plus l’ouverture est petite, plus la diffraction est importante.",
                        "Les interférences résultent de la superposition de deux ondes cohérentes.",
                        "Les interférences peuvent être constructives ou destructives.",
                        "Ces phénomènes permettent de mesurer des longueurs d’onde."
                ),
                List.of(
                        "Identifier le phénomène : diffraction ou interférences.",
                        "Repérer les grandeurs : longueur d’onde, ouverture, distance.",
                        "Choisir la relation adaptée.",
                        "Faire attention aux unités.",
                        "Interpréter la figure obtenue."
                ),
                List.of(
                        "\\[ \\theta \\approx \\frac{\\lambda}{a} \\]",
                        "\\[ i=\\frac{\\lambda D}{b} \\]",
                        "\\[ \\delta=k\\lambda \\Rightarrow \\text{interférence constructive} \\]",
                        "\\[ \\delta=(k+\\frac{1}{2})\\lambda \\Rightarrow \\text{interférence destructive} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre les comportements ondulatoires de la lumière et à mesurer des grandeurs comme la longueur d’onde."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère la figure observée, puis on utilise la relation adaptée en convertissant les unités, surtout les nanomètres et les mètres."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les expériences de fente, de laser, de Young, les mesures de longueur d’onde et les figures lumineuses."
                        )
                ),
                List.of(
                        new QuizQuestion("Quand observe-t-on la diffraction ?", "Quand une onde rencontre une ouverture ou un obstacle."),
                        new QuizQuestion("Que sont des interférences constructives ?", "Des ondes qui se renforcent."),
                        new QuizQuestion("Quelle grandeur est souvent mesurée ?", "La longueur d’onde.")
                )
        );
    }

    private CourseContent effetDoppler(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Effet Doppler",
                "L’effet Doppler correspond au changement de fréquence perçue lorsqu’une source d’onde et un observateur sont en mouvement relatif.",
                List.of(
                        "La fréquence perçue change si la source se rapproche ou s’éloigne.",
                        "Si la source se rapproche, la fréquence perçue augmente.",
                        "Si la source s’éloigne, la fréquence perçue diminue.",
                        "Le phénomène existe pour le son et la lumière.",
                        "Il permet de mesurer des vitesses."
                ),
                List.of(
                        "Identifier la source et l’observateur.",
                        "Déterminer s’ils se rapprochent ou s’éloignent.",
                        "Comparer fréquence émise et fréquence reçue.",
                        "Utiliser la relation adaptée si elle est donnée.",
                        "Interpréter le résultat en termes de vitesse."
                ),
                List.of(
                        "\\[ \\Delta f=f_R-f_E \\]",
                        "\\[ \\text{rapprochement} \\Rightarrow f_R>f_E \\]",
                        "\\[ \\text{éloignement} \\Rightarrow f_R<f_E \\]",
                        "\\[ v \\text{ peut être déduite du décalage en fréquence} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le son d’une sirène change quand elle passe devant nous et comment on peut mesurer une vitesse à distance."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On regarde si la source se rapproche ou s’éloigne. Ensuite, on compare la fréquence reçue à la fréquence émise."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour les radars, les sirènes, l’astronomie, les étoiles qui s’éloignent et les mesures de vitesse."
                        )
                ),
                List.of(
                        new QuizQuestion("Que se passe-t-il si la source se rapproche ?", "La fréquence perçue augmente."),
                        new QuizQuestion("Que se passe-t-il si la source s’éloigne ?", "La fréquence perçue diminue."),
                        new QuizQuestion("À quoi sert l’effet Doppler ?", "À mesurer des vitesses ou interpréter des mouvements.")
                )
        );
    }

    private CourseContent condensateurCircuits(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Condensateur et circuits électriques",
                "Un condensateur est un dipôle capable de stocker de l’énergie électrique. Dans un circuit RC, sa charge et sa décharge suivent une évolution progressive au cours du temps.",
                List.of(
                        "Un condensateur stocke des charges électriques.",
                        "La tension aux bornes du condensateur évolue progressivement.",
                        "La constante de temps caractérise la rapidité de charge ou décharge.",
                        "L’énergie stockée dépend de la capacité et de la tension.",
                        "Les circuits RC sont utilisés dans de nombreux systèmes électroniques."
                ),
                List.of(
                        "Identifier le circuit étudié.",
                        "Repérer R, C et la tension.",
                        "Calculer la constante de temps.",
                        "Étudier la charge ou la décharge.",
                        "Interpréter le comportement limite."
                ),
                List.of(
                        "\\[ q=C\\times U \\]",
                        "\\[ \\tau=RC \\]",
                        "\\[ E=\\frac{1}{2}CU^2 \\]",
                        "\\[ U_C(t)=E(1-e^{-t/RC}) \\quad \\text{charge} \\]"
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment un circuit peut stocker de l’énergie électrique et comment la tension évolue dans le temps."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On calcule la constante de temps τ = RC, puis on étudie si le condensateur se charge ou se décharge."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les circuits RC, les graphes de tension, les constantes de temps, l’énergie électrique et les systèmes électroniques."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert un condensateur ?", "À stocker des charges et de l’énergie électrique."),
                        new QuizQuestion("Que vaut la constante de temps ?", "τ = RC."),
                        new QuizQuestion("De quoi dépend l’énergie stockée ?", "De la capacité C et de la tension U.")
                )
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de physique-chimie en préparation",
                "Ce chapitre de physique-chimie n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les principaux chapitres de Terminale physique-chimie sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les formules principales en attendant.",
                        "Faire des exercices simples du chapitre."
                ),
                List.of(
                        "Aucune formule détaillée disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("physique chimie terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider physique-chimie.")
                ),
                "science",
                List.of(
                        new ExplanationBlock(
                                "Cours en préparation",
                                "Ce chapitre sera ajouté avec un vrai résumé, des formules, une méthode, des vidéos et un quiz."
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
                        new VideoLink("Cours vidéo — " + title, youtube("physique chimie terminale " + title)),
                        new VideoLink("Méthode bac — " + title, youtube("méthode bac physique chimie " + title)),
                        new VideoLink("Exercices corrigés — " + title, youtube("exercices corrigés physique chimie terminale " + title))
                ),
                quiz,
                "science",
                explanations
        );
    }
}