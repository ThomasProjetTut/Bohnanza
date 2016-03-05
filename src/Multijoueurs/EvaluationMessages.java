package Multijoueurs;

import controller.Controlleur;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by VDP on 01/03/2016.
 */
public class EvaluationMessages {

    public static void Evaluer(short MSG_TYPE, DataInputStream dataInputStream, Controlleur controlleur) throws IOException {

        switch (MSG_TYPE) {

            // RECEPTION DE LA DECONNEXION DU JOUEUR PAR LE SERVEUR
            case EnvoyerMessages.MSG_DECO_CLIENT:
                int idJoueur = dataInputStream.readInt();
                controlleur.getServeurTCP().deconnecterClient(controlleur.getServeurTCP().getEchangeByID(idJoueur));
                System.out.println("Client numéro "+idJoueur+" c'est déconnecté.");
                break;

            // RECEPTION DE LA CONNEXION DU JOUEUR PAR LE CLIENT
            case EnvoyerMessages.MSG_CONNEXION_CLIENT:
                idJoueur = dataInputStream.readInt();
                controlleur.getClientTCP().GetEchange().setIdJoueur(idJoueur);
                break;

            // KICK LE JOUEUR PAR LE SERVEUR
            case EnvoyerMessages.MSG_FORCE_KICK_CLIENT:
                controlleur.getClientTCP().StopClient();
                break;
        }
    }
}
