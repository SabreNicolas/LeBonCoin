package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.controller.InscriptionController;
import leSuperCoin.resources.Globals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Inscription extends JPanel {
    private InscriptionController form;
    private GridBagConstraints grid;

    JPanel inscrptionForm;

    GridBagConstraints inscriptionFormGrid;

    public Inscription(Controller controller) {
        this.form = new InscriptionController(controller);

        this.grid = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        // Afficher champ pseudo / mot de passe
        // Afficher un btn "ou s'inscrire" qui appelle this.form.getController().getView().navigate(View.Target.INSCRIPTION);

        // this.form.get/setPseudo(...); (peut être null)
        // this.form.get/setMotDePasse(...); (peut être null)
        // this.form.get/setNom(...); (peut être null)
        // this.form.get/setPrenom(...); (peut être null)
        // this.form.get/setMail(...); (peut être null)
        // this.form.isReady(); -> est-ce que le btn submit doit être disabled
        // this.form.submit();

        // r'appeler la rerendre le btn submit .set(...) (pour raffraichir s'il est grisé)
        // pas besoin d'appeler quoi que ce soit après le submit

        this.addEntete();
        this.addInscriptionForm();

        this.setVisible(true);
    }
    public void addInscriptionForm() {
        this.inscrptionForm = new JPanel();
        this.inscrptionForm.setLayout(new GridBagLayout());
        this.inscriptionFormGrid = new GridBagConstraints();
        this.inscriptionFormGrid.fill = GridBagConstraints.BOTH;
        this.inscriptionFormGrid.insets = new Insets(10, 25, 10, 25);
        this.grid.gridx = 0;
        this.grid.gridy = 1;
        this.grid.weighty = 10;
        this.add(this.inscrptionForm, this.grid);

        JLabel labelInputNom = new JLabel();
        labelInputNom.setText(Globals.Constants.NOM);
        labelInputNom.setFont(new Font(labelInputNom.getFont().getName(), Font.PLAIN, 15));
        labelInputNom.setForeground(Globals.Colors.NOIR);
        inscriptionFormGrid.gridx = 0;
        inscriptionFormGrid.gridy = 0;
        inscrptionForm.add(labelInputNom, inscriptionFormGrid);

        JTextField inputNom = new JTextField();
        inputNom.setPreferredSize(new Dimension(250, 20));
        inputNom.setBorder(BorderFactory.createLineBorder(Globals.Colors.NOIR, 1));
        inscriptionFormGrid.gridx = 1;
        inscriptionFormGrid.gridy = 0;
        inscrptionForm.add(inputNom, inscriptionFormGrid);

        JLabel labelPrenom = new JLabel();
        labelPrenom.setText(Globals.Constants.PRENOM);
        labelPrenom.setFont(new Font(labelPrenom.getFont().getName(), Font.PLAIN, 15));
        labelPrenom.setForeground(Globals.Colors.NOIR);
        inscriptionFormGrid.gridx = 0;
        inscriptionFormGrid.gridy = 1;
        inscrptionForm.add(labelPrenom, inscriptionFormGrid);

        JTextField inputPrenom = new JTextField();
        inputPrenom.setPreferredSize(new Dimension(250, 20));
        inputPrenom.setBorder(BorderFactory.createLineBorder(Globals.Colors.NOIR, 1));
        inscriptionFormGrid.gridx = 1;
        inscriptionFormGrid.gridy = 1;
        inscrptionForm.add(inputPrenom, inscriptionFormGrid);

        JLabel labelPseudo = new JLabel();
        labelPseudo.setText(Globals.Constants.PSEUDO);
        labelPseudo.setFont(new Font(labelPseudo.getFont().getName(), Font.PLAIN, 15));
        labelPseudo.setForeground(Globals.Colors.NOIR);
        inscriptionFormGrid.gridx = 0;
        inscriptionFormGrid.gridy = 2;
        inscrptionForm.add(labelPseudo, inscriptionFormGrid);

        JTextField inputPseudo = new JTextField();
        inputPseudo.setPreferredSize(new Dimension(250, 20));
        inputPseudo.setBorder(BorderFactory.createLineBorder(Globals.Colors.NOIR, 1));
        inscriptionFormGrid.gridx = 1;
        inscriptionFormGrid.gridy = 2;
        inscrptionForm.add(inputPseudo, inscriptionFormGrid);

        JLabel labelMail = new JLabel();
        labelMail.setText(Globals.Constants.MAIL);
        labelMail.setFont(new Font(labelMail.getFont().getName(), Font.PLAIN, 15));
        labelMail.setForeground(Globals.Colors.NOIR);
        inscriptionFormGrid.gridx = 0;
        inscriptionFormGrid.gridy = 3;
        inscrptionForm.add(labelMail, inscriptionFormGrid);

        JTextField inputMail = new JTextField();
        inputMail.setPreferredSize(new Dimension(250, 20));
        inputMail.setBorder(BorderFactory.createLineBorder(Globals.Colors.NOIR, 1));
        inscriptionFormGrid.gridx = 1;
        inscriptionFormGrid.gridy = 3;
        inscrptionForm.add(inputMail, inscriptionFormGrid);

        JLabel labelInputPwd = new JLabel();
        labelInputPwd.setText(Globals.Constants.MOT_DE_PASSE);
        labelInputPwd.setFont(new Font(labelInputPwd.getFont().getName(), Font.PLAIN, 15));
        labelInputPwd.setForeground(Globals.Colors.NOIR);
        inscriptionFormGrid.gridx = 0;
        inscriptionFormGrid.gridy = 4;
        inscrptionForm.add(labelInputPwd, inscriptionFormGrid);

        JTextField inputPwd = new JTextField();
        inputPwd.setPreferredSize(new Dimension(250, 20));
        inputPwd.setBorder(BorderFactory.createLineBorder(Globals.Colors.NOIR, 1));
        inscriptionFormGrid.gridx = 1;
        inscriptionFormGrid.gridy = 4;
        inscrptionForm.add(inputPwd, inscriptionFormGrid);

        JButton connexion = new JButton(Globals.Constants.CREER_COMPTE);
        connexion.setBorder(BorderFactory.createEmptyBorder());
        connexion.setBorder(BorderFactory.createLineBorder(Globals.Colors.BLEU, 5));
        connexion.setBackground(Globals.Colors.BLEU);
        connexion.setForeground(Globals.Colors.BLANC);
        inscriptionFormGrid.gridx = 0;
        inscriptionFormGrid.gridy = 5;
        inscriptionFormGrid.gridwidth = 2;
        inscrptionForm.add(connexion, inscriptionFormGrid);

        connexion.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                form.getController().getView().navigate(View.Target.MON_COMPTE);
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
