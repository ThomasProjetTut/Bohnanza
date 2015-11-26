package bohnanza.Carte;

import java.util.HashMap;

public class Carte_Pata_Tetraplegique extends Carte {

    public Carte_Pata_Tetraplegique(){
        nom = "Pata Tetraplegique";
        nbMax = 10;
        patatometre = new HashMap<>();
        patatometre.put(2,1);
        patatometre.put(4,2);
        patatometre.put(5,3);
        patatometre.put(6,4);
    }

    public boolean isPataTetraplegique(){
        return true;
    }
}
