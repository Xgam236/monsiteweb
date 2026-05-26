package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(1)
public class MathCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        return normalize(matiere).contains("math");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("calcul integral")) return calculIntegral(matiere, chapitre);
        if (c.contains("fonction exponentielle")) return fonctionExponentielle(matiere, chapitre);
        if (c.contains("fonction logarithme")) return fonctionLogarithme(matiere, chapitre);
        if (c.contains("suites numeriques")) return suitesNumeriques(matiere, chapitre);
        if (c.contains("limites de suites")) return limitesSuites(matiere, chapitre);
        if (c.contains("limites de fonctions")) return limitesFonctions(matiere, chapitre);
        if (c.contains("continuite")) return continuite(matiere, chapitre);
        if (c.contains("derivation") || c.contains("convexite")) return derivationConvexite(matiere, chapitre);
        if (c.contains("primitives")) return primitives(matiere, chapitre);
        if (c.contains("equations differentielles")) return equationsDifferentielles(matiere, chapitre);
        if (c.contains("variables aleatoires")) return variablesAleatoires(matiere, chapitre);
        if (c.contains("loi binomiale")) return loiBinomiale(matiere, chapitre);
        if (c.contains("sommes de variables")) return sommesVariablesAleatoires(matiere, chapitre);
        if (c.contains("concentration") || c.contains("loi des grands nombres")) return concentrationLoiGrandsNombres(matiere, chapitre);
        if (c.contains("combinatoire") || c.contains("denombrement")) return combinatoireDenombrement(matiere, chapitre);
        if (c.contains("vecteurs") || c.contains("droites et plans de l espace")) return vecteursDroitesPlans(matiere, chapitre);
        if (c.contains("orthogonalite") || c.contains("distances dans l espace")) return orthogonaliteDistances(matiere, chapitre);
        if (c.contains("equations de droites") || c.contains("equations de plans")) return equationsDroitesPlans(matiere, chapitre);

        return coursMathEnPreparation(matiere, chapitre);
    }

    private CourseContent calculIntegral(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Calcul intégral",
                "Le calcul intégral permet de mesurer une aire sous une courbe et de calculer une quantité accumulée. En Terminale, on utilise surtout le lien entre intégrale et primitive : si F est une primitive de f, alors l’intégrale de f entre a et b vaut F(b) - F(a).",
                List.of(
                        "Une intégrale peut représenter une aire, une quantité totale ou une accumulation.",
                        "Si f est positive sur [a ; b], l’intégrale correspond à l’aire sous la courbe.",
                        "Le calcul d’une intégrale repose souvent sur la recherche d’une primitive.",
                        "L’intégrale est linéaire : on peut séparer les sommes et sortir les constantes.",
                        "L’unité d’une intégrale dépend du contexte : aire, distance, énergie, quantité, coût..."
                ),
                List.of(
                        "Identifier les bornes a et b.",
                        "Identifier la fonction f à intégrer.",
                        "Chercher une primitive F de f.",
                        "Calculer F(b) - F(a).",
                        "Interpréter le résultat selon la situation."
                ),
                List.of(
                        "\\[ \\int_a^b f(x)\\,dx = F(b)-F(a) \\]",
                        "\\[ \\int_a^b (f(x)+g(x))\\,dx = \\int_a^b f(x)\\,dx + \\int_a^b g(x)\\,dx \\]",
                        "\\[ \\int_a^b kf(x)\\,dx = k\\int_a^b f(x)\\,dx \\]",
                        "\\[ \\int_a^b 1\\,dx = b-a \\]",
                        "\\[ \\int_a^b x^n\\,dx = \\left[\\frac{x^{n+1}}{n+1}\\right]_a^b \\quad n\\neq -1 \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Intégrales Terminale", youtube("Yvan Monka intégrales terminale")),
                        new VideoLink("Méthode — Calculer une intégrale", youtube("calculer une intégrale terminale méthode")),
                        new VideoLink("Exercices corrigés — Intégrales", youtube("exercices corrigés intégrales terminale"))
                ),
                List.of(
                        new QuizQuestion("Que représente une intégrale si f est positive ?", "Elle représente l’aire sous la courbe entre les bornes a et b."),
                        new QuizQuestion("Comment calcule-t-on une intégrale avec une primitive ?", "On calcule F(b) - F(a)."),
                        new QuizQuestion("Quelle est l’erreur fréquente ?", "Inverser les bornes ou oublier de soustraire F(a)."),
                        new QuizQuestion("À quoi peut servir l’intégrale dans un problème concret ?", "À calculer une quantité totale accumulée.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Le calcul intégral sert à calculer une aire sous une courbe ou une quantité totale accumulée. Par exemple, si une fonction représente une vitesse, son intégrale peut donner une distance parcourue. Si elle représente un débit, l’intégrale peut donner un volume total."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On commence par repérer les bornes a et b, puis la fonction f. Ensuite, on cherche une primitive F de f et on applique la formule F(b) - F(a). La dernière étape est d’interpréter le résultat dans le contexte de l’exercice."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On utilise les intégrales dans les exercices d’aires, de valeur moyenne, de quantité accumulée, de physique, d’économie ou lorsqu’un graphique demande de calculer une surface sous une courbe."
                        )
                )
        );
    }

    private CourseContent fonctionExponentielle(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Fonction exponentielle",
                "La fonction exponentielle est une fonction fondamentale qui modélise de nombreuses croissances rapides. Sa particularité est d’être égale à sa propre dérivée.",
                List.of(
                        "La fonction exponentielle se note exp(x) ou e^x.",
                        "Elle est définie sur tout R.",
                        "Elle est toujours strictement positive.",
                        "Elle est strictement croissante.",
                        "Sa dérivée est elle-même.",
                        "Elle intervient dans les croissances, décroissances, intérêts composés et équations différentielles."
                ),
                List.of(
                        "Reconnaître une expression du type e^x ou e^{u(x)}.",
                        "Utiliser les propriétés de calcul de l’exponentielle.",
                        "Dériver correctement l’expression.",
                        "Étudier le signe de la dérivée pour les variations.",
                        "Utiliser le logarithme si l’inconnue est dans l’exposant."
                ),
                List.of(
                        "\\[ e^0=1 \\]",
                        "\\[ e^{a+b}=e^a e^b \\]",
                        "\\[ e^{a-b}=\\frac{e^a}{e^b} \\]",
                        "\\[ (e^x)'=e^x \\]",
                        "\\[ (e^{u(x)})'=u'(x)e^{u(x)} \\]",
                        "\\[ \\lim_{x\\to +\\infty} e^x=+\\infty \\]",
                        "\\[ \\lim_{x\\to -\\infty} e^x=0 \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Fonction exponentielle", youtube("Yvan Monka fonction exponentielle terminale")),
                        new VideoLink("Dériver une exponentielle", youtube("dérivée exponentielle terminale")),
                        new VideoLink("Exercices corrigés — Exponentielle", youtube("exercices corrigés exponentielle terminale"))
                ),
                List.of(
                        new QuizQuestion("Quelle est la dérivée de e^x ?", "La dérivée de e^x est e^x."),
                        new QuizQuestion("La fonction exponentielle peut-elle être négative ?", "Non, elle est toujours strictement positive."),
                        new QuizQuestion("Comment dérive-t-on e^{u(x)} ?", "On utilise u'(x)e^{u(x)}."),
                        new QuizQuestion("Pourquoi l’exponentielle est-elle importante ?", "Elle modélise des phénomènes d’évolution rapide.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La fonction exponentielle sert à modéliser des évolutions rapides : croissance d’une population, intérêts composés, refroidissement, décroissance radioactive ou évolution d’une quantité au cours du temps."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On l’utilise en reconnaissant les expressions avec e^x ou e^{u(x)}. Pour dériver e^{u(x)}, on multiplie par la dérivée de u. Pour résoudre une équation avec une inconnue en exposant, on utilise souvent le logarithme."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "Elle apparaît dans les études de fonctions, les équations différentielles, les modèles d’évolution et les problèmes avec taux de croissance ou de décroissance."
                        )
                )
        );
    }

    private CourseContent fonctionLogarithme(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Fonction logarithme népérien",
                "La fonction logarithme népérien, notée ln, est la fonction réciproque de l’exponentielle. Elle permet notamment de résoudre des équations où l’inconnue se trouve dans un exposant.",
                List.of(
                        "ln(x) est défini uniquement pour x > 0.",
                        "ln(1) = 0 et ln(e) = 1.",
                        "La fonction ln est strictement croissante.",
                        "Le logarithme transforme les produits en sommes.",
                        "Il est utilisé pour résoudre des équations exponentielles.",
                        "Il faut toujours vérifier le domaine de définition."
                ),
                List.of(
                        "Vérifier que ce qui est dans ln est strictement positif.",
                        "Utiliser les propriétés de calcul du logarithme.",
                        "Simplifier l’expression si possible.",
                        "Dériver avec la formule adaptée.",
                        "Résoudre l’équation puis vérifier la validité des solutions."
                ),
                List.of(
                        "\\[ \\ln(1)=0 \\]",
                        "\\[ \\ln(e)=1 \\]",
                        "\\[ \\ln(ab)=\\ln(a)+\\ln(b) \\]",
                        "\\[ \\ln\\left(\\frac{a}{b}\\right)=\\ln(a)-\\ln(b) \\]",
                        "\\[ \\ln(a^n)=n\\ln(a) \\]",
                        "\\[ (\\ln x)'=\\frac{1}{x} \\]",
                        "\\[ (\\ln(u(x)))'=\\frac{u'(x)}{u(x)} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Logarithme népérien", youtube("Yvan Monka logarithme népérien terminale")),
                        new VideoLink("Résoudre avec ln", youtube("résoudre équation logarithme terminale")),
                        new VideoLink("Exercices corrigés — Logarithme", youtube("exercices corrigés logarithme terminale"))
                ),
                List.of(
                        new QuizQuestion("Quel est le domaine de définition de ln(x) ?", "ln(x) est défini pour x > 0."),
                        new QuizQuestion("Combien vaut ln(1) ?", "ln(1) vaut 0."),
                        new QuizQuestion("Quelle est la dérivée de ln(x) ?", "C’est 1/x."),
                        new QuizQuestion("Quelle erreur faut-il éviter ?", "Utiliser ln sur un nombre négatif ou nul.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Le logarithme sert principalement à résoudre des équations où l’inconnue est dans un exposant. Il est aussi utilisé pour étudier certaines fonctions et simplifier des produits, quotients ou puissances."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Avant d’utiliser ln, on vérifie toujours que l’expression est strictement positive. Ensuite, on applique les propriétés : ln(ab), ln(a/b), ln(a^n), ou la formule de dérivée."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On le retrouve dans les résolutions d’équations exponentielles, les études de fonctions avec ln, les dérivées de ln(u) et les problèmes d’évolution."
                        )
                )
        );
    }

    private CourseContent suitesNumeriques(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Suites numériques",
                "Une suite numérique est une liste ordonnée de nombres. Elle permet de modéliser une évolution étape par étape, par exemple une population, un capital, une quantité ou un algorithme.",
                List.of(
                        "Une suite associe un nombre u_n à chaque entier n.",
                        "Une suite peut être définie par une formule explicite ou par récurrence.",
                        "Une suite arithmétique ajoute toujours la même raison.",
                        "Une suite géométrique multiplie toujours par la même raison.",
                        "On étudie souvent le sens de variation et la limite d’une suite."
                ),
                List.of(
                        "Identifier si la suite est explicite ou récurrente.",
                        "Calculer les premiers termes.",
                        "Reconnaître si elle est arithmétique ou géométrique.",
                        "Étudier les variations avec u_{n+1} - u_n.",
                        "Interpréter l’évolution de la suite."
                ),
                List.of(
                        "\\[ u_n=u_0+nr \\quad \\text{suite arithmétique} \\]",
                        "\\[ u_n=u_0q^n \\quad \\text{suite géométrique} \\]",
                        "\\[ u_{n+1}-u_n>0 \\Rightarrow (u_n) \\text{ croissante} \\]",
                        "\\[ u_{n+1}-u_n<0 \\Rightarrow (u_n) \\text{ décroissante} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Suites numériques", youtube("Yvan Monka suites numériques terminale")),
                        new VideoLink("Suites arithmétiques et géométriques", youtube("suites arithmétiques géométriques terminale")),
                        new VideoLink("Exercices corrigés — Suites", youtube("exercices corrigés suites terminale"))
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une suite arithmétique ?", "C’est une suite où l’on ajoute toujours le même nombre."),
                        new QuizQuestion("Qu’est-ce qu’une suite géométrique ?", "C’est une suite où l’on multiplie toujours par le même nombre."),
                        new QuizQuestion("Comment étudier les variations d’une suite ?", "On peut étudier le signe de u_{n+1} - u_n."),
                        new QuizQuestion("Quelle différence entre explicite et récurrence ?", "Une formule explicite donne directement u_n, une récurrence utilise le terme précédent.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les suites servent à modéliser des phénomènes qui évoluent étape par étape : une population chaque année, un capital chaque mois, une quantité produite ou un algorithme qui répète une action."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On commence par comprendre comment passer d’un terme au suivant. Si on ajoute toujours le même nombre, la suite est arithmétique. Si on multiplie toujours par le même nombre, elle est géométrique."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "Les suites apparaissent dans les problèmes d’évolution, d’algorithmes, de placements financiers, de populations et dans les questions de limite."
                        )
                )
        );
    }

    private CourseContent limitesSuites(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Limites de suites",
                "La limite d’une suite décrit le comportement de ses termes lorsque n devient très grand. Une suite peut se rapprocher d’un nombre réel, tendre vers l’infini ou ne pas avoir de limite.",
                List.of(
                        "Une suite convergente se rapproche d’une valeur finie.",
                        "Une suite divergente peut tendre vers +∞ ou -∞.",
                        "Les suites géométriques ont des limites différentes selon la raison q.",
                        "Les théorèmes de comparaison permettent de déterminer certaines limites.",
                        "Il ne faut pas juger une limite uniquement avec les premiers termes."
                ),
                List.of(
                        "Identifier l’expression de la suite.",
                        "Reconnaître les suites de référence.",
                        "Étudier les termes dominants.",
                        "Appliquer les règles de limites.",
                        "Conclure sur la convergence ou la divergence."
                ),
                List.of(
                        "\\[ \\lim_{n\\to +\\infty}\\frac{1}{n}=0 \\]",
                        "\\[ \\lim_{n\\to +\\infty}n=+\\infty \\]",
                        "\\[ -1<q<1 \\Rightarrow \\lim_{n\\to+\\infty}q^n=0 \\]",
                        "\\[ q>1 \\Rightarrow \\lim_{n\\to+\\infty}q^n=+\\infty \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Limites de suites", youtube("Yvan Monka limites de suites terminale")),
                        new VideoLink("Méthode limites de suites", youtube("limites de suites terminale méthode")),
                        new VideoLink("Exercices corrigés — Limites de suites", youtube("exercices corrigés limites de suites terminale"))
                ),
                List.of(
                        new QuizQuestion("Que signifie u_n tend vers L ?", "Les termes de la suite se rapprochent de L quand n devient grand."),
                        new QuizQuestion("Quelle est la limite de 1/n ?", "Elle vaut 0."),
                        new QuizQuestion("Que devient q^n si -1 < q < 1 ?", "La suite tend vers 0."),
                        new QuizQuestion("Quelle erreur faut-il éviter ?", "Confondre les premiers termes avec le comportement à l’infini.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La limite d’une suite sert à savoir ce que devient une évolution sur le long terme. On peut savoir si une quantité se stabilise, augmente sans limite ou diminue vers zéro."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère la forme de la suite, puis on utilise les limites connues. Pour une suite géométrique, tout dépend de la raison q. Pour les fractions, on regarde souvent les termes dominants."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les problèmes de population, de suites géométriques, d’algorithmes, de placements financiers et pour interpréter une évolution à long terme."
                        )
                )
        );
    }

    private CourseContent limitesFonctions(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Limites de fonctions",
                "La limite d’une fonction décrit son comportement lorsqu’une variable se rapproche d’une valeur ou part vers l’infini. Elle permet de comprendre les asymptotes et les comportements extrêmes.",
                List.of(
                        "On peut étudier une limite en un réel ou à l’infini.",
                        "Une limite peut être finie ou infinie.",
                        "Les formes indéterminées doivent être transformées.",
                        "Les termes dominants sont essentiels à l’infini.",
                        "Les limites permettent d’identifier des asymptotes."
                ),
                List.of(
                        "Identifier vers quoi tend x.",
                        "Remplacer mentalement pour repérer la forme.",
                        "Factoriser ou simplifier en cas de forme indéterminée.",
                        "Utiliser les limites de référence.",
                        "Conclure graphiquement si nécessaire."
                ),
                List.of(
                        "\\[ \\lim_{x\\to+\\infty}x^n=+\\infty \\]",
                        "\\[ \\lim_{x\\to+\\infty}\\frac{1}{x}=0 \\]",
                        "\\[ \\lim_{x\\to+\\infty}e^x=+\\infty \\]",
                        "\\[ \\lim_{x\\to+\\infty}\\ln(x)=+\\infty \\]",
                        "\\[ \\lim_{x\\to0^+}\\ln(x)=-\\infty \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Limites de fonctions", youtube("Yvan Monka limites de fonctions terminale")),
                        new VideoLink("Formes indéterminées", youtube("formes indéterminées terminale limites")),
                        new VideoLink("Exercices corrigés — Limites de fonctions", youtube("exercices corrigés limites de fonctions terminale"))
                ),
                List.of(
                        new QuizQuestion("À quoi sert une limite de fonction ?", "Elle décrit le comportement d’une fonction près d’un point ou à l’infini."),
                        new QuizQuestion("Que faire avec une forme indéterminée ?", "Il faut transformer l’expression."),
                        new QuizQuestion("Quelle limite vaut lim 1/x en +∞ ?", "Elle vaut 0."),
                        new QuizQuestion("Quelle notion graphique est liée aux limites ?", "Les asymptotes.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les limites de fonctions servent à comprendre le comportement d’une courbe quand x devient très grand, très petit, ou se rapproche d’une valeur interdite. Elles permettent aussi d’étudier les asymptotes."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On regarde vers quoi tend x, puis on simplifie l’expression si nécessaire. En cas de forme indéterminée, on factorise, on développe ou on utilise les termes dominants."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On les utilise dans les études de fonctions, les tableaux de variations, les asymptotes verticales ou horizontales et l’analyse graphique."
                        )
                )
        );
    }

    private CourseContent continuite(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Continuité",
                "Une fonction continue est une fonction dont la courbe ne présente pas de rupture. La continuité est essentielle pour prouver qu’une équation possède au moins une solution.",
                List.of(
                        "Une fonction continue se trace sans rupture sur un intervalle.",
                        "Les fonctions usuelles sont continues sur leur domaine.",
                        "Le théorème des valeurs intermédiaires permet de prouver l’existence d’une solution.",
                        "Si la fonction est continue et strictement monotone, la solution est unique.",
                        "La continuité est souvent utilisée avec un tableau de variations."
                ),
                List.of(
                        "Vérifier que la fonction est continue sur l’intervalle.",
                        "Calculer les images aux bornes.",
                        "Vérifier que la valeur cherchée est comprise entre les deux images.",
                        "Appliquer le théorème des valeurs intermédiaires.",
                        "Ajouter la stricte monotonie pour prouver l’unicité."
                ),
                List.of(
                        "\\[ f \\text{ continue sur } [a;b] \\]",
                        "\\[ k \\text{ entre } f(a) \\text{ et } f(b) \\Rightarrow \\exists c\\in[a;b], f(c)=k \\]",
                        "\\[ \\text{continue + strictement monotone} \\Rightarrow \\text{solution unique} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Continuité", youtube("Yvan Monka continuité terminale")),
                        new VideoLink("Théorème des valeurs intermédiaires", youtube("théorème des valeurs intermédiaires terminale")),
                        new VideoLink("Exercices corrigés — Continuité", youtube("exercices corrigés continuité terminale"))
                ),
                List.of(
                        new QuizQuestion("Que signifie graphiquement la continuité ?", "La courbe ne présente pas de rupture."),
                        new QuizQuestion("À quoi sert le théorème des valeurs intermédiaires ?", "À prouver l’existence d’une solution."),
                        new QuizQuestion("Quand la solution est-elle unique ?", "Quand la fonction est continue et strictement monotone."),
                        new QuizQuestion("Quelle condition ne faut-il pas oublier ?", "La continuité sur l’intervalle étudié.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La continuité sert surtout à prouver qu’une équation a une solution, même quand on ne sait pas la trouver directement. Elle permet de dire qu’une courbe passe forcément par certaines valeurs."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On vérifie que la fonction est continue sur un intervalle, puis on regarde les valeurs aux bornes. Si la valeur cherchée est entre les deux, le théorème des valeurs intermédiaires garantit une solution."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les questions d’existence de solution, les équations du type f(x)=k, les tableaux de variations et les preuves d’unicité."
                        )
                )
        );
    }

    private CourseContent derivationConvexite(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Dérivation et convexité",
                "La dérivation permet d’étudier les variations d’une fonction. La convexité permet d’analyser la forme de la courbe grâce à la dérivée seconde.",
                List.of(
                        "La dérivée donne le coefficient directeur de la tangente.",
                        "Le signe de la dérivée donne les variations.",
                        "La dérivée seconde permet d’étudier la convexité.",
                        "Une fonction est convexe si sa courbe est tournée vers le haut.",
                        "Un point d’inflexion correspond à un changement de convexité."
                ),
                List.of(
                        "Calculer f'(x).",
                        "Étudier le signe de f'(x).",
                        "Construire le tableau de variations.",
                        "Calculer f''(x) si la convexité est demandée.",
                        "Étudier le signe de f''(x)."
                ),
                List.of(
                        "\\[ f'(x)>0 \\Rightarrow f \\text{ croissante} \\]",
                        "\\[ f'(x)<0 \\Rightarrow f \\text{ décroissante} \\]",
                        "\\[ f''(x)>0 \\Rightarrow f \\text{ convexe} \\]",
                        "\\[ f''(x)<0 \\Rightarrow f \\text{ concave} \\]",
                        "\\[ y=f'(a)(x-a)+f(a) \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Dérivation Terminale", youtube("Yvan Monka dérivation terminale")),
                        new VideoLink("Yvan Monka — Convexité", youtube("Yvan Monka convexité terminale")),
                        new VideoLink("Exercices corrigés — Dérivation convexité", youtube("exercices corrigés dérivation convexité terminale"))
                ),
                List.of(
                        new QuizQuestion("À quoi sert la dérivée ?", "À étudier les variations et les tangentes."),
                        new QuizQuestion("Que signifie f'(x) > 0 ?", "La fonction est croissante."),
                        new QuizQuestion("Que signifie f''(x) > 0 ?", "La fonction est convexe."),
                        new QuizQuestion("Qu’est-ce qu’un point d’inflexion ?", "Un point où la convexité change.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La dérivation sert à comprendre comment une fonction évolue : elle augmente, diminue, atteint un maximum ou un minimum. La convexité sert à comprendre la forme de la courbe."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On calcule d’abord la dérivée f'(x), puis on étudie son signe pour obtenir les variations. Pour la convexité, on calcule f''(x) et on regarde si elle est positive ou négative."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les études de fonctions, les tableaux de variations, les tangentes, les maximums/minimums et les questions sur la convexité ou les points d’inflexion."
                        )
                )
        );
    }

    private CourseContent primitives(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Primitives",
                "Une primitive d’une fonction f est une fonction F dont la dérivée est f. Les primitives sont indispensables pour calculer des intégrales et résoudre des équations différentielles.",
                List.of(
                        "F est une primitive de f si F' = f.",
                        "Une fonction possède plusieurs primitives.",
                        "Deux primitives d’une même fonction diffèrent d’une constante.",
                        "Les primitives permettent de calculer des intégrales.",
                        "Il faut reconnaître les formes usuelles."
                ),
                List.of(
                        "Identifier la fonction à primitiver.",
                        "Reconnaître une forme connue.",
                        "Écrire une primitive possible.",
                        "Ajouter +C si on demande toutes les primitives.",
                        "Vérifier en dérivant."
                ),
                List.of(
                        "\\[ F'=f \\]",
                        "\\[ \\int x^n dx=\\frac{x^{n+1}}{n+1}+C \\quad n\\neq -1 \\]",
                        "\\[ \\int e^x dx=e^x+C \\]",
                        "\\[ \\int \\frac{1}{x}dx=\\ln(x)+C \\quad x>0 \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Primitives", youtube("Yvan Monka primitives terminale")),
                        new VideoLink("Tableau des primitives", youtube("tableau primitives terminale")),
                        new VideoLink("Exercices corrigés — Primitives", youtube("exercices corrigés primitives terminale"))
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une primitive de f ?", "C’est une fonction F telle que F' = f."),
                        new QuizQuestion("Deux primitives diffèrent de quoi ?", "D’une constante."),
                        new QuizQuestion("Comment vérifier une primitive ?", "On la dérive."),
                        new QuizQuestion("Pourquoi les primitives sont-elles utiles ?", "Pour calculer des intégrales.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les primitives servent à faire l’opération inverse de la dérivation. Elles sont surtout utiles pour calculer des intégrales et résoudre certaines équations différentielles."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On cherche une fonction F qui, une fois dérivée, redonne la fonction f. Pour vérifier, il suffit de dériver la primitive proposée."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On les utilise dans les calculs d’intégrales, les tableaux de primitives, les problèmes d’aire et les équations différentielles."
                        )
                )
        );
    }

    private CourseContent equationsDifferentielles(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Équations différentielles",
                "Une équation différentielle est une équation dont l’inconnue est une fonction et dans laquelle apparaît sa dérivée. Elle sert à modéliser des phénomènes d’évolution.",
                List.of(
                        "L’inconnue est une fonction.",
                        "L’équation relie souvent une fonction et sa dérivée.",
                        "Les solutions de y' = ay sont des fonctions exponentielles.",
                        "Une condition initiale permet de trouver une solution unique.",
                        "Ces équations modélisent des croissances, décroissances ou refroidissements."
                ),
                List.of(
                        "Identifier le type d’équation.",
                        "Utiliser la forme générale de la solution.",
                        "Appliquer la condition initiale.",
                        "Déterminer la constante.",
                        "Interpréter la solution."
                ),
                List.of(
                        "\\[ y'=ay \\Rightarrow y(x)=Ce^{ax} \\]",
                        "\\[ y'=ay+b \\Rightarrow y(x)=Ce^{ax}-\\frac{b}{a} \\quad a\\neq0 \\]",
                        "\\[ y(0)=y_0 \\Rightarrow \\text{permet de déterminer } C \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Équations différentielles", youtube("Yvan Monka équations différentielles terminale")),
                        new VideoLink("Méthode équations différentielles", youtube("équations différentielles terminale méthode")),
                        new VideoLink("Exercices corrigés — Équations différentielles", youtube("exercices corrigés équations différentielles terminale"))
                ),
                List.of(
                        new QuizQuestion("Quelle est l’inconnue dans une équation différentielle ?", "Une fonction."),
                        new QuizQuestion("Quelle est la solution de y' = ay ?", "y(x) = Ce^{ax}."),
                        new QuizQuestion("À quoi sert une condition initiale ?", "À déterminer la constante C."),
                        new QuizQuestion("Pourquoi utilise-t-on ces équations ?", "Pour modéliser des phénomènes d’évolution.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les équations différentielles servent à modéliser une quantité qui évolue selon sa propre variation : population, température, radioactivité, vitesse ou croissance."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On reconnaît le type d’équation, par exemple y'=ay. Ensuite, on écrit la forme générale de la solution, puis on utilise une condition initiale pour trouver la constante."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On les retrouve dans les problèmes de modélisation, de croissance exponentielle, de décroissance, de refroidissement ou d’évolution d’une grandeur."
                        )
                )
        );
    }

    private CourseContent variablesAleatoires(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Variables aléatoires",
                "Une variable aléatoire associe un nombre à chaque issue d’une expérience aléatoire. Elle permet de modéliser des gains, des pertes ou des résultats numériques dépendant du hasard.",
                List.of(
                        "Une variable aléatoire transforme une issue en nombre.",
                        "La loi de probabilité donne les valeurs possibles et leurs probabilités.",
                        "L’espérance représente une moyenne théorique.",
                        "La variance mesure la dispersion.",
                        "L’écart-type mesure la dispersion dans la même unité que la variable."
                ),
                List.of(
                        "Lister les valeurs possibles.",
                        "Déterminer la probabilité de chaque valeur.",
                        "Construire la loi de probabilité.",
                        "Calculer l’espérance.",
                        "Interpréter le résultat dans le contexte."
                ),
                List.of(
                        "\\[ \\mathbb{E}(X)=\\sum x_i p_i \\]",
                        "\\[ V(X)=\\sum p_i(x_i-\\mathbb{E}(X))^2 \\]",
                        "\\[ \\sigma(X)=\\sqrt{V(X)} \\]",
                        "\\[ \\sum p_i=1 \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Variables aléatoires", youtube("Yvan Monka variables aléatoires terminale")),
                        new VideoLink("Espérance variance écart-type", youtube("espérance variance écart type terminale")),
                        new VideoLink("Exercices corrigés — Variables aléatoires", youtube("exercices corrigés variables aléatoires terminale"))
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une variable aléatoire ?", "Elle associe une valeur numérique à chaque issue."),
                        new QuizQuestion("Que représente l’espérance ?", "Une moyenne théorique à long terme."),
                        new QuizQuestion("Que mesure la variance ?", "La dispersion autour de l’espérance."),
                        new QuizQuestion("Quelle condition vérifient les probabilités ?", "Leur somme vaut 1.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les variables aléatoires servent à transformer une situation de hasard en valeurs numériques. Elles permettent par exemple de calculer un gain moyen, une perte moyenne ou un résultat attendu."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On liste les valeurs possibles de la variable, puis on associe une probabilité à chaque valeur. Ensuite, on peut calculer l’espérance, la variance ou l’écart-type."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On les utilise dans les jeux de hasard, les gains, les probabilités, les expériences aléatoires et les situations où un résultat numérique dépend du hasard."
                        )
                )
        );
    }

    private CourseContent loiBinomiale(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Loi binomiale",
                "La loi binomiale modélise le nombre de succès obtenus lors de la répétition indépendante d’une même expérience à deux issues : succès ou échec.",
                List.of(
                        "Une épreuve de Bernoulli a deux issues.",
                        "La loi binomiale compte le nombre de succès.",
                        "Les répétitions doivent être indépendantes.",
                        "Le nombre de répétitions est n.",
                        "La probabilité du succès est p."
                ),
                List.of(
                        "Identifier ce qu’on appelle succès.",
                        "Déterminer n.",
                        "Déterminer p.",
                        "Vérifier l’indépendance.",
                        "Utiliser la formule ou la calculatrice."
                ),
                List.of(
                        "\\[ X\\sim\\mathcal{B}(n,p) \\]",
                        "\\[ P(X=k)=\\binom{n}{k}p^k(1-p)^{n-k} \\]",
                        "\\[ \\mathbb{E}(X)=np \\]",
                        "\\[ V(X)=np(1-p) \\]",
                        "\\[ \\sigma(X)=\\sqrt{np(1-p)} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Loi binomiale", youtube("Yvan Monka loi binomiale terminale")),
                        new VideoLink("Calculatrice loi binomiale", youtube("calculatrice loi binomiale terminale")),
                        new VideoLink("Exercices corrigés — Loi binomiale", youtube("exercices corrigés loi binomiale terminale"))
                ),
                List.of(
                        new QuizQuestion("Que modélise la loi binomiale ?", "Le nombre de succès dans n répétitions indépendantes."),
                        new QuizQuestion("Que signifie X suit B(n,p) ?", "X suit une loi binomiale de paramètres n et p."),
                        new QuizQuestion("Quelle est l’espérance ?", "E(X)=np."),
                        new QuizQuestion("Quelle condition est essentielle ?", "Les répétitions doivent être indépendantes.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La loi binomiale sert à calculer la probabilité d’obtenir un certain nombre de succès après plusieurs répétitions d’une même expérience."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On identifie le succès, le nombre de répétitions n et la probabilité p. Si les répétitions sont indépendantes, on peut utiliser la formule de la loi binomiale ou la calculatrice."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On la retrouve dans les tirages, les sondages, les tests, les expériences répétées et les problèmes où l’on compte un nombre de réussites."
                        )
                )
        );
    }

    private CourseContent sommesVariablesAleatoires(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Sommes de variables aléatoires",
                "Ce chapitre étudie ce qui se passe lorsqu’on additionne plusieurs variables aléatoires. Il permet notamment de calculer l’espérance et la variance d’une somme.",
                List.of(
                        "L’espérance est linéaire.",
                        "L’espérance d’une somme est la somme des espérances.",
                        "La variance d’une somme s’additionne si les variables sont indépendantes.",
                        "Ce chapitre est utile pour les expériences répétées.",
                        "Il prépare à la loi des grands nombres."
                ),
                List.of(
                        "Identifier les variables aléatoires.",
                        "Calculer leurs espérances.",
                        "Utiliser la linéarité de l’espérance.",
                        "Vérifier l’indépendance pour les variances.",
                        "Interpréter le résultat."
                ),
                List.of(
                        "\\[ \\mathbb{E}(X+Y)=\\mathbb{E}(X)+\\mathbb{E}(Y) \\]",
                        "\\[ \\mathbb{E}(aX+b)=a\\mathbb{E}(X)+b \\]",
                        "\\[ V(X+Y)=V(X)+V(Y) \\quad \\text{si X et Y sont indépendantes} \\]"
                ),
                List.of(
                        new VideoLink("Sommes de variables aléatoires", youtube("sommes de variables aléatoires terminale")),
                        new VideoLink("Espérance d’une somme", youtube("espérance somme variables aléatoires terminale")),
                        new VideoLink("Exercices corrigés — Sommes de variables", youtube("exercices corrigés somme variables aléatoires terminale"))
                ),
                List.of(
                        new QuizQuestion("Que vaut E(X+Y) ?", "E(X+Y)=E(X)+E(Y)."),
                        new QuizQuestion("Quand peut-on additionner les variances ?", "Quand les variables sont indépendantes."),
                        new QuizQuestion("Pourquoi ce chapitre est important ?", "Il permet d’étudier des répétitions d’expériences."),
                        new QuizQuestion("Quelle propriété est essentielle ?", "La linéarité de l’espérance.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les sommes de variables aléatoires servent à étudier un résultat total obtenu en additionnant plusieurs résultats aléatoires, comme plusieurs gains ou plusieurs répétitions d’une expérience."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On calcule les espérances séparément puis on les additionne. Pour les variances, il faut vérifier l’indépendance avant de les additionner."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les répétitions d’expériences, les gains cumulés, les sommes de résultats aléatoires et les situations qui préparent à la loi des grands nombres."
                        )
                )
        );
    }

    private CourseContent concentrationLoiGrandsNombres(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Concentration et loi des grands nombres",
                "La loi des grands nombres explique que lorsqu’on répète une expérience aléatoire un grand nombre de fois, la moyenne observée se rapproche de l’espérance théorique.",
                List.of(
                        "La moyenne expérimentale se stabilise quand le nombre d’essais augmente.",
                        "La fréquence observée se rapproche de la probabilité théorique.",
                        "La variance de la moyenne diminue quand n augmente.",
                        "Ce chapitre justifie les estimations statistiques.",
                        "Plus l’échantillon est grand, plus la moyenne devient fiable."
                ),
                List.of(
                        "Identifier l’expérience répétée.",
                        "Identifier la variable étudiée.",
                        "Calculer ou repérer l’espérance.",
                        "Comprendre ce que représente la moyenne.",
                        "Interpréter la stabilité quand n augmente."
                ),
                List.of(
                        "\\[ M_n=\\frac{X_1+X_2+...+X_n}{n} \\]",
                        "\\[ \\mathbb{E}(M_n)=\\mathbb{E}(X) \\]",
                        "\\[ V(M_n)=\\frac{V(X)}{n} \\]",
                        "\\[ n \\text{ grand } \\Rightarrow M_n \\text{ proche de } \\mathbb{E}(X) \\]"
                ),
                List.of(
                        new VideoLink("Loi des grands nombres", youtube("loi des grands nombres terminale")),
                        new VideoLink("Concentration probabilités Terminale", youtube("concentration probabilités terminale")),
                        new VideoLink("Exercices corrigés — Loi des grands nombres", youtube("exercices corrigés loi des grands nombres terminale"))
                ),
                List.of(
                        new QuizQuestion("Que dit la loi des grands nombres ?", "La moyenne observée se rapproche de l’espérance quand n augmente."),
                        new QuizQuestion("Que se passe-t-il quand n augmente ?", "La variance de la moyenne diminue."),
                        new QuizQuestion("Pourquoi ce chapitre est utile ?", "Il justifie les estimations sur grands échantillons."),
                        new QuizQuestion("Quelle est l’idée principale ?", "Plus on répète, plus la moyenne est stable.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La loi des grands nombres sert à comprendre pourquoi les statistiques deviennent plus fiables quand on augmente le nombre d’expériences ou la taille d’un échantillon."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On étudie une moyenne de résultats aléatoires. Plus le nombre de répétitions augmente, plus cette moyenne se rapproche de l’espérance."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les sondages, les simulations, les expériences répétées et les problèmes où l’on veut justifier qu’une moyenne observée devient stable."
                        )
                )
        );
    }

    private CourseContent combinatoireDenombrement(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Combinatoire et dénombrement",
                "La combinatoire sert à compter le nombre de possibilités dans une situation. Elle est essentielle en probabilités, car calculer une probabilité revient souvent à compter les cas favorables et les cas possibles.",
                List.of(
                        "Le dénombrement consiste à compter sans oublier ni répéter.",
                        "L’ordre peut compter ou non selon la situation.",
                        "Une combinaison ne tient pas compte de l’ordre.",
                        "Le coefficient binomial compte le nombre de choix possibles.",
                        "La combinatoire est utilisée dans la loi binomiale."
                ),
                List.of(
                        "Identifier si l’ordre compte.",
                        "Identifier s’il y a répétition.",
                        "Choisir la formule adaptée.",
                        "Calculer le nombre de cas possibles.",
                        "Utiliser le résultat dans une probabilité."
                ),
                List.of(
                        "\\[ n!=1\\times2\\times...\\times n \\]",
                        "\\[ \\binom{n}{k}=\\frac{n!}{k!(n-k)!} \\]",
                        "\\[ \\binom{n}{0}=1 \\]",
                        "\\[ \\binom{n}{n}=1 \\]",
                        "\\[ \\binom{n}{k}=\\binom{n}{n-k} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Combinatoire", youtube("Yvan Monka combinatoire dénombrement terminale")),
                        new VideoLink("Coefficients binomiaux", youtube("coefficients binomiaux terminale")),
                        new VideoLink("Exercices corrigés — Dénombrement", youtube("exercices corrigés dénombrement terminale"))
                ),
                List.of(
                        new QuizQuestion("À quoi sert la combinatoire ?", "À compter le nombre de possibilités."),
                        new QuizQuestion("Que signifie C(n,k) ?", "Le nombre de façons de choisir k éléments parmi n."),
                        new QuizQuestion("Quelle question faut-il se poser ?", "Est-ce que l’ordre compte ?"),
                        new QuizQuestion("Où utilise-t-on la combinatoire ?", "En probabilités, notamment avec la loi binomiale.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La combinatoire sert à compter rapidement le nombre de possibilités sans tout lister à la main. C’est très utile pour calculer des probabilités."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "La première question est de savoir si l’ordre compte. Ensuite, on choisit la formule adaptée : factorielle, coefficient binomial ou raisonnement par cas."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les tirages, les choix de groupes, les arrangements, les probabilités et la loi binomiale."
                        )
                )
        );
    }

    private CourseContent vecteursDroitesPlans(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Vecteurs, droites et plans de l’espace",
                "Ce chapitre généralise la géométrie du plan à l’espace. Les vecteurs permettent de décrire des points, des droites, des plans et des positions en trois dimensions.",
                List.of(
                        "Un point de l’espace possède trois coordonnées.",
                        "Un vecteur de l’espace possède trois coordonnées.",
                        "Une droite peut être définie par un point et un vecteur directeur.",
                        "Un plan peut être défini par un point et deux vecteurs non colinéaires.",
                        "La colinéarité permet d’étudier alignement et parallélisme."
                ),
                List.of(
                        "Calculer les coordonnées de vecteurs.",
                        "Tester la colinéarité.",
                        "Écrire une représentation paramétrique de droite.",
                        "Identifier un plan avec deux directions.",
                        "Interpréter géométriquement le résultat."
                ),
                List.of(
                        "\\[ \\overrightarrow{AB}(x_B-x_A;y_B-y_A;z_B-z_A) \\]",
                        "\\[ M\\in d \\Rightarrow \\overrightarrow{AM}=t\\vec{u} \\]",
                        "\\[ \\vec{u}=k\\vec{v} \\Rightarrow \\vec{u} \\text{ et } \\vec{v} \\text{ colinéaires} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Géométrie dans l’espace", youtube("Yvan Monka vecteurs droites plans espace terminale")),
                        new VideoLink("Droites et plans de l’espace", youtube("droites plans espace terminale")),
                        new VideoLink("Exercices corrigés — Vecteurs espace", youtube("exercices corrigés vecteurs espace terminale"))
                ),
                List.of(
                        new QuizQuestion("Combien de coordonnées possède un point de l’espace ?", "Trois coordonnées."),
                        new QuizQuestion("Comment définir une droite ?", "Avec un point et un vecteur directeur."),
                        new QuizQuestion("Comment tester la colinéarité ?", "On vérifie si un vecteur est un multiple de l’autre."),
                        new QuizQuestion("À quoi sert une représentation paramétrique ?", "À décrire tous les points d’une droite.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La géométrie dans l’espace sert à étudier des objets en trois dimensions : droites, plans, points, parallélisme, alignement et intersections."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On utilise les coordonnées des points et des vecteurs. Une droite se décrit souvent avec un point et un vecteur directeur. Un plan peut se décrire avec un point et deux directions."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour tester l’alignement, montrer que deux droites sont parallèles, écrire une droite paramétrique ou étudier une position relative dans l’espace."
                        )
                )
        );
    }

    private CourseContent orthogonaliteDistances(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Orthogonalité et distances dans l’espace",
                "Ce chapitre utilise le produit scalaire pour étudier les angles, l’orthogonalité et les distances dans l’espace.",
                List.of(
                        "Le produit scalaire permet de tester l’orthogonalité.",
                        "Deux vecteurs sont orthogonaux si leur produit scalaire vaut 0.",
                        "La norme d’un vecteur donne sa longueur.",
                        "La distance entre deux points se calcule avec leurs coordonnées.",
                        "Un vecteur normal est perpendiculaire à un plan."
                ),
                List.of(
                        "Calculer les coordonnées des vecteurs.",
                        "Calculer le produit scalaire.",
                        "Tester s’il vaut 0.",
                        "Calculer une norme ou une distance.",
                        "Conclure géométriquement."
                ),
                List.of(
                        "\\[ \\vec{u}\\cdot\\vec{v}=xx'+yy'+zz' \\]",
                        "\\[ \\vec{u}\\perp\\vec{v} \\Leftrightarrow \\vec{u}\\cdot\\vec{v}=0 \\]",
                        "\\[ \\|\\vec{u}\\|=\\sqrt{x^2+y^2+z^2} \\]",
                        "\\[ AB=\\sqrt{(x_B-x_A)^2+(y_B-y_A)^2+(z_B-z_A)^2} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Produit scalaire espace", youtube("Yvan Monka produit scalaire espace terminale")),
                        new VideoLink("Orthogonalité dans l’espace", youtube("orthogonalité distance espace terminale")),
                        new VideoLink("Exercices corrigés — Distances espace", youtube("exercices corrigés distances espace terminale"))
                ),
                List.of(
                        new QuizQuestion("Quand deux vecteurs sont-ils orthogonaux ?", "Quand leur produit scalaire vaut 0."),
                        new QuizQuestion("Que représente la norme ?", "La longueur du vecteur."),
                        new QuizQuestion("Comment calcule-t-on une distance entre deux points ?", "Avec la formule utilisant les différences de coordonnées."),
                        new QuizQuestion("Qu’est-ce qu’un vecteur normal ?", "Un vecteur perpendiculaire à un plan.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à calculer des distances, montrer que deux directions sont perpendiculaires et comprendre les relations d’orthogonalité dans l’espace."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On calcule le produit scalaire de deux vecteurs. S’il vaut zéro, les vecteurs sont orthogonaux. Pour les distances, on utilise la formule avec les coordonnées."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour prouver des angles droits, calculer des longueurs, trouver des distances entre points et travailler avec des plans perpendiculaires."
                        )
                )
        );
    }

    private CourseContent equationsDroitesPlans(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Équations de droites et de plans",
                "Ce chapitre apprend à décrire les droites et les plans de l’espace avec des équations paramétriques et cartésiennes.",
                List.of(
                        "Une droite de l’espace se décrit souvent par une représentation paramétrique.",
                        "Un plan peut être décrit par une équation cartésienne.",
                        "Un vecteur directeur sert à définir une droite.",
                        "Un vecteur normal sert à définir un plan.",
                        "Les systèmes permettent d’étudier les intersections."
                ),
                List.of(
                        "Pour une droite, repérer un point et un vecteur directeur.",
                        "Écrire les trois équations paramétriques.",
                        "Pour un plan, repérer un vecteur normal.",
                        "Utiliser la forme ax + by + cz + d = 0.",
                        "Tester l’appartenance par substitution."
                ),
                List.of(
                        "\\[ d:\\begin{cases} x=x_A+ta \\\\ y=y_A+tb \\\\ z=z_A+tc \\end{cases} \\]",
                        "\\[ P: ax+by+cz+d=0 \\]",
                        "\\[ \\vec{n}(a;b;c) \\text{ est un vecteur normal au plan } P \\]",
                        "\\[ M(x;y;z)\\in P \\Leftrightarrow ax+by+cz+d=0 \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Droites et plans", youtube("Yvan Monka équations droites plans espace terminale")),
                        new VideoLink("Représentation paramétrique", youtube("représentation paramétrique droite espace terminale")),
                        new VideoLink("Équation cartésienne d’un plan", youtube("équation cartésienne plan terminale"))
                ),
                List.of(
                        new QuizQuestion("Quelle forme utilise-t-on pour une droite ?", "Une représentation paramétrique."),
                        new QuizQuestion("Quelle est la forme d’une équation de plan ?", "ax + by + cz + d = 0."),
                        new QuizQuestion("À quoi sert un vecteur normal ?", "À écrire l’équation d’un plan."),
                        new QuizQuestion("Comment tester si un point appartient à un plan ?", "On remplace ses coordonnées dans l’équation.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les équations de droites et de plans servent à décrire précisément des objets de l’espace avec des coordonnées. Cela permet de calculer des intersections et de tester des appartenances."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Pour une droite, on utilise un point et un vecteur directeur. Pour un plan, on utilise souvent un vecteur normal et une équation de la forme ax + by + cz + d = 0."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour écrire une droite, écrire un plan, tester si un point appartient à un objet, chercher une intersection ou étudier des positions relatives."
                        )
                )
        );
    }

    private CourseContent coursMathEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de mathématiques en préparation",
                "Ce chapitre de mathématiques n’a pas encore été ajouté dans la version complète.",
                List.of(
                        "Chapitre non encore rédigé en version complète.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les chapitres principaux de Terminale mathématiques sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Utiliser les vidéos proposées en attendant.",
                        "Créer une fiche personnelle sur ce chapitre."
                ),
                List.of(
                        "Aucune formule détaillée disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("Yvan Monka terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider mathématiques.")
                ),
                "math",
                List.of(
                        new ExplanationBlock(
                                "Cours en préparation",
                                "Ce chapitre sera rédigé dans une prochaine mise à jour avec un vrai cours, une méthode, des exemples, des vidéos et un quiz."
                        )
                )
        );
    }
}