package Multijoueurs;

import controller.Controlleur;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by VDP on 01/03/2016.
 */
public class EnvoyerMessages {

    public static final short MSG_DECO_CLIENT = 1;
    public static final short MSG_CONNEXION_CLIENT = 2;
    public static final short MSG_FORCE_KICK_CLIENT = 3;

    public static void Envoyer(short type, Echange source) throws IOException {

        DataOutputStream outputStream = source.getOut();

        switch (type) {

            case MSG_FORCE_KICK_CLIENT:
                outputStream.writeShort(type);
                outputStream.flush();
                break;

            case MSG_CONNEXION_CLIENT:
            case MSG_DECO_CLIENT:
                outputStream.writeShort(type);
                outputStream.writeInt(source.getIdJoueur());
                outputStream.flush();
                break;


        }
    }
}
