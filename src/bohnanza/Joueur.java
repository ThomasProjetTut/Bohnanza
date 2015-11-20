package bohnanza;

import java.util.ArrayList;

/**
 * Created by Maxime on 13/11/2015.
 */
public class Joueur {
    private String nom;
    private ArrayList<Carte> main;
    private Champ champ1;
    private Champ champ2;
    private Champ champ3;

    public Joueur(){
        nom="";
        champ1=new Champ(1);
        champ2=new Champ(2);
    }

    public Joueur(String nom) {
        this.nom=nom;
        champ1=new Champ(1);
        champ2=new Champ(2);
    }

    public void recoisMain(ArrayList<Carte> main) {
        this.main=main;
        for(Carte c : main){
            c.print();
        }
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public void jouerCoup() {
        if(champ1.haricots.isEmpty() || champ1.derniereCarte().compareInstance(main.get(0))){
            champ1.planter(main.get(0));
        }else {
            if (champ2.haricots.isEmpty() || champ2.derniereCarte().compareInstance(main.get(0))) {
                champ2.planter(main.get(0));
            } else {
                champ1.planter(main.get(0));
            }
        }
    }

    public void troisChamp(){
        champ3=new Champ(3);
    }

    public Champ getChamp1() {
        return champ1;
    }
}
