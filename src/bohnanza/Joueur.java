package bohnanza;

import bohnanza.Carte.Carte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 13/11/2015.
 */
public class Joueur {

    private int thunes;
    private String nom;
    private ArrayList<Carte> main;
    private Champ champ1;
    private Champ champ2;
    private Champ champ3;
    private Zone zoneEchange;

    public Joueur(){
        nom="";
        thunes =0;


        champ1=new Champ(1);
        champ2=new Champ(2);
        zoneEchange=new Zone();

        main = new ArrayList<>();
    }

    public Joueur(String nom) {
        this.nom=nom;
        thunes =0;

        champ1=new Champ(1);
        champ2=new Champ(2);
        zoneEchange=new Zone();

        main = new ArrayList<>();
    }

    public void recoisMain() {
        main.clear();

        // Ajoute la premiere carte & la supprime du jeu de carte
        for (int i = 0 ; i < 4 ; i++) {
            piocher();
        }
    }

    public void piocher() {
        if (main.size() > 4) {
            System.out.println("Tu as déjà une main complète.");
            return;
        }

        List<Carte> cartes = Jeu.getlisteCarte();

        addCarte(cartes.get(0));
        Jeu.removeCarte();
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public void addCarte(Carte carte) {
        main.add(carte);
    }
    /*
    public void jouerCoup() {
        if(champ1.haricots.isEmpty() || champ1.derniereCarte().compareInstance(main.get(0))){
            champ1.planter(main.get(0));
        }else {
            if (champ2.haricots.isEmpty() || champ2.derniereCarte().compareInstance(main.get(0))) {
                champ2.planter(main.get(0));
            } else {
                champ1.planter(main.get(0));
            }
        }
    }

    public void troisChamp(){
        champ3=new Champ(3);
    }

    public Champ getChamp1() {
        return champ1;
    }
    */
}
