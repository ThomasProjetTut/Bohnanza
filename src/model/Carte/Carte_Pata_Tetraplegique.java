package model.Carte;

import java.util.HashMap;

public class Carte_Pata_Tetraplegique extends Carte {

    public Carte_Pata_Tetraplegique(){
        nom = "Pata Tetraplegique";
        nbMax = 10;
        patatometre = new HashMap<Integer, Integer>();
        patatometre.put(2,1);
        patatometre.put(4,2);
        patatometre.put(5,3);
        patatometre.put(6,4);
        idCarte = 7;
    }

    public boolean isPataTetraplegique(){
        return true;
    }
}
