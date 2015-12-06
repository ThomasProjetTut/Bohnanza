package controller;

import org.jsfml.graphics.Sprite;
import org.jsfml.window.event.Event;
import view.Vue;

import java.io.IOException;
import java.util.ArrayList;


public class Controlleur {


        private Vue vue;
        private static int joueur;

        public Controlleur( ) throws IOException {
            vue = new Vue();

            joueur = 1;

            jeu();
            //updateJeu();



        }

        private void jeu(){
            while (vue.getFenetre().isOpen()){
                etapePlanter();
            }
        }

    private void etapePlanter() {
        vue.afficherEtape(1);
        vue.creationSpriteCliquableEtape1(joueur);
        vue.actualiserFenetre();

        int nbplants = 0;

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();


                    if(nbplants < 2) {
                        if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur - 1][0], vue.getFenetre())) {
                            System.out.println("plante premier champ");
                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        }

                        if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur - 1][1], vue.getFenetre())) {
                            System.out.println("plante deuxième champ");
                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        }

                        if (vue.cliqueSprite(event, vue.getSprsChamps()[joueur - 1][2], vue.getFenetre())) {
                            System.out.println("plante troisième champ");
                            vue.setSpriteCliquable(vue.getSprsBoutonsEtapes()[0]);
                            nbplants++;
                        }
                    }

                    if (vue.cliqueSprite(event, vue.getSprsBoutonsEtapes()[0], vue.getFenetre())) {
                        etapeEchange();
                        return;
                    }

                }
            }
        }
    }
    private void etapeEchange() {
        System.out.println("etapeEchange");
        vue.afficherEtape(2);
        vue.creationSpriteCliquableCarte1();
        vue.actualiserFenetreEchange();
        Sprite carte = vue.getSprCartePiochee1();

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){

                if (event.type == Event.Type.CLOSED) {
                    vue.getFenetre().close();
                }

                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, carte, vue.getFenetre())) {
                        vue.creerMenuCarte(carte.getPosition().x + 75, carte.getPosition().y);
                        vue.actualiserFenetreEchangeMenu();

                        while (vue.getFenetre().isOpen()){

                        }
                        return;
                    }

                }
            }
        }
    }
    private void etapePlantageEchange() {
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




