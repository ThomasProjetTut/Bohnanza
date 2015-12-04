package bohnanza;

import org.jsfml.window.event.Event;
import java.io.IOException;


public class Controlleur {


        private static Vue vue;
        private static int joueur;

        public Controlleur( ) throws IOException {
            vue = new Vue();

            joueur = 1;

            updateJeu();




        }

        private void updateJeu() {
            while(vue.getFenetre().isOpen()) {

                for (Event event : vue.getFenetre().pollEvents()) {
                    if (event.type == Event.Type.CLOSED) {
                        vue.getFenetre().close();
                    }

                /*
                if (event.type == Event.Type.KEY_PRESSED.) {
                    event.asKeyEvent();
                    if (vue.cliqueSprite(event, vue.getFinDeTour(), vue.getFenetre())) {
                        rotationPlateau();
                    }

                }
*/
                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////

                    if (event.type == Event.Type.KEY_PRESSED) {
                        event.asMouseEvent();
                        if (vue.cliqueSprite(event, vue.getFinDeTour(), vue.getFenetre())) {
                            rotationPlateau();
                        }

                    }

                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////

                    if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                        event.asMouseEvent();
                        if (vue.cliqueSprite(event, vue.getFinDeTour(), vue.getFenetre())) {
                            rotationPlateau();
                        }

                    }

                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////

                    if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                        event.asMouseEvent();
                        if (vue.cliqueSprite(event, vue.getFinDeTour(), vue.getFenetre())) {
                            rotationPlateau();
                        }

                    }

                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////

                    if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                        event.asMouseEvent();
                        if (vue.cliqueSprite(event, vue.getFinDeTour(), vue.getFenetre())) {
                            rotationPlateau();
                        }

                    }

                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////

                    if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                        event.asMouseEvent();
                        if (vue.cliqueSprite(event, vue.getFinDeTour(), vue.getFenetre())) {
                            rotationPlateau();
                        }

                    }

                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////

                    if (event.type == Event.Type.MOUSE_BUTTON_RELEASED) {
                        event.asMouseEvent();
                        if (vue.cliqueSprite(event, vue.getFinDeTour(), vue.getFenetre())) {
                            rotationPlateau();
                        }

                    }
                }
            }
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




