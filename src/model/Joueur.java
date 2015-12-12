package model;

import model.Carte.Carte;

import javax.net.ssl.SSLContext;
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
    private int idJoueur;

    public Joueur(){
        nom="";
        idJoueur = 0;
        thunes = new ArrayList<Carte>();
        nbThunes = thunes.size();
        maxChamps = 2;
        champs = new ArrayList<Champ>();

        for (int i = 0 ; i < maxChamps ; i++) {
            champs.add(new Champ(i+1));
        }

        zoneEchange=new Zone();

        main = new ArrayList<Carte>();
    }

    public Joueur(String nom, int idJoueur) {
        this.nom=nom;
        this.idJoueur = idJoueur;
        thunes = new ArrayList<Carte>();
        maxChamps = 2;
        champs = new ArrayList<Champ>();

        for (int i = 0 ; i < maxChamps ; i++) {
            champs.add(new Champ(i+1));
        }

        zoneEchange=new Zone();

        main = new ArrayList<Carte>();
    }

    public void recoisMain(Pioche pioche) {
        main.clear();

        // Ajoute la premiere carte & la supprime du jeu de carte
        for (int i = 0 ; i < 4 ; i++) {
            piocher(pioche);
        }
    }

    public void piocheEtape4(Pioche pioche){
        for (int i = 0 ; i < 3 ; i++) {
            piocher(pioche);
        }
    }

    public void piocher(Pioche pioche) {

        addCarte(pioche.getlisteCarte().get(0));
        pioche.removeCarte();

    }

    public void afficherMain(){
        System.out.println("Main de "+nom+" :");

        for (Carte carte: main) {
            System.out.println(carte.getNom());
        }

        System.out.println("Fin de l'affichage des mains.");
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

    //GETTER AND SETTER

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

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

}
