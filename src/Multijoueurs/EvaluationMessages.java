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

    public static void Evaluer(byte[] data, Echange destinataire) {

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



        }
    }
}
