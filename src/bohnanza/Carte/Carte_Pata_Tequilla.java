package bohnanza.Carte;

import java.util.HashMap;

public class Carte_Pata_Tequilla extends Carte {

    public Carte_Pata_Tequilla(){
        nom = "Pata Tequilla";
        nbMax = 16;
        patatometre = new HashMap<>();
        patatometre.put(3,1);
        patatometre.put(5,2);
        patatometre.put(7,3);
        patatometre.put(8,4);
    }

    public boolean isPataTequilla(){
        return true;
    }
}
