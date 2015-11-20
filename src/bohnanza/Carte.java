package bohnanza;

/**
 * Created by Maxime on 13/11/2015.
 */
public class Carte {
    private int v4;  //valeur pour 7-plus haricots
    private int v3;  //valeur pour 5-6 haricots
    private int v2;  //valeur pour 3-4 haricots
    private int v1;  //valeur pour 1-2 haricots
    private String nom;

    public Carte(String nom, int i, int i1, int i2, int i3) {
        this.nom=nom;
        v1=i;
        v2=i1;
        v3=i2;
        v4=i3;
    }

    public String getNom() {
        return nom;
    }

    public boolean compareInstance(Carte c5) {
        return c5 != null;
    }
    public void print(){
        System.out.print(nom);
    }
}
