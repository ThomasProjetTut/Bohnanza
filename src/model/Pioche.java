package model;

import model.Carte.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {

    private List<Carte> pioche;
    private List<Carte> defausse;
    private int tourDePioche;

    public Pioche(){
        initPioche();
        defausse = new ArrayList<>();
        tourDePioche  = 1;
    }

    private void initPioche() {
        pioche = new ArrayList<Carte>();
        for (int i = 0; i < 104; i++) {
            if (i<6){
                pioche.add(new Carte_Pata_Tecktonik());
            }
            else if(i<14){
                pioche.add(new Carte_Pata_Terroriste());
            }
            else if(i<24){
                pioche.add(new Carte_Pata_Tetraplegique());
            }
            else if(i<36){
                pioche.add(new Carte_Pata_Tetenucleaire());
            }
            else if(i<50){
                pioche.add(new Carte_Pata_Testosterone());
            }
            else if(i<66){
                pioche.add(new Carte_Pata_Tequilla());
            }
            else if(i<84){
                pioche.add(new Carte_Pata_Tentacule());
            }
            else {
                pioche.add(new Carte_Pata_Twerk());
            }
        }
        Collections.shuffle(pioche);
    }

    public void removeCarte() {
        pioche.remove(pioche.size()-1);
    }

    public void addCarteToDefausse(Carte carte){
        defausse.add(carte);
    }

    public void nouveauTourDePioche(){
        if (pioche.size() > 0) return;

        for (Carte carte: defausse) {
            pioche.add(carte);
            defausse.remove(carte);
        }

        tourDePioche++;
    }

    //GETTER AND SETTER

    public int getTaillePioche(){
        return pioche.size();
    }

    public List<Carte> getPioche() {
        return pioche;
    }

    public void setPioche(List<Carte> pioche) {
        this.pioche = pioche;
    }

    public List<Carte> getDefausse() {
        return defausse;
    }

    public void setDefausse(List<Carte> defausse) {
        this.defausse = defausse;
    }

    public int getTourDePioche() {
        return tourDePioche;
    }

    public void setTourDePioche(int tourDePioche) {
        this.tourDePioche = tourDePioche;
    }
}
