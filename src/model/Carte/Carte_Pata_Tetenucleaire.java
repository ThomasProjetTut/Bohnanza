package model.Carte;

import java.util.HashMap;

public class Carte_Pata_Tetenucleaire extends Carte {

    public Carte_Pata_Tetenucleaire(){
        nom = "Pata Tetenucleaire";
        nbMax = 12;
        patatometre = new HashMap<Integer, Integer>();
        patatometre.put(2,1);
        patatometre.put(4,2);
        patatometre.put(6,3);
        patatometre.put(7,4);
        idCarte = 6;
    }

    public boolean isPataTetenucleaire(){
        return true;
    }
}
