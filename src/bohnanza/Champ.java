package bohnanza;

import bohnanza.Carte.Carte;


import java.util.ArrayList;

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
        ArrayList<Integer> nbThunes=new ArrayList<Integer>();


        if (CompareDerniereCarte(c)){
            patates.add(c);
            return 0;
        }else{
            for(int key :patates.get(0).getPatatometre().keySet()){
                nbThunes.add(key);
            }
            for (int i = nbThunes.size(); i >=0 ; i--) {
                if (NombreCarte>nbThunes.get(i)){
                    return patates.get(0).getPatatometre().get(i);
                }
            }
            patates.clear();
            patates.add(c);
        }
        return 0;
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

}
