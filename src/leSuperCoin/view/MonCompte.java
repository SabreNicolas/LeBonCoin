package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.resources.Globals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MonCompte extends JPanel {
    private Controller controller;
    private GridBagConstraints grid;

    JPanel deconnexionForm;

    GridBagConstraints deconnexionFormGrid;

    public MonCompte(Controller controller) {
        this.controller = controller;

        this.grid = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        this.addEntete();
        this.addDeconnexion();

        this.setVisible(true);
    }

    public void addDeconnexion() {
        this.deconnexionForm = new JPanel();
        this.deconnexionForm.setLayout(new GridBagLayout());
        this.deconnexionFormGrid = new GridBagConstraints();
        this.deconnexionFormGrid.fill = GridBagConstraints.BOTH;
        this.deconnexionFormGrid.insets = new Insets(10, 25, 10, 25);
        this.grid.gridx = 0;
        this.grid.gridy = 1;
        this.grid.weighty = 10;
        this.add(this.deconnexionForm, this.grid);

        JButton connexion = new JButton(Globals.Constants.SE_DECONNECTER);
        connexion.setBorder(BorderFactory.createEmptyBorder());
        connexion.setBorder(BorderFactory.createLineBorder(Globals.Colors.BLEU, 5));
        connexion.setBackground(Globals.Colors.BLEU);
        connexion.setForeground(Globals.Colors.BLANC);
        deconnexionFormGrid.gridx = 0;
        deconnexionFormGrid.gridy = 0;
        deconnexionFormGrid.gridwidth = 2;
        deconnexionForm.add(connexion, deconnexionFormGrid);

        connexion.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                controller.getModel().disconnect();
                controller.getView().navigate(View.Target.ACCUEIL);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void addEntete() {
        Entete entete = new Entete(controller);
        this.grid.weightx = 1;
        this.grid.gridwidth = 1;
        this.grid.gridx = 0;
        this.grid.gridy = 0;
        this.grid.weighty = 0.1;
        this.grid.anchor = GridBagConstraints.NORTH;
        this.add(entete, this.grid);
    }
}
