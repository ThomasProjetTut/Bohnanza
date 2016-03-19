package view;

import Multijoueurs.ClientTCP;
import Multijoueurs.ServeurTCP;
import controller.Controlleur;
import controller.ControlleurDepart;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class vueConnexion extends JFrame {

    private JCheckBox checkBoxBonus;

    private String hostIP = "localhost";
    private static boolean isHost = true;
    private int port = 55;

    private JTextField ipField = null;
    private JTextField portField = null;
    private JButton connectButton = null;

    private ControlleurDepart control;

    public vueConnexion(final ControlleurDepart controlleurDepart) {
        control = controlleurDepart;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    control.resetClient();
                    control.resetServeur();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JPanel optionsPane = initOptionsPane();

        JPanel mainPane = new JPanel(new BorderLayout());
        mainPane.add(optionsPane, BorderLayout.WEST);

        String ipv4 = "";

        try {
            ipv4 = java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        setTitle("Multijoueurs - IPv4 : "+ipv4);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPane);
        setSize(getPreferredSize());
        setLocation(200, 200);
        setIconImage(new ImageIcon("images/Autres/icone.png").getImage());
        setResizable(false);
        pack();
        setVisible(true);
    }

    public JPanel initOptionsPane() {
        JPanel paneNom;
        ActionAdapter buttonListener;
        JPanel fond = new JPanel();

        // Create an options pane
        JPanel optionsPane = new JPanel(new GridLayout(4, 1));

        // IP address input
        paneNom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label1 = new JLabel("Hôte IP : ");
        paneNom.add(label1);
        ipField = new JTextField(10);
        ipField.setText(hostIP);
        ipField.setEnabled(false);
        ipField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                ipField.selectAll();

                hostIP = ipField.getText();
            }
        });

        paneNom.add(ipField);
        paneNom.setOpaque(false);
        optionsPane.add(paneNom);

        // Port input
        paneNom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label2 = new JLabel("Port : ");
        paneNom.add(label2);
        portField = new JTextField(10);
        portField.setEditable(true);
        portField.setText((new Integer(port)).toString());
        portField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {

                int temp;
                try {
                    temp = Integer.parseInt(portField.getText());
                    port = temp;
                } catch (NumberFormatException nfe) {
                    portField.setText((new Integer(port)).toString());
                    repaint();
                }
            }
        });

        paneNom.add(portField);
        paneNom.setOpaque(false);
        optionsPane.add(paneNom);

        buttonListener = new ActionAdapter() {
            public void actionPerformed(ActionEvent e) {
                isHost = e.getActionCommand().equals("host");

                if (isHost) {
                    ipField.setEnabled(false);
                    ipField.setText("localhost");
                    hostIP = "localhost";
                }
                else {
                    ipField.setEnabled(true);
                }
            }
        };

        ButtonGroup bg = new ButtonGroup();
        JRadioButton hostOption = new JRadioButton("Hôte", true);
        hostOption.setMnemonic(KeyEvent.VK_H);
        hostOption.setActionCommand("host");
        hostOption.addActionListener(buttonListener);
        JRadioButton guestOption = new JRadioButton("Client", false);
        guestOption.setMnemonic(KeyEvent.VK_G);
        guestOption.setActionCommand("guest");
        guestOption.addActionListener(buttonListener);
        bg.add(hostOption);
        bg.add(guestOption);
        paneNom = new JPanel(new GridLayout(2, 2));
        paneNom.add(hostOption);
        paneNom.add(guestOption);
        paneNom.setOpaque(false);
        optionsPane.add(paneNom);
        paneNom.setOpaque(false);

        // Connect/disconnect buttons
        JPanel buttonPane = new JPanel(new GridLayout(1, 2));
        buttonListener = new ActionAdapter() {
            public void actionPerformed(ActionEvent e) {

                if (isHost) {
                    if (control.getServeurTCP() == null) {
                        try {
                            control.InitServeur(port);
                            connectButton.setText("En attente..");
                        } catch (IOException e1) {
                            System.out.println("Il y a eu un problème lors de la création du serveur.");
                        }

                    }
                    else {
                        connectButton.setText("Connexion");
                        try {
                            control.resetServeur();
                        } catch (IOException ignored) {
                        }
                    }
                }
                else {
                    if (control.getClientTCP() == null) {
                        try {
                            control.InitClient(hostIP, port);
                            connectButton.setText("En attente..");
                        } catch (IOException e1) {
                            System.out.println("Le serveur distant n'est pas joignable.");
                        }
                    }
                    else {
                        connectButton.setText("Connexion");
                        try {
                            control.resetClient();
                        } catch (IOException ignored) {
                        }
                    }
                }
            }
        };

        connectButton = new JButton("Connexion");
        connectButton.setMnemonic(KeyEvent.VK_C);
        connectButton.setActionCommand("connect");
        connectButton.addActionListener(buttonListener);
        connectButton.setEnabled(true);

        ipField.setText(hostIP);
        portField.setText((new Integer(port)).toString());
        hostOption.setSelected(isHost);
        guestOption.setSelected(!isHost);

        buttonPane.add(connectButton);
        buttonPane.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        optionsPane.add(buttonPane);
        fond.add(optionsPane);
        paneNom.setOpaque(false);
        buttonPane.setOpaque(false);
        optionsPane.setOpaque(false);
        return fond;
    }

    public void reiniButton() {
        connectButton.setText("Connexion");
    }

    public static boolean isHost() {
        return isHost;
    }

    class ActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {}
    }

    public String getHostIP() {
        return hostIP;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

}
