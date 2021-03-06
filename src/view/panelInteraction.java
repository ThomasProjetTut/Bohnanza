package view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class panelInteraction {

    //image icone
    ImageIcon iconeCarte = new ImageIcon("Sprites/carteTest.png");
    ImageIcon iconeCartesGardees = new ImageIcon("Sprites/cartesGardees.png");

    //Panels
    JLayeredPane globalPanel;

    //ETAPES
    JLayeredPane globalPanelEtape;
    //label
    JLabel labelEtape;
    //planter
    JButton bouttonPlanter;
    //piocher
    JButton bouttonPiocher;
    //echanger
    JButton bouttonEchange;
    //piocher2
    JButton bouttonPiocherFDT;
    //FDT
    JButton bouttonFDT;

    //ECHANGE
    JLayeredPane globalPanelEchange;
    //label
    JLabel labelEchange;
    //cartes piochees
    JLabel cartePiochee1;
    JLabel cartePiochee2;
    //ComboBox
    String[] listeChoix = {"Garder", "Echanger", "Donner"};

    JComboBox choix1;
    JComboBox choix2;
    //OK
    JButton ok1;
    JButton ok2;
    //cartes gardees
    JLabel carteGardees;



    public panelInteraction(){

        //global fenetre
        globalPanel = new JLayeredPane();

        globalPanel.setPreferredSize(new Dimension(500,350));
        creationEtapes();
        creationEchange();

        //fenetre
        globalPanelEtape.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        globalPanelEchange.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        globalPanel.add(globalPanelEtape);
        globalPanel.add(globalPanelEchange);

    }

    public void creationEtapes(){
        //////////////////////partie etape//////////////////////
        //global
        globalPanelEtape = new JLayeredPane();
        globalPanelEtape.setBounds(0, 0, 250, 350);

        //label eTape
        labelEtape = new JLabel("Etapes");
        labelEtape.setBounds(50, 0, 150, 40);
        globalPanelEtape.add(labelEtape);

        //planter
        bouttonPlanter = new JButton("Planter");
        bouttonPlanter.setBounds(50,50,150,40);
        globalPanelEtape.add(bouttonPlanter);

        //Piocher
        bouttonPiocher = new JButton("Piocher");
        bouttonPiocher.setBounds(50, 105, 150, 40);
        globalPanelEtape.add(bouttonPiocher);

        //Echange
        bouttonEchange = new JButton("Echange");
        bouttonEchange.setBounds(50, 160, 150, 40);
        globalPanelEtape.add(bouttonEchange);

        //Piocher2
        bouttonPiocherFDT = new JButton("Piocher");
        bouttonPiocherFDT.setBounds(50, 215, 150, 40);
        globalPanelEtape.add(bouttonPiocherFDT);

        //FDT
        bouttonFDT = new JButton("Fin de tour");
        bouttonFDT.setBounds(50,270,150,40);
        globalPanelEtape.add(bouttonFDT);

    }

    public void creationEchange(){
        //////////////////////partie Echange//////////////////////
        //global
        globalPanelEchange = new JLayeredPane();
        globalPanelEchange.setBounds(250, 0, 250, 350);

        //labelEchange
        labelEchange = new JLabel("Etape Echange");
        labelEchange.setBounds(50, 0, 150, 40);
        globalPanelEchange.add(labelEchange);

        //cartes piochéees
        cartePiochee1 = new JLabel();
        cartePiochee1.setIcon(iconeCarte);
        cartePiochee1.setBounds(40, 50, 65, 80);

        cartePiochee2 = new JLabel();
        cartePiochee2.setIcon(iconeCarte);
        cartePiochee2.setBounds(145, 50, 65, 80);

        globalPanelEchange.add(cartePiochee1);
        globalPanelEchange.add(cartePiochee2);

        //choix
        choix1 = new JComboBox(listeChoix);
        choix1.setBounds(15, 140, 100, 25);

        choix2 = new JComboBox(listeChoix);
        choix2.setBounds(135, 140, 100, 25);

        globalPanelEchange.add(choix1);
        globalPanelEchange.add(choix2);

        //OK
        ok1 = new JButton("OK");
        ok2 = new JButton("OK");

        ok1.setBounds(35, 175, 55, 25);
        ok2.setBounds(160, 175, 55, 25);

        globalPanelEchange.add(ok1);
        globalPanelEchange.add(ok2);

        //cartes piochéees
        carteGardees = new JLabel();
        carteGardees.setIcon(iconeCartesGardees);
        carteGardees.setBounds(10, 215, 225, 90);

        globalPanelEchange.add(carteGardees);
    }

    public JLayeredPane getPanelInteraction(){
        return globalPanel;
    }

    public JButton[] getEtapes(){
        JButton[] tabretour = new JButton[5];
        tabretour[0] = bouttonPlanter;
        tabretour[1] = bouttonPiocher;
        tabretour[2] = bouttonEchange;
        tabretour[3] = bouttonPiocherFDT;
        tabretour[4] = bouttonFDT;

        return tabretour;
    }
    public JComboBox[] getChoix(){
        JComboBox[] tabRetour = new JComboBox[2];
        tabRetour[0] = choix1;
        tabRetour[1] = choix2;

        return tabRetour;
    }
    public JButton[] getOk(){
        JButton[] tabRetour = new JButton[2];

        tabRetour[0] = ok1;
        tabRetour[1] = ok2;

        return tabRetour;
    }
}
