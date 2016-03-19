package controller;

import Multijoueurs.ClientTCP;
import Multijoueurs.ServeurTCP;
import view.VueDepart;
import view.vueConnexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlleurDepart implements ActionListener {

    private VueDepart vueDepart;
    private Controlleur jeu;

    private vueConnexion vueCon;

    private ServeurTCP serveurTCP;
    private ClientTCP clientTCP;

    public ControlleurDepart(){
        //vueDepart = new VueDepart(this);
        LancerVueConnexion();
    }

    public void LancerVueConnexion() {

        vueCon = new vueConnexion(this);
    }

    public void disposeVueConnexion() {
        vueCon.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vueDepart.getBouttonCommencer()){


        }
    }

    //Partie multi
    public void InitClient(String ipServ, int port) throws IOException {
        System.out.println("Lancement du client.");
        clientTCP = new ClientTCP(this, ipServ, port);
        clientTCP.Start();
    }
    public void InitServeur(int port) throws IOException {
        System.out.println("Lancement du serveur.");
        serveurTCP = new ServeurTCP(this, port);
        serveurTCP.Start();
    }
    public void resetClient() throws IOException {

        if (clientTCP == null)
            return;

        if (!clientTCP.SocketIsClose())
            clientTCP.StopClient();

        clientTCP = null;
        vueCon.reiniButton();
        System.out.println("Déconnection réussie.");
    }
    public void resetServeur() throws IOException {

        if (serveurTCP == null)
            return;

        if (!serveurTCP.SocketIsClose())
            serveurTCP.StopServeur();

        serveurTCP = null;
        vueCon.reiniButton();
        System.out.println("Le serveur à bien été stoppé.");
    }
    public ServeurTCP getServeurTCP() {
        return serveurTCP;
    }
    public ClientTCP getClientTCP() {
        return clientTCP;
    }


}
