package model;

import model.Carte.Carte;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private int maxChamps;
    private List<Carte> thunes;
    private int nbThunes;
    private String nom;
    private List<Carte> main;
    private List<Champ> champs;

    private Zone zoneEchange;

    public Joueur(){
        nom="";
        thunes = new ArrayList<>();
        nbThunes = thunes.size();
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
        thunes = new ArrayList<>();
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

        List<Carte> cartes = Pioche.getlisteCarte();

        addCarte(cartes.get(0));
        Pioche.removeCarte();
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

    public List<Carte> getMain() {
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

    public List<Carte> getThunes() {
        return thunes;
    }

    public void setThunes(List<Carte> thunes) {
        this.thunes = thunes;
    }


    public int getNbThunes() {
        nbThunes = thunes.size();
        return nbThunes;
    }

    public void setNbThunes(int nbThunes) {
        this.nbThunes = nbThunes;
    }

}
