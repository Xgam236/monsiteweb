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

        if (c.contains("calcul integral")) {
            return calculIntegral(matiere, chapitre);
        }

        if (c.contains("fonction exponentielle")) {
            return exponentielle(matiere, chapitre);
        }

        if (c.contains("fonction logarithme")) {
            return logarithme(matiere, chapitre);
        }

        if (c.contains("suites numeriques")) {
            return suitesNumeriques(matiere, chapitre);
        }

        if (c.contains("limites de suites")) {
            return limitesSuites(matiere, chapitre);
        }

        if (c.contains("limites de fonctions")) {
            return limitesFonctions(matiere, chapitre);
        }

        if (c.contains("continuite")) {
            return continuite(matiere, chapitre);
        }

        if (c.contains("derivation") || c.contains("convexite")) {
            return derivationConvexite(matiere, chapitre);
        }

        if (c.contains("primitives")) {
            return primitives(matiere, chapitre);
        }

        if (c.contains("equations differentielles")) {
            return equationsDifferentielles(matiere, chapitre);
        }

        if (c.contains("variables aleatoires")) {
            return variablesAleatoires(matiere, chapitre);
        }

        if (c.contains("loi binomiale")) {
            return loiBinomiale(matiere, chapitre);
        }

        if (c.contains("sommes de variables")) {
            return sommesVariables(matiere, chapitre);
        }

        if (c.contains("concentration") || c.contains("loi des grands nombres")) {
            return concentration(matiere, chapitre);
        }

        if (c.contains("combinatoire") || c.contains("denombrement")) {
            return combinatoire(matiere, chapitre);
        }

        if (c.contains("vecteurs") || c.contains("droites et plans")) {
            return vecteursDroitesPlans(matiere, chapitre);
        }

        if (c.contains("orthogonalite") || c.contains("distances")) {
            return orthogonaliteDistances(matiere, chapitre);
        }

        if (c.contains("equations de droites") || c.contains("equations de plans")) {
            return equationsDroitesPlans(matiere, chapitre);
        }

        return mathsGeneral(matiere, chapitre);
    }

    private CourseContent calculIntegral(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Calcul intégral",
                "Le calcul intégral permet de calculer une aire sous une courbe, une accumulation ou une quantité totale à partir d’une fonction. En Terminale, on relie surtout l’intégrale à la notion de primitive.",
                List.of(
                        "L’intégrale de f entre a et b se note ∫ de a à b f(x) dx.",
                        "Si f est positive, l’intégrale représente l’aire sous la courbe.",
                        "Pour calculer une intégrale, on utilise une primitive F de f.",
                        "L’intégrale peut représenter une aire, une distance, une quantité, une énergie ou une accumulation.",
                        "Les propriétés de linéarité permettent de simplifier les calculs."
                ),
                List.of(
                        "Identifier les bornes a et b.",
                        "Identifier la fonction à intégrer.",
                        "Trouver une primitive F de la fonction f.",
                        "Calculer F(b) - F(a).",
                        "Interpréter le résultat selon le contexte."
                ),
                List.of(
                        "\\[ \\int_a^b f(x)\\,dx = F(b)-F(a) \\]",
                        "\\[ \\int_a^b (f(x)+g(x))\\,dx = \\int_a^b f(x)\\,dx + \\int_a^b g(x)\\,dx \\]",
                        "\\[ \\int_a^b kf(x)\\,dx = k\\int_a^b f(x)\\,dx \\]",
                        "\\[ \\int_a^b 1\\,dx = b-a \\]",
                        "\\[ \\int_a^b x^n\\,dx = \\left[\\frac{x^{n+1}}{n+1}\\right]_a^b \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Intégrales Terminale", youtube("Yvan Monka intégrales terminale")),
                        new VideoLink("Calculer une intégrale — méthode", youtube("calculer une intégrale terminale méthode")),
                        new VideoLink("Exercices corrigés — Intégrales", youtube("exercices corrigés intégrales terminale"))
                ),
                List.of(
                        new QuizQuestion("À quoi sert une intégrale ?", "Elle sert à calculer une aire sous une courbe ou une quantité accumulée."),
                        new QuizQuestion("Quelle formule utilise-t-on avec une primitive F ?", "On utilise ∫ de a à b f(x) dx = F(b) - F(a)."),
                        new QuizQuestion("Si f est positive, que représente l’intégrale ?", "Elle représente l’aire sous la courbe entre a et b."),
                        new QuizQuestion("Quelle erreur faut-il éviter ?", "Oublier les bornes ou calculer F(a) - F(b) au lieu de F(b) - F(a).")
                ),
                "math"
        );
    }

    private CourseContent exponentielle(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Fonction exponentielle",
                "La fonction exponentielle est une fonction fondamentale en Terminale. Elle est strictement positive, strictement croissante et possède une propriété unique : sa dérivée est elle-même.",
                List.of(
                        "La fonction exponentielle se note exp(x) ou e^x.",
                        "Elle est définie sur tout R.",
                        "Elle est toujours strictement positive.",
                        "Elle est strictement croissante.",
                        "Sa dérivée est elle-même.",
                        "Elle intervient dans les modèles de croissance, de décroissance et les équations différentielles."
                ),
                List.of(
                        "Reconnaître les expressions contenant e^x ou e^{u(x)}.",
                        "Utiliser les propriétés de calcul de l’exponentielle.",
                        "Dériver avec la formule adaptée.",
                        "Étudier le signe de la dérivée pour les variations.",
                        "Utiliser le logarithme pour résoudre certaines équations."
                ),
                List.of(
                        "\\[ e^0 = 1 \\]",
                        "\\[ e^{a+b}=e^a e^b \\]",
                        "\\[ e^{a-b}=\\frac{e^a}{e^b} \\]",
                        "\\[ (e^x)'=e^x \\]",
                        "\\[ (e^{u(x)})'=u'(x)e^{u(x)} \\]",
                        "\\[ \\lim_{x\\to +\\infty} e^x = +\\infty \\]",
                        "\\[ \\lim_{x\\to -\\infty} e^x = 0 \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Fonction exponentielle", youtube("Yvan Monka fonction exponentielle terminale")),
                        new VideoLink("Dériver une exponentielle", youtube("dérivée exponentielle terminale")),
                        new VideoLink("Exercices corrigés — Exponentielle", youtube("exercices corrigés exponentielle terminale"))
                ),
                List.of(
                        new QuizQuestion("Quelle est la dérivée de e^x ?", "La dérivée de e^x est e^x."),
                        new QuizQuestion("La fonction exponentielle peut-elle être négative ?", "Non, elle est toujours strictement positive."),
                        new QuizQuestion("Quelle propriété simplifie e^{a+b} ?", "e^{a+b} = e^a × e^b."),
                        new QuizQuestion("Comment dériver e^{u(x)} ?", "On utilise u'(x)e^{u(x)}.")
                ),
                "math"
        );
    }

    private CourseContent logarithme(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Fonction logarithme népérien",
                "La fonction logarithme népérien, notée ln, est la fonction réciproque de l’exponentielle. Elle est définie uniquement pour les nombres strictement positifs.",
                List.of(
                        "ln(x) est défini seulement pour x > 0.",
                        "ln(1) = 0 et ln(e) = 1.",
                        "La fonction ln est strictement croissante sur ]0 ; +∞[.",
                        "Elle transforme les produits en sommes.",
                        "Elle permet de résoudre des équations exponentielles."
                ),
                List.of(
                        "Vérifier le domaine de définition.",
                        "Utiliser les propriétés du logarithme.",
                        "Résoudre les équations avec ln si l’inconnue est dans un exposant.",
                        "Dériver avec la formule adaptée.",
                        "Interpréter le résultat."
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
                        new VideoLink("Résoudre une équation avec ln", youtube("résoudre équation logarithme terminale")),
                        new VideoLink("Exercices corrigés — Logarithme", youtube("exercices corrigés logarithme terminale"))
                ),
                List.of(
                        new QuizQuestion("Quel est le domaine de définition de ln(x) ?", "ln(x) est défini pour x > 0."),
                        new QuizQuestion("Combien vaut ln(1) ?", "ln(1) = 0."),
                        new QuizQuestion("Quelle est la dérivée de ln(x) ?", "La dérivée est 1/x."),
                        new QuizQuestion("Quelle erreur faut-il éviter ?", "Écrire ln d’un nombre négatif ou nul.")
                ),
                "math"
        );
    }

    private CourseContent suitesNumeriques(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Suites numériques",
                "Une suite numérique est une liste ordonnée de nombres. Elle permet de modéliser une évolution étape par étape : population, capital, distance, algorithme ou phénomène récurrent.",
                List.of(
                        "Une suite associe un nombre u_n à chaque entier n.",
                        "Elle peut être définie explicitement ou par récurrence.",
                        "Une suite arithmétique ajoute toujours la même raison.",
                        "Une suite géométrique multiplie toujours par la même raison.",
                        "On peut étudier ses variations et sa limite."
                ),
                List.of(
                        "Identifier le type de suite.",
                        "Calculer les premiers termes.",
                        "Déterminer si elle est arithmétique, géométrique ou autre.",
                        "Étudier les variations.",
                        "Chercher ou conjecturer la limite."
                ),
                List.of(
                        "\\[ u_n = u_0 + nr \\]",
                        "\\[ u_n = u_0 \\times q^n \\]",
                        "\\[ u_{n+1}-u_n > 0 \\Rightarrow (u_n) \\text{ croissante} \\]",
                        "\\[ u_{n+1}-u_n < 0 \\Rightarrow (u_n) \\text{ décroissante} \\]"
                ),
                List.of(
                        new VideoLink("Yvan Monka — Suites numériques", youtube("Yvan Monka suites numériques terminale")),
                        new VideoLink("Suites arithmétiques et géométriques", youtube("suites arithmétiques géométriques terminale")),
                        new VideoLink("Exercices corrigés — Suites", youtube("exercices corrigés suites terminale"))
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une suite arithmétique ?", "C’est une suite où l’on ajoute toujours le même nombre."),
                        new QuizQuestion("Qu’est-ce qu’une suite géométrique ?", "C’est une suite où l’on multiplie toujours par le même nombre."),
                        new QuizQuestion("Comment montrer qu’une suite est croissante ?", "On peut étudier le signe de u_{n+1} - u_n."),
                        new QuizQuestion("Quelle différence entre explicite et récurrence ?", "Une formule explicite donne directement u_n, une récurrence utilise le terme précédent.")
                ),
                "math"
        );
    }

    private CourseContent limitesSuites(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Limites de suites",
                "Étudier la limite d’une suite consiste à comprendre son comportement lorsque n devient très grand. Une suite peut converger vers un nombre ou diverger vers l’infini.",
                List.of(
                        "\\[ \\lim_{n\\to+\\infty}\\frac{1}{n}=0 \\]",
                        "\\[ \\lim_{n\\to+\\infty} n = +\\infty \\]",
                        "\\[ -1<q<1 \\Rightarrow \\lim_{n\\to+\\infty} q^n=0 \\]",
                        "\\[ q>1 \\Rightarrow \\lim_{n\\to+\\infty} q^n=+\\infty \\]"
                ),
                "Yvan Monka limites de suites terminale"
        );
    }

    private CourseContent limitesFonctions(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Limites de fonctions",
                "La limite d’une fonction décrit son comportement près d’un nombre ou à l’infini. Elle sert à étudier les asymptotes, les comportements extrêmes et les formes indéterminées.",
                List.of(
                        "\\[ \\lim_{x\\to+\\infty} x^n=+\\infty \\]",
                        "\\[ \\lim_{x\\to+\\infty}\\frac{1}{x}=0 \\]",
                        "\\[ \\lim_{x\\to+\\infty} e^x=+\\infty \\]",
                        "\\[ \\lim_{x\\to0^+}\\ln(x)=-\\infty \\]"
                ),
                "Yvan Monka limites de fonctions terminale"
        );
    }

    private CourseContent continuite(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Continuité",
                "Une fonction continue est une fonction dont la courbe ne présente pas de rupture. La continuité permet d’utiliser le théorème des valeurs intermédiaires.",
                List.of(
                        "\\[ f \\text{ continue sur } [a;b] \\]",
                        "\\[ k \\text{ entre } f(a) \\text{ et } f(b) \\Rightarrow \\exists c\\in[a;b], f(c)=k \\]",
                        "\\[ \\text{Continue + strictement monotone} \\Rightarrow \\text{solution unique} \\]"
                ),
                "Yvan Monka continuité terminale"
        );
    }

    private CourseContent derivationConvexite(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Dérivation et convexité",
                "La dérivation permet d’étudier les variations d’une fonction. La convexité permet d’analyser la forme de la courbe grâce à la dérivée seconde.",
                List.of(
                        "\\[ f'(x)>0 \\Rightarrow f \\text{ croissante} \\]",
                        "\\[ f'(x)<0 \\Rightarrow f \\text{ décroissante} \\]",
                        "\\[ f''(x)>0 \\Rightarrow f \\text{ convexe} \\]",
                        "\\[ f''(x)<0 \\Rightarrow f \\text{ concave} \\]",
                        "\\[ y=f'(a)(x-a)+f(a) \\]"
                ),
                "Yvan Monka dérivation convexité terminale"
        );
    }

    private CourseContent primitives(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Primitives",
                "Une primitive d’une fonction f est une fonction F dont la dérivée est f. Les primitives servent à calculer des intégrales et résoudre certaines équations différentielles.",
                List.of(
                        "\\[ F'=f \\]",
                        "\\[ \\int x^n dx = \\frac{x^{n+1}}{n+1}+C \\]",
                        "\\[ \\int e^x dx = e^x+C \\]",
                        "\\[ \\int \\frac{1}{x}dx = \\ln(x)+C \\]"
                ),
                "Yvan Monka primitives terminale"
        );
    }

    private CourseContent equationsDifferentielles(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Équations différentielles",
                "Une équation différentielle est une équation dont l’inconnue est une fonction et où intervient sa dérivée. Elle permet de modéliser des phénomènes d’évolution.",
                List.of(
                        "\\[ y'=ay \\Rightarrow y(x)=Ce^{ax} \\]",
                        "\\[ y'=ay+b \\Rightarrow y(x)=Ce^{ax}-\\frac{b}{a} \\]",
                        "\\[ y(0)=y_0 \\Rightarrow \\text{permet de trouver } C \\]"
                ),
                "Yvan Monka équations différentielles terminale"
        );
    }

    private CourseContent variablesAleatoires(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Variables aléatoires",
                "Une variable aléatoire associe un nombre à chaque issue d’une expérience aléatoire. Elle permet de modéliser des gains, des pertes ou des résultats numériques.",
                List.of(
                        "\\[ \\mathbb{E}(X)=\\sum x_i p_i \\]",
                        "\\[ V(X)=\\sum p_i(x_i-\\mathbb{E}(X))^2 \\]",
                        "\\[ \\sigma(X)=\\sqrt{V(X)} \\]",
                        "\\[ \\sum p_i=1 \\]"
                ),
                "Yvan Monka variables aléatoires terminale"
        );
    }

    private CourseContent loiBinomiale(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Loi binomiale",
                "La loi binomiale modélise le nombre de succès dans une répétition indépendante d’expériences identiques à deux issues : succès ou échec.",
                List.of(
                        "\\[ X\\sim\\mathcal{B}(n,p) \\]",
                        "\\[ P(X=k)=\\binom{n}{k}p^k(1-p)^{n-k} \\]",
                        "\\[ \\mathbb{E}(X)=np \\]",
                        "\\[ V(X)=np(1-p) \\]"
                ),
                "Yvan Monka loi binomiale terminale"
        );
    }

    private CourseContent sommesVariables(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Sommes de variables aléatoires",
                "Ce chapitre étudie ce qui se passe lorsqu’on additionne plusieurs variables aléatoires. Il sert à calculer l’espérance et la variance d’une somme.",
                List.of(
                        "\\[ \\mathbb{E}(X+Y)=\\mathbb{E}(X)+\\mathbb{E}(Y) \\]",
                        "\\[ \\mathbb{E}(aX+b)=a\\mathbb{E}(X)+b \\]",
                        "\\[ V(X+Y)=V(X)+V(Y) \\text{ si X et Y indépendantes} \\]"
                ),
                "sommes de variables aléatoires terminale"
        );
    }

    private CourseContent concentration(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Concentration et loi des grands nombres",
                "La loi des grands nombres explique que lorsqu’on répète une expérience un grand nombre de fois, la moyenne observée se rapproche de l’espérance théorique.",
                List.of(
                        "\\[ M_n=\\frac{X_1+X_2+...+X_n}{n} \\]",
                        "\\[ \\mathbb{E}(M_n)=\\mathbb{E}(X) \\]",
                        "\\[ V(M_n)=\\frac{V(X)}{n} \\]"
                ),
                "loi des grands nombres terminale"
        );
    }

    private CourseContent combinatoire(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Combinatoire et dénombrement",
                "La combinatoire sert à compter le nombre de possibilités dans une situation donnée. Elle est essentielle en probabilités.",
                List.of(
                        "\\[ n! = 1\\times2\\times...\\times n \\]",
                        "\\[ \\binom{n}{k}=\\frac{n!}{k!(n-k)!} \\]",
                        "\\[ \\binom{n}{k}=\\binom{n}{n-k} \\]"
                ),
                "Yvan Monka combinatoire dénombrement terminale"
        );
    }

    private CourseContent vecteursDroitesPlans(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Vecteurs, droites et plans de l’espace",
                "Ce chapitre généralise la géométrie du plan à l’espace. Les vecteurs permettent de décrire des points, des droites, des plans et des positions en trois dimensions.",
                List.of(
                        "\\[ \\overrightarrow{AB}(x_B-x_A;y_B-y_A;z_B-z_A) \\]",
                        "\\[ M\\in d \\Rightarrow \\overrightarrow{AM}=t\\vec{u} \\]",
                        "\\[ \\vec{u}=k\\vec{v} \\Rightarrow \\vec{u} \\text{ et } \\vec{v} \\text{ colinéaires} \\]"
                ),
                "Yvan Monka géométrie espace terminale"
        );
    }

    private CourseContent orthogonaliteDistances(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Orthogonalité et distances dans l’espace",
                "Ce chapitre utilise le produit scalaire pour étudier l’orthogonalité, les longueurs, les distances et les plans dans l’espace.",
                List.of(
                        "\\[ \\vec{u}\\cdot\\vec{v}=xx'+yy'+zz' \\]",
                        "\\[ \\vec{u}\\perp\\vec{v} \\Leftrightarrow \\vec{u}\\cdot\\vec{v}=0 \\]",
                        "\\[ AB=\\sqrt{(x_B-x_A)^2+(y_B-y_A)^2+(z_B-z_A)^2} \\]"
                ),
                "Yvan Monka produit scalaire espace terminale"
        );
    }

    private CourseContent equationsDroitesPlans(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Équations de droites et de plans",
                "Ce chapitre apprend à décrire les droites et les plans de l’espace avec des équations paramétriques et cartésiennes.",
                List.of(
                        "\\[ d:\\begin{cases} x=x_A+ta \\\\ y=y_A+tb \\\\ z=z_A+tc \\end{cases} \\]",
                        "\\[ P: ax+by+cz+d=0 \\]",
                        "\\[ \\vec{n}(a;b;c) \\text{ est normal au plan } P \\]"
                ),
                "équations droites plans espace terminale"
        );
    }

    private CourseContent mathsGeneral(String matiere, String chapitre) {
        return simpleMathCourse(
                matiere,
                chapitre,
                "Cours de mathématiques",
                "Ce chapitre de mathématiques doit être travaillé avec les définitions, les propriétés, les formules et les méthodes d’exercice.",
                List.of(
                        "\\[ \\text{Définition} \\Rightarrow \\text{Méthode} \\Rightarrow \\text{Application} \\]",
                        "\\[ \\text{Résultat final} = \\text{calcul justifié} + \\text{conclusion} \\]"
                ),
                "Yvan Monka terminale " + chapitre
        );
    }

    private CourseContent simpleMathCourse(
            String matiere,
            String chapitre,
            String title,
            String resume,
            List<String> formulas,
            String videoQuery
    ) {
        return new CourseContent(
                matiere,
                chapitre,
                title,
                resume,
                List.of(
                        "Comprendre la définition principale du chapitre.",
                        "Savoir reconnaître les situations où utiliser la méthode.",
                        "Apprendre les propriétés et formules importantes.",
                        "S’entraîner sur des exercices progressifs.",
                        "Savoir rédiger proprement une réponse."
                ),
                List.of(
                        "Lire l’énoncé attentivement.",
                        "Repérer les données utiles.",
                        "Choisir la formule ou propriété adaptée.",
                        "Faire les calculs étape par étape.",
                        "Conclure avec une phrase claire."
                ),
                formulas,
                List.of(
                        new VideoLink("Vidéo de cours — " + title, youtube(videoQuery)),
                        new VideoLink("Exercices corrigés — " + title, youtube("exercices corrigés " + title + " terminale")),
                        new VideoLink("Méthode bac — " + title, youtube("méthode bac " + title + " terminale"))
                ),
                List.of(
                        new QuizQuestion("Quelle est l’idée principale du chapitre ?", "Elle dépend du chapitre, mais il faut pouvoir la résumer simplement avec les définitions clés."),
                        new QuizQuestion("Pourquoi les formules sont importantes ?", "Elles permettent d’appliquer le cours dans les exercices."),
                        new QuizQuestion("Quelle est la bonne méthode de révision ?", "Comprendre le cours, refaire les exemples, puis s’entraîner avec des exercices."),
                        new QuizQuestion("Quelle erreur faut-il éviter ?", "Appliquer une formule sans vérifier ses conditions d’utilisation.")
                ),
                "math"
        );
    }
}