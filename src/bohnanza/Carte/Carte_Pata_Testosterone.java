package bohnanza.Carte;

import java.util.HashMap;

public class Carte_Pata_Testosterone extends Carte {

    public Carte_Pata_Testosterone(){
        nom = "Pata Testosterone";
        nbMax = 14;
        patatometre = new HashMap<Integer, Integer>();
        patatometre.put(3,1);
        patatometre.put(5,2);
        patatometre.put(6,3);
        patatometre.put(7,4);
    }

    public boolean isPataTestosterone(){
        return true;
    }
}
