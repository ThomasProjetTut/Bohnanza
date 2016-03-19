package view;

import controller.Controlleur;
import javafx.scene.layout.BorderWidths;
import model.Carte.Carte;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.List;
import java.util.*;

public class Vue extends JFrame {

    private Controlleur controlleur;

    private ImageIcon iconeCarte;
    private ImageIcon iconeChampsAJ;
    private ImageIcon iconeChampsPerso;
    private ImageIcon iconeNomAJ;
    private ImageIcon iconNbPatate;

    //Cartes
    private ImageIcon iconeTecktonik;
    private ImageIcon iconeTentacule;
    private ImageIcon iconeTequilla;
    private ImageIcon iconeTerroriste;
    private ImageIcon iconeTestosterone;
    private ImageIcon iconeTetenucleaire;
    private ImageIcon iconeTetraplegique;
    private ImageIcon iconeTwerk;

    private JPanel panelGlobal = new JPanel();

    ///////////////////////////////////////
    /////////Champs autres joueurs/////////
    ///////////////////////////////////////
    private JPanel globalPanelAutreJoueur = new JPanel();
    private JLabel titreChampsAJ = new JLabel("Champs autres joueurs");

    /////////////////Tableaux//////////////////

    private JPanel[] globalPanelChampsAJS = new JPanel[3];
    private JPanel[] globalPanelNBpatate = new JPanel[3];
    private JPanel[] globalPanelAJS = new JPanel[3];

    private JLabel[] nomsAJS = new JLabel[3];

    private JPanel[][] panelChampsAJS = new JPanel[3][3];
    private JLabel[][] labelChampsAJS = new JLabel[3][3];
    private JPanel[][] panelNbPatateAJS = new JPanel[3][3];
    private JLabel[][] labelNBPatateAJS = new JLabel[3][3];

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

    panelInteraction panelInteraction;

    ///////////////////////////////////////
    //////////////Interaction//////////////
    ///////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////Section centrale/////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////Section Basse////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private JPanel panelGlobalSectionBasse = new JPanel();

    /////////////////Informations

    private JPanel panelGlobalInformation = new JPanel();

    private JTextArea textAreaInformation = new JTextArea();

    /////////////////Main

    private JLayeredPane panelGlobalMain = new JLayeredPane();
    private ArrayList<JLabel> mainLabel;

///?????????????????

    /////////////////Chat

    private JPanel panelGlobalChat = new JPanel();

    private JTextArea chatTexte = new JTextArea();
    private JTextField chatLigne = new JTextField();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////Section Basse////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Vue(Controlleur controlleur){
        this.controlleur = controlleur;

        initAttribut();
        creerFenetre();

        setListener(controlleur);

        setSize(1000, 750);
        setLocation(50,50);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(0);

