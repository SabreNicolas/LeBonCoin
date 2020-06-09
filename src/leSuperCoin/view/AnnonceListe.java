package leSuperCoin.view;

import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AnnonceListe extends JPanel {

    public AnnonceListe(List<AnnonceItem> annonces) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.anchor = GridBagConstraints.NORTH;
        grid.gridx = 0;
        grid.gridy = 0;
        grid.weighty = 0.1;
        grid.insets = new Insets(5, 0, 5, 0);

        for (AnnonceItem annonce : annonces) {
            this.add(annonce, grid);
            grid.gridy += 1;
        }

        grid.weighty = 10;
        this.add(new JLabel(), grid);
        this.setBackground(Colors.BLANC);

        this.setVisible(true);
    }

}
