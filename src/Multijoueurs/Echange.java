package Multijoueurs;

import java.io.*;
import java.net.Socket;


public class Echange {

    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Reception reception = null;

    public Echange(Socket s){
        socket = s;
        run();
    }

    private void run() {

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            reception = new Reception(in, this);
            reception.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(byte[] message, int msgLen) {
        try {
            // Envoie la taille du message puis le message
            out.writeInt(msgLen);
            out.write(message, 0, msgLen);
            out.flush();
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
}