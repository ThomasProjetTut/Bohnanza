package Multijoueurs;

import controller.Controlleur;
import controller.ControlleurDepart;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by VDP on 25/01/2016.
 */
public class ClientTCP {
    private Socket conn;

    // Communication avec le serveur
    private Echange echange = null;
    private ControlleurDepart control;

    private String IPHost;

    public ClientTCP(ControlleurDepart controlleur, String ipServ, int port) throws IOException {
        conn = new Socket(ipServ, port);
        IPHost = ipServ;
        echange = new Echange(conn, controlleur);
        control = controlleur;
    }

    public void Start() {
        echange.Start();
        System.out.println("Connecté à "+IPHost);
    }

    public boolean SocketIsClose() {
        return conn.isClosed();
    }

    public Echange GetEchange() {
        return echange;
    }

    public void StopClient() throws IOException {
        EnvoyerMessages.DECONNEXION(echange);
        echange.StopEchange();
    }
}
