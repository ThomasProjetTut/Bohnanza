package model;

import controller.Controlleur;
import controller.ControlleurDepart;
import model.Carte.Carte;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedInputStream;

public class Joueur {

    private int maxChamps;
    private List<Carte> thunes;
    private String nom;
    private List<Carte> main;
    private List<Champ> champs;
    private Zone zoneEchange;

    public ControlleurDepart getControlleurDepart() {
        return controlleurDepart;
    }

    private ControlleurDepart controlleurDepart;
    private int idJoueur;

    public Controlleur getControlleur() {
        return controlleur;
    }

    private Controlleur controlleur;

    public Joueur(){
        nom="";
        idJoueur = 0;
        thunes = new ArrayList<Carte>();
        maxChamps = 2;
        champs = new ArrayList<Champ>();

        for (int i = 0 ; i < maxChamps ; i++) {
            champs.add(new Champ(i+1));
        }

        zoneEchange=new Zone();

        main = new ArrayList<Carte>();

        controlleur = new Controlleur(this);
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

        controlleur = new Controlleur(this);
    }

    public Joueur(String nom, int idJoueur, ControlleurDepart controlleurDepart) {
        this.controlleurDepart = controlleurDepart;
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

        controlleur = new Controlleur(this);
    }

    public void recoisMain(Pioche pioche) {
        main.clear();

        // Ajoute la dernière carte de la liste pioche & la supprime du jeu de carte
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
        addCarte(pioche.giveNextCarte());
    }

    public void afficherMain(){
        //System.out.println("Main de "+nom+" :");

        for (Carte carte: main) {
           // System.out.println(carte.getNom());
        }

        //System.out.println("Fin de l'affichage des mains.");
    }

    public void acheterChamps(Pioche pioche) {
        if (maxChamps >= 3) return;

        if (thunes.size() < 5) return;

        for (int i = 0; i < 5; i++) {
            pioche.addCarteToDefausse(thunes.get(thunes.size()-1));
            thunes.remove(thunes.size()-1);
        }

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

    public void planter(int numChamp, Pioche pioche) {

        if (numChamp > maxChamps || numChamp < 1)
            return;
        if(verifChamps(main.get(0),champs.get(numChamp-1))) {
            if (champs.get(numChamp - 1).planter(main.get(0))) {
                main.remove(main.get(0));
            } else {
                champs.get(numChamp - 1).recolter(this, pioche);

                champs.get(numChamp - 1).planter(main.get(0));

                main.remove(main.get(0));
            }
        }
    }

    public boolean verifChamps(Carte carte, Champ champ){
        for (Champ champVerif : champs) {
            if(champVerif != champ){
                if(champVerif.patates.size() > 0){
                    if (carte.getIdCarte() == champVerif.derniereCarte().getIdCarte()){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void planterViaZoneEchange(int numChamp, Pioche pioche, int placeInZone){

        if (numChamp > maxChamps || numChamp < 1)
            return;

        if (!getChamp(numChamp).planter(zoneEchange.getZone().get(placeInZone-1))) {
            getChamp(numChamp).recolter(this, pioche);
            getChamp(numChamp).planter(zoneEchange.getZone().get(placeInZone-1));
        }
    }

    public void recoisCarte(Carte c) {
        zoneEchange.ajouterCarte(c);
    }

    public void donnerCarte(Carte c, Joueur joueur) {
        joueur.recoisCarte(c);
        main.remove(c);
    }

    public void echangeCarteMainMain(Carte donnee, Joueur cible, Carte recue) {

        if (recue != null){
            donnerCarte(donnee,cible);
            cible.donnerCarte(recue,this);
        }
    }

    public void echangeCartePiocheMain(Carte donnee, Joueur cible, Carte recue) {

        if (recue != null){
            cible.recoisCarte(donnee);
            cible.donnerCarte(recue,this);
        }

    }

    public void addThunes(Carte carte) {
        thunes.add(carte);
    }

    public Carte findCarteById (int idCarte){
        Carte carteRetour = null;

        for (Carte carte: main) {
            if (carte.getIdCarte() == idCarte){
                carteRetour = carte;
            }
        }

        return carteRetour;

    }

    public boolean haveCarteInMain(int idCarte){
        boolean retour = false;

        for (Carte carteMain: main) {
            if (carteMain.getIdCarte() == idCarte)
                retour = true;
        }

        return retour;
    }

    //GETTER AND SETTER

    public List<Carte> getThunes() {
        return thunes;
    }

    public void setThunes(List<Carte> thunes) {
        this.thunes = thunes;
    }

    public int getNbThunes(){
        return thunes.size();
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public int getMaxChamps() {
        return maxChamps;
    }

    public void setMaxChamps(int maxChamps) {
        this.maxChamps = maxChamps;
    }

    public Zone getZoneEchange() {
        return zoneEchange;
    }

    public void setZoneEchange(Zone zoneEchange) {
        this.zoneEchange = zoneEchange;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
