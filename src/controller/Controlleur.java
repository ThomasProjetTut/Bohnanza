package controller;

//import jdk.nashorn.internal.ir.SplitReturn;
import model.Carte.Carte;
import model.Joueur;
import model.Pioche;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.event.Event;
import view.Vue;

import java.io.IOException;
import java.util.ArrayList;


public class Controlleur {

    private int compteurTour;

    private Vue vue;
    private Joueur[] joueurs;
    private Joueur joueurActif;
    private Pioche pioche;

    public Controlleur() throws IOException {
        vue = new Vue();
        joueurs=new Joueur[4];
        Joueur joueur1=new Joueur("Joueur 1",1);
        Joueur joueur2=new Joueur("Joueur 2",2);
        Joueur joueur3=new Joueur("Joueur 3",3);
        Joueur joueur4=new Joueur("Joueur 4",4);

        joueurs[0]=joueur1;
        joueurs[1]=joueur2;
        joueurs[2]=joueur3;
        joueurs[3]=joueur4;

        joueurActif=joueurs[0];

        pioche = new Pioche();

        jeu();
        //updateJeu();

    }

    private void jeu() {
        compteurTour = 1;

        for(Joueur j:joueurs){
            j.recoisMain(pioche);
            j.afficherMain();
            actualiserMain(j);
        }
        System.out.println("Taille de la pioche : "+pioche.getTaillePioche());

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

                            joueurActif.planter(1);
                            actualiserMain(joueurActif);
                            vue.actualiserFenetre();

                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        } else if (vue.cliqueSprite(event, vue.getSprsChamps()[joueurActif.getIdJoueur() - 1][1], vue.getFenetre())) {
                            System.out.println("plante deuxième champ");

                            joueurActif.planter(2);
                            actualiserMain(joueurActif);
                            vue.actualiserFenetre();

                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        } else if (vue.cliqueSprite(event, vue.getSprsChamps()[joueurActif.getIdJoueur() - 1][2], vue.getFenetre())) {
                            System.out.println("plante troisième champ");

                            joueurActif.planter(3);
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

    private void etapeEchange() {
        System.out.println("ETAPE ECHANGE");
        int carteNonJouee = 2;
        int retour;

        vue.afficherEtape(2);
        vue.actualiserFenetreEchange();
        //vue.afficherMainJ1();

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
                        retour = etapeEchangeMenuCarte1();
                        vue.creationSpriteCliquableCarte();
                        vue.actualiserFenetreEchange();
                        if (carteNonJouee == 1) {
                            vue.delSpriteCliquable(carte2);
                        }
                        if(retour != 50) {
                            vue.delSpriteCliquable(carte1);
                            carteNonJouee--;
                        }

                    } else {
                        if (vue.cliqueSprite(event, carte2, vue.getFenetre())) {
                            System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());
                            vue.creerMenuCarte(carte2.getPosition().x + 75, carte2.getPosition().y);
                            vue.actualiserFenetreEchangeMenu();
                            retour = etapeEchangeMenuCarte2();
                            vue.creationSpriteCliquableCarte();
                            vue.actualiserFenetreEchange();
                            if (carteNonJouee == 1) {
                                vue.delSpriteCliquable(carte1);
                            }
                            if(retour != 50) {
                                vue.delSpriteCliquable(carte2);
                                carteNonJouee--;
                            }
                        }
                    }

                    System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

                    for(Sprite sprite : vue.getSpriteCliquable()){
                        System.out.println(sprite.getPosition().x + ", " + sprite.getPosition().y);
                    }

