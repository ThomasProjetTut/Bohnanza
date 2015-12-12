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
