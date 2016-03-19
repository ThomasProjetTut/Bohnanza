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

    public static void FORCE_KICK(Echange source) throws IOException {
        DataOutputStream outputStream = source.getOut();

        outputStream.writeShort(MSG_FORCE_KICK_CLIENT);
        outputStream.flush();
    }

    public static void DECONNEXION(Echange source) throws IOException {
        DataOutputStream outputStream = source.getOut();

        outputStream.writeShort(MSG_DECO_CLIENT);
        outputStream.writeInt(source.getIdJoueur());
        outputStream.flush();
    }

    public static void CONNEXION(Echange source) throws IOException {
        DataOutputStream outputStream = source.getOut();

        outputStream.writeShort(MSG_CONNEXION_CLIENT);
        outputStream.writeInt(source.getIdJoueur());
        outputStream.flush();
    }

}
