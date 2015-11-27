package bohnanza.Carte;

import java.util.HashMap;

public class Carte_Pata_Tentacule extends Carte {

    public Carte_Pata_Tentacule(){
        nom = "Pata Tentacule";
        nbMax = 18;
        patatometre = new HashMap<Integer, Integer>();
        patatometre.put(3,1);
        patatometre.put(6,2);
        patatometre.put(8,3);
        patatometre.put(9,4);
    }

    public boolean isPataTentacule(){
        return true;
    }
}
