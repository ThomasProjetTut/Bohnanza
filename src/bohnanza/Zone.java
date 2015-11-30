package bohnanza;

import bohnanza.Carte.Carte;
import bohnanza.Carte.Carte_Pata_Tecktonik;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 30/11/2015.
 */
public class Zone {
    public List<Carte> zoneEchange = new ArrayList<Carte>();

    public void ajouterCarte(Carte c) {
        zoneEchange.add(c);
    }
    public List<Carte> getZone(){
        return zoneEchange;
    }
}
