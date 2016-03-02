package Multijoueurs;

import controller.Controlleur;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by VDP on 01/03/2016.
 */
public class EnvoyerMessages {

    public static final short MSG_TYPE_1 = 1;
    public static final short MSG_TYPE_2 = 2;

    private Controlleur controlleur;

    public EnvoyerMessages(Controlleur controlleur) {
        this.controlleur = controlleur;
    }

    public static void Envoyer(short type, Echange destinataire) {

        // COMPOSER UN MESSAGE
        /*
            byte[] id = ByteBuffer.allocate(Short.BYTES).putShort((short)2).array();
            byte[] numeroJoueur = ByteBuffer.allocate(Integer.BYTES).putInt(numJoueur).array();
            byte[] posX = ByteBuffer.allocate(Float.BYTES).putFloat(x).array();
            byte[] posY = ByteBuffer.allocate(Float.BYTES).putFloat(y).array();
            byte[] direction = ByteBuffer.allocate(Integer.BYTES).putInt(dir).array();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
            try {
                outputStream.write(id);
                outputStream.write(numeroJoueur);
                outputStream.write(posX);
                outputStream.write(posY);
                outputStream.write(direction);
            } catch (IOException e) {
                System.out.println("La concaténation des bytes a échouée.");
            }

            byte[] data = outputStream.toByteArray();
        */

        switch (type) {

            case MSG_TYPE_1:
                // Compose le message en récupérant les données du controlleur
                // L'envoi au destinataire
                break;

        }
    }
}
