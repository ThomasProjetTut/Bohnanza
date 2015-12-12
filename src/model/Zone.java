package model;

import model.Carte.Carte;

import java.util.ArrayList;
import java.util.List;

public class Zone {

    public List<Carte> zone;

    public Zone(){
        zone =new ArrayList<Carte>();
    }

    public void ajouterCarte(Carte c) {
        zone.add(c);
    }

    public void supprimerCarte(Carte c){
        zone.remove(c);
    }

    public List<Carte> getZone(){
        return zone;
    }

    public void clear() {
        for (Carte carte: zone) {
            zone.remove(carte);
        }
    }

    public void printZone(){
        System.out.println("Les carte de la zone :");
        for (Carte carte : zone) {
            System.out.println(carte.getNom());
        }
    }
}
