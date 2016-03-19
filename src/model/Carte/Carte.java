package model.Carte;

import java.util.Map;

public abstract class Carte {
    protected String nom;
    protected int nbMax;
    protected int idCarte;
    protected Map<Integer,Integer> patatometre;

    public String getNom() {
        return nom;
    }

    public static Carte createCarteByID(int id) {
        switch (id) {
            case 1:
                return new Carte_Pata_Tecktonik();
            case 2:
                return new Carte_Pata_Tentacule();
            case 3:
                return new Carte_Pata_Tequilla();
            case 4:
                return new Carte_Pata_Terroriste();
            case 5:
                return new Carte_Pata_Testosterone();
            case 6:
                return new Carte_Pata_Tetenucleaire();
            case 7:
                return new Carte_Pata_Tetenucleaire();
            case 8:
                return new Carte_Pata_Twerk();
        }
        return null;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public Map<Integer, Integer> getPatatometre() {
        return patatometre;
    }

    public void setPatatometre(Map<Integer, Integer> patatometre) {
        this.patatometre = patatometre;
    }

    public boolean isPataTecktonik(){
        return false;
    }
    public boolean isPataTentacule(){
        return false;
    }
    public boolean isPataTequilla(){
        return false;
    }
    public boolean isPataTerroriste(){
        return false;
    }
    public boolean isPataTestosterone(){
        return false;
    }
    public boolean isPataTetenucleaire(){
        return false;
    }
    public boolean isPataTetraplegique(){
        return false;
    }
    public boolean isPataTwerk(){
        return false;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

}
