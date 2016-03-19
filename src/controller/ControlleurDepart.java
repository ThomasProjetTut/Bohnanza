package controller;

import view.VueDepart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurDepart implements ActionListener {

    VueDepart vueDepart;

    public ControlleurDepart(){
        vueDepart = new VueDepart(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
