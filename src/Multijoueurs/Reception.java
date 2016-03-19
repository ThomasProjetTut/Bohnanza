package Multijoueurs;

import controller.Controlleur;

import javax.management.AttributeChangeNotification;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by VDP on 09/01/2016.
 */
public class Reception extends Thread {

    private DataInputStream in;
    private Echange echange = null;

    boolean arret = false;

    public Reception(DataInputStream in, Echange echange) {
        this.in = in;
        this.echange = echange;
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

                short MSG_TYPE;
                if ((MSG_TYPE = in.readShort()) == 0)
                    continue;

                // Analyser le message
                EvaluationMessages.Evaluer(MSG_TYPE, in, echange.getControlleurDepart());

            } catch (IOException e) {
                StopThread();
                break;
            }
        }

    }

    public synchronized void StopThread() {
        arret = true;
    }
}