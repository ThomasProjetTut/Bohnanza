package controller;

//import jdk.nashorn.internal.ir.SplitReturn;
import Multijoueurs.ClientTCP;
import Multijoueurs.ServeurTCP;
import model.Carte.Carte;
import model.Joueur;
import model.Pioche;
import model.Zone;
import view.Vue;
import view.vueConnexion;
import view.vueDons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controlleur {

    private int compteurTour;

    private vueConnexion vueCon;

    private Vue vue;
    private vueDons vueDons;
    private Joueur[] joueurs;
    private Joueur joueurActif;
    private Pioche pioche;
    private Zone zonePioche;
    private int[][] nbCarteChamps;

    private ServeurTCP serveurTCP;
    private ClientTCP clientTCP;

    public Controlleur() {
        initAttributs();
    }

    public void InitClient(String ipServ, int port) throws IOException {
        System.out.println("Lancement du client.");
        clientTCP = new ClientTCP(this, ipServ, port);
        clientTCP.Start();
    }

    public void InitServeur(int port) throws IOException {
        System.out.println("Lancement du serveur.");
        serveurTCP = new ServeurTCP(this, port);
        serveurTCP.Start();
    }

    public void resetClient() throws IOException {

        if (clientTCP == null)
            return;

        if (!clientTCP.SocketIsClose())
            clientTCP.StopClient();

        clientTCP = null;
        vueCon.reiniButton();
        System.out.println("Déconnection réussie.");
    }

    public void resetServeur() throws IOException {

        if (serveurTCP == null)
            return;

        if (!serveurTCP.SocketIsClose())
            serveurTCP.StopServeur();

        serveurTCP = null;
        vueCon.reiniButton();
        System.out.println("Le serveur à bien été stoppé.");
    }

    private void initAttributs() {

        vueCon = new vueConnexion(this);

        vue = new Vue(this);
        vueDons = new vueDons(this);
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

    public ServeurTCP getServeurTCP() {
        return serveurTCP;
    }

    public ClientTCP getClientTCP() {
        return clientTCP;
    }
}