        setTitle("Bohnanza");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
    }

    private void initAttribut() {

        iconeCarte = new ImageIcon("Sprites/carteTest.png");
        iconeChampsAJ = new ImageIcon("Sprites/champTest.png");
        iconeChampsPerso = new ImageIcon("Sprites/champPerso.png");
        iconeNomAJ = new ImageIcon("Sprites/nomAJTest.png");
        iconNbPatate = new ImageIcon("Sprites/nbPatateChamp.png");

        //cartes
        iconeTecktonik = new ImageIcon("Sprites/carteTest.png");
        iconeTentacule = new ImageIcon("Sprites/carteTest.png");
        iconeTequilla = new ImageIcon("Sprites/carteTest.png");
        iconeTerroriste = new ImageIcon("Sprites/carteTest.png");
        iconeTestosterone = new ImageIcon("Sprites/carteTest.png");
        iconeTetenucleaire = new ImageIcon("Sprites/carteTest.png");
        iconeTetraplegique = new ImageIcon("Sprites/carteTest.png");
        iconeTwerk = new ImageIcon("Sprites/carteTest.png");

        panelGlobal.setLayout(new BorderLayout());

        initAttributChampsAutreJoueurs();
        initAttributSectionCentrale();
        initAttributSectionBasse();

    }

    private void initAttributChampsAutreJoueurs() {

        //global
        for (int i = 0; i < 3; i++) {
            globalPanelChampsAJS[i] = new JPanel();
            globalPanelNBpatate[i] = new JPanel();
            globalPanelAJS[i] = new JPanel();

            globalPanelAJS[i].setBackground(Color.white);

            nomsAJS[i] = new JLabel();
            nomsAJS[i].setIcon(iconeNomAJ);
            nomsAJS[i].setBorder(new EtchedBorder());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panelChampsAJS[i][j] = new JPanel();
                labelChampsAJS[i][j] = new JLabel();
                panelNbPatateAJS[i][j] = new JPanel();
                labelNBPatateAJS[i][j] = new JLabel();
            }
        }

        globalPanelAutreJoueur.setLayout(new BorderLayout());

        for (JPanel globalPanel : globalPanelAJS) {
            globalPanel.setLayout(new BorderLayout());
            globalPanel.setBorder(new EtchedBorder());
        }

        for (JPanel globalPanelChamps : globalPanelChampsAJS) {
            globalPanelChamps.setLayout(new BorderLayout());
        }

        for (JPanel globalPanelNbPatates : globalPanelNBpatate) {
            globalPanelNbPatates.setLayout(new BorderLayout());
        }

        for (JLabel[] tabChmp : labelChampsAJS) {
            for (JLabel labChmp : tabChmp){
                labChmp.setIcon(iconeChampsAJ);
            }
        }

        for (JLabel[] tabNbPatate : labelNBPatateAJS) {
            for (JLabel labChmp : tabNbPatate){
                labChmp.setIcon(iconNbPatate);
            }
        }

    }

    private void initAttributSectionBasse() {
        panelGlobalSectionBasse.setLayout(new BorderLayout());

        //info

        //panelGlobalInformation.setBackground(Color.YELLOW);
        panelGlobalInformation.setPreferredSize(new Dimension(300, 200));
        panelGlobalInformation.setBorder(new EtchedBorder());

        //main

        panelGlobalMain.setPreferredSize(new Dimension(400,200));
        panelGlobalMain.setBorder(new EtchedBorder());

        mainLabel = new ArrayList<>();

        //chat
        panelGlobalChat.setLayout(new BorderLayout());
        panelGlobalChat.setBorder(new EtchedBorder());

        JScrollPane chatTextPane = new JScrollPane(chatTexte,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelGlobalChat.add(chatLigne, BorderLayout.SOUTH);
        panelGlobalChat.add(chatTextPane, BorderLayout.CENTER);
        panelGlobalChat.setPreferredSize(new Dimension(300, 200));

    }

    private void initAttributSectionCentrale() {


        panelGlobalChampsPerso.setPreferredSize(new Dimension(500, 350));

        champPerso1.setIcon(iconeChampsPerso);
        champPerso2.setIcon(iconeChampsPerso);
        champPerso3.setIcon(iconeChampsPerso);

        //interaction
        panelInteraction = new panelInteraction();
        globalPanelSectionCentrale.setLayout(new BorderLayout());

    }

    private void creerFenetre(){
        creerChampsAutresJoueurs();
        creerSectionCentrale();
        creerSectionBasse();

        panelGlobal.add(globalPanelAutreJoueur, BorderLayout.NORTH);
        panelGlobal.add(globalPanelSectionCentrale, BorderLayout.CENTER);
        panelGlobal.add(panelGlobalSectionBasse, BorderLayout.SOUTH);

        getContentPane().add(panelGlobal);
    }

    private void creerChampsAutresJoueurs() {

        globalPanelAutreJoueur.setPreferredSize(new Dimension(1000,200));

        for (JPanel gbP : globalPanelAJS) {
            gbP.setPreferredSize(new Dimension(333,200));
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panelChampsAJS[i][j].add(labelChampsAJS[i][j]);
                panelNbPatateAJS[i][j].add(labelNBPatateAJS[i][j]);

            }
        }



        for (int i = 0; i < 3; i++) {
            globalPanelChampsAJS[i].add(panelChampsAJS[i][0], BorderLayout.WEST);
            globalPanelChampsAJS[i].add(panelChampsAJS[i][2], BorderLayout.EAST);
            globalPanelChampsAJS[i].add(panelChampsAJS[i][1], BorderLayout.CENTER);



            globalPanelNBpatate[i].add(panelNbPatateAJS[i][0], BorderLayout.WEST);
            globalPanelNBpatate[i].add(panelNbPatateAJS[i][1], BorderLayout.CENTER);
            globalPanelNBpatate[i].add(panelNbPatateAJS[i][2], BorderLayout.EAST);

            globalPanelAJS[i].add(nomsAJS[i], BorderLayout.NORTH);
            globalPanelAJS[i].add(globalPanelChampsAJS[i], BorderLayout.CENTER);
            globalPanelAJS[i].add(globalPanelNBpatate[i], BorderLayout.SOUTH);

        }

        globalPanelAutreJoueur.add(titreChampsAJ, BorderLayout.NORTH);

        globalPanelAutreJoueur.add(globalPanelAJS[0], BorderLayout.WEST);
        globalPanelAutreJoueur.add(globalPanelAJS[1], BorderLayout.EAST);
        globalPanelAutreJoueur.add(globalPanelAJS[2], BorderLayout.CENTER);

    }

    private void creerSectionCentrale(){
        //champs perso

        panelGlobalChampsPerso.setLayout(new BorderLayout());
        panelGlobalChampsPerso.add(titreChampsPersonnel, BorderLayout.NORTH);
        panelGlobalChampsPerso.add(champPerso1, BorderLayout.NORTH);
        panelGlobalChampsPerso.add(champPerso3, BorderLayout.SOUTH);
        panelGlobalChampsPerso.add(champPerso2, BorderLayout.CENTER);

        //////////////////////Interaction//////////////////////


        globalPanelSectionCentrale.add(panelInteraction.getPanelInteraction(), BorderLayout.EAST);

        globalPanelSectionCentrale.add(panelGlobalChampsPerso, BorderLayout.CENTER);

    }

    private void creerSectionBasse() {
        //info
        panelGlobalInformation.add(textAreaInformation);

        //main


        //chat
        panelGlobalChat.add(chatTexte, BorderLayout.CENTER);
        panelGlobalChat.add(chatLigne, BorderLayout.SOUTH);

        //global

        panelGlobalSectionBasse.add(panelGlobalInformation, BorderLayout.WEST);
        panelGlobalSectionBasse.add(panelGlobalMain, BorderLayout.CENTER);
        panelGlobalSectionBasse.add(panelGlobalChat, BorderLayout.EAST);

    }

    private void setListener(Controlleur controlleur){
        for (JButton button : getEtapes()) {
            button.addActionListener(controlleur);
        }

        for (JComboBox choix : getChoix()) {
            choix.addActionListener(controlleur);
        }

        for (JButton button : getOk()) {
            button.addActionListener(controlleur);
        }

        champPerso1.addActionListener(controlleur);
        champPerso2.addActionListener(controlleur);
        champPerso3.addActionListener(controlleur);

    }

    public void actualiserMain(){
        mainLabel.clear();
        for (Carte carte : controlleur.getJoueur().getMain()){
            switch (carte.getIdCarte()){
                case 1 :
                    mainLabel.add(new JLabel(iconeTecktonik));
                    break;
                case 2 :
                    mainLabel.add(new JLabel(iconeTentacule));
                    break;
                case 3 :
                    mainLabel.add(new JLabel(iconeTequilla));
                    break;
                case 4 :
                    mainLabel.add(new JLabel(iconeTerroriste));
                    break;
                case 5 :
                    mainLabel.add(new JLabel(iconeTestosterone));
                    break;
                case 6 :
                    mainLabel.add(new JLabel(iconeTetenucleaire));
                    break;
                case 7 :
                    mainLabel.add(new JLabel(iconeTetraplegique));
                    break;
                case 8 :
                    mainLabel.add(new JLabel(iconeTwerk));
                    break;
            }
        }

        actualiserAffichageMain();


    }

    private void actualiserAffichageMain() {
        int espaceEntreCarte;

        if(mainLabel.size()>0){
            espaceEntreCarte = 400%(65*mainLabel.size())/mainLabel.size();
        }else{
            espaceEntreCarte = 0;
        }

        while(mainLabel.size()*(75+espaceEntreCarte) > 400){
            espaceEntreCarte -= 5;
        }

        for (int i = mainLabel.size() - 1; i >=  0; i--){
            mainLabel.get(i).setBounds(10 + i*(65 + espaceEntreCarte), 60, 65, 80);
            panelGlobalMain.add(mainLabel.get(i));
        }

    }

    //getters
    public JButton[] getEtapes(){
        return panelInteraction.getEtapes();
    }
    public JButton[] getOk(){
        return panelInteraction.getOk();
    }
    public JComboBox[] getChoix(){
        return panelInteraction.getChoix();
    }
    public JButton[] getChamps(){
        JButton[] tabRetour = new JButton[3];

        tabRetour[0] = champPerso1;
        tabRetour[1] = champPerso2;
        tabRetour[2] = champPerso3;

        return tabRetour;
    }

}
