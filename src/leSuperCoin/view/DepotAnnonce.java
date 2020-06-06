package leSuperCoin.view;

import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DepotAnnonce extends JPanel {

    public DepotAnnonce() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        Entete entete = new Entete();
        entete.setBackground(Colors.BLEU);
        grid.weightx = 1;
        grid.gridx = 0;
        grid.gridy = 0;
        grid.weighty = 0.1;
        grid.anchor = GridBagConstraints.NORTH;
        this.add(entete, grid);

        JLabel titre = new JLabel();
        titre.setText(Constans.TITRE_DEPOT_ANNONCE);
        titre.setFont(new Font(titre.getFont().getName(), Font.PLAIN, 30));
        titre.setForeground(Colors.BLEU);
        grid.insets = new Insets(0, 250, 0, 250);
        grid.gridx = 0;
        grid.gridy = 1;
        grid.weighty = 0.1;
        grid.anchor = GridBagConstraints.NORTH;
        this.add(titre, grid);

        JPanel etape = new JPanel();
        etape.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 2));
        etape.setBackground(Colors.BLANC);
        grid.insets = new Insets(10, 250, 15, 250);
        grid.gridy = 2;
        grid.weighty = 1;
        this.add(etape, grid);

        List<JPanel> etapes = new ArrayList<>();

        etapes.add(new DepotAnnonceEtapes.Categorie());
        etapes.add(new DepotAnnonceEtapes.Description());
        etapes.add(new DepotAnnonceEtapes.Prix());
        etapes.add(new DepotAnnonceEtapes.Recapitulatif());

        etape.add(etapes.get(0));

        JButton etapeSuivante = new JButton(Constans.ETAPE_SUIVANTE);
        etapeSuivante.setForeground(Colors.BLANC);
        etapeSuivante.setBackground(Colors.BLEU);
        etapeSuivante.setBorderPainted(false);
        grid.gridy = 3;
        grid.weighty = 0.1;
        this.add(etapeSuivante, grid);

        etapeSuivante.addActionListener(e -> {
            etapeSuivante.setBackground(Colors.NOIR);
            etape.remove(etapes.get(0));
            etape.add(etapes.get(1));
            etape.validate();
        });

        this.setVisible(true);
    }
}
