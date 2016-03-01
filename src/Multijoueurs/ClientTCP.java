package Multijoueurs;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by VDP on 25/01/2016.
 */
public class ClientTCP {
    private Socket conn;

    // Communication avec le serveur
    private Echange echange = null;

    boolean arret = false;

    public ClientTCP(String ipServ, int port) throws IOException {
        conn = new Socket(ipServ, port);
    }

    public void Start() {

        boolean fin = false;

        while (!fin) {

            synchronized (this) {
                Thread.yield();
                fin = arret;
            }

            if (arret)
                break;

            echange = new Echange(conn);
        }
    }

    public Echange GetEchange() {
        return echange;
    }

    public synchronized void StopClient() {
        arret = true;
    }
}
