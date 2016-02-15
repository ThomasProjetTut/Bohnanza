package view;

import javafx.scene.layout.BorderWidths;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Vue extends JFrame {

    private ImageIcon iconeChamps;
    private ImageIcon iconePanelChamps;
    private ImageIcon iconeNbPatate;
    private ImageIcon iconeNomAJ;

    private JPanel panelGlobal = new JPanel();

    ///////////////////////////////////////
    /////////Champs autres joueurs/////////
    ///////////////////////////////////////
    private JPanel globalPanelAutreJoueur = new JPanel();
    private JLabel titreChampsAJ = new JLabel("Champs autres joueurs");

    ///////////////champs J1///////////////
    private JPanel globalPanelAJ1 = new JPanel();
    private JPanel globalPanelChampsAJ1 = new JPanel();
    private JPanel globalPanelNbPatateAJ1 = new JPanel();

    private JLabel nomAJ1 = new JLabel("Joueur 1");

    private JPanel panelChampAJ1_1 = new JPanel();
    private JPanel panelChampAJ1_2 = new JPanel();
    private JPanel panelChampAJ1_3 = new JPanel();

    private JLabel champAJ1_1 = new JLabel();
    private JLabel champAJ1_2 = new JLabel();
    private JLabel champAJ1_3 = new JLabel();

    private JLabel nbPatateChmp1_1 = new JLabel("1_1");
    private JLabel nbPatateChmp1_2 = new JLabel("1_2");
    private JLabel nbPatateChmp1_3 = new JLabel("1_3");


    ///////////////champs J2///////////////
    private JPanel globalPanelAJ2 = new JPanel();
    private JPanel globalPanelChampsAJ2 = new JPanel();
    private JPanel globalPanelNbPatateAJ2 = new JPanel();

    private JLabel nomAJ2 = new JLabel("Joueur 2");

    private JPanel panelChampAJ2_1 = new JPanel();
    private JPanel panelChampAJ2_2 = new JPanel();
    private JPanel panelChampAJ2_3 = new JPanel();

    private JLabel champAJ2_1 = new JLabel();
    private JLabel champAJ2_2 = new JLabel();
    private JLabel champAJ2_3 = new JLabel();

    private JLabel nbPatateChmp2_1 = new JLabel("2_1");
    private JLabel nbPatateChmp2_2 = new JLabel("2_2");
    private JLabel nbPatateChmp2_3 = new JLabel("2_3");


    ///////////////champs J3///////////////
    private JPanel globalPanelAJ3 = new JPanel();
    private JPanel globalPanelChampsAJ3 = new JPanel();
    private JPanel globalPanelNbPatateAJ3 = new JPanel();

    private JLabel nomAJ3 = new JLabel("Joueur 3");

    private JPanel panelChampAJ3_1 = new JPanel();
    private JPanel panelChampAJ3_2 = new JPanel();
    private JPanel panelChampAJ3_3 = new JPanel();

    private JLabel champAJ3_1 = new JLabel();
    private JLabel champAJ3_2 = new JLabel();
    private JLabel champAJ3_3 = new JLabel();

    private JLabel nbPatateChmp3_1 = new JLabel("3_1");
    private JLabel nbPatateChmp3_2 = new JLabel("3_2");
    private JLabel nbPatateChmp3_3 = new JLabel("3_3");


    ///////////////////////////////////////
    /////////Champs autres joueurs/////////
    ///////////////////////////////////////

    ///////////////////////////////////////////////////////Section centrale/////////////////////////////////////////////////////

    private JPanel globalPanelSectionCentrale = new JPanel();

    ///////////////////////////////////////
    ///////////Champs personnel///////////
    //////////////////////////////////////

    private JPanel panelGlobalChampsPerso = new JPanel();

    private JLabel titreChampsPersonnel = new JLabel();

    private JButton champPerso1 = new JButton("champs perso 1");
    private JButton champPerso2 = new JButton("champs perso 2");
    private JButton champPerso3 = new JButton("champs perso 3");

    ///////////////////////////////////////
    ///////////Champs personnel///////////
    ///////////////////////////////////////

    ///////////////////////////////////////
    //////////////Interaction//////////////
    ///////////////////////////////////////

    private JPanel panelGlobalInteraction = new JPanel();




    ///////////////////////////////////////
    //////////////Interaction//////////////
    ///////////////////////////////////////


    ///////////////////////////////////////////////////////Section centrale/////////////////////////////////////////////////////

    public Vue(){

        initAttribut();
        creerFenetre();

        setSize(920, 650);
        setLocation(50,50);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(0);

        setTitle("Bohnanza");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
    }

    private void initAttribut() {

        iconeChamps = new ImageIcon("Sprites/champ.png");
        iconeNomAJ = new ImageIcon("Sprites/labelNom.png");
        iconeNbPatate = new ImageIcon("Sprites/nbPatate.png");
        iconePanelChamps = new ImageIcon("Sprites/champAJ.png");

        panelGlobal.setLayout(new BorderLayout());

        initAttributChampsAutreJoueurs();
        initAttributSectionCentrale();
        initAttributSectionBasse();

    }

    private void initAttributChampsAutreJoueurs() {

        //global
        globalPanelAutreJoueur.setLayout(new BorderLayout());


        //champ J1
        globalPanelAJ1.setLayout(new BorderLayout());
        globalPanelChampsAJ1.setLayout(new BorderLayout());
        globalPanelNbPatateAJ1.setLayout(new BorderLayout());

        champAJ1_1.setIcon(iconeChamps);
        champAJ1_2.setIcon(iconeChamps);
        champAJ1_3.setIcon(iconeChamps);

        globalPanelAJ1.setBorder(new EtchedBorder());

        //champ J2
        globalPanelAJ2.setLayout(new BorderLayout());
        globalPanelChampsAJ2.setLayout(new BorderLayout());
        globalPanelNbPatateAJ2.setLayout(new BorderLayout());

        champAJ2_1.setIcon(iconeChamps);
        champAJ2_2.setIcon(iconeChamps);
        champAJ2_3.setIcon(iconeChamps);

        globalPanelAJ2.setBorder(new EtchedBorder());

        //champ J3
        globalPanelAJ3.setLayout(new BorderLayout());
        globalPanelChampsAJ3.setLayout(new BorderLayout());
        globalPanelNbPatateAJ3.setLayout(new BorderLayout());

        champAJ3_1.setIcon(iconeChamps);
        champAJ3_2.setIcon(iconeChamps);
        champAJ3_3.setIcon(iconeChamps);

        globalPanelAJ3.setBorder(new EtchedBorder());


    }


    private void initAttributSectionBasse() {


    }

    private void initAttributSectionCentrale() {
        //interactino

        panelGlobalInteraction.setPreferredSize(new Dimension(305, 500));
        panelGlobalInteraction.setBackground(Color.BLUE);


        champPerso1.setIcon(iconeChamps);
        champPerso2.setIcon(iconeChamps);
        champPerso3.setIcon(iconeChamps);


        globalPanelSectionCentrale.setLayout(new BorderLayout());

    }

    private void creerFenetre(){
        creerChampsAutresJoueurs();
        creerFenetreSectionCentrale();

        panelGlobal.add(globalPanelAutreJoueur, BorderLayout.NORTH);
        panelGlobal.add(globalPanelSectionCentrale, BorderLayout.CENTER);

        getContentPane().add(panelGlobal);
    }

    private void creerChampsAutresJoueurs() {

        //AJ1

        panelChampAJ1_1.add(champAJ1_1);
        panelChampAJ1_2.add(champAJ1_2);
        panelChampAJ1_3.add(champAJ1_3);

        globalPanelChampsAJ1.add(panelChampAJ1_1, BorderLayout.WEST);
        globalPanelChampsAJ1.add(panelChampAJ1_3, BorderLayout.EAST);
        globalPanelChampsAJ1.add(panelChampAJ1_2, BorderLayout.CENTER);

        globalPanelNbPatateAJ1.add(nbPatateChmp1_1, BorderLayout.WEST);
        globalPanelNbPatateAJ1.add(nbPatateChmp1_3, BorderLayout.EAST);
        globalPanelNbPatateAJ1.add(nbPatateChmp1_2, BorderLayout.CENTER);

        //AJ2
        panelChampAJ2_1.add(champAJ2_1);
        panelChampAJ2_2.add(champAJ2_2);
        panelChampAJ2_3.add(champAJ2_3);

        globalPanelChampsAJ2.add(panelChampAJ2_1, BorderLayout.WEST);
        globalPanelChampsAJ2.add(panelChampAJ2_3, BorderLayout.EAST);
        globalPanelChampsAJ2.add(panelChampAJ2_2, BorderLayout.CENTER);

        globalPanelNbPatateAJ2.add(nbPatateChmp2_1, BorderLayout.WEST);
        globalPanelNbPatateAJ2.add(nbPatateChmp2_3, BorderLayout.EAST);
        globalPanelNbPatateAJ2.add(nbPatateChmp2_2, BorderLayout.CENTER);

        //AJ3
        panelChampAJ3_1.add(champAJ3_1);
        panelChampAJ3_2.add(champAJ3_2);
        panelChampAJ3_3.add(champAJ3_3);

        globalPanelChampsAJ3.add(panelChampAJ3_1, BorderLayout.WEST);
        globalPanelChampsAJ3.add(panelChampAJ3_3, BorderLayout.EAST);
        globalPanelChampsAJ3.add(panelChampAJ3_2, BorderLayout.CENTER);

        globalPanelNbPatateAJ3.add(nbPatateChmp3_1, BorderLayout.WEST);
        globalPanelNbPatateAJ3.add(nbPatateChmp3_3, BorderLayout.EAST);
        globalPanelNbPatateAJ3.add(nbPatateChmp3_2, BorderLayout.CENTER);

        //global

        globalPanelAJ1.setBackground(Color.orange);

        globalPanelAJ1.add(nomAJ1, BorderLayout.NORTH);
        globalPanelAJ1.add(globalPanelNbPatateAJ1, BorderLayout.SOUTH);
        globalPanelAJ1.add(globalPanelChampsAJ1, BorderLayout.CENTER);

        globalPanelAJ2.setBackground(Color.CYAN);

        globalPanelAJ2.add(nomAJ2, BorderLayout.NORTH);
        globalPanelAJ2.add(globalPanelNbPatateAJ2, BorderLayout.SOUTH);
        globalPanelAJ2.add(globalPanelChampsAJ2, BorderLayout.CENTER);


        globalPanelAJ3.setBackground(Color.YELLOW);

        globalPanelAJ3.add(nomAJ3, BorderLayout.NORTH);
        globalPanelAJ3.add(globalPanelNbPatateAJ3, BorderLayout.SOUTH);
        globalPanelAJ3.add(globalPanelChampsAJ3, BorderLayout.CENTER);

        globalPanelAutreJoueur.add(titreChampsAJ, BorderLayout.NORTH);

        globalPanelAutreJoueur.add(globalPanelAJ1, BorderLayout.WEST);
        globalPanelAutreJoueur.add(globalPanelAJ3, BorderLayout.EAST);
        globalPanelAutreJoueur.add(globalPanelAJ2, BorderLayout.CENTER);

    }

    private void creerFenetreSectionCentrale(){
        //champs perso

        panelGlobalChampsPerso.setLayout(new BorderLayout());
        panelGlobalChampsPerso.add(titreChampsPersonnel, BorderLayout.NORTH);
        panelGlobalChampsPerso.add(champPerso1, BorderLayout.NORTH);
        panelGlobalChampsPerso.add(champPerso3, BorderLayout.SOUTH);
        panelGlobalChampsPerso.add(champPerso2, BorderLayout.CENTER);


        globalPanelSectionCentrale.add(panelGlobalChampsPerso, BorderLayout.CENTER);

    }


}