                    if (carteNonJouee == 0) {

                        if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[1], vue.getFenetre())) {
                            etapePlantageEchange();
                            return;
                        }

                    }

                }

            }
        }
    }

    private int etapeEchangeMenuCarte1(){
        vue.creationSpriteCliquableMenuCarte();

        while (vue.getFenetre().isOpen()){
            for(Event eventMenu : vue.getFenetre().pollEvents()){


                if (eventMenu.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if(eventMenu.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[2], vue.getFenetre())) {
                        System.out.println("garder");
                        System.out.println("appel garder carte 1");
                        vue.garderCarte(1);
                        vue.creationSpriteCliquableCarte();
                        return 1;
                    }else{
                        if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[0], vue.getFenetre())){
                            System.out.println("echange");
                            vue.creerMenuCarteChoix(vue.getSprsMenuCartes()[0].getPosition().x + 140, vue.getSprsMenuCartes()[0].getPosition().y - 10);
                            vue.actualiserFenetreEchangeMenuChoix();
                            int retour = etapeEchangeMenuCarteChoix();
                            vue.creationSpriteCliquableMenuCarte();
                            vue.actualiserFenetreEchangeMenu();
                            switch (retour){
                                case 0 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else{
                                        return 20;
                                    }
                                case 1 :
                                    System.out.println("retour tequila");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else {
                                        return 21;
                                    }
                                case 2 :
                                    System.out.println("retour terroriste");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else {
                                        return 22;
                                    }
                                case 3 :
                                    System.out.println("retour testost�rone");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else {
                                        return 23;
                                    }
                                case 4 :
                                    System.out.println("retour tetenucleaire");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else{
                                        return 24;
                                    }
                                case 5 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else{
                                        return 25;
                                    }
                                case 6 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else{
                                        return 26;
                                    }
                                case 7 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(1) == -5){
                                        return 50;
                                    }else{
                                        return 27;
                                    }
                                case 10 :
                                    System.out.println("retour retour");
                                    break;
                            }
                        }else{
                            if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[1], vue.getFenetre())){
                                System.out.println("don");
                                vue.creationSpriteCliquableDon(joueurActif.getIdJoueur());
                                vue.actualiserFenetreEchange();
                                int retour = etapeEchangeMenuCarteDon();
                                switch(retour){
                                    case 1 :
                                        System.out.println("J1 ?");
                                        vue.donnerCarteJ1(1);
                                        return 31;
                                    case 2 :
                                        System.out.println("J2 ?");
                                        vue.donnerCarteJ2(1);
                                        return 32;
                                    case 3 :
                                        System.out.println("J3 ?");
                                        vue.donnerCarteJ3(1);
                                        return 33;
                                    case 4 :
                                        System.out.println("J4 ?");
                                        vue.donnerCarteJ4(1);
                                        return 34;
                                    case 5 :
                                        System.out.println("retour");
                                        return 50;
                                }

                            }else{
                                if (vue.cliqueSprite(eventMenu, vue.getFond(), vue.getFenetre())) {
                                    vue.actualiserFenetreEchange();
                                    vue.creationSpriteCliquableCarte();
                                    return 50;
                                }
                            }
                        }
                    }
                }

            }

        }
        return -5;
    }

    private int etapeEchangeMenuCarte2(){
        vue.creationSpriteCliquableMenuCarte();

        while (vue.getFenetre().isOpen()){
            for(Event eventMenu : vue.getFenetre().pollEvents()){


                if (eventMenu.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if(eventMenu.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[2], vue.getFenetre())){
                        System.out.println("garder");
                        System.out.println("appel garder 2");
                        vue.garderCarte(2);
                        vue.creationSpriteCliquableCarte();
                        return 1;
                    }else{
                        if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[0], vue.getFenetre())){
                            System.out.println("echange");
                            vue.creerMenuCarteChoix(vue.getSprsMenuCartes()[0].getPosition().x + 140, vue.getSprsMenuCartes()[0].getPosition().y - 10);
                            vue.actualiserFenetreEchangeMenuChoix();
                            int retour = etapeEchangeMenuCarteChoix();
                            vue.creationSpriteCliquableMenuCarte();
                            switch (retour){
                                case 0 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                        return 50;
                                    }else{
                                        return 20;
                                    }
                                case 1 :
                                    System.out.println("retour tequila");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                        return 50;
                                    }else {
                                        return 21;
                                    }
                                case 2 :
                                    System.out.println("retour terroriste");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                        return 50;
                                    }else {
                                        return 22;
                                    }
                                case 3 :
                                    System.out.println("retour testost�rone");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                        return 50;
                                    }else {
                                        return 23;
                                    }
                                case 4 :
                                    System.out.println("retour tetenucleaire");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                        return 50;
                                    }else{
                                        return 24;
                                    }
                                case 5 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                        return 50;
                                    }else{
                                        return 25;
                                    }
                                case 6 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                        return 50;
                                    }else{
                                        return 26;
                                    }
                                case 7 :
                                    System.out.println("retour tentacule");
                                    if(etapeDemandeEchangeAcceptation(2) == -5){
                                       return 50;
                                    }else{
                                        return 27;
                                    }
                                case 10 :
                                    System.out.println("retour retour");
                                    return 50;
                            }

                        }else{
                            if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[1], vue.getFenetre())){
                                System.out.println("don");
                                vue.creationSpriteCliquableDon(joueurActif.getIdJoueur());
                                vue.actualiserFenetreEchange();
                                int retour = etapeEchangeMenuCarteDon();
                                switch(retour){
                                    case 1 :
                                        System.out.println("J1 ?");
                                        vue.donnerCarteJ1(2);
                                        return 31;
                                    case 2 :
                                        System.out.println("J2 ?");
                                        vue.donnerCarteJ2(2);
                                        return 32;
                                    case 3 :
                                        System.out.println("J3 ?");
                                        vue.donnerCarteJ3(2);
                                        return 33;
                                    case 4 :
                                        System.out.println("J4 ?");
                                        vue.donnerCarteJ4(2);
                                        return 34;
                                    case 5 :
                                        System.out.println("retour");
                                        return 50;
                                }

                            }else{
                                if (vue.cliqueSprite(eventMenu, vue.getFond(), vue.getFenetre())) {
                                    System.out.println("uibvsidjfvbisjdvfoisdhvbf");
                                    vue.actualiserFenetreEchange();
                                    vue.creationSpriteCliquableCarte();
                                    return 50;
                                }
                            }
                        }
                    }
                }

            }

        }

        return -5;

    }

    private int etapeDemandeEchangeAcceptation(int idCarte) {
        Sprite[] spriteJoueur = new Sprite[3];
        spriteJoueur = vue.getSprsAutresJoueurs(joueurActif.getIdJoueur());

        for (int i = 0; i < 3; i++) {
            vue.clearSpritesCliquables();
            vue.creerMenuOuiNon(spriteJoueur[i].getPosition().x + spriteJoueur[i].getGlobalBounds().width + 5, spriteJoueur[i].getPosition().y);
            vue.creationSpriteCliquableMenuOuiNon(joueurActif.getIdJoueur());
            vue.actualisationFenetreMenuOuiNon();

            if(etapeConfirmation(i)) {
                if(i <= 2) {
                    System.out.println("Le joueur " + (i + 2));
                    vue.clearSpritesCliquables();
                    switch (i + 2){
                        case 1 :
                            vue.donnerCarteJ1(idCarte);
                            break;
                        case 2 :
                            vue.donnerCarteJ2(idCarte);
                            break;
                        case 3 :
                            vue.donnerCarteJ3(idCarte);
                            break;
                        case 4 :
                            vue.donnerCarteJ4(idCarte);
                            break;
                    }

                    return i + 2;
                }else {
                    System.out.println("Le joueur " + (i + 1));
                    vue.clearSpritesCliquables();
                    switch (i + 1){
                        case 1 :
                            vue.donnerCarteJ1(idCarte);
                            break;
                        case 2 :
                            vue.donnerCarteJ2(idCarte);
                            break;
                        case 3 :
                            vue.donnerCarteJ3(idCarte);
                            break;
                        case 4 :
                            vue.donnerCarteJ4(idCarte);
                            break;
                    }
                    return i + 1;
                }
            }
        }
        vue.clearSpritesCliquables();
        System.out.println("Aucun joueur n'accepte");
        return -5;

    }

    private boolean etapeConfirmation(int id){
        while(vue.getFenetre().isOpen()) {
            for (Event eventON : vue.getFenetre().pollEvents()) {
                if (eventON.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (eventON.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    if (vue.cliqueSprite(eventON, vue.getSprsMenuON()[0], vue.getFenetre())) {
                        vue.clearSpritesCliquables();
                        System.out.println("Le joueur " + (id + 2) + " accepte.");
                        return true;
                    }else {
                        if (vue.cliqueSprite(eventON, vue.getSprsMenuON()[1], vue.getFenetre())) {
                            System.out.println("Le joueur " + (id + 1) + " refuse.");
                            return false;

                        }
                    }
                }

            }
        }
        return false;
    }

    private int etapeEchangeMenuCarteDon() {
        Sprite[] joueursAttente = new Sprite[3];
        joueursAttente = vue.getSprsAutresJoueurs(joueurActif.getIdJoueur());

        while(vue.getFenetre().isOpen()){
            for(Event eventDon : vue.getFenetre().pollEvents()){
                if(eventDon.type == Event.Type.CLOSED){
                    vue.getFenetre().close();
                }

                if(eventDon.type == Event.Type.MOUSE_BUTTON_RELEASED){
                    if(vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[0], vue.getFenetre())){
                        System.out.println("Don J1");
                        return 1;
                    }

                    if(vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[1], vue.getFenetre())){
                        System.out.println("Don J2");
                        return 2;
                    }

                    if(vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[2], vue.getFenetre())){
                        System.out.println("Don J3");
                        return 3;
                    }

                    if(vue.cliqueSprite(eventDon, vue.getSprsJoueurs()[3], vue.getFenetre())){
                        System.out.println("Don J4");
                        return 4;
                    }

                    if(vue.cliqueSprite(eventDon, vue.getFond(), vue.getFenetre())){
                        System.out.println("retour");

                        return 5;

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

        while(vue.getFenetre().isOpen()){
            for(Event eventMenuChoix : vue.getFenetre().pollEvents()){

                if (eventMenuChoix.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if(eventMenuChoix.type == Event.Type.MOUSE_BUTTON_RELEASED){

                    if(vue.cliqueSprite(eventMenuChoix, tabSprChoix[0], vue.getFenetre())){
                        System.out.println("choix patatectonik");
                        return 0;
                    }else {
                        if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[1], vue.getFenetre())) {
                            System.out.println("choix patatentacule");
                            return 1;
                        } else {
                            if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[2], vue.getFenetre())) {
                                System.out.println("choix patatequila");
                                return 2;
                            } else {
                                if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[3], vue.getFenetre())) {
                                    System.out.println("choix pataterroriste");
                                    return 3;
                                } else {
                                    if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[4], vue.getFenetre())) {
                                        System.out.println("choix patatestost�rone");
                                        return 4;
                                    } else {
                                        if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[5], vue.getFenetre())) {
                                            System.out.println("choix patatetenuclearire");
                                            return 5;
                                        } else {
                                            if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[6], vue.getFenetre())) {
                                                System.out.println("choix patatetrapl�gique");
                                                return 6;
                                            } else {
                                                if (vue.cliqueSprite(eventMenuChoix, tabSprChoix[7], vue.getFenetre())) {
                                                    System.out.println("choix patatwerk");
                                                    return 7;
                                                } else {
                                                    if (vue.cliqueSprite(eventMenuChoix, vue.getFond(), vue.getFenetre())) {
                                                        return 10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return -5;

    }

    private void etapePlantageEchange(){
        System.out.println("ETAPE PLANTER APRES ECHANGE");
        vue.afficherEtape(3);
        vue.actualiserFenetre();
        ArrayList<Sprite> spriteZoneEchange = new ArrayList<Sprite>();

        /////////////////////////////////////////
        vue.creerZoneEchangeJ1();
        vue.creerZoneEchangeJ2();
        vue.creerZoneEchangeJ3();
        vue.creerZoneEchangeJ4();
        /////////////////////////////////////////


        for (int i = 0; i < 4; i++) {

            switch (i) {
                case 1:
                    spriteZoneEchange = vue.getZoneEchangeJ1();
                    break;
                case 2:
                    spriteZoneEchange = vue.getZoneEchangeJ2();
                    break;
                case 3:
                    spriteZoneEchange = vue.getZoneEchangeJ3();
                    break;
                case 4:
                    spriteZoneEchange = vue.getZoneEchangeJ4();
                    break;
            }

            for (Sprite sprite : spriteZoneEchange) {


                while (vue.getFenetre().isOpen()) {
                    for (Event event : vue.getFenetre().pollEvents()) {

                        if (event.type == Event.Type.CLOSED) {
                            vue.getFenetre().close();
                        }

                        if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                            if (vue.cliqueSprite(event, vue.getSprsChamps()[i][0], vue.getFenetre())) {
                                System.out.println("Joueur " + (i + 1) + " champ 1");
                            } else {
                                if (vue.cliqueSprite(event, vue.getSprsChamps()[i][1], vue.getFenetre())) {
                                    System.out.println("Joueur " + (i + 1) + " champ 2");
                                } else {
                                    if (vue.cliqueSprite(event, vue.getSprsChamps()[i][2], vue.getFenetre())) {
                                        System.out.println("Joueur " + (i + 1) + " champ 3");
                                    }
                                }
                            }
                        }

                        if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                            if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[2], vue.getFenetre())) {
                                etapePioche();
                                return;
                            }

                        }
                    }
                }
            }

            etapePioche();

        }
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

    public void actualiserMain(Joueur j){
        vue.clearMain(j.getIdJoueur());
        putTextureCarte(j);
    }

}




