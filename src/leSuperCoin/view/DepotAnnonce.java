package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.controller.DepotAnnonceController;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DepotAnnonce extends JPanel {
    private DepotAnnonceController form;
    private GridBagConstraints grid;

    private int etapeActuelle;
    private JPanel etape;
    private JButton etapeSuivante;

    private Consumer<Boolean> toggleEtapeSuivante;

    public DepotAnnonce(Controller controller) {
        this.form = new DepotAnnonceController(controller);

        this.toggleEtapeSuivante = (Boolean b) -> {
            this.etapeSuivante.setEnabled(b.booleanValue());
        };

        this.setLayout(new GridBagLayout());
        this.grid = new GridBagConstraints();
        this.grid.fill = GridBagConstraints.BOTH;

        addEntete();
        addTitre();
        addEtapes();
        addEtapeSuivante();

        this.toggleEtapeSuivante.accept(false);

        this.setVisible(true);
    }

    private void addEntete() {
        Entete entete = new Entete(form.getController());
        entete.setBackground(Colors.BLEU);
        this.grid.weightx = 1;
        this.grid.gridx = 0;
        this.grid.gridy = 0;
        this.grid.weighty = 0.1;
        this.grid.anchor = GridBagConstraints.NORTH;
        this.add(entete, this.grid);

    }

    private void addTitre() {
        JLabel titre = new JLabel();
        titre.setText(Constants.TITRE_DEPOT_ANNONCE);
        titre.setFont(new Font(titre.getFont().getName(), Font.PLAIN, 30));
        titre.setForeground(Colors.BLEU);
        this.grid.insets = new Insets(0, 250, 0, 250);
        this.grid.gridx = 0;
        this.grid.gridy = 1;
        this.grid.weighty = 0.1;
        this.grid.anchor = GridBagConstraints.NORTH;
        this.add(titre, this.grid);
    }

    private void addEtapes() {
        addEtape();
        etapeActuelle = 0;
        updateEtape();
    }

    private void addEtape() {
        etape = new JPanel();
        etape.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 2));
        etape.setBackground(Colors.BLANC);
        this.grid.insets = new Insets(10, 250, 15, 250);
        this.grid.gridy = 2;
        this.grid.weighty = 1;
        this.add(etape, this.grid);
    }

    private void updateEtape() {
        etape.removeAll();
        etape.repaint();
        switch (this.etapeActuelle) {
            case 0:
                etape.add(new DepotAnnonceEtapes.Categorie(this.form, this.toggleEtapeSuivante));
                break;
            case 1:
                etape.add(new DepotAnnonceEtapes.Description(this.form, this.toggleEtapeSuivante));
                break;
            case 2:
                etape.add(new DepotAnnonceEtapes.Criteres(this.form, this.toggleEtapeSuivante));
                break;
        }
        etape.validate();
    }

    private void addEtapeSuivante() {
        this.etapeSuivante = new JButton(Constants.ETAPE_SUIVANTE);
        etapeSuivante.setForeground(Colors.BLANC);
        etapeSuivante.setBackground(Colors.BLEU);
        etapeSuivante.setBorderPainted(false);
        this.grid.gridy = 3;
        this.grid.weighty = 0.1;
        this.add(etapeSuivante, this.grid);

        /* To Do :
            - Récupérer l'index de l'écran actuel
            - Système d'incrémentation pour passer à l'écran suivant
            - Valisdation à la dernière étape
         */
        etapeSuivante.addActionListener(e -> {
            etapeActuelle++;
            if (etapeActuelle < 3) {
                updateEtape();
                toggleEtapeSuivante.accept(false);
            } else {
                this.form.submit();
            }
        });
    }
}
