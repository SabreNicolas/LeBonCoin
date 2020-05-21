package leSuperCoin.view;

import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Accueil extends JPanel {

    public Accueil() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        Entete entete = new Entete();
        entete.setBackground(Colors.BLEU);
        grid.weightx = 1;
        grid.gridwidth = 1;
        grid.gridx = 0;
        grid.gridy = 0;
        grid.weighty = 0.1;
        grid.anchor = GridBagConstraints.NORTH;
        this.add(entete, grid);

        Filtres filtres = new Filtres();
        filtres.setBackground(Colors.GRIS_CLAIR);
        grid.gridy = 1;
        grid.weighty = 0.1;
        grid.insets = new Insets(50, 200, 40, 200);
        this.add(filtres, grid);

        ArrayList<AnnonceItem> liste = new ArrayList<>();

        liste.add(new AnnonceItem());
        liste.add(new AnnonceItem());
        liste.add(new AnnonceItem());

        JPanel annonceListe = new AnnonceListe(liste);

        grid.gridy = 2;
        grid.weighty = 10;
        grid.insets = new Insets(10, 0, 10, 0);

        this.add(annonceListe, grid);

        this.setBackground(Colors.BLANC);

        this.setVisible(true);
    }
}
