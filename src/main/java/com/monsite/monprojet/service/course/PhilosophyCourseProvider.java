package com.monsite.monprojet.service.course;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.monsite.monprojet.service.course.CourseUtils.normalize;
import static com.monsite.monprojet.service.course.CourseUtils.youtube;

@Component
@Order(2)
public class PhilosophyCourseProvider implements CourseProvider {

    @Override
    public boolean supports(String matiere) {
        String m = normalize(matiere);
        return m.contains("philo");
    }

    @Override
    public CourseContent getCourse(String matiere, String chapitre) {
        String c = normalize(chapitre);

        if (c.contains("art")) return art(matiere, chapitre);
        if (c.contains("bonheur")) return bonheur(matiere, chapitre);
        if (c.contains("conscience")) return conscience(matiere, chapitre);
        if (c.contains("devoir")) return devoir(matiere, chapitre);
        if (c.contains("etat")) return etat(matiere, chapitre);
        if (c.contains("inconscient")) return inconscient(matiere, chapitre);
        if (c.contains("justice")) return justice(matiere, chapitre);
        if (c.contains("langage")) return langage(matiere, chapitre);
        if (c.contains("liberte")) return liberte(matiere, chapitre);
        if (c.contains("nature")) return nature(matiere, chapitre);
        if (c.contains("raison")) return raison(matiere, chapitre);
        if (c.contains("religion")) return religion(matiere, chapitre);
        if (c.contains("science")) return science(matiere, chapitre);
        if (c.contains("technique")) return technique(matiere, chapitre);
        if (c.contains("temps")) return temps(matiere, chapitre);
        if (c.contains("travail")) return travail(matiere, chapitre);
        if (c.contains("verite")) return verite(matiere, chapitre);

        return coursPhiloEnPreparation(matiere, chapitre);
    }

