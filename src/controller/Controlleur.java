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
    private int[][] nbCarteChamps;

    public Controlleur() {

        initAttributs();
    }

    private void initAttributs() {
        vue = new Vue();
        joueurs = new Joueur[4];
        Joueur joueur1 = new Joueur("Joueur 1", 1);
        Joueur joueur2 = new Joueur("Joueur 2", 2);
        Joueur joueur3 = new Joueur("Joueur 3", 3);
        Joueur joueur4 = new Joueur("Joueur 4", 4);

        nbCarteChamps = new int[4][3];

        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        joueurs[2] = joueur3;
        joueurs[3] = joueur4;

        joueurActif = joueurs[0];

        pioche = new Pioche();
        zonePioche = new Zone();

        compteurTour = 1;

        for (Joueur j : joueurs) {
            j.recoisMain(pioche);
            j.afficherMain();
        }
        System.out.println("Taille de la pioche : " + pioche.getTaillePioche());
        System.out.println("nombre de tour de pioche : " + pioche.getTourDePioche());

    }
}



