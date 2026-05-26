package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(5)
public class NsiCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("nsi")
                || m.contains("numerique")
                || m.contains("informatique");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("structures de donnees")) return structuresDonnees(matiere, chapitre);
        if (c.contains("bases de donnees") || c.contains("sql")) return basesDonneesSql(matiere, chapitre);
        if (c.contains("architectures materielles") || c.contains("systemes d exploitation") || c.contains("linux")) return architectureSystemes(matiere, chapitre);
        if (c.contains("reseaux") || c.contains("protocoles")) return reseauxProtocoles(matiere, chapitre);
        if (c.contains("programmation orientee objet") || c.contains("poo")) return programmationObjet(matiere, chapitre);
        if (c.contains("recursivite") || c.contains("recursif")) return recursivite(matiere, chapitre);
        if (c.contains("mise au point") || c.contains("tests")) return miseAuPointTests(matiere, chapitre);
        if (c.contains("algorithmes") && c.contains("graphes")) return graphes(matiere, chapitre);
        if (c.contains("graphes")) return graphes(matiere, chapitre);
        if (c.contains("arbres")) return arbres(matiere, chapitre);
        if (c.contains("programmation dynamique")) return programmationDynamique(matiere, chapitre);
        if (c.contains("diviser") || c.contains("regner")) return diviserPourRegner(matiere, chapitre);
        if (c.contains("securisation") || c.contains("cryptographie") || c.contains("securite")) return securiteCryptographie(matiere, chapitre);

        return coursEnPreparation(matiere, chapitre);
    }

    private CourseContent structuresDonnees(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Structures de données",
                "Les structures de données servent à organiser l’information pour la stocker, la parcourir et la modifier efficacement. En NSI, on étudie notamment les tableaux, listes, piles, files, dictionnaires et structures chaînées.",
                List.of(
                        "Une structure de données organise des valeurs selon une logique précise.",
                        "Un tableau permet un accès direct par indice.",
                        "Une pile fonctionne en dernier entré, premier sorti.",
                        "Une file fonctionne en premier entré, premier sorti.",
                        "Un dictionnaire associe une clé à une valeur.",
                        "Le choix d’une structure influence l’efficacité d’un programme."
                ),
                List.of(
                        "Identifier les données à stocker.",
                        "Repérer les opérations nécessaires : ajouter, supprimer, rechercher, parcourir.",
                        "Choisir la structure la plus adaptée.",
                        "Écrire les opérations de base.",
                        "Tester la structure avec plusieurs cas."
                ),
                List.of(
                        "Tableau : accès par indice.",
                        "Pile : LIFO, Last In First Out.",
                        "File : FIFO, First In First Out.",
                        "Dictionnaire : clé → valeur.",
                        "Structure adaptée → programme plus clair et plus efficace."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment ranger les données dans un programme. Un bon choix de structure rend le code plus simple, plus rapide et plus facile à maintenir."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On regarde ce que le programme doit faire avec les données. Si on doit retrouver rapidement une valeur avec une clé, on choisit un dictionnaire. Si on doit gérer un ordre d’attente, on choisit une file."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les exercices de piles, files, tableaux, dictionnaires, parcours de données, simulations et gestion d’informations."
                        )
                ),
                List.of(
                        new QuizQuestion("Que signifie LIFO ?", "Last In First Out : le dernier élément ajouté est le premier retiré."),
                        new QuizQuestion("Que signifie FIFO ?", "First In First Out : le premier élément ajouté est le premier retiré."),
                        new QuizQuestion("À quoi sert un dictionnaire ?", "À associer une clé à une valeur."),
                        new QuizQuestion("Pourquoi choisir une bonne structure ?", "Pour rendre le programme plus efficace et plus clair.")
                )
        );
    }

    private CourseContent basesDonneesSql(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Bases de données et SQL",
                "Une base de données permet de stocker des informations de manière organisée. En NSI, on utilise le modèle relationnel, composé de tables, de lignes, de colonnes, de clés primaires et de clés étrangères. SQL permet d’interroger ces données.",
                List.of(
                        "Une table stocke des données sous forme de lignes et colonnes.",
                        "Une clé primaire identifie de manière unique chaque ligne.",
                        "Une clé étrangère relie deux tables.",
                        "SQL permet de sélectionner, filtrer, trier et joindre des données.",
                        "Une base bien conçue évite les doublons et les incohérences."
                ),
                List.of(
                        "Identifier les tables nécessaires.",
                        "Repérer les attributs et les clés.",
                        "Comprendre les relations entre les tables.",
                        "Écrire une requête SELECT.",
                        "Ajouter WHERE, ORDER BY ou JOIN selon la question."
                ),
                List.of(
                        "SELECT colonne FROM table;",
                        "SELECT * FROM table WHERE condition;",
                        "ORDER BY colonne ASC/DESC;",
                        "JOIN : relier plusieurs tables.",
                        "Clé primaire → identifiant unique.",
                        "Clé étrangère → lien vers une autre table."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les sites, applications et logiciels stockent leurs données : utilisateurs, messages, notes, produits, commandes ou cours."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On commence par comprendre la structure des tables. Ensuite, on écrit une requête SQL pour récupérer seulement les informations demandées."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour écrire des requêtes SQL, comprendre un schéma relationnel, faire des jointures, filtrer des résultats et analyser des erreurs de base de données."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert une clé primaire ?", "À identifier de manière unique une ligne dans une table."),
                        new QuizQuestion("À quoi sert une clé étrangère ?", "À créer un lien entre deux tables."),
                        new QuizQuestion("Quelle commande SQL permet de lire des données ?", "SELECT."),
                        new QuizQuestion("À quoi sert WHERE ?", "À filtrer les lignes selon une condition.")
                )
        );
    }

    private CourseContent architectureSystemes(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Architectures matérielles et systèmes d’exploitation",
                "Ce chapitre étudie comment un ordinateur exécute des programmes et comment un système d’exploitation organise les ressources. On y retrouve le processeur, la mémoire, les fichiers, les processus et les commandes système.",
                List.of(
                        "Le processeur exécute les instructions.",
                        "La mémoire vive stocke temporairement les données et programmes en cours.",
                        "Le système d’exploitation gère les fichiers, processus, utilisateurs et ressources.",
                        "Un processus est un programme en cours d’exécution.",
                        "Le système de fichiers organise les données en dossiers et fichiers.",
                        "Les commandes permettent d’interagir avec le système."
                ),
                List.of(
                        "Identifier le rôle de chaque composant.",
                        "Distinguer matériel et logiciel système.",
                        "Comprendre ce qu’est un processus.",
                        "Lire ou écrire des chemins de fichiers.",
                        "Utiliser les commandes de base selon l’exercice."
                ),
                List.of(
                        "CPU → exécute les instructions.",
                        "RAM → mémoire temporaire.",
                        "OS → gestion des ressources.",
                        "Processus → programme en cours d’exécution.",
                        "Chemin absolu → depuis la racine.",
                        "Chemin relatif → depuis le dossier courant."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre ce qu’il se passe derrière un programme : comment l’ordinateur l’exécute, comment les fichiers sont rangés et comment le système gère plusieurs tâches."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans les exercices, il faut relier chaque élément à son rôle : processeur pour calculer, mémoire pour stocker temporairement, système d’exploitation pour organiser et contrôler."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les questions sur Linux, les fichiers, les permissions, les processus, l’architecture de Von Neumann et les commandes système."
                        )
                ),
                List.of(
                        new QuizQuestion("Quel est le rôle du processeur ?", "Exécuter les instructions."),
                        new QuizQuestion("Que stocke la mémoire vive ?", "Les données et programmes en cours d’utilisation."),
                        new QuizQuestion("Qu’est-ce qu’un processus ?", "Un programme en cours d’exécution."),
                        new QuizQuestion("À quoi sert un système d’exploitation ?", "À gérer les ressources de l’ordinateur.")
                )
        );
    }

    private CourseContent reseauxProtocoles(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Réseaux et protocoles",
                "Les réseaux permettent à des machines de communiquer. Les protocoles fixent les règles de cette communication. En NSI, on étudie notamment les adresses IP, le routage, TCP/IP, DNS, HTTP et la transmission des paquets.",
                List.of(
                        "Un réseau relie plusieurs machines capables d’échanger des données.",
                        "Une adresse IP identifie une machine sur un réseau.",
                        "Les données circulent souvent sous forme de paquets.",
                        "Le routage permet de choisir le chemin des paquets.",
                        "DNS associe un nom de domaine à une adresse IP.",
                        "HTTP permet l’échange de pages web."
                ),
                List.of(
                        "Identifier les machines qui communiquent.",
                        "Repérer les adresses IP et les sous-réseaux.",
                        "Comprendre le rôle des routeurs.",
                        "Associer chaque protocole à sa fonction.",
                        "Suivre le trajet d’une donnée sur le réseau."
                ),
                List.of(
                        "IP → adressage.",
                        "TCP → transport fiable.",
                        "DNS → nom de domaine vers adresse IP.",
                        "HTTP/HTTPS → consultation de pages web.",
                        "Routeur → transfert des paquets.",
                        "Paquet → morceau de donnée transmis."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment Internet fonctionne. Quand tu ouvres un site, ton ordinateur utilise plusieurs protocoles pour trouver le serveur, lui parler et recevoir les données."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut suivre le chemin logique : nom de domaine, DNS, adresse IP, routage, transport, puis protocole applicatif comme HTTP."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les exercices sur adresses IP, routage, DNS, protocoles, paquets, client-serveur et sécurité web."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert une adresse IP ?", "À identifier une machine sur un réseau."),
                        new QuizQuestion("À quoi sert DNS ?", "À traduire un nom de domaine en adresse IP."),
                        new QuizQuestion("À quoi sert un routeur ?", "À transmettre les paquets vers leur destination."),
                        new QuizQuestion("Quel protocole est utilisé pour le web ?", "HTTP ou HTTPS.")
                )
        );
    }

    private CourseContent programmationObjet(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Programmation orientée objet",
                "La programmation orientée objet organise le code autour d’objets. Un objet possède des attributs, qui décrivent son état, et des méthodes, qui décrivent ses actions. Une classe sert de modèle pour créer des objets.",
                List.of(
                        "Une classe est un modèle.",
                        "Un objet est une instance d’une classe.",
                        "Les attributs stockent l’état de l’objet.",
                        "Les méthodes décrivent les comportements de l’objet.",
                        "Le constructeur initialise un objet.",
                        "La POO permet de structurer un programme complexe."
                ),
                List.of(
                        "Identifier les objets du problème.",
                        "Définir une classe adaptée.",
                        "Choisir les attributs nécessaires.",
                        "Écrire le constructeur.",
                        "Ajouter les méthodes utiles.",
                        "Créer des instances et tester leur comportement."
                ),
                List.of(
                        "Classe → modèle.",
                        "Objet → instance.",
                        "Attribut → donnée de l’objet.",
                        "Méthode → action de l’objet.",
                        "Constructeur → initialisation.",
                        "self → référence à l’objet courant en Python."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à organiser un programme autour d’éléments proches du réel : un utilisateur, une voiture, un compte, une fiche ou un joueur peuvent devenir des objets."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère les données à stocker dans les attributs et les actions à faire dans les méthodes. Ensuite, on crée des objets à partir de la classe."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour créer des classes Python, manipuler des objets, écrire des constructeurs, accéder aux attributs et appeler des méthodes."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une classe ?", "Un modèle permettant de créer des objets."),
                        new QuizQuestion("Qu’est-ce qu’un objet ?", "Une instance d’une classe."),
                        new QuizQuestion("À quoi sert un attribut ?", "À stocker une information sur l’objet."),
                        new QuizQuestion("À quoi sert une méthode ?", "À définir une action ou un comportement de l’objet.")
                )
        );
    }

    private CourseContent recursivite(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Récursivité",
                "La récursivité consiste à résoudre un problème en le ramenant à un problème plus petit de même nature. Une fonction récursive s’appelle elle-même, avec une condition d’arrêt indispensable.",
                List.of(
                        "Une fonction récursive s’appelle elle-même.",
                        "Il faut toujours une condition d’arrêt.",
                        "Chaque appel doit rapprocher du cas de base.",
                        "La récursivité est utile pour les arbres, les graphes, les suites et les divisions de problème.",
                        "Une récursion mal écrite peut provoquer une boucle infinie ou une erreur de pile."
                ),
                List.of(
                        "Identifier le cas de base.",
                        "Identifier le cas récursif.",
                        "Vérifier que chaque appel simplifie le problème.",
                        "Tester sur de petits exemples.",
                        "Comparer éventuellement avec une version itérative."
                ),
                List.of(
                        "Cas de base → arrêt.",
                        "Cas récursif → appel de la fonction elle-même.",
                        "Problème n → problème n-1 ou plus petit.",
                        "Sans cas d’arrêt → récursion infinie.",
                        "Pile d’appels → mémoire des appels successifs."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La récursivité sert à résoudre élégamment des problèmes qui se répètent avec la même structure, comme parcourir un arbre, calculer une factorielle ou explorer un graphe."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut d’abord écrire le cas simple qui donne directement une réponse. Ensuite, on écrit le cas général qui appelle la fonction sur un problème plus petit."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les fonctions récursives, arbres, tris, algorithmes diviser pour régner, suites, factorielle et parcours."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’une fonction récursive ?", "Une fonction qui s’appelle elle-même."),
                        new QuizQuestion("Pourquoi faut-il un cas de base ?", "Pour arrêter la récursion."),
                        new QuizQuestion("Quel risque existe sans condition d’arrêt ?", "Une récursion infinie."),
                        new QuizQuestion("Dans quels chapitres la récursivité est-elle utile ?", "Arbres, graphes, tris et diviser pour régner.")
                )
        );
    }

    private CourseContent miseAuPointTests(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Mise au point des programmes et tests",
                "La mise au point consiste à vérifier, corriger et améliorer un programme. Les tests permettent de s’assurer qu’une fonction donne les bons résultats dans plusieurs situations, y compris les cas limites.",
                List.of(
                        "Un programme peut contenir des erreurs de syntaxe, d’exécution ou de logique.",
                        "Un test vérifie un comportement attendu.",
                        "Les assertions permettent de contrôler des propriétés.",
                        "Les cas limites sont importants.",
                        "La documentation aide à comprendre et utiliser une fonction.",
                        "Déboguer consiste à localiser et corriger une erreur."
                ),
                List.of(
                        "Lire le message d’erreur.",
                        "Identifier la ligne ou la fonction concernée.",
                        "Tester avec des exemples simples.",
                        "Ajouter des assertions si nécessaire.",
                        "Corriger puis relancer les tests.",
                        "Vérifier aussi les cas limites."
                ),
                List.of(
                        "assert condition",
                        "Test unitaire → vérifie une partie du programme.",
                        "Cas nominal → situation classique.",
                        "Cas limite → situation extrême ou particulière.",
                        "Bug logique → le programme tourne mais donne un mauvais résultat."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à apprendre à rendre un programme fiable. Un code qui fonctionne une seule fois ne suffit pas : il doit fonctionner dans plusieurs cas."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On écrit des tests avec des entrées connues et des résultats attendus. Si un test échoue, on cherche l’erreur puis on corrige."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les questions de tests unitaires, assertions, débogage, correction d’erreurs et analyse de fonctions Python."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert un test ?", "À vérifier qu’un programme donne le résultat attendu."),
                        new QuizQuestion("Qu’est-ce qu’un cas limite ?", "Une situation extrême ou particulière à tester."),
                        new QuizQuestion("Qu’est-ce qu’un bug logique ?", "Une erreur qui donne un mauvais résultat même si le programme s’exécute."),
                        new QuizQuestion("À quoi sert assert ?", "À vérifier qu’une condition est vraie.")
                )
        );
    }

    private CourseContent graphes(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Graphes",
                "Un graphe modélise des relations entre objets. Les objets sont appelés sommets et les relations sont appelées arêtes ou arcs. Les graphes sont utilisés pour les réseaux, les cartes, les liens sociaux et les chemins.",
                List.of(
                        "Un graphe est composé de sommets et d’arêtes.",
                        "Un graphe orienté utilise des arcs avec un sens.",
                        "Un chemin relie plusieurs sommets.",
                        "Un cycle revient au sommet de départ.",
                        "Un graphe peut être représenté par une matrice ou des listes d’adjacence.",
                        "Les parcours permettent d’explorer un graphe."
                ),
                List.of(
                        "Identifier les sommets et les arêtes.",
                        "Choisir une représentation adaptée.",
                        "Repérer les voisins d’un sommet.",
                        "Appliquer un parcours si nécessaire.",
                        "Interpréter le résultat dans le contexte."
                ),
                List.of(
                        "Sommet → objet.",
                        "Arête → relation non orientée.",
                        "Arc → relation orientée.",
                        "Liste d’adjacence → voisins de chaque sommet.",
                        "Matrice d’adjacence → tableau des connexions.",
                        "Parcours en largeur → file.",
                        "Parcours en profondeur → pile ou récursivité."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les graphes servent à représenter des réseaux : routes, Internet, relations sociales, dépendances, cartes ou connexions entre pages."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On transforme la situation en sommets et relations. Ensuite, on choisit une représentation et on applique un algorithme de parcours ou de recherche de chemin."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les parcours BFS/DFS, les listes d’adjacence, les matrices, les chemins, les cycles et les réseaux."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce qu’un sommet ?", "Un objet ou un point du graphe."),
                        new QuizQuestion("Qu’est-ce qu’une arête ?", "Une relation entre deux sommets."),
                        new QuizQuestion("Quelle structure utilise le parcours en largeur ?", "Une file."),
                        new QuizQuestion("Quelle structure utilise souvent le parcours en profondeur ?", "Une pile ou la récursivité.")
                )
        );
    }

    private CourseContent arbres(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Arbres",
                "Un arbre est une structure de données hiérarchique. Il possède une racine, des nœuds, des feuilles et des liens parent-enfant. Les arbres sont utilisés pour représenter des fichiers, expressions, décisions et données ordonnées.",
                List.of(
                        "Un arbre possède une racine.",
                        "Un nœud peut avoir des enfants.",
                        "Une feuille est un nœud sans enfant.",
                        "La profondeur mesure l’éloignement par rapport à la racine.",
                        "Les arbres binaires ont au plus deux enfants par nœud.",
                        "Un arbre binaire de recherche permet de retrouver rapidement des valeurs."
                ),
                List.of(
                        "Identifier la racine.",
                        "Repérer les parents, enfants et feuilles.",
                        "Déterminer la hauteur ou profondeur.",
                        "Choisir le parcours adapté.",
                        "Appliquer les règles de l’arbre binaire de recherche si nécessaire."
                ),
                List.of(
                        "Racine → premier nœud.",
                        "Feuille → nœud sans enfant.",
                        "Hauteur → longueur maximale vers une feuille.",
                        "Parcours préfixe : racine puis sous-arbres.",
                        "Parcours infixe : gauche, racine, droite.",
                        "Parcours suffixe : sous-arbres puis racine."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Les arbres servent à représenter des données organisées en hiérarchie : dossiers d’un ordinateur, arbre généalogique, expressions mathématiques ou choix successifs."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère la racine puis on parcourt l’arbre selon une méthode : préfixe, infixe, suffixe ou largeur. Pour un arbre de recherche, on compare les valeurs."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les parcours d’arbres, arbres binaires de recherche, hauteurs, feuilles, récursivité et représentations hiérarchiques."
                        )
                ),
                List.of(
                        new QuizQuestion("Qu’est-ce que la racine d’un arbre ?", "Le nœud de départ."),
                        new QuizQuestion("Qu’est-ce qu’une feuille ?", "Un nœud sans enfant."),
                        new QuizQuestion("Combien d’enfants maximum dans un arbre binaire ?", "Deux."),
                        new QuizQuestion("Quel parcours donne les valeurs triées dans un arbre binaire de recherche ?", "Le parcours infixe.")
                )
        );
    }

    private CourseContent programmationDynamique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Programmation dynamique",
                "La programmation dynamique est une méthode algorithmique qui résout un problème en réutilisant les résultats de sous-problèmes déjà calculés. Elle évite de refaire plusieurs fois les mêmes calculs.",
                List.of(
                        "Un problème est découpé en sous-problèmes.",
                        "Les sous-problèmes se répètent souvent.",
                        "On mémorise les résultats pour éviter les recalculs.",
                        "La mémoïsation utilise souvent un dictionnaire ou un tableau.",
                        "La méthode ascendante remplit progressivement une table.",
                        "Cette technique améliore fortement l’efficacité de certains algorithmes."
                ),
                List.of(
                        "Identifier les sous-problèmes.",
                        "Trouver la relation de récurrence.",
                        "Choisir mémoïsation ou tableau dynamique.",
                        "Initialiser les cas de base.",
                        "Remplir ou calculer les valeurs nécessaires.",
                        "Retourner le résultat final."
                ),
                List.of(
                        "Mémoïsation → stockage des résultats déjà calculés.",
                        "Cas de base → valeurs connues directement.",
                        "Relation de récurrence → lien entre problème et sous-problèmes.",
                        "Approche descendante → récursion + mémoire.",
                        "Approche ascendante → remplissage d’un tableau."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "La programmation dynamique sert à rendre efficaces des algorithmes qui recalculeraient plusieurs fois les mêmes choses, comme Fibonacci, rendu de monnaie ou chemins optimaux."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère les sous-problèmes identiques, on écrit une relation de récurrence, puis on stocke les résultats pour les réutiliser."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans les problèmes d’optimisation, suites, chemins, calculs récursifs coûteux et tableaux de valeurs."
                        )
                ),
                List.of(
                        new QuizQuestion("Quel est le principe principal ?", "Réutiliser les résultats de sous-problèmes déjà calculés."),
                        new QuizQuestion("À quoi sert la mémoïsation ?", "À stocker des résultats pour éviter de les recalculer."),
                        new QuizQuestion("Pourquoi cette méthode est efficace ?", "Elle réduit le nombre de calculs répétés."),
                        new QuizQuestion("Que faut-il identifier d’abord ?", "Les sous-problèmes et les cas de base.")
                )
        );
    }

    private CourseContent diviserPourRegner(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Diviser pour régner",
                "La méthode diviser pour régner consiste à découper un problème en sous-problèmes plus petits, les résoudre séparément, puis combiner leurs résultats. Elle est utilisée dans plusieurs algorithmes efficaces.",
                List.of(
                        "On divise le problème initial.",
                        "On résout les sous-problèmes.",
                        "On combine les solutions obtenues.",
                        "La méthode est souvent récursive.",
                        "Elle est utilisée pour le tri fusion, la recherche dichotomique et certains calculs efficaces."
                ),
                List.of(
                        "Identifier comment diviser le problème.",
                        "Définir le cas de base.",
                        "Résoudre récursivement les sous-problèmes.",
                        "Combiner les résultats.",
                        "Analyser l’efficacité si demandé."
                ),
                List.of(
                        "Diviser → résoudre → combiner.",
                        "Recherche dichotomique → diviser par deux.",
                        "Tri fusion → diviser le tableau puis fusionner.",
                        "Récursivité → outil fréquent de cette méthode."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Cette méthode sert à résoudre plus efficacement des problèmes en les découpant. Au lieu de traiter tout d’un coup, on traite plusieurs petits morceaux."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On définit comment couper le problème, puis on écrit le cas d’arrêt. Ensuite, on résout les sous-problèmes et on rassemble les réponses."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise dans le tri fusion, la recherche dichotomique, la récursivité, les algorithmes de tri et les analyses de complexité."
                        )
                ),
                List.of(
                        new QuizQuestion("Quelles sont les trois étapes ?", "Diviser, résoudre, combiner."),
                        new QuizQuestion("Quel tri utilise cette méthode ?", "Le tri fusion."),
                        new QuizQuestion("Quel algorithme divise l’espace de recherche par deux ?", "La recherche dichotomique."),
                        new QuizQuestion("Quel outil est souvent utilisé ?", "La récursivité.")
                )
        );
    }

    private CourseContent securiteCryptographie(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Sécurisation des communications et cryptographie",
                "La sécurisation des communications vise à protéger les échanges numériques. La cryptographie permet de garantir la confidentialité, l’authenticité, l’intégrité et parfois la non-répudiation des messages.",
                List.of(
                        "La confidentialité empêche un tiers de lire le message.",
                        "L’intégrité garantit que le message n’a pas été modifié.",
                        "L’authentification vérifie l’identité de l’émetteur.",
                        "Le chiffrement symétrique utilise une même clé pour chiffrer et déchiffrer.",
                        "Le chiffrement asymétrique utilise une clé publique et une clé privée.",
                        "Les certificats participent à la confiance sur le web."
                ),
                List.of(
                        "Identifier le besoin : confidentialité, intégrité ou authentification.",
                        "Distinguer chiffrement symétrique et asymétrique.",
                        "Comprendre le rôle des clés.",
                        "Relier le protocole HTTPS à la sécurité web.",
                        "Interpréter un schéma d’échange sécurisé."
                ),
                List.of(
                        "Chiffrement → rendre un message illisible sans clé.",
                        "Déchiffrement → retrouver le message original.",
                        "Clé publique → peut être partagée.",
                        "Clé privée → doit rester secrète.",
                        "HTTPS → HTTP sécurisé.",
                        "Signature numérique → authenticité + intégrité."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment protéger les communications numériques, par exemple quand on se connecte à un site, envoie un mot de passe ou échange des données sensibles."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "On repère ce que l’on veut protéger : le contenu, l’identité ou l’intégrité du message. Ensuite, on choisit le mécanisme adapté : chiffrement, signature ou certificat."
                        ),
                        new ExplanationBlock(
                                "Dans quels exercices ?",
                                "On l’utilise pour HTTPS, clés publiques/privées, chiffrement symétrique, signature numérique, certificats et sécurité des échanges."
                        )
                ),
                List.of(
                        new QuizQuestion("À quoi sert le chiffrement ?", "À rendre un message illisible sans la clé."),
                        new QuizQuestion("Quelle différence entre symétrique et asymétrique ?", "Le symétrique utilise une même clé, l’asymétrique utilise une clé publique et une clé privée."),
                        new QuizQuestion("À quoi sert HTTPS ?", "À sécuriser les échanges web."),
                        new QuizQuestion("Que garantit l’intégrité ?", "Que le message n’a pas été modifié.")
                )
        );
    }

    private CourseContent coursEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de NSI en préparation",
                "Ce chapitre de NSI n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Le contenu sera ajouté dans une prochaine mise à jour.",
                        "Les principaux chapitres de spécialité NSI sont déjà pris en charge."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les notions principales en attendant.",
                        "S’entraîner sur des petits programmes."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("NSI terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider NSI.")
                ),
                "nsi",
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
                        new VideoLink("Cours vidéo — " + title, youtube("NSI terminale " + title)),
                        new VideoLink("Méthode bac NSI — " + title, youtube("méthode bac NSI terminale " + title)),
                        new VideoLink("Exercices corrigés — " + title, youtube("exercices corrigés NSI terminale " + title))
                ),
                quiz,
                "nsi",
                explanations
        );
    }
}