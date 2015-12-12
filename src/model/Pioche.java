package model;

import model.Carte.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {

    private List<Carte> listeCarte;

    public Pioche(){
        initListeCarte();
    }

    private void initListeCarte() {
        listeCarte = new ArrayList<Carte>();
        for (int i = 0; i < 104; i++) {
            if (i<6){
                listeCarte.add(new Carte_Pata_Tecktonik());
            }
            else if(i<14){
                listeCarte.add(new Carte_Pata_Terroriste());
            }
            else if(i<24){
                listeCarte.add(new Carte_Pata_Tetraplegique());
            }
            else if(i<36){
                listeCarte.add(new Carte_Pata_Tetenucleaire());
            }
            else if(i<50){
                listeCarte.add(new Carte_Pata_Testosterone());
            }
            else if(i<66){
                listeCarte.add(new Carte_Pata_Tequilla());
            }
            else if(i<84){
                listeCarte.add(new Carte_Pata_Tentacule());
            }
            else {
                listeCarte.add(new Carte_Pata_Twerk());
            }
        }
        Collections.shuffle(listeCarte);
    }

    public List<Carte> getlisteCarte() {
        return listeCarte;
    }

    public void removeCarte() {
        listeCarte.remove(0);
    }

    public int getTaillePioche(){
        return listeCarte.size();
    }
}
