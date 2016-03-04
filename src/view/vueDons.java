package view;

import controller.Controlleur;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by mvava on 29/02/2016.
 */
public class vueDons extends JFrame {
    private Controlleur controlleur;

    // Carte à donnee
    private JPanel panelCarteADonnee;

    //Image
    private ImageIcon imageJ1, imageJ2, imageJ3;

    //

    //Boutons
    private JButton btacceptationJ1=new JButton("Proposer");
    private JButton btacceptationJ2 =new JButton("Proposer");
    private JButton btacceptationJ3 = new JButton("Proposer");
    private JButton btconclure = new JButton("CONCLURE");


    //Label
    private JLabel txtAccpterJ1=new JLabel("REFUSER");
    private JLabel txtAccpterJ2= new JLabel("REFUSER");
    private JLabel txtAccpterJ3= new JLabel("REFUSER");

    private JLabel textJ1=new JLabel("JOUEUR 1");
    private JLabel textJ2=new JLabel("JOUEUR 2");
    private JLabel textJ3=new JLabel("JOUEUR 3");

    //Panel
    private JPanel panGlobal = new JPanel();
    private JPanel zoneJoueur = new JPanel();

    private GridLayout g1=new GridLayout(3,3);


    public vueDons(Controlleur controlleur){
        this.controlleur = controlleur;

        initAttribut();
        creerFenetre();

        setListener(controlleur);

        setSize(920, 650);
        setLocation(50,50);
        setResizable(false);
        setVisible(true);

        setTitle("Dons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initAttribut() {
        Dimension dim=new Dimension(100,20);
        panGlobal.setLayout(new BoxLayout(panGlobal,BoxLayout.Y_AXIS));
        zoneJoueur.setLayout(g1);
        panelCarteADonnee=new JPanel();
    }


    private void creerFenetre(){
        zoneJoueur.add(textJ1);
        zoneJoueur.add(btacceptationJ1);
        zoneJoueur.add(txtAccpterJ1);

        zoneJoueur.add(textJ2);
        zoneJoueur.add(btacceptationJ2);
        zoneJoueur.add(txtAccpterJ2);

        zoneJoueur.add(textJ3);
        zoneJoueur.add(btacceptationJ3);
        zoneJoueur.add(txtAccpterJ3);

        panGlobal.add(panelCarteADonnee);
        panGlobal.add(zoneJoueur);
        panGlobal.add(btconclure);

        getContentPane().add(panGlobal);
    }
    private void setListener(Controlleur controlleur) {}

}