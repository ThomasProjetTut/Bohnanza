package controller;

//import jdk.nashorn.internal.ir.SplitReturn;
import model.Carte.Carte;
import model.Joueur;
import model.Pioche;
import model.Zone;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.event.Event;
import view.Vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controlleur {

    private int compteurTour;

    private Vue vue;
    private Joueur[] joueurs;
    private Joueur joueurActif;
    private Pioche pioche;
    private Zone zonePioche;

    public Controlleur() throws IOException {
        vue = new Vue();
        joueurs = new Joueur[4];
        Joueur joueur1 = new Joueur("Joueur 1", 1);
        Joueur joueur2 = new Joueur("Joueur 2", 2);
        Joueur joueur3 = new Joueur("Joueur 3", 3);
        Joueur joueur4 = new Joueur("Joueur 4", 4);

        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        joueurs[2] = joueur3;
        joueurs[3] = joueur4;

        joueurActif = joueurs[0];

        pioche = new Pioche();
        zonePioche = new Zone();

        jeu();

    }

    private void jeu() {
        compteurTour = 1;

        for (Joueur j : joueurs) {
            j.recoisMain(pioche);
            j.afficherMain();
            actualiserMain(j);
        }
        System.out.println("Taille de la pioche : " + pioche.getTaillePioche());

        while (vue.getFenetre().isOpen()) {

            etapePlanter();
        }
    }

    private void etapePlanter() {

        System.out.println("ETAPE PLANTER");
        vue.afficherEtape(1);
        vue.creationSpriteCliquableEtape1(joueurActif.getIdJoueur());
        vue.actualiserFenetre();

        int nbplants = 0;
        System.out.println("nb plant  = " + nbplants);

        while (vue.getFenetre().isOpen()) {
            for (Event event : vue.getFenetre().pollEvents()) {

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if (nbplants >= 1) {

                        if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[0], vue.getFenetre())) {
                            etapeEchange();
                            return;
                        }
                    }

                    if (nbplants < 2) {
                        System.out.println("nb plant  = " + nbplants);


                        if (vue.cliqueSprite(event, vue.getSprsChamps()[joueurActif.getIdJoueur() - 1][0], vue.getFenetre())) {
                            System.out.println("plante premier champ");

                            vue.planterChamp(joueurActif.getIdJoueur() - 1, 0, joueurActif.getMain().get(0).getIdCarte());
                            joueurActif.planter(1, pioche);
                            actualiserMain(joueurActif);
                            vue.actualiserFenetre();

                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        } else if (vue.cliqueSprite(event, vue.getSprsChamps()[joueurActif.getIdJoueur() - 1][1], vue.getFenetre())) {
                            System.out.println("plante deuxième champ");

                            vue.planterChamp(joueurActif.getIdJoueur() - 1, 1, joueurActif.getMain().get(0).getIdCarte());
                            joueurActif.planter(2, pioche);
                            actualiserMain(joueurActif);
                            vue.actualiserFenetre();

                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        } else if (joueurActif.getMaxChamps() >= 3 && vue.cliqueSprite(event, vue.getSprsChamps()[joueurActif.getIdJoueur() - 1][2], vue.getFenetre())) {

                            System.out.println("plante troisième champ");

                            vue.planterChamp(joueurActif.getIdJoueur() - 1, 2, joueurActif.getMain().get(0).getIdCarte());
                            joueurActif.planter(3, pioche);
                            actualiserMain(joueurActif);
                            vue.actualiserFenetre();

                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        }
                    }
                }
            }
        }
    }

    //ETAPE ECHANGE

    private void etapeEchange() {
        System.out.println("ETAPE ECHANGE");

        zonePioche.ajouterCarte(pioche.giveNextCarte());
        zonePioche.ajouterCarte(pioche.giveNextCarte());
        setTxtZonePioche();

        int carteNonJouee = zonePioche.getZone().size();
        boolean retour;

        vue.afficherEtape(2);
        vue.actualiserFenetreEchange();

        Sprite carte1 = vue.getSprCartePiochee1();
        Sprite carte2 = vue.getSprCartePiochee2();

        vue.creationSpriteCliquableCarte();

        while (vue.getFenetre().isOpen()) {
            for (Event event : vue.getFenetre().pollEvents()) {

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    if (vue.cliqueSprite(event, carte1, vue.getFenetre())) {
                        System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

                        vue.creerMenuCarte(carte1.getPosition().x + 75, carte1.getPosition().y);
                        vue.actualiserFenetreEchangeMenu();
                        retour = etapeEchangeMenuCarte(1);
                        vue.creationSpriteCliquableCarte();
                        vue.clearZonesEchanges();
                        putSprite();
                        vue.actualiserFenetreEchange();
                        if (carteNonJouee == 1) {
                            vue.delSpriteCliquable(carte2);
                        }
                        if (retour) {
                            vue.delSpriteCliquable(carte1);
                            carteNonJouee--;
                        }

                    } else if (vue.cliqueSprite(event, carte2, vue.getFenetre())) {

                        System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());
                        vue.creerMenuCarte(carte2.getPosition().x + 75, carte2.getPosition().y);
                        vue.actualiserFenetreEchangeMenu();
                        retour = etapeEchangeMenuCarte(2);
                        vue.creationSpriteCliquableCarte();
                        vue.clearZonesEchanges();
                        putSprite();
                        vue.actualiserFenetreEchange();
                        if (carteNonJouee == 1) {
                            vue.delSpriteCliquable(carte1);
                        }
                        if (retour) {
                            vue.delSpriteCliquable(carte2);
                            carteNonJouee--;
                        }
                    }

                    System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

                    for (Sprite sprite : vue.getSpriteCliquable()) {
                        System.out.println(sprite.getPosition().x + ", " + sprite.getPosition().y);
                    }

                    if (carteNonJouee == 0) {

                        if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[1], vue.getFenetre())) {

                            zonePioche.clear();
                            etapePlantageEchange();
                            return;
                        }
                    }
                }
            }
        }
    }

    private boolean etapeEchangeMenuCarte(int choixCarte) {
        vue.creationSpriteCliquableMenuCarte();

        while (vue.getFenetre().isOpen()) {
            for (Event eventMenu : vue.getFenetre().pollEvents()) {


                if (eventMenu.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (eventMenu.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if (vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[2], vue.getFenetre())) {
                        System.out.println("GARDER");

                        //METTRE LA CARTE 1 DE ZONE PIOCHE DANS LA ZONE ECHANGE DU JOUEUR ACTIF
                        joueurActif.getZoneEchange().ajouterCarte(zonePioche.getZone().get(choixCarte - 1));


                        vue.garderCarte(choixCarte, joueurActif.getIdJoueur());
                        vue.creationSpriteCliquableCarte();
                        return true;

                    } else if (vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[0], vue.getFenetre())) {

                        System.out.println("ECHANGE");

                        vue.creerMenuCarteChoix(vue.getSprsMenuCartes()[0].getPosition().x + 140, vue.getSprsMenuCartes()[0].getPosition().y - 10);
                        vue.actualiserFenetreEchangeMenuChoix();
                        int carteDemande = etapeEchangeMenuCarteChoix();
                        vue.creationSpriteCliquableMenuCarte();
                        vue.actualiserFenetreEchangeMenu();
                        return carteDemande != -1 && etapeDemandeEchangeAcceptation(choixCarte, carteDemande);

                    } else if (vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[1], vue.getFenetre())) {

                        System.out.println("DON");

                        vue.creationSpriteCliquableDon(joueurActif.getIdJoueur());
                        vue.actualiserFenetreEchange();
                        int choixJoueur = etapeEchangeMenuCarteDon();

                        if (choixJoueur == 0) {
                            return false;
                        } else if (etapeConfirmation(choixJoueur, vue.getSprsJoueurs()[choixJoueur - 1])) {
                            joueurs[choixJoueur - 1].recoisCarte(zonePioche.getZone().get(choixCarte - 1));
                            vue.donnerCarte(choixCarte, choixJoueur - 1);
                            return true;
                        } else {
                            return false;
                        }

                    } else if (vue.cliqueSprite(eventMenu, vue.getFond(), vue.getFenetre())) {

                        System.out.println("RETOUR");

                        vue.actualiserFenetreEchange();
                        vue.creationSpriteCliquableCarte();
                        return false;

                    }
                }
            }
        }
        return false;
    }

    private boolean etapeDemandeEchangeAcceptation(int idCarte, int idCarteVoulu) {

        Sprite[] spriteJoueur;
        spriteJoueur = vue.getSprsAutresJoueurs(joueurActif.getIdJoueur());

        ArrayList<Sprite> joueursConcernes = new ArrayList<>();
        List<Integer> numJoueurConcerne = new ArrayList<>();
        for (Sprite sprite : spriteJoueur) {

            if (sprite == vue.getSprJoueurAttente1()) {
                if (joueurs[0].haveCarteInMain(idCarteVoulu)) {
                    System.out.println("Le joueur 1 a une patate d'id n°" + idCarteVoulu);
                    joueursConcernes.add(sprite);
                    numJoueurConcerne.add(1);
                }
            } else if (sprite == vue.getSprJoueurAttente2()) {
                if (joueurs[1].haveCarteInMain(idCarteVoulu)) {
                    System.out.println("Le joueur 2 a une patate d'id n°" + idCarteVoulu);
                    joueursConcernes.add(sprite);
                    numJoueurConcerne.add(2);
                }
            } else if (sprite == vue.getSprJoueurAttente3()) {
                if (joueurs[2].haveCarteInMain(idCarteVoulu)) {
                    System.out.println("Le joueur 3 a une patate d'id n°" + idCarteVoulu);
                    joueursConcernes.add(sprite);
                    numJoueurConcerne.add(3);
                }
            } else if (sprite == vue.getSprJoueurAttente4()) {
                if (joueurs[3].haveCarteInMain(idCarteVoulu)) {
                    System.out.println("Le joueur 4 a une patate d'id n°" + idCarteVoulu);
                    joueursConcernes.add(sprite);
                    numJoueurConcerne.add(4);
                }
            }
        }

        for (int i = 0; i < numJoueurConcerne.size(); i++) {
            vue.clearSpritesCliquables();
            vue.setSpriteCliquable(joueursConcernes.get(i));
            if (etapeConfirmation(numJoueurConcerne.get(i), joueursConcernes.get(i))) {
                vue.clearSpritesCliquables();
                switch (numJoueurConcerne.get(i)) {
                    case 1:
                        System.out.println("L'écahnge a été fait avec le joueur 1.");
                        System.out.println("Le joueur actif a échangé une " + zonePioche.getZone().get(idCarte - 1).getNom()
                                + " contre une " + joueurs[0].findCarteById(idCarteVoulu).getNom());
                        vue.donnerCarte(idCarte, 1);
                        joueurActif.echangeCartePiocheMain(zonePioche.getZone().get(idCarte - 1), joueurs[0], joueurs[0].findCarteById(idCarteVoulu));
                        break;

                    case 2:
                        System.out.println("L'écahnge a été fait avec le joueur 2.");
                        System.out.println("Le joueur actif a échangé une " + zonePioche.getZone().get(idCarte - 1).getNom()
                                + " contre une " + joueurs[1].findCarteById(idCarteVoulu).getNom());
                        vue.donnerCarte(idCarte, 2);

                        joueurActif.echangeCartePiocheMain(zonePioche.getZone().get(idCarte - 1), joueurs[1], joueurs[1].findCarteById(idCarteVoulu));
                        break;

                    case 3:
                        System.out.println("L'écahnge a été fait avec le joueur 3.");
                        System.out.println("Le joueur actif a échangé une " + zonePioche.getZone().get(idCarte - 1).getNom()
                                + " contre une " + joueurs[2].findCarteById(idCarteVoulu).getNom());
                        vue.donnerCarte(idCarte, 3);
                        joueurActif.echangeCartePiocheMain(zonePioche.getZone().get(idCarte - 1), joueurs[2], joueurs[2].findCarteById(idCarteVoulu));
                        break;

                    case 4:
                        System.out.println("L'écahnge a été fait avec le joueur 4.");
                        System.out.println("Le joueur actif a échangé une " + zonePioche.getZone().get(idCarte - 1).getNom()
                                + " contre une " + joueurs[3].findCarteById(idCarteVoulu).getNom());
                        vue.donnerCarte(idCarte, 4);
                        joueurActif.echangeCartePiocheMain(zonePioche.getZone().get(idCarte - 1), joueurs[3], joueurs[3].findCarteById(idCarteVoulu));

                        break;
                }

                return true;

            }
        }
        vue.clearSpritesCliquables();
        System.out.println("Aucun joueur n'accepte");
        return false;

    }

    private boolean etapeConfirmation(int idJoueur, Sprite sprite) {

        if (sprite == vue.getSprsJoueurs()[3]) {
            vue.creerMenuOuiNon(sprite.getPosition().x + sprite.getGlobalBounds().width + 5, sprite.getPosition().y - 50);

        } else {
            vue.creerMenuOuiNon(sprite.getPosition().x + sprite.getGlobalBounds().width + 5, sprite.getPosition().y);
        }

        vue.actualisationFenetreMenuOuiNon();


        while (vue.getFenetre().isOpen()) {
            for (Event eventON : vue.getFenetre().pollEvents()) {
                if (eventON.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (eventON.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    if (vue.cliqueSprite(eventON, vue.getSprsMenuON()[0], vue.getFenetre())) {
                        vue.clearSpritesCliquables();
                        System.out.println("Le joueur " + (idJoueur) + " accepte.");
                        return true;
                    } else if (vue.cliqueSprite(eventON, vue.getSprsMenuON()[1], vue.getFenetre())) {

                        System.out.println("Le joueur " + (idJoueur) + " refuse.");
                        return false;

                    }
                    return false;
                }

            }
        }
        return false;
    }

    private int etapeEchangeMenuCarteDon() {
        Sprite[] joueursAttente = new Sprite[3];
        joueursAttente = vue.getSprsAutresJoueurs(joueurActif.getIdJoueur());

        while (vue.getFenetre().isOpen()) {
            for (Event eventDon : vue.getFenetre().pollEvents()) {
                if (eventDon.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (eventDon.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    if (vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[0], vue.getFenetre())) {
                        System.out.println("Don J1");
                        return 1;
                    }

                    if (vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[1], vue.getFenetre())) {
                        System.out.println("Don J2");
                        return 2;
                    }

                    if (vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[2], vue.getFenetre())) {
                        System.out.println("Don J3");
                        return 3;
                    }

                    if (vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[3], vue.getFenetre())) {
                        System.out.println("Don J4");
                        return 4;
                    } else {
                        System.out.println("retour");
                        return 0;
                    }
                }
            }
        }
        return 0;
    }

    private int etapeEchangeMenuCarteChoix() {
        vue.creationSpriteCliquableMenuCarteChoix();
        Sprite[] tabSprChoix = new Sprite[8];
        tabSprChoix = vue.getSprsMenuCartesChoix();

        while (vue.getFenetre().isOpen()) {
            for (Event eventMenuChoix : vue.getFenetre().pollEvents()) {

                if (eventMenuChoix.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (eventMenuChoix.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[0], vue.getFenetre())) {
                        System.out.println("choix patatectonik");
                        return 1;
                    } else if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[1], vue.getFenetre())) {
                        System.out.println("choix patatentacule");
                        return 2;
                    } else if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[2], vue.getFenetre())) {
                        System.out.println("choix patatequila");
                        return 3;
                    } else if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[3], vue.getFenetre())) {
                        System.out.println("choix pataterroriste");
                        return 4;
                    } else if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[4], vue.getFenetre())) {
                        System.out.println("choix patatestostérone");
                        return 5;
                    } else if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[5], vue.getFenetre())) {
                        System.out.println("choix patatetenuclearire");
                        return 6;
                    } else if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[6], vue.getFenetre())) {
                        System.out.println("choix patatetraplégique");
                        return 7;
                    } else if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[7], vue.getFenetre())) {
                        System.out.println("choix patatwerk");
                        return 8;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    //FIN ETAPE ECHANGE

    private void etapePlantageEchange() {
        System.out.println("ETAPE PLANTER APRES ECHANGE");

        int numCarteAPlanter;

        vue.afficherEtape(3);
        ArrayList<Sprite> spriteZoneEchange = new ArrayList<Sprite>();

        for (int i = 0; i < 4; i++) {

            numCarteAPlanter = 0;

            vue.clearSpritesCliquables();

            System.out.println("i = " + i);

            switch (i) {
                case 0:
                    vue.creationSpriteCliquablePlantagePostEchange(0);
                    vue.clearZonesEchanges();
                    putSprite();
                    vue.actualiserFenetrePlantagePostEchangeJ1();
                    spriteZoneEchange = vue.getZoneEchangeJ1();
                    break;
                case 1:
                    vue.creationSpriteCliquablePlantagePostEchange(1);
                    vue.clearZonesEchanges();
                    putSprite();
                    vue.actualiserFenetrePlantagePostEchangeJ2();
                    spriteZoneEchange = vue.getZoneEchangeJ2();
                    break;
                case 2:
                    vue.creationSpriteCliquablePlantagePostEchange(2);
                    vue.clearZonesEchanges();
                    putSprite();
                    vue.actualiserFenetrePlantagePostEchangeJ3();
                    spriteZoneEchange = vue.getZoneEchangeJ3();
                    break;
                case 3:
                    vue.creationSpriteCliquablePlantagePostEchange(3);
                    vue.clearZonesEchanges();
                    putSprite();
                    vue.actualiserFenetrePlantagePostEchangeJ4();
                    spriteZoneEchange = vue.getZoneEchangeJ4();
                    break;
            }

            System.out.println("i = " + i);
            System.out.println("zone echange = " + spriteZoneEchange.size());

            System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

            for (Sprite sprite : vue.getSpriteCliquable()) {
                System.out.println(sprite.getPosition().x + ", " + sprite.getPosition().y);
            }

            for (Sprite sprite : spriteZoneEchange) {
                numCarteAPlanter++;

                System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

                for (Sprite spritecli : vue.getSpriteCliquable()) {
                    System.out.println(spritecli.getPosition().x + ", " + spritecli.getPosition().y);
                }


                joueurs[i].getZoneEchange().printZone();

                int champChoisi = choixChamp(sprite, i);
                joueurs[i].planterViaZoneEchange(champChoisi, pioche, numCarteAPlanter);
                System.out.println("retour choix " + champChoisi);

                vue.planterEchange(i, champChoisi, joueurs[i].getZoneEchange().getZone().get(numCarteAPlanter - 1).getIdCarte(), numCarteAPlanter - 1);

                joueurs[i].getChamp(1).printChamp();
                joueurs[i].getChamp(2).printChamp();

            }
        }

            while (vue.getFenetre().isOpen()) {

                for (Event event : vue.getFenetre().pollEvents()) {

                    if (event.type == Event.Type.CLOSED) {
                        vue.getFenetre().close();
                    }

                    if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                        if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[2], vue.getFenetre())) {

                            for (Joueur joueur : joueurs) {
                                joueur.getZoneEchange().clear();
                            }
                            etapePioche();
                            return;
                        }

                    }

                }

            }

    }


    private int choixChamp(Sprite cartePlantee, int joueur) {

        while (vue.getFenetre().isOpen()) {
            for (Event event : vue.getFenetre().pollEvents()) {

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur][0], vue.getFenetre())) {
                        System.out.println("Joueur " + (joueur + 1) + " champ 1");
                        return 1;
                    } else if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur][1], vue.getFenetre())) {
                        System.out.println("Joueur " + (joueur + 1) + " champ 2");
                        return 2;
                    } else if (joueurActif.getMaxChamps() >= 3 && vue.cliqueSprite(event, vue.getSprsChamps()[joueur][2], vue.getFenetre())) {

                        System.out.println("Joueur " + (joueur + 1) + " champ 3");
                        return 3;
                    }

                }
            }
        }
        return 0;
    }

    private void etapePioche() {
        System.out.println("ETAPE PIOCHE (ETAPE 4)");
        vue.afficherEtape(4);
        joueurActif.piocheEtape4(pioche);
        actualiserMain(joueurActif);
        vue.actualiserFenetre();

        while(vue.getFenetre().isOpen()){

            for(Event event : vue.getFenetre().pollEvents()){

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[3], vue.getFenetre())) {
                        finDeTour();
                        return;
                    }
                }
            }
        }
    }

    private void finDeTour() {
        System.out.println("FIN DE TOUR");

        rotationPlateau();

        System.out.println("Fin du tour n°"+compteurTour);
        compteurTour++;

        etapePlanter();
    }

    private void rotationPlateau() {
        switch (joueurActif.getIdJoueur()){
            case 1 :
                vue.rotationJ2();
                joueurActif=joueurs[1];
                break;
            case 2 :
                vue.rotationJ3();
                joueurActif=joueurs[2];
                break;
            case 3 :
                vue.rotationJ4();
                joueurActif=joueurs[3];
                break;
            case 4 :
                vue.rotationJ1();
                joueurActif=joueurs[0];
                break;
        }
    }

    //Ajout des cartes du model en tant que texture.
    public void putTextureCarte(Joueur j){
        for (Carte carte : j.getMain()){
            if (carte.isPataTecktonik()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTectonik());
            }
            else if (carte.isPataTentacule()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTentacule());
            }
            else if (carte.isPataTequilla()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTequila());
            }
            else if (carte.isPataTerroriste()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTerroriste());
            }
            else if (carte.isPataTestosterone()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTestosterone());
            }
            else if (carte.isPataTetenucleaire()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTeteNucleaire());
            }
            else if (carte.isPataTetraplegique()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTetraplegique());
            }
            else if (carte.isPataTwerk()){
                vue.addCarteMain(j.getIdJoueur(), vue.getTxtCarteTwerk());
            }
        }
    }

    //Ajout des cartes de toutes les zones d'échange en tant que texture.
    public void putSprite(){
        for (int i = 0; i < 4; i++) {
            joueurs[i].getZoneEchange().printZone();
            for (Carte carte: joueurs[i].getZoneEchange().getZone()) {
                vue.addSpriteIntoZoneEchange(i, carte.getIdCarte());
            }
        }
    }

    public void setTxtZonePioche(){
        int idCartePiochee1 = zonePioche.getZone().get(0).getIdCarte();
        int idCartePiochee2 = zonePioche.getZone().get(1).getIdCarte();

        switch (idCartePiochee1){
            case 1:
                vue.setTxtCartePiochee1(vue.getTxtCarteTectonik());
                break;
            case 2:
                vue.setTxtCartePiochee1(vue.getTxtCarteTentacule());
                break;
            case 3:
                vue.setTxtCartePiochee1(vue.getTxtCarteTequila());
                break;
            case 4:
                vue.setTxtCartePiochee1(vue.getTxtCarteTerroriste());
                break;
            case 5:
                vue.setTxtCartePiochee1(vue.getTxtCarteTestosterone());
                break;
            case 6:
                vue.setTxtCartePiochee1(vue.getTxtCarteTeteNucleaire());
                break;
            case 7:
                vue.setTxtCartePiochee1(vue.getTxtCarteTetraplegique());
                break;
            case 8:
                vue.setTxtCartePiochee1(vue.getTxtCarteTwerk());
                break;
        }

        switch (idCartePiochee2){
            case 1:
                vue.setTxtCartePiochee2(vue.getTxtCarteTectonik());
                break;
            case 2:
                vue.setTxtCartePiochee2(vue.getTxtCarteTentacule());
                break;
            case 3:
                vue.setTxtCartePiochee2(vue.getTxtCarteTequila());
                break;
            case 4:
                vue.setTxtCartePiochee2(vue.getTxtCarteTerroriste());
                break;
            case 5:
                vue.setTxtCartePiochee2(vue.getTxtCarteTestosterone());
                break;
            case 6:
                vue.setTxtCartePiochee2(vue.getTxtCarteTeteNucleaire());
                break;
            case 7:
                vue.setTxtCartePiochee2(vue.getTxtCarteTetraplegique());
                break;
            case 8:
                vue.setTxtCartePiochee2(vue.getTxtCarteTwerk());
                break;
        }
    }

    public void actualiserMain(Joueur j){
        vue.clearMain(j.getIdJoueur());
        putTextureCarte(j);
    }

}




