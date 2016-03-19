package model;

import model.Carte.Carte;
import java.util.ArrayList;
import java.util.List;

public class Champ {

    private int numeroChamp;
    public ArrayList<Carte> patates;

    public Champ(int i) {
        if (i>3){
            i=3;
        }
        numeroChamp=i;
        patates=new ArrayList<Carte>();
    }

    public Champ(int i, ArrayList<Carte> list) {
        numeroChamp=i;
        patates=list;
    }

    public Carte derniereCarte(){

        if (patates.size()==0) {
            return null;
        }else {
        return patates.get(patates.size()-1);}
    }

    public boolean planter(Carte c) {

        if (c == null)
            return false;

        if (CompareDerniereCarte(c)){
            patates.add(c);

            //System.out.println("Ajout de "+c.getNom()+" réussie");
            return true;
        }
        else{
            //System.out.println("Impossible de planter une "+c.getNom()+" car il y a au moins une "+derniereCarte().getNom()+" dans le champ.");
            return false;
        }
    }

    public boolean CompareDerniereCarte(Carte carte) {

        if (derniereCarte() == null) // Si le champs est vide
            return true;

        if (derniereCarte().getIdCarte() != carte.getIdCarte())
            return false;

        return true;
    }

    public void recolter(Joueur j, Pioche pioche) {

        //Valeur de la récolte en Thunes
        int valeurThune=0;

        //Nombre de Carte dans le Champ
        int NombreCarte=patates.size();

        //Différentes Key pour cette carte
        List<Integer>nbThunes=new ArrayList<Integer>();

        //Rends impossible la recolte pour un champs d'une carte
        if(NombreCarte == 1)return;


        for(int key :patates.get(0).getPatatometre().keySet()){
            nbThunes.add(key);
        }

        for(int nbPatateNecessary:nbThunes) {
            if(NombreCarte>=nbPatateNecessary){
                valeurThune=patates.get(0).getPatatometre().get(nbPatateNecessary);
            }
        }

        for (int i = 1; i < patates.size() ; i++) {

            if (i <= valeurThune){
                j.addThunes(derniereCarte());
            }
            else{
                pioche.addCarteToDefausse(derniereCarte());
            }
        }

        patates.clear();

        //System.out.println("Récolte de "+valeurThune+" thunes avec cette récolte.");
        // System.out.println("Il y a "+j.getThunes().size()+" patates dans Thunes");
        //System.out.println("Il y a "+j.getNbThunes()+" patates dans Thunes");
    }

    public void printChamp(){
        if (patates.size() != 0){
            //System.out.println("Il y a "+patates.size()+" "+derniereCarte().getNom()+" dans le champ n°"+numeroChamp+".");
        }
        else {
            //System.out.println("Il n'y a aucune patate dans le champ n°"+numeroChamp+".");
        }

    }

    public int getNumeroChamp() {
        return numeroChamp;
    }

    public void setNumeroChamp(int numeroChamp) {
        this.numeroChamp = numeroChamp;
    }
}
