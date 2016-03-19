package Multijoueurs;

import controller.Controlleur;
import controller.ControlleurDepart;
import model.Joueur;
import model.Pioche;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServeurTCP {
	private ServerSocket conn;
	private int port;
    private int countIDJoueur;
    private ControlleurDepart control;
    private Joueur joueur;

    public List<Echange> getEchange() {
        return echange;
    }

    // Liste des clients
    private List<Echange> echange;

    private Connexion connexion;

	public ServeurTCP(ControlleurDepart controlleur, int port) throws IOException {
        countIDJoueur = 0;
		this.port = port;
        echange = new ArrayList<>();
		conn = new ServerSocket(port);
        connexion = new Connexion(conn, this, controlleur);
	}

	public void Start() throws IOException {
        connexion.start();
	}

    public void CreateGame() {

        joueur = new Joueur("Joueur 0", 0);

        Pioche pioche = joueur.getControlleur().InitPioche();
        joueur.getControlleur().InitAttributs();
        joueur.getControlleur().RecoisMain();

        try {
            for (Echange ech : echange) {
                Joueur player = ech.getJoueur();
                player.recoisMain(pioche);
                EnvoyerMessages.START_GAME(ech);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        control.disposeVueConnexion();

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
        EnvoyerMessages.FORCE_KICK(ech);
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
    private ControlleurDepart controlleurDepart;

    boolean arret = false;

    public Connexion(ServerSocket s, ServeurTCP server,  ControlleurDepart controlleurDepart){
        conn = s;
        serverTCP = server;
        this.controlleurDepart = controlleurDepart;
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

                Echange echange = new Echange(comm, controlleurDepart);
                echange.Start();
                serverTCP.incrementCountIDJoueur();
                echange.CreerJoueur("Joueur "+serverTCP.getCountIDJoueur(), serverTCP.getCountIDJoueur());

                serverTCP.GetEchange().add(echange);

                EnvoyerMessages.CONNEXION(echange);
                System.out.println("Joueur numéro "+echange.getIdJoueur()+" connecté.");

                if (serverTCP.getCountIDJoueur() == 1) {
                    serverTCP.CreateGame();
                    return;
                }

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