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

        if (CompareDerniereCarte(c)){
            patates.add(c);
            return true;
        }
        else return false;
    }

    public boolean CompareDerniereCarte(Carte carte) {
        return derniereCarte() == null || derniereCarte().getIdCarte() == carte.getIdCarte();
    }

    public int recolter(Joueur j, Pioche pioche) {

        //Valeur de la récolte en Thunes
        int valeurThune=0;

        //Nombre de Carte dans le Champ
        int NombreCarte=patates.size();

        //Différentes Key pour cette carte
        List<Integer>nbThunes=new ArrayList<Integer>();


        for(int key :patates.get(0).getPatatometre().keySet()){
            nbThunes.add(key);
        }

        for(int nbPatateNecessary:nbThunes) {
            if(NombreCarte>=nbPatateNecessary){
                valeurThune=patates.get(0).getPatatometre().get(nbPatateNecessary);
            }
        }

        for (int i = 1; i < patates.size() ; i++) {

            if (i < valeurThune){
                j.addThunes(derniereCarte());
            }
            else{
                pioche.addCarteToDefausse(derniereCarte());
            }
            patates.remove(derniereCarte());
        }

        return valeurThune;
    }
}
