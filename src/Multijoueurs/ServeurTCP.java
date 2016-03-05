package Multijoueurs;

import controller.Controlleur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServeurTCP {
	private ServerSocket conn;
	private int port;
    private int countIDJoueur;
    private Controlleur control;

    // Liste des clients
    private List<Echange> echange;

    private Connexion connexion;

	public ServeurTCP(Controlleur controlleur, int port) throws IOException {
        countIDJoueur = 0;
		this.port = port;
        echange = new ArrayList<>();
		conn = new ServerSocket(port);
        connexion = new Connexion(controlleur, conn, this);
        control = controlleur;
	}

	public void Start() throws IOException {
        connexion.start();
        UpdateGame();
	}

    public boolean SocketIsClose() {
        return conn.isClosed();
    }

    // Déroulement du jeu
    public void UpdateGame() {

    }

    public List<Echange> GetEchange() {
        return echange;
    }

    public void StopServeur() throws IOException {
        connexion.Stop();

        for (Echange ech: echange) {
            kickClient(ech);
        }

        while (!echange.isEmpty()) {

        }

        conn.close();
    }

    public void kickClient(Echange ech) throws IOException {
        EnvoyerMessages.Envoyer(EnvoyerMessages.MSG_FORCE_KICK_CLIENT, ech);
    }

    public void deconnecterClient(Echange ech) throws IOException {
        ech.StopEchange();
        echange.remove(ech);
    }

    public void incrementCountIDJoueur() {
        countIDJoueur++;
    }

    public int getCountIDJoueur() {
        return countIDJoueur;
    }

    public Echange getEchangeByID(int id) {
        for (Echange ech : echange)
            if (ech.getIdJoueur() == id)
                return ech;

        return null;
    }
}

class Connexion extends Thread {

    private ServerSocket conn;
    private ServeurTCP serverTCP;
    private Controlleur controller;

    boolean arret = false;

    public Connexion(Controlleur controlleur, ServerSocket s, ServeurTCP server){
        conn = s;
        serverTCP = server;
        controller = controlleur;
    }

    public void run() {

        boolean fin = false;


        while (!fin) {
            try {

                synchronized (this) {
                    Thread.yield();
                    fin = arret;
                }

                if (arret)
                    break;

                Socket comm = conn.accept();

                Echange echange = new Echange(comm, controller);
                echange.Start();
                serverTCP.incrementCountIDJoueur();
                echange.setIdJoueur(serverTCP.getCountIDJoueur());

                serverTCP.GetEchange().add(echange);

                EnvoyerMessages.Envoyer(EnvoyerMessages.MSG_CONNEXION_CLIENT, echange);
                System.out.println("Joueur numéro "+echange.getIdJoueur()+" connecté.");

            } catch (IOException e) {
                Stop();
                break;
            }
        }
    }

    public synchronized void Stop() {
        arret = true;
    }
}