package leSuperCoin.view;

import leSuperCoin.controller.ConnexionController;
import leSuperCoin.controller.Controller;
import leSuperCoin.resources.Globals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Connexion extends JPanel {
    private ConnexionController form;
    private GridBagConstraints grid;

    JPanel connectionForm;

    GridBagConstraints connectionFormGrid;

    public Connexion(Controller controller) {
        this.form = new ConnexionController(controller);

        this.grid = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        // Afficher champ pseudo / mot de passe
        // Afficher un btn "ou s'inscrire" qui appelle this.form.getController().getView().navigate(View.Target.INSCRIPTION);

        // this.form.get/setPseudo(...); (peut être null)
        // this.form.get/setMotDePasse(...); (peut être null)
        // this.form.isReady(); -> est-ce que le btn submit doit être disabled
        // this.form.submit();

        // r'appeler la rerendre le btn submit .set(...) (pour raffraichir s'il est grisé)
        // pas besoin d'appeler quoi que ce soit après le submit

        this.addEntete();
        this.addConnectionForm();

        this.setVisible(true);
    }

    public void addConnectionForm() {
        this.connectionForm = new JPanel();
        this.connectionForm.setLayout(new GridBagLayout());
        this.connectionFormGrid = new GridBagConstraints();
        this.connectionFormGrid.fill = GridBagConstraints.BOTH;
        this.connectionFormGrid.insets = new Insets(10, 25, 10, 25);
        this.grid.gridx = 0;
        this.grid.gridy = 1;
        this.grid.weighty = 10;
        this.add(this.connectionForm, this.grid);

        JButton connexion = new JButton(Globals.Constants.SE_CONNECTER);

        JLabel labelInputId = new JLabel();
        labelInputId.setText(Globals.Constants.IDENTIFIANT);
        labelInputId.setFont(new Font(labelInputId.getFont().getName(), Font.PLAIN, 15));
        labelInputId.setForeground(Globals.Colors.NOIR);
        connectionFormGrid.gridx = 0;
        connectionFormGrid.gridy = 0;
        connectionForm.add(labelInputId, connectionFormGrid);

        JTextField inputId = new JTextField();
        inputId.setPreferredSize(new Dimension(250, 20));
        inputId.setBorder(BorderFactory.createLineBorder(Globals.Colors.NOIR, 1));
        connectionFormGrid.gridx = 1;
        connectionFormGrid.gridy = 0;
        inputId.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                form.setPseudo(inputId.getText());
                connexion.setEnabled(form.isReady());
            }
        });
        connectionForm.add(inputId, connectionFormGrid);

        JLabel labelInputPwd = new JLabel();
        labelInputPwd.setText(Globals.Constants.MOT_DE_PASSE);
        labelInputPwd.setFont(new Font(labelInputPwd.getFont().getName(), Font.PLAIN, 15));
        labelInputPwd.setForeground(Globals.Colors.NOIR);
        connectionFormGrid.gridx = 0;
        connectionFormGrid.gridy = 1;
        connectionForm.add(labelInputPwd, connectionFormGrid);

        JTextField inputPwd = new JTextField();
        inputPwd.setPreferredSize(new Dimension(250, 20));
        inputPwd.setBorder(BorderFactory.createLineBorder(Globals.Colors.NOIR, 1));
        connectionFormGrid.gridx = 1;
        connectionFormGrid.gridy = 1;
        inputPwd.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                form.setMotDePasse(inputPwd.getText());
                connexion.setEnabled(form.isReady());
            }
        });
        connectionForm.add(inputPwd, connectionFormGrid);

        connexion.setBorder(BorderFactory.createEmptyBorder());
        connexion.setBorder(BorderFactory.createLineBorder(Globals.Colors.BLEU, 5));
        connexion.setBackground(Globals.Colors.BLEU);
        connexion.setForeground(Globals.Colors.BLANC);
        connexion.setEnabled(false);
        connectionFormGrid.gridx = 0;
        connectionFormGrid.gridy = 2;
        connectionFormGrid.gridwidth = 2;
        connexion.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                form.submit();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        connectionForm.add(connexion, connectionFormGrid);

        JButton creerCompte = new JButton(Globals.Constants.CREER_COMPTE);
        creerCompte.setBorder(BorderFactory.createEmptyBorder());
        creerCompte.setBorder(BorderFactory.createLineBorder(Globals.Colors.BLEU_FONCE, 5));
        creerCompte.setBackground(Globals.Colors.BLEU_FONCE);
        creerCompte.setForeground(Globals.Colors.BLANC);
        connectionFormGrid.gridx = 0;
        connectionFormGrid.gridy = 3;
        connectionFormGrid.gridwidth = 2;
        connectionForm.add(creerCompte, connectionFormGrid);

        creerCompte.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                form.getController().getView().navigate(View.Target.INSCRIPTION);
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
        Entete entete = new Entete(this.form.getController());
        this.grid.weightx = 1;
        this.grid.gridwidth = 1;
        this.grid.gridx = 0;
        this.grid.gridy = 0;
        this.grid.weighty = 0.1;
        this.grid.anchor = GridBagConstraints.NORTH;
        this.add(entete, this.grid);
    }
}
