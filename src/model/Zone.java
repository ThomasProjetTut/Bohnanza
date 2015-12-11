package model;

import model.Carte.Carte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 30/11/2015.
 */
public class Zone {

    public List<Carte> zoneEchange;

    public Zone(){
        zoneEchange=new ArrayList<Carte>();
    }

    public void ajouterCarte(Carte c) {
        zoneEchange.add(c);
    }
    public void supprimerCarte(Carte c){zoneEchange.remove(c);}
    public List<Carte> getZone(){
        return zoneEchange;
    }


    public void donnerCarte(Carte c, Zone zone) {
        zone.ajouterCarte(c);
        supprimerCarte(c);
    }

    public void echangerCarte(Carte adonner, Zone zone1, Carte recu) {
        zone1.ajouterCarte(adonner);
        supprimerCarte(adonner);
        ajouterCarte(recu);
        zone1.supprimerCarte(recu);

    }
}
