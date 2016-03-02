package Multijoueurs;

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

                int msgLen = 0;
                if ((msgLen = in.readInt()) == 0)
                    continue;

                byte[] message = new byte[msgLen];
                in.readFully(message);

                // Analyser le message
                EvaluationMessages.Evaluer(message);

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