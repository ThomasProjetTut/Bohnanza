package model.Carte;

import java.util.HashMap;

public class Carte_Pata_Twerk extends Carte {

    public Carte_Pata_Twerk(){
        nom = "Pata Twerk";
        nbMax = 20;
        patatometre = new HashMap<Integer, Integer>();
        patatometre.put(4,1);
        patatometre.put(6,2);
        patatometre.put(8,3);
        patatometre.put(10,4);

    }

    public boolean isPataTwerk(){
        return true;
    }
}
