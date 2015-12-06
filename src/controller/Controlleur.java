package controller;

import org.jsfml.window.event.Event;
import view.Vue;

import java.io.IOException;


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
            while (true){
                System.out.println("whiole");
                etapePlanter();
            }
        }

    private void etapePlanter() {
        System.out.println("etapePlanter");

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){
                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, vue.getBouton()[0], vue.getFenetre())) {
                        etapeEchange();
                    }

                }
            }
        }
    }
    private void etapeEchange() {
        System.out.println("etapeEchange");

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){
                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, vue.getBouton()[1], vue.getFenetre())) {
                        etapePlantageEchange();
                    }

                }
            }
        }
    }
    private void etapePlantageEchange() {
        System.out.println("etapePlantageEchange");

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){
                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, vue.getBouton()[2], vue.getFenetre())) {
                        etapePioche();
                    }

                }
            }
        }
    }
    private void etapePioche() {
        System.out.println("etapePioche");

        while(vue.getFenetre().isOpen()){
            for(Event event : vue.getFenetre().pollEvents()){
                if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, vue.getBouton()[3], vue.getFenetre())) {
                        finDeTour();
                    }

                }
            }
        }
    }

    private void finDeTour() {
        System.out.println("finDeTour");
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




