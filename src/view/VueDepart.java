package view;

import controller.ControlleurDepart;

import javax.swing.*;
import java.awt.*;

public class VueDepart extends JFrame{

        private ControlleurDepart controlleurDepart;

        JLayeredPane panelGlobal = new JLayeredPane();
        JButton bouttonCommencer = new JButton("Commencer");

        public VueDepart(ControlleurDepart controlleurDepart){
            this.controlleurDepart = controlleurDepart;

            initAttribut();
            creerFenetre();

            setListener(controlleurDepart);

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
        panelGlobal.setPreferredSize(new Dimension(1000, 750));
        bouttonCommencer.setBounds(305, 515, 400, 75);
    }

    private void creerFenetre() {
        panelGlobal.add(bouttonCommencer);
        getContentPane().add(panelGlobal);
    }

    public void setListener(ControlleurDepart controlleurDepart){
        bouttonCommencer.addActionListener(controlleurDepart);
    }

    public JButton getBouttonCommencer(){
        return bouttonCommencer;
    }

}
