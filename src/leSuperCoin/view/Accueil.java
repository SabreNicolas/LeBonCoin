package leSuperCoin.view;

import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;

public class Accueil extends JPanel {

    public Accueil() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        JPanel entete = new Entete();
        entete.setBackground(Colors.BLEU);
        grid.weightx = 1;
        grid.gridx = 0;
        grid.gridy = 0;
        this.add(entete, grid);

        JPanel filtres = new Filtres();
        filtres.setBackground(Colors.GRIS_CLAIR);
        grid.gridy = 1;
        grid.insets = new Insets(50, 200, 0, 200);
        this.add(filtres, grid);

        this.setVisible(true);
    }
}
