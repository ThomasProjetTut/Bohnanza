package bohnanza;

import bohnanza.Carte.Carte;
import bohnanza.Carte.Carte_Pata_Tecktonik;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 13/11/2015.
 */
public class Joueur {

    private int maxChamps;
    private int thunes;
    private String nom;
    private ArrayList<Carte> main;
    private ArrayList<Champ> champs;
    private Zone zoneEchange;

    public Joueur(){
        nom="";
        thunes =0;
        maxChamps = 2;
        champs = new ArrayList<>();

        for (int i = 0 ; i < maxChamps ; i++) {
            champs.add(new Champ(i+1));
        }

        zoneEchange=new Zone();

        main = new ArrayList<>();
    }

    public Joueur(String nom) {
        this.nom=nom;
        thunes =0;
        maxChamps = 2;
        champs = new ArrayList<>();

        for (int i = 0 ; i < maxChamps ; i++) {
            champs.add(new Champ(i+1));
        }

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

    public void acheterChamps() {
        if (maxChamps > 3)
            return;

        maxChamps++;

        champs.add(new Champ(maxChamps-1));
    }

    public Champ getChamp(int index) {
        return champs.get(index-1);
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public void addCarte(Carte carte) {
        main.add(carte);
    }

    public void planter(int champ) {

        if (champ > maxChamps || champ < 1)
            return;

        champs.get(champ - 1).planter(main.get(0));
        main.remove(main.get(0));
    }

    public void recoisCarte(Carte c) {
        zoneEchange.ajouterCarte(c);
    }

    public void donnerCarte(Carte c, Joueur joueur) {
        joueur.recoisCarte(c);
        main.remove(c);
    }

    public Zone getZone() {
        return zoneEchange;
    }

    public void echangeCarte(Carte donnee, Joueur cible, Carte recue) {
        donnerCarte(donnee,cible);
        cible.donnerCarte(recue,this);
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
