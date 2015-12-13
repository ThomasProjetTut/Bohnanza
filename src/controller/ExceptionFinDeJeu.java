package controller;

import model.Joueur;

public class ExceptionFinDeJeu  extends Exception{


    private Joueur joueurVainqueur;

    public ExceptionFinDeJeu (Joueur joueur){
        super("Le jeu est fini");
        joueurVainqueur = joueur;
    }

    public Joueur getJoueurVainqueur() {
        return joueurVainqueur;
    }

}
