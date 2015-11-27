package bohnanza.Carte;

import java.util.HashMap;

public class Carte_Pata_Tecktonik extends Carte {

    public Carte_Pata_Tecktonik(){
        nom = "Pata Tecktonik";
        nbMax = 6;
        patatometre = new HashMap<Integer, Integer>();
        patatometre.put(2,2);
        patatometre.put(3,3);
    }

    public boolean isPataTecktonik(){
        return true;
    }
}
