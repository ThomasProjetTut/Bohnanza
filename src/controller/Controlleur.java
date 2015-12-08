package controller;

import org.jsfml.graphics.Sprite;
import org.jsfml.window.event.Event;
import view.Vue;

import java.io.IOException;
import java.util.ArrayList;


public class Controlleur {


    private Vue vue;
    private static int joueur;

    public Controlleur() throws IOException {
        vue = new Vue();

        joueur = 1;

        jeu();
        //updateJeu();


    }

    private void jeu() {
        while (vue.getFenetre().isOpen()) {
            etapePlanter();
        }
    }

    private void etapePlanter() {
        vue.afficherEtape(1);
        vue.creationSpriteCliquableEtape1(joueur);
        vue.actualiserFenetre();

        int nbplants = 0;
        System.out.println("nb plant  = " + nbplants);

        while (vue.getFenetre().isOpen()) {
            for (Event event : vue.getFenetre().pollEvents()) {

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();

                    if (nbplants >= 1) {

                        if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[0], vue.getFenetre())) {
                            etapeEchange();
                            return;
                        }
                    }

                        if (nbplants < 2) {
                            System.out.println("nb plant  = " + nbplants);


                            if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur - 1][0], vue.getFenetre())) {
                                System.out.println("plante premier champ");
                                vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                                nbplants++;
                            } else {
                                if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur - 1][1], vue.getFenetre())) {
                                    System.out.println("plante deuxi?me champ");
                                    vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                                    nbplants++;
                                } else {
                                    if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur - 1][2], vue.getFenetre())) {
                                        System.out.println("plante troisi?me champ");
                                        vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                                        nbplants++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }



    private void etapeEchange() {
        System.out.println("etapeEchange");
        int carteNonJouee = 2;

        vue.afficherEtape(2);
        vue.actualiserFenetreEchange();

        Sprite carte1 = vue.getSprCartePiochee1();
        Sprite carte2 = vue.getSprCartePiochee2();

        vue.creationSpriteCliquableCarte();//ajout 2 cartes
        vue.setSpriteCliquable(carte1);
        vue.setSpriteCliquable(carte2);
        vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[1]);

        while (vue.getFenetre().isOpen()) {
            for (Event event : vue.getFenetre().pollEvents()) {

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, carte1, vue.getFenetre())) {
                        System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

                        vue.creerMenuCarte(carte1.getPosition().x + 75, carte1.getPosition().y);
                        vue.actualiserFenetreEchangeMenu();
                        etapeEchangeMenuCarte1();
                        vue.delSpriteCliquable(carte1);
                    } else {
                        if (vue.cliqueSprite(event, carte2, vue.getFenetre())) {
                            System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

                            vue.creerMenuCarte(carte2.getPosition().x + 75, carte2.getPosition().y);
                            vue.actualiserFenetreEchangeMenu();
                            etapeEchangeMenuCarte2();
                            vue.delSpriteCliquable(carte2);
                        }
                    }

                    System.out.println("sprite cliquable :" + vue.getSpriteCliquable().size());

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

    private void etapeEchangeMenuCarte1(){
        vue.setSpriteCliquable(vue.getFond());

        while (vue.getFenetre().isOpen()){
            for(Event eventMenu : vue.getFenetre().pollEvents()){


                if (eventMenu.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if(eventMenu.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[2], vue.getFenetre())) {
                        System.out.println("garder");
                        vue.garderCarte(1);
                        return;
                    }else{
                        if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[0], vue.getFenetre())){
                            System.out.println("echange");
                        }else{
                            if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[1], vue.getFenetre())){
                                System.out.println("don");
                            }else{
                                if (vue.cliqueSprite(eventMenu, vue.getFond(), vue.getFenetre())) {
                                    vue.actualiserFenetreEchange();
                                    vue.delSpriteCliquable(vue.getFond());
                                    return;
                                }
                            }
                        }
                    }
                }

            }

        }

    }


    private void etapeEchangeMenuCarte2(){
        vue.setSpriteCliquable(vue.getFond());

        while (vue.getFenetre().isOpen()){
            for(Event eventMenu : vue.getFenetre().pollEvents()){


                if (eventMenu.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if(eventMenu.type == Event.Type.MOUSE_BUTTON_RELEASED) {

                    if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[2], vue.getFenetre())){
                        System.out.println("garder");
                        vue.garderCarte(2);
                        return;
                    }else{
                        if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[0], vue.getFenetre())){
                            System.out.println("echange");
                        }else{
                            if(vue.cliqueSprite(eventMenu, vue.getSprsMenuCartes()[1], vue.getFenetre())){
                                System.out.println("don");
                            }else{
                                if (vue.cliqueSprite(eventMenu, vue.getFond(), vue.getFenetre())) {
                                    vue.actualiserFenetreEchange();
                                    vue.delSpriteCliquable(vue.getFond());
                                    return;
                                }
                            }
                        }
                    }
                }

            }

        }

    }



    private void etapePlantageEchange(){
        vue.afficherEtape(3);
        vue.actualiserFenetre();

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[2], vue.getFenetre())) {
                        etapePioche();
                        return;
                    }

                }
            }
        }
    }
    private void etapePioche() {
        vue.afficherEtape(4);
        vue.actualiserFenetre();

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[3], vue.getFenetre())) {
                        finDeTour();
                        return;
                    }
                }
            }
        }
    }


    private void finDeTour() {
        rotationPlateau();
    }

    private void rotationPlateau() {
        switch (joueur){
            case 1 :
                vue.rotationJ2();
                joueur = 2;
                break;
            case 2 :
                vue.rotationJ3();
                joueur = 3;
                break;
            case 3 :
                vue.rotationJ4();
                joueur = 4;
                break;
            case 4 :
                vue.rotationJ1();
                joueur = 1;
                break;
        }
    }


}




