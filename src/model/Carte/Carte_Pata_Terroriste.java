package model.Carte;

import java.util.HashMap;

public class Carte_Pata_Terroriste extends Carte {

    public Carte_Pata_Terroriste(){
        nom = "Pata Terroriste";
        nbMax = 8;
        patatometre = new HashMap<Integer, Integer>();
        patatometre.put(2,1);
        patatometre.put(3,2);
        patatometre.put(4,3);
        patatometre.put(5,4);
        idCarte = 4;
    }

    public boolean isPataTerroriste(){
        return true;
    }
}