    private CourseContent art(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "L’art",
                "L’art désigne une activité humaine de création qui produit des œuvres capables de provoquer une expérience sensible, esthétique ou intellectuelle. Le chapitre interroge la beauté, le goût, l’imitation, l’expression et le rôle de l’artiste.",
                List.of(
                        "L’art n’est pas seulement décoratif : il peut aussi faire réfléchir.",
                        "Une œuvre d’art peut imiter le réel, le transformer ou le critiquer.",
                        "Le jugement esthétique semble personnel, mais il cherche souvent à être partagé.",
                        "L’artiste ne copie pas simplement la nature : il donne une forme à une vision du monde.",
                        "L’art peut révéler des aspects du réel que l’on ne remarque pas dans la vie quotidienne."
                ),
                List.of(
                        "Définir le mot art dans le sujet.",
                        "Distinguer art, artisanat, technique et beauté.",
                        "Se demander si l’œuvre doit plaire, représenter ou faire penser.",
                        "Utiliser des exemples précis : peinture, cinéma, musique, littérature.",
                        "Construire une réponse nuancée : l’art peut divertir, exprimer, dénoncer ou révéler."
                ),
                List.of(
                        "Platon : l’art peut être imitation des apparences.",
                        "Aristote : l’imitation peut instruire et produire du plaisir.",
                        "Kant : le jugement de goût est subjectif mais prétend à l’universalité.",
                        "Hegel : l’art donne une forme sensible aux idées.",
                        "Exemples : Guernica, La Joconde, cinéma engagé, musique, théâtre."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi l’art occupe une place importante dans la vie humaine. L’art ne sert pas seulement à faire joli : il peut exprimer une émotion, dénoncer une injustice, représenter une époque ou changer notre regard sur le monde."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans une dissertation, il faut éviter de réduire l’art à la beauté. Il faut montrer que l’art peut plaire, mais aussi troubler, critiquer, instruire ou révéler. Les exemples d’œuvres sont très importants."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "On peut l’utiliser pour des sujets comme : L’art doit-il imiter la nature ? Une œuvre d’art doit-elle être belle ? L’art nous éloigne-t-il du réel ou nous le révèle-t-il ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent bonheur(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Le bonheur",
                "Le bonheur désigne un état durable de satisfaction ou d’accomplissement. Il se distingue du simple plaisir, qui est souvent plus court et plus immédiat. Le chapitre interroge la possibilité d’être heureux et les conditions d’une vie réussie.",
                List.of(
                        "Le bonheur n’est pas forcément la somme des plaisirs.",
                        "Le désir peut conduire au bonheur mais aussi à l’insatisfaction permanente.",
                        "Le bonheur peut dépendre de soi, des autres, de la société ou du hasard.",
                        "Être heureux suppose parfois de maîtriser ses désirs.",
                        "La question principale est de savoir si le bonheur est un idéal accessible ou impossible."
                ),
                List.of(
                        "Distinguer bonheur, plaisir, joie et satisfaction.",
                        "Identifier si le sujet parle d’un bonheur individuel ou collectif.",
                        "Analyser le rôle du désir.",
                        "Se demander si le bonheur dépend de nous.",
                        "Nuancer : le bonheur peut être recherché, mais il ne se commande pas totalement."
                ),
                List.of(
                        "Épicure : le bonheur suppose de limiter les désirs inutiles.",
                        "Stoïciens : il faut distinguer ce qui dépend de nous et ce qui n’en dépend pas.",
                        "Kant : le bonheur est un idéal de l’imagination difficile à définir précisément.",
                        "Aristote : le bonheur est lié à l’accomplissement d’une vie vertueuse.",
                        "Exemples : consommation, réussite, amitié, sagesse, liberté."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à réfléchir à ce que signifie réussir sa vie. Il permet de distinguer le plaisir immédiat du bonheur durable, et de comprendre pourquoi la recherche du bonheur peut parfois rendre malheureux."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut toujours commencer par distinguer bonheur et plaisir. Ensuite, on peut montrer que le bonheur dépend à la fois de nos choix, de nos désirs, de nos relations et des circonstances."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Le bonheur dépend-il de nous ? Faut-il satisfaire tous ses désirs pour être heureux ? Le bonheur est-il le but de la vie ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent conscience(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La conscience",
                "La conscience est la capacité de se représenter soi-même et le monde. Être conscient, ce n’est pas seulement percevoir : c’est aussi savoir que l’on perçoit, penser ses actes et pouvoir se juger soi-même.",
                List.of(
                        "La conscience permet à l’être humain de se connaître et de réfléchir.",
                        "Elle donne une distance par rapport à ses actes et ses pensées.",
                        "La conscience morale permet de juger le bien et le mal.",
                        "La conscience peut être source de liberté, mais aussi d’angoisse.",
                        "La conscience n’est pas forcément transparente à elle-même."
                ),
                List.of(
                        "Distinguer conscience psychologique et conscience morale.",
                        "Se demander si la conscience permet vraiment de se connaître.",
                        "Analyser le rapport entre conscience et liberté.",
                        "Montrer que la conscience peut aussi être limitée.",
                        "Utiliser des exemples de responsabilité, regret, choix, introspection."
                ),
                List.of(
                        "Descartes : le cogito, « je pense donc je suis ».",
                        "Sartre : la conscience est liberté et responsabilité.",
                        "Freud : la conscience n’est pas maîtresse de toute la vie psychique.",
                        "Exemples : remords, décision morale, introspection, mauvaise foi."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre ce qui fait de l’homme un être capable de réflexion. Grâce à la conscience, on peut se reconnaître comme sujet, juger ses actes et se projeter dans l’avenir."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans un sujet, il faut bien distinguer être conscient de quelque chose et avoir une conscience morale. On peut aussi montrer les limites de la conscience avec l’inconscient."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : La conscience de soi suffit-elle à se connaître ? La conscience fait-elle notre liberté ? Peut-on échapper à sa conscience ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent devoir(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Le devoir",
                "Le devoir désigne ce que l’on se sent obligé de faire moralement, même lorsque cela va contre nos désirs ou nos intérêts. Il pose la question de l’obligation morale, de la liberté et de la responsabilité.",
                List.of(
                        "Le devoir n’est pas une contrainte extérieure simple : il engage la conscience morale.",
                        "Faire son devoir peut aller contre ses envies.",
                        "Le devoir suppose que l’on soit responsable de ses actes.",
                        "Il peut entrer en conflit avec le bonheur ou l’intérêt personnel.",
                        "Obéir par peur n’est pas forcément agir moralement."
                ),
                List.of(
                        "Distinguer obligation morale, obligation légale et contrainte.",
                        "Se demander pourquoi on doit faire son devoir.",
                        "Analyser le rôle de la liberté dans l’action morale.",
                        "Chercher s’il existe des devoirs universels.",
                        "Nuancer avec les conflits de devoirs."
                ),
                List.of(
                        "Kant : agir par devoir, c’est agir par respect pour la loi morale.",
                        "Rousseau : obéir à la loi qu’on s’est prescrite est liberté.",
                        "Exemples : dire la vérité, aider autrui, respecter une promesse, désobéir à une loi injuste."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi certaines actions semblent obligatoires moralement, même lorsqu’elles sont difficiles. Il permet de réfléchir à la responsabilité et à la différence entre obéir et agir moralement."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut distinguer la contrainte extérieure du devoir moral. Une action a plus de valeur morale si elle est faite librement par respect pour ce qui est juste."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Faut-il toujours faire son devoir ? Le devoir s’oppose-t-il au bonheur ? Peut-on être libre en obéissant au devoir ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent etat(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "L’État",
                "L’État désigne l’organisation politique qui exerce une autorité souveraine sur un territoire et une population. Il pose la question de la loi, de la sécurité, de la liberté et de la légitimité du pouvoir.",
                List.of(
                        "L’État organise la vie collective grâce aux lois et aux institutions.",
                        "Il peut garantir la sécurité et les libertés.",
                        "Mais il peut aussi devenir oppressif s’il abuse de son pouvoir.",
                        "La question centrale est celle de la légitimité de l’autorité.",
                        "Le pouvoir politique doit être distingué de la violence pure."
                ),
                List.of(
                        "Définir État, société, pouvoir et loi.",
                        "Se demander pourquoi les hommes acceptent l’autorité de l’État.",
                        "Analyser le rapport entre sécurité et liberté.",
                        "Distinguer État légitime et tyrannie.",
                        "Utiliser des exemples : démocratie, dictature, contrat social, institutions."
                ),
                List.of(
                        "Hobbes : l’État protège les hommes contre la violence de l’état de nature.",
                        "Rousseau : le contrat social fonde une autorité légitime.",
                        "Montesquieu : la séparation des pouvoirs limite les abus.",
                        "Max Weber : l’État revendique le monopole de la violence légitime."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi une société a besoin d’institutions, de lois et d’un pouvoir commun. Il permet aussi de réfléchir aux dangers d’un pouvoir trop fort."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut toujours poser la tension entre sécurité et liberté. L’État protège, mais il peut aussi limiter. La question est donc de savoir quand son autorité est légitime."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : L’État est-il nécessaire ? L’État limite-t-il la liberté ? Peut-on vivre sans lois ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent inconscient(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "L’inconscient",
                "L’inconscient désigne une partie de la vie psychique qui échappe à la conscience mais influence nos pensées, nos désirs et nos actes. Cette notion remet en question l’idée que l’homme se connaît parfaitement.",
                List.of(
                        "L’inconscient montre que tout dans l’esprit n’est pas conscient.",
                        "Certains désirs ou souvenirs peuvent agir sans être clairement connus.",
                        "Les rêves, lapsus et symptômes peuvent révéler l’inconscient.",
                        "Cette notion limite l’idée d’une conscience totalement maîtresse d’elle-même.",
                        "Elle pose la question de la liberté et de la responsabilité."
                ),
                List.of(
                        "Distinguer inconscient, oubli, réflexe et ignorance.",
                        "Comprendre en quoi l’inconscient agit sur le sujet.",
                        "Analyser les conséquences sur la liberté.",
                        "Opposer la transparence de la conscience à ses limites.",
                        "Utiliser des exemples : rêves, lapsus, actes manqués, refoulement."
                ),
                List.of(
                        "Freud : l’inconscient contient des désirs refoulés.",
                        "Descartes : la pensée est liée à la conscience.",
                        "Sartre critique l’idée d’un inconscient qui déresponsabilise totalement.",
                        "Exemples : rêve, lapsus, acte manqué, symptôme."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre que l’être humain ne se connaît pas totalement. Il montre que certains comportements peuvent avoir des causes profondes que la conscience ignore."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans une dissertation, il faut montrer que l’inconscient remet en cause la maîtrise de soi, mais sans forcément supprimer toute responsabilité."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Sommes-nous maîtres de nous-mêmes ? L’inconscient excuse-t-il nos actes ? Peut-on se connaître soi-même ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent justice(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La justice",
                "La justice peut désigner une institution, une vertu ou un idéal d’égalité et d’équité. Elle interroge le rapport entre droit, morale, égalité, mérite et sanction.",
                List.of(
                        "La justice n’est pas seulement l’application mécanique de la loi.",
                        "Le droit peut être légal sans être moralement juste.",
                        "L’égalité ne signifie pas toujours traiter tout le monde de manière identique.",
                        "L’équité consiste à adapter la règle aux situations.",
                        "La justice suppose une réflexion sur le mérite, les droits et les devoirs."
                ),
                List.of(
                        "Distinguer justice institutionnelle, justice morale et justice sociale.",
                        "Analyser le rapport entre droit et morale.",
                        "Se demander si l’égalité suffit à être juste.",
                        "Utiliser des exemples de sanctions, lois, inégalités, droits.",
                        "Nuancer entre égalité stricte et équité."
                ),
                List.of(
                        "Aristote : justice distributive et corrective.",
                        "Rawls : une société juste protège les plus défavorisés.",
                        "Platon : la justice est harmonie dans la cité et dans l’âme.",
                        "Exemples : égalité devant la loi, impôts, école, sanctions."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment une société peut être organisée de façon juste. Il permet de réfléchir aux lois, aux inégalités, aux sanctions et aux droits."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut distinguer ce qui est légal et ce qui est juste. Une loi peut être légale mais contestable moralement. Il faut aussi distinguer égalité et équité."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : La loi est-elle toujours juste ? Faut-il traiter tout le monde de la même manière ? La justice peut-elle être injuste ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent langage(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Le langage",
                "Le langage est la capacité humaine de communiquer et de penser à l’aide de signes. Il permet d’exprimer des idées, de transmettre une culture, mais il peut aussi déformer ou limiter la pensée.",
                List.of(
                        "Le langage permet la communication entre les individus.",
                        "Il sert aussi à structurer la pensée.",
                        "Les mots ne sont pas les choses : ils représentent le réel.",
                        "Le langage peut être source de vérité, mais aussi de mensonge ou de manipulation.",
                        "Il distingue en grande partie l’homme de l’animal."
                ),
                List.of(
                        "Distinguer langage, langue et parole.",
                        "Se demander si l’on pense avant ou grâce aux mots.",
                        "Analyser le pouvoir du langage sur autrui.",
                        "Étudier les limites du langage.",
                        "Utiliser des exemples : dialogue, mensonge, poésie, politique, traduction."
                ),
                List.of(
                        "Aristote : l’homme est un animal politique parce qu’il possède le langage.",
                        "Saussure : la langue est un système de signes.",
                        "Bergson : le langage simplifie parfois la richesse du réel.",
                        "Exemples : promesse, ordre, mensonge, débat, poésie."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre que le langage ne sert pas seulement à parler. Il permet de penser, de convaincre, d’échanger, de transmettre et parfois de manipuler."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut distinguer communiquer et penser. On peut montrer que le langage aide la pensée, mais qu’il peut aussi la limiter avec des mots trop généraux."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Les mots trahissent-ils la pensée ? Peut-on penser sans langage ? Le langage sert-il seulement à communiquer ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent liberte(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La liberté",
                "La liberté désigne la capacité d’agir selon sa volonté, mais elle ne signifie pas forcément faire tout ce que l’on veut. Elle interroge les limites, la responsabilité, la loi et le déterminisme.",
                List.of(
                        "Être libre ne signifie pas forcément être sans contraintes.",
                        "La liberté suppose souvent la responsabilité.",
                        "La loi peut limiter la liberté mais aussi la protéger.",
                        "Le déterminisme remet en question l’idée de libre arbitre.",
                        "La liberté peut être intérieure, politique ou morale."
                ),
                List.of(
                        "Distinguer liberté naturelle, liberté politique et liberté morale.",
                        "Se demander si une contrainte supprime toujours la liberté.",
                        "Analyser le rapport entre liberté et loi.",
                        "Étudier la question du déterminisme.",
                        "Nuancer entre indépendance, autonomie et responsabilité."
                ),
                List.of(
                        "Rousseau : obéir à la loi qu’on s’est prescrite est liberté.",
                        "Spinoza : les hommes se croient libres parce qu’ils ignorent les causes qui les déterminent.",
                        "Sartre : l’homme est condamné à être libre.",
                        "Kant : l’autonomie est la capacité de se donner à soi-même la loi morale."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre ce que signifie vraiment être libre. Il permet d’éviter l’idée trop simple selon laquelle la liberté serait seulement faire ce qu’on veut."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut toujours se demander si la contrainte détruit la liberté ou si elle peut parfois la rendre possible, par exemple avec des lois qui protègent les droits."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Être libre, est-ce faire ce que l’on veut ? La loi est-elle ennemie de la liberté ? Sommes-nous responsables de ce que nous sommes ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent nature(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La nature",
                "La nature désigne ce qui existe indépendamment de l’action humaine, mais aussi l’essence d’une chose. Le chapitre interroge le rapport entre l’homme et la nature, entre naturel et artificiel.",
                List.of(
                        "La nature peut désigner le monde non transformé par l’homme.",
                        "Elle peut aussi désigner l’essence d’un être.",
                        "L’homme fait partie de la nature mais la transforme par la technique.",
                        "Opposer nature et culture est parfois trop simple.",
                        "La crise écologique oblige à repenser notre rapport à la nature."
                ),
                List.of(
                        "Distinguer nature comme monde extérieur et nature comme essence.",
                        "Analyser l’opposition entre naturel et artificiel.",
                        "Se demander si l’homme est séparé de la nature.",
                        "Utiliser des exemples de technique, écologie, culture, instinct.",
                        "Nuancer le rapport domination/protection."
                ),
                List.of(
                        "Aristote : la nature d’un être est sa finalité propre.",
                        "Descartes : l’homme peut se rendre comme maître et possesseur de la nature.",
                        "Rousseau : la société transforme l’homme naturel.",
                        "Exemples : environnement, technique, culture, instinct, écologie."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre notre rapport au monde vivant et au réel non fabriqué par l’homme. Il permet aussi de réfléchir aux limites de la transformation technique de la nature."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut éviter de penser que nature signifie toujours ce qui est bon. Il faut distinguer le naturel, l’artificiel, le culturel et l’essence d’une chose."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Faut-il respecter la nature ? L’homme est-il un être naturel ? La technique nous éloigne-t-elle de la nature ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent raison(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La raison",
                "La raison est la faculté de penser, de juger, de démontrer et de distinguer le vrai du faux. Elle permet de dépasser les opinions immédiates, mais elle a aussi des limites.",
                List.of(
                        "La raison permet de construire des raisonnements cohérents.",
                        "Elle s’oppose à la simple opinion ou au préjugé.",
                        "Elle est essentielle dans la science, la morale et la philosophie.",
                        "Mais elle ne peut pas tout expliquer, notamment certaines émotions ou croyances.",
                        "La raison doit parfois reconnaître ses propres limites."
                ),
                List.of(
                        "Définir la raison comme faculté de juger et de démontrer.",
                        "Distinguer raison, opinion, croyance et passion.",
                        "Se demander si la raison suffit à guider l’homme.",
                        "Analyser ses pouvoirs et ses limites.",
                        "Utiliser des exemples scientifiques, moraux ou politiques."
                ),
                List.of(
                        "Descartes : le bon sens est la chose du monde la mieux partagée.",
                        "Kant : la raison doit connaître ses limites.",
                        "Platon : la raison doit guider l’âme contre les passions.",
                        "Pascal : le cœur a ses raisons que la raison ne connaît point."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment l’être humain peut penser correctement, argumenter, démontrer et éviter les préjugés. La raison est au centre de la philosophie et de la science."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans un sujet, il faut montrer que la raison permet de dépasser l’opinion, mais qu’elle ne règle pas tout. Certaines dimensions humaines comme les émotions, la foi ou le désir posent la question de ses limites."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : La raison peut-elle tout comprendre ? Faut-il toujours suivre sa raison ? La raison s’oppose-t-elle aux passions ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent religion(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La religion",
                "La religion désigne un ensemble de croyances, de rites et de pratiques reliant les hommes à une réalité sacrée ou divine. Elle pose la question de la foi, de la raison, de la société et de la liberté.",
                List.of(
                        "La religion donne du sens à l’existence et à la mort.",
                        "Elle crée du lien social grâce aux rites et aux croyances partagées.",
                        "Elle peut entrer en tension avec la raison scientifique.",
                        "La foi ne fonctionne pas comme une démonstration rationnelle.",
                        "La religion peut libérer, rassurer, mais aussi être instrumentalisée."
                ),
                List.of(
                        "Distinguer foi, croyance, superstition et savoir.",
                        "Analyser le rapport entre religion et raison.",
                        "Se demander si la religion est individuelle ou sociale.",
                        "Étudier son rôle moral, existentiel et politique.",
                        "Nuancer : elle peut unir ou diviser."
                ),
                List.of(
                        "Durkheim : la religion est un fait social qui unit une communauté.",
                        "Marx : la religion peut être une consolation face à la souffrance sociale.",
                        "Pascal : la foi ne relève pas seulement de la raison.",
                        "Exemples : rites, prière, morale, laïcité, croyance."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi les hommes croient, pratiquent des rites et cherchent un sens au-delà du monde matériel. Il permet aussi de réfléchir à la place de la religion dans la société."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut distinguer croire et savoir. La religion ne repose pas sur la démonstration scientifique, mais elle peut avoir une fonction morale, sociale et existentielle."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : La religion est-elle contraire à la raison ? Pourquoi les hommes ont-ils besoin de religion ? La religion unit-elle les hommes ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent science(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La science",
                "La science vise une connaissance rationnelle, vérifiable et organisée du réel. Elle se distingue de l’opinion par la méthode, la preuve, l’expérimentation et la remise en question.",
                List.of(
                        "La science cherche à produire des connaissances objectives.",
                        "Elle repose sur des méthodes, des preuves et des expériences.",
                        "Une théorie scientifique doit pouvoir être discutée et testée.",
                        "La science progresse en corrigeant ses erreurs.",
                        "Elle ne répond pas forcément à toutes les questions humaines."
                ),
                List.of(
                        "Distinguer science, opinion, croyance et technique.",
                        "Analyser le rôle de l’expérience et de la démonstration.",
                        "Se demander si la science peut atteindre la vérité.",
                        "Étudier ses limites éthiques et pratiques.",
                        "Utiliser des exemples : médecine, physique, climat, expérimentation."
                ),
                List.of(
                        "Bachelard : la science progresse contre les opinions premières.",
                        "Popper : une théorie scientifique doit être réfutable.",
                        "Descartes : la méthode est essentielle pour bien conduire sa raison.",
                        "Exemples : hypothèse, expérience, théorie, erreur, modèle."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre ce qui distingue une connaissance scientifique d’une simple opinion. La science cherche des preuves, construit des modèles et accepte la correction."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans une dissertation, il faut insister sur la méthode : observation, hypothèse, expérimentation, démonstration. Mais il faut aussi montrer que la science a des limites."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : La science dit-elle toujours la vérité ? La science peut-elle tout expliquer ? L’opinion est-elle l’ennemie de la science ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent technique(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La technique",
                "La technique désigne l’ensemble des moyens inventés par l’homme pour transformer la nature et atteindre des fins pratiques. Elle augmente notre puissance, mais pose aussi des problèmes éthiques et écologiques.",
                List.of(
                        "La technique permet à l’homme de transformer son environnement.",
                        "Elle répond à des besoins mais crée aussi de nouveaux désirs.",
                        "Elle peut libérer l’homme de certaines contraintes naturelles.",
                        "Mais elle peut aussi le rendre dépendant.",
                        "Le progrès technique n’est pas toujours un progrès moral."
                ),
                List.of(
                        "Distinguer technique, science, outil et progrès.",
                        "Analyser ce que la technique apporte à l’homme.",
                        "Se demander si elle nous rend plus libres.",
                        "Étudier ses risques : dépendance, destruction, déshumanisation.",
                        "Nuancer entre maîtrise et responsabilité."
                ),
                List.of(
                        "Descartes : devenir comme maîtres et possesseurs de la nature.",
                        "Heidegger : la technique moderne transforme notre rapport au monde.",
                        "Jonas : la puissance technique impose une responsabilité nouvelle.",
                        "Exemples : IA, médecine, aviation, réseaux sociaux, nucléaire."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre comment les outils et les inventions modifient la vie humaine. La technique permet d’agir sur le monde, mais elle pose aussi la question de ses limites."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut éviter de dire simplement que la technique est bonne ou mauvaise. Elle dépend de ses usages, de ses buts et de la responsabilité humaine."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : La technique nous rend-elle libres ? Le progrès technique est-il toujours un progrès ? Faut-il limiter la technique ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent temps(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Le temps",
                "Le temps est à la fois une dimension objective du monde et une expérience subjective vécue par la conscience. Il interroge le changement, la mémoire, l’avenir et la condition humaine.",
                List.of(
                        "Le temps peut être mesuré objectivement par les horloges.",
                        "Mais il est aussi vécu subjectivement : attente, ennui, souvenir.",
                        "Le temps transforme les êtres et les choses.",
                        "La conscience humaine est marquée par le passé et l’avenir.",
                        "Le temps pose la question de la mort et de la finitude."
                ),
                List.of(
                        "Distinguer temps objectif et temps vécu.",
                        "Analyser le rapport entre temps, mémoire et identité.",
                        "Se demander si l’on peut maîtriser le temps.",
                        "Étudier le rôle de l’avenir et du passé.",
                        "Utiliser des exemples : attente, vieillissement, souvenir, projet."
                ),
                List.of(
                        "Augustin : le temps existe dans l’âme par mémoire, attention et attente.",
                        "Bergson : la durée vécue n’est pas le temps mesuré.",
                        "Heidegger : l’existence humaine est marquée par la finitude.",
                        "Exemples : horloge, souvenir, attente, vieillissement."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le temps n’est pas seulement une mesure. Il est aussi une expérience intime : attendre cinq minutes peut paraître long ou court selon la situation."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut distinguer le temps physique, mesurable, et le temps vécu par la conscience. Cette différence est très utile pour construire une dissertation."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Le temps nous appartient-il ? Peut-on vivre sans penser au passé ? Le temps est-il seulement ce que mesure l’horloge ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent travail(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "Le travail",
                "Le travail est une activité par laquelle l’homme transforme la nature, produit des biens ou services, et se transforme lui-même. Il peut être une contrainte, mais aussi une source de liberté et de reconnaissance.",
                List.of(
                        "Le travail répond à des besoins matériels.",
                        "Il transforme la nature et le monde humain.",
                        "Il peut développer les capacités et l’autonomie.",
                        "Mais il peut aussi être pénible, aliénant ou exploité.",
                        "Le travail a une dimension sociale : reconnaissance, statut, utilité."
                ),
                List.of(
                        "Distinguer travail, emploi, activité et production.",
                        "Analyser le rapport entre travail et liberté.",
                        "Se demander si le travail humanise ou aliène.",
                        "Étudier le rôle social du travail.",
                        "Utiliser des exemples : métier, usine, création, chômage, automatisation."
                ),
                List.of(
                        "Marx : le travail peut être aliéné dans le système capitaliste.",
                        "Hegel : le travail forme la conscience et transforme le monde.",
                        "Arendt : travail, œuvre et action doivent être distingués.",
                        "Exemples : artisanat, salariat, robotisation, reconnaissance sociale."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre pourquoi le travail est central dans la vie humaine. Il permet de survivre, de produire, de s’intégrer socialement et parfois de se réaliser."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Il faut montrer l’ambivalence du travail : il peut libérer en donnant autonomie et reconnaissance, mais aussi aliéner s’il devient répétitif, subi ou exploité."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Le travail rend-il libre ? Le travail est-il seulement une contrainte ? Peut-on se réaliser dans le travail ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent verite(String matiere, String chapitre) {
        return build(
                matiere,
                chapitre,
                "La vérité",
                "La vérité désigne l’accord entre ce que l’on affirme et ce qui est. Elle s’oppose à l’erreur, au mensonge et à l’illusion. Le chapitre interroge les critères du vrai et la possibilité d’atteindre une vérité certaine.",
                List.of(
                        "La vérité se distingue de l’opinion.",
                        "Une affirmation vraie doit pouvoir être justifiée.",
                        "Le mensonge suppose de connaître la vérité mais de la cacher.",
                        "L’erreur est une fausse croyance involontaire.",
                        "La vérité peut être scientifique, morale, historique ou personnelle."
                ),
                List.of(
                        "Distinguer vérité, opinion, croyance, erreur et mensonge.",
                        "Se demander comment reconnaître le vrai.",
                        "Analyser le rôle de la preuve et de la démonstration.",
                        "Étudier les limites de la certitude.",
                        "Nuancer selon les domaines : science, morale, histoire."
                ),
                List.of(
                        "Descartes : chercher une vérité certaine par le doute méthodique.",
                        "Platon : sortir de l’opinion pour atteindre la connaissance.",
                        "Nietzsche : critique de la prétention à une vérité absolue.",
                        "Exemples : preuve scientifique, témoignage, illusion, mensonge."
                ),
                List.of(
                        new ExplanationBlock(
                                "À quoi ça sert ?",
                                "Ce chapitre sert à comprendre ce qui distingue une simple opinion d’une affirmation vraie. Il est essentiel pour réfléchir à la preuve, au doute et à la connaissance."
                        ),
                        new ExplanationBlock(
                                "Comment l’utiliser ?",
                                "Dans un sujet, il faut toujours distinguer erreur, mensonge, illusion et opinion. Ensuite, il faut demander quels critères permettent de reconnaître la vérité."
                        ),
                        new ExplanationBlock(
                                "Dans quels sujets ?",
                                "Exemples : Peut-on douter de tout ? Toute vérité est-elle bonne à dire ? L’opinion peut-elle contenir une part de vérité ?"
                        )
                ),
                "philo"
        );
    }

    private CourseContent coursPhiloEnPreparation(String matiere, String chapitre) {
        return new CourseContent(
                matiere,
                chapitre,
                "Cours de philosophie en préparation",
                "Ce chapitre de philosophie n’a pas encore été ajouté en version complète.",
                List.of(
                        "Chapitre non encore rédigé.",
                        "Les notions principales de philosophie sont déjà disponibles.",
                        "Le contenu sera enrichi dans une prochaine mise à jour."
                ),
                List.of(
                        "Revenir après la prochaine mise à jour.",
                        "Réviser les notions principales en attendant.",
                        "Préparer une problématique et des définitions."
                ),
                List.of(
                        "Aucun repère détaillé disponible pour le moment."
                ),
                List.of(
                        new VideoLink("Recherche vidéo — " + chapitre, youtube("philosophie terminale " + chapitre))
                ),
                List.of(
                        new QuizQuestion("Pourquoi ce chapitre n’est pas complet ?", "Parce qu’il n’a pas encore été rédigé dans le provider philosophie.")
                ),
                "philo",
                List.of(
                        new ExplanationBlock(
                                "Cours en préparation",
                                "Ce chapitre sera ajouté avec un vrai résumé, des auteurs, des exemples, une méthode et un quiz."
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
                        new VideoLink("Cours vidéo — " + title, youtube("philosophie terminale " + title)),
                        new VideoLink("Méthode dissertation — " + title, youtube("méthode dissertation philosophie terminale " + title)),
                        new VideoLink("Explication de texte — " + title, youtube("méthode explication de texte philosophie terminale"))
                ),
                List.of(
                        new QuizQuestion(
                                "Quelle est l’idée centrale du chapitre ?",
                                "Il faut comprendre la définition de la notion et le problème philosophique qu’elle pose."
                        ),
                        new QuizQuestion(
                                "Pourquoi faut-il définir les mots du sujet ?",
                                "Parce qu’en philosophie, une mauvaise définition mène souvent au hors-sujet."
                        ),
                        new QuizQuestion(
                                "Que faut-il mettre dans une dissertation ?",
                                "Des définitions, une problématique, des arguments, des exemples et si possible des auteurs."
                        ),
                        new QuizQuestion(
                                "Comment éviter de réciter le cours ?",
                                "Il faut utiliser le cours pour répondre précisément au sujet, pas seulement répéter des connaissances."
                        )
                ),
                type,
                explanations
        );
    }
}