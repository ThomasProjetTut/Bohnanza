package model;

import model.Carte.Carte;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 13/11/2015.
 */
public class Champ {

    private int numeroChamp;
    public ArrayList<Carte> patates;

    public Champ(int i) {
        if (i>3){
            i=3;
        }
        numeroChamp=i;
        patates=new ArrayList<>();
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

    public int planter(Carte c) {
        int NombreCarte=patates.size();
        List<Integer> nbThunes=new ArrayList<Integer>();
        int valeurThune=0;


        if (CompareDerniereCarte(c)){
            patates.add(c);
            return 0;
        }else{
            for(int key :patates.get(0).getPatatometre().keySet()){
                nbThunes.add(key);
            }
            for(int nbPatateNecessary:nbThunes) {
                if(NombreCarte>=nbPatateNecessary){
                    valeurThune=patates.get(0).getPatatometre().get(nbPatateNecessary);
                }
            }
            patates.clear();
            patates.add(c);
            return valeurThune;
        }
    }

    public boolean CompareDerniereCarte(Carte c5) {
        if (derniereCarte()==null){
            return true;
        }
        if(c5.isPataTecktonik()){
            if (derniereCarte().isPataTecktonik()){
                return true;
            }else{
                return false;
            }
        }else {
            if (c5.isPataTentacule()) {
                if (derniereCarte().isPataTentacule()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (c5.isPataTequilla()) {
                    if (derniereCarte().isPataTequilla()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (c5.isPataTerroriste()) {
                        if (derniereCarte().isPataTerroriste()) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (c5.isPataTestosterone()) {
                            if (derniereCarte().isPataTestosterone()) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            if (c5.isPataTetenucleaire()) {
                                if (derniereCarte().isPataTetenucleaire()) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                if (c5.isPataTetraplegique()) {
                                    if (derniereCarte().isPataTetraplegique()) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int recolter() {
        //Valeur de la récolte en Thunes
        int valeurThune=0;
        //Nombre de Carte dans le Champ
        int NombreCarte=patates.size();
        //Différentes Key pour cette carte
        List<Integer>nbThunes=new ArrayList<>();
        for(int key :patates.get(0).getPatatometre().keySet()){
            nbThunes.add(key);
        }
        for(int nbPatateNecessary:nbThunes) {
            if(NombreCarte>=nbPatateNecessary){
                valeurThune=patates.get(0).getPatatometre().get(nbPatateNecessary);
                for (int i = 1; i <nbPatateNecessary ; i++) {
                    patates.remove(derniereCarte());
                }
            }
        }

        return valeurThune;
    }
}
