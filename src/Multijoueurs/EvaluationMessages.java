package Multijoueurs;

import controller.Controlleur;
import controller.ControlleurDepart;
import model.Carte.Carte;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by VDP on 01/03/2016.
 */
public class EvaluationMessages {

    public static void Evaluer(short MSG_TYPE, DataInputStream dataInputStream, ControlleurDepart controlleur) throws IOException {

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
                controlleur.getClientTCP().GetEchange().CreerJoueur("Joueur "+idJoueur, idJoueur);
                break;

            // KICK LE JOUEUR PAR LE SERVEUR
            case EnvoyerMessages.MSG_FORCE_KICK_CLIENT:
                controlleur.getClientTCP().StopClient();
                break;

            // COMMENCE LA PARTIE PAR LE CLIENT
            case EnvoyerMessages.MSG_START_GAME:

                controlleur.getClientTCP().GetEchange().getControlleurDepart().disposeVueConnexion();
                controlleur.getClientTCP().GetEchange().getJoueur().getControlleur().InitAttributs();

                for (int i = 0 ; i < 4 ; i++)
                    controlleur.getClientTCP().GetEchange().getJoueur().addCarte(Carte.createCarteByID(dataInputStream.readInt()));

                controlleur.getClientTCP().GetEchange().getJoueur().afficherMain();
                break;
        }
    }
}
