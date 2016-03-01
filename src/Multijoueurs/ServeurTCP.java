package Multijoueurs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ServeurTCP {
	private ServerSocket conn;
	private int port;

    // Liste des clients
    private List<Echange> echange;

    private Connexion connexion;

	public ServeurTCP(int port) throws IOException {
		this.port = port;
        echange = new ArrayList<>();
		conn = new ServerSocket(port);
        connexion = new Connexion(conn, this);
	}

	public void Start() throws IOException {
        connexion.start();
	}

    public List<Echange> GetEchange() {
        return echange;
    }

    public void StopServeur() throws IOException {
        connexion.Stop();

        for (Echange ech: echange) {
            ech.StopEchange();
        }

        conn.close();
    }
}

class Connexion extends Thread {

    private ServerSocket conn;
    private ServeurTCP serverTCP;

    boolean arret = false;

    public Connexion(ServerSocket s, ServeurTCP server){
        conn = s;
        serverTCP = server;
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

                serverTCP.GetEchange().add(new Echange(comm));

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