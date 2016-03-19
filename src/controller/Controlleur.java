package controller;

//import jdk.nashorn.internal.ir.SplitReturn;
import Multijoueurs.EnvoyerMessages;
import model.Joueur;
import model.Pioche;
import model.Zone;
import view.Vue;
import view.vueDons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Controlleur implements ActionListener {

    private int compteurTour;

    private Vue vue;
    private vueDons vueDons;
    private Joueur joueur;
    private Pioche pioche;
    private Zone zonePioche;
    private int[][] nbCarteChamps;

    private JButton[] etapes = null;
    private JButton[] oks = null;
    private JComboBox[] choix = null;
    private JButton[] champs = null;

    private int etapeEnCours;
    private boolean etapeTerminee = false;
    private int nbPlants;

    private final int ETAPE_DEBUT = 0;
    private final int ETAPE_PLANTE = 1;
    private final int ETAPE_PIOCHE = 2;
    private final int ETAPE_ECHANGE = 3;
    private final int ETAPE_PLANTE_ECHANGE = 4;
    private final int ETAPE_PLANTE_PIOCHE_FDT = 5;
    private final int ETAPE_TOUR_FINI = 6;

    public Controlleur(Joueur joueur) {
        this.joueur = joueur;
        //InitAttributs();
    }

    public void jouerTour(){
        debutDuTour();
    }

    public void actualiserAffichageMain() {
        vue.actualiserMain();
    }

    public void InitAttributs() {
        System.out.println("init");

        vue = new Vue(this);
        //joueur = new Joueur("Joueur 1", 1);

        etapes = vue.getEtapes();
        champs = vue.getChamps();
        oks = vue.getOk();
        choix = vue.getChoix();

        nbCarteChamps = new int[4][3];

        zonePioche = new Zone();

        compteurTour = 1;

        ///////////////////////
        //reçoi main du serveur
        ///////////////////////
        //joueur.recoisMain(pioche);
        //joueur.afficherMain();

        //System.out.println("Taille de la pioche : " + pioche.getTaillePioche());
        //System.out.println("nombre de tour de pioche : " + pioche.getTourDePioche());

    }

    public void RecoisMain() {

        joueur.recoisMain(pioche);
        joueur.afficherMain();
    }

    public Pioche InitPioche() {
       return pioche = new Pioche();
    }

    private void debutDuTour() {
        etapeEnCours = ETAPE_DEBUT;
        etapeTerminee = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");
        if (e.getSource() == etapes[0] && etapeEnCours == ETAPE_DEBUT && etapeTerminee){
            System.out.println("on plante");
            etapePlante();
        }else if (e.getSource() == etapes[1] && etapeEnCours == ETAPE_PLANTE && etapeTerminee){
            etapePioche();
        }else if (e.getSource() == etapes[2] && etapeEnCours == ETAPE_PIOCHE && etapeTerminee){
            etapeEchange();
        }else if (e.getSource() == etapes[3] && etapeEnCours == ETAPE_PLANTE_ECHANGE && etapeTerminee){
            etapePiocheFDT();
        }else if (e.getSource() == etapes[4] && etapeEnCours == ETAPE_PLANTE_PIOCHE_FDT && etapeTerminee){
            etapeFDT();
        }else if (e.getSource() == oks[0] && etapeEnCours == ETAPE_ECHANGE && !etapeTerminee){
            switch ((String) choix[0].getSelectedItem()){
                case "Garder" :
                    garderCarte(1);
                    break;
                case "Echanger" :
                    echangerCarte(1);
                    break;
                case "Donner" :
                    donnerCarte(1);
                    break;
            }
        }else if (e.getSource() == oks[1] && etapeEnCours == ETAPE_ECHANGE && !etapeTerminee){
            switch ((String) choix[1].getSelectedItem()){
                case "Garder" :
                    garderCarte(2);
                    break;
                case "Echanger" :
                    echangerCarte(2);
                    break;
                case "Donner" :
                    donnerCarte(2);
                    break;
            }
        }else if (e.getSource() == champs[0] && etapeEnCours == ETAPE_PLANTE && !etapeTerminee){
            planterMain(1);
        }else if (e.getSource() == champs[1] && etapeEnCours == ETAPE_PLANTE && !etapeTerminee){
            planterMain(2);
        }else if (e.getSource() == champs[2] && etapeEnCours == ETAPE_PLANTE && !etapeTerminee){
            planterMain(3);
        }else if (e.getSource() == champs[0] && etapeEnCours == ETAPE_PLANTE_ECHANGE && !etapeTerminee){
            planterEchange(1);
        }else if (e.getSource() == champs[1] && etapeEnCours == ETAPE_PLANTE_ECHANGE && !etapeTerminee){
            planterEchange(2);
        }else if (e.getSource() == champs[2] && etapeEnCours == ETAPE_PLANTE_ECHANGE && !etapeTerminee){
            planterEchange(3);
        }
    }

    //Partie déroulement du jeu
    //etape
    public void etapePlante(){
        System.out.println("On plante");
        etapeEnCours = ETAPE_PLANTE;
        nbPlants = 0;
        etapeTerminee = false;
    }

    private void etapePioche() {
        System.out.println("On pioche");
        etapeEnCours = ETAPE_PIOCHE;
        etapeTerminee = true;
    }

    private void etapeEchange() {
        System.out.println("On echange");
        etapeEnCours = ETAPE_ECHANGE;
        etapeTerminee = false;
    }

    private void etapePiocheFDT() {
        System.out.println("On pioche 2");
        etapeEnCours = ETAPE_PLANTE_PIOCHE_FDT;
        etapeTerminee = true;
    }

    private void etapeFDT() {
        System.out.println("On FDT");
        etapeEnCours = ETAPE_TOUR_FINI;
        etapeTerminee = true;

        if (joueur.getIdJoueur() == 0)
            joueur.getControlleurDepart().getServeurTCP().UpdateGameFDT(1);
        else {
            try {
                EnvoyerMessages.FIN_DU_TOUR(joueur.getControlleurDepart().getClientTCP().GetEchange());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Echange
    private void garderCarte(int idCarte) {
        System.out.println("On garde la carte" + idCarte);
        //ajouter carte zone pioche

        etapeEnCours = ETAPE_PLANTE_ECHANGE;
    }

    private void donnerCarte(int idCarte) {
        System.out.println("On donne la carte" + idCarte);
        //ouverture fenetre don

        etapeEnCours = ETAPE_PLANTE_ECHANGE;
    }

    private void echangerCarte(int idCarte) {
        System.out.println("On ehcnage la carte" + idCarte);
        //ouverture fenetre échange

        etapeEnCours = ETAPE_PLANTE_ECHANGE;
    }


    //planter
    private void planterMain(int idChamp) {
        System.out.println("On plante dans le champ : " + idChamp);

        if(idChamp < 3){
            joueur.planter(idChamp, pioche);
            nbPlants++;
        }else{
            if(joueur.getMaxChamps() >= 3){
                joueur.planter(idChamp, pioche);
                nbPlants++;
            }else{
                if(joueur.getNbThunes() >= 5){
                    /*if(etapeConfirmation()){
                        joueur.acheterChamps(pioche);
                    }*/
                }
            }
        }

        //vue.actualiser();
        if (nbPlants == 2){
            etapeTerminee = true;
        }
    }

    private void planterEchange(int idChamp) {
        System.out.println("On plante dans le champ : "  + idChamp);

        joueur.planterViaZoneEchange(idChamp, pioche, nbPlants);
        nbPlants++;

        if(joueur.getZoneEchange().getZone().size() == 0){
            etapeTerminee = true;

        }

    }

    public Joueur getJoueur(){
        return joueur;
    }



}




