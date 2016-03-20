package view;

import controller.ControlleurEchange;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by mvava on 04/03/2016.
 */
public class VueEchange extends JFrame {
    private ControlleurEchange controlleurEchange;

    // Carte à donnee
    private JPanel panelCarteADonnee;

    //Image
    private ImageIcon imageJ1, imageJ2, imageJ3;

    //ImageIcon
    private ImageIcon carteADonnerIcone;
    private ImageIcon carteARecevoirIcone;
    private ImageIcon flecheIcone;

    private ImageIcon iconeAvisFavorable;
    private ImageIcon iconeAvisRefus;
    private ImageIcon iconeAvisNegociation;

    //Boutons
    private JButton okJ1=new JButton("Accepter");
    private JButton okJ2=new JButton("Accepter");
    private JButton okJ3=new JButton("Accepter");

    private JButton refuserJ1=new JButton("Refuser");
    private JButton refuserJ2=new JButton("Refuser");
    private JButton refuserJ3=new JButton("Refuser");

    private JButton proposer=new JButton("Proposer");



    //Label
    private JLabel carteADonner=new JLabel();
    private JLabel carteARecevoir=new JLabel();
    private JLabel fleche1 = new JLabel();
    private JLabel fleche2 = new JLabel();

    private JLabel aJ1=new JLabel("AJ1");
    private JLabel aJ2=new JLabel("AJ2");
    private JLabel aJ3=new JLabel("AJ3");

    private JLabel acceptJ1=new JLabel();
    private JLabel acceptJ2=new JLabel();
    private JLabel acceptJ3=new JLabel();

    private JLabel carteProposerJ1=new JLabel();
    private JLabel carteProposerJ2=new JLabel();
    private JLabel carteProposerJ3=new JLabel();

    private JLabel carteRecuJ1=new JLabel();
    private JLabel carteRecuJ2=new JLabel();
    private JLabel carteRecuJ3=new JLabel();


    private JLabel flecheJ1 = new JLabel();
    private JLabel flecheJ2 = new JLabel();
    private JLabel flecheJ3 = new JLabel();


    //Combo Box
    private String[] listPatate={"Patate1","Patate2"};
    private JComboBox cbPatate=new JComboBox(listPatate);
    private JComboBox cbPatate2=new JComboBox(listPatate);


    //Panel
    private JPanel panGlobal = new JPanel();
    private JPanel panDemandeInitial = new JPanel();
    private JPanel panAdversaireProposition = new JPanel();

    private JPanel panelAJ1 = new JPanel();
    private JPanel panelAJ2 = new JPanel();
    private JPanel panelAJ3 = new JPanel();

    //private GridLayout g1=new GridLayout(3,7);


    public VueEchange(ControlleurEchange controlleurEchange){
        this.controlleurEchange = controlleurEchange;

        initAttribut();
        creerFenetre();

        setListener(controlleurEchange);

        setSize(750, 385);
        //pack();
        setLocation(50,50);
        setResizable(false);
        setVisible(true);

        setTitle("Echange");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initAttribut() {
        carteADonnerIcone = new ImageIcon("Sprites/champ65x80_test.png");
        carteARecevoirIcone = new ImageIcon("Sprites/champ65x80_test.png");
        flecheIcone = new ImageIcon("Sprites/fleche.png");

        iconeAvisFavorable = new ImageIcon("Sprites/favorable.png");
        iconeAvisRefus = new ImageIcon("Sprites/refus.png");
        iconeAvisNegociation = new ImageIcon("Sprites/negociation.png");

        fleche1.setIcon(flecheIcone);
        fleche2.setIcon(flecheIcone);
        flecheJ1.setIcon(flecheIcone);
        flecheJ2.setIcon(flecheIcone);
        flecheJ3.setIcon(flecheIcone);

        carteProposerJ1.setIcon(carteADonnerIcone);
        carteProposerJ2.setIcon(carteADonnerIcone);
        carteProposerJ3.setIcon(carteADonnerIcone);

        carteRecuJ1.setIcon(carteADonnerIcone);
        carteRecuJ2.setIcon(carteADonnerIcone);
        carteRecuJ3.setIcon(carteADonnerIcone);

        carteADonner.setIcon(carteADonnerIcone);
        carteARecevoir.setIcon(carteARecevoirIcone);

        acceptJ1.setIcon(iconeAvisFavorable);
        acceptJ2.setIcon(iconeAvisRefus);
        acceptJ3.setIcon(iconeAvisNegociation);

        panGlobal.setLayout(new BoxLayout(panGlobal,BoxLayout.Y_AXIS));
        panDemandeInitial.setLayout(new BoxLayout(panDemandeInitial,BoxLayout.X_AXIS));

        //panAdversaireProposition.setLayout(g1);
        panAdversaireProposition.setLayout(new BorderLayout());


        panDemandeInitial.setBorder(new EtchedBorder());

    }


    private void creerFenetre(){
        panDemandeInitial.add(carteADonner);
        panDemandeInitial.add(fleche1);
        panDemandeInitial.add(carteARecevoir);

        panGlobal.add(panDemandeInitial);

        panelAJ1.add(aJ1);
        panelAJ1.add(carteProposerJ1);
        panelAJ1.add(flecheJ1);
        panelAJ1.add(carteRecuJ1);
        panelAJ1.add(acceptJ1);
        panelAJ1.add(okJ1);
        panelAJ1.add(refuserJ1);

        panelAJ2.add(aJ2);
        panelAJ2.add(carteProposerJ2);
        panelAJ2.add(flecheJ2);
        panelAJ2.add(carteRecuJ2);
        panelAJ2.add(acceptJ2);
        panelAJ2.add(okJ2);
        panelAJ2.add(refuserJ2);

        panelAJ3.add(aJ3);
        panelAJ3.add(carteProposerJ3);
        panelAJ3.add(flecheJ3);
        panelAJ3.add(carteRecuJ3);
        panelAJ3.add(acceptJ3);
        panelAJ3.add(okJ3);
        panelAJ3.add(refuserJ3);

        panAdversaireProposition.add(panelAJ1, BorderLayout.NORTH);
        panAdversaireProposition.add(panelAJ2, BorderLayout.CENTER);
        panAdversaireProposition.add(panelAJ3, BorderLayout.SOUTH);

        panGlobal.add(panAdversaireProposition);


        getContentPane().add(panGlobal);
    }
    private void setListener(ControlleurEchange controlleurEchange) {}

}
