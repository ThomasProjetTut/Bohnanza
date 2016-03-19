package Multijoueurs;

import controller.Controlleur;
import controller.ControlleurDepart;
import model.Joueur;

import java.io.*;
import java.net.Socket;


public class Echange {

    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Reception reception = null;
    private Joueur joueur;

    public ControlleurDepart getControlleurDepart() {
        return controlleurDepart;
    }

    private ControlleurDepart controlleurDepart;

    public Echange(Socket s, ControlleurDepart controlleurDepart){
        socket = s;
        this.controlleurDepart = controlleurDepart;
    }

    public void CreerJoueur(String name, int idJoueur) {
        joueur = new Joueur(name, idJoueur);
    }

    public void setIdJoueur(int id) {
        joueur.setIdJoueur(id);
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void Start() {

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            reception = new Reception(in, this);
            reception.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StopEchange() throws IOException {

        reception.StopThread();
        socket.close();
        in.close();
        out.close();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public int getIdJoueur() {
        return joueur.getIdJoueur();
    }

    public Controlleur getControlleur() {
        return joueur.getControlleur();
    }
}