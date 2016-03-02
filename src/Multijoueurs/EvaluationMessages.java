package Multijoueurs;

import controller.Controlleur;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by VDP on 01/03/2016.
 */
public class EvaluationMessages {

    private Controlleur controlleur;

    public EvaluationMessages(Controlleur controlleur) {
        this.controlleur = controlleur;
    }

    public static void Evaluer(byte[] data) {

        // DECOMPOSER UN MESSAGE
        /*
            countBytes = Short.BYTES;
            wrapped = ByteBuffer.wrap(Arrays.copyOfRange(data, Short.BYTES, countBytes + Integer.BYTES)); // 4 bytes
            x = wrapped.getInt();
            countBytes += Integer.BYTES;

            wrapped = ByteBuffer.wrap(Arrays.copyOfRange(data, countBytes, countBytes + Integer.BYTES)); // 5 bytes
            y = wrapped.getInt();
            countBytes += Integer.BYTES;

            wrapped = ByteBuffer.wrap(Arrays.copyOfRange(data, countBytes, countBytes + Integer.BYTES)); // 4 bytes
            numJOueur = wrapped.getInt();
            countBytes += Integer.BYTES;

            wrapped = ByteBuffer.wrap(Arrays.copyOfRange(data, countBytes, data.length)); // 20 bytes
            String nomJoueur = null;// = wrapped.asCharBuffer().toString();

            //String str = null;
            try {
                nomJoueur = new String(wrapped.array(),  "Cp1252");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        */

        ByteBuffer wrapped = ByteBuffer.wrap(Arrays.copyOfRange(data, 0, Short.BYTES));
        short id = wrapped.getShort();

        int countBytes = Short.BYTES;

        switch (id) {

            case EnvoyerMessages.MSG_TYPE_1:
                // Decompose le message
                // Appelle la méthode du controlleur correspondante
                break;

        }
    }
}
