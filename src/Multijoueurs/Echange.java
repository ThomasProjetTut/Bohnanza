package Multijoueurs;

import controller.Controlleur;

import java.io.*;
import java.net.Socket;


public class Echange {

    private int idJoueur;
    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Reception reception = null;

    private Controlleur controlleur;

    public Echange(Socket s, Controlleur controlleur){
        socket = s;
        this.controlleur = controlleur;
    }

    public void setIdJoueur(int id) {
        idJoueur = id;
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

    public int getIdJoueur() {
        return idJoueur;
    }

    public Controlleur getControlleur() {
        return controlleur;
    }
}