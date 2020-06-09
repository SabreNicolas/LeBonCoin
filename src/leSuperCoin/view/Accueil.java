package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.controller.FiltreController;
import leSuperCoin.model.entities.AnnonceEntity;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Accueil extends JPanel {
    private Controller controller;
    FiltreController filtre;
    private GridBagConstraints grid;

    public Accueil(Controller controller, FiltreController filtre) {
        this.controller = controller;
        this.filtre = filtre != null ? filtre : new FiltreController((controller));

        this.setBackground(Colors.BLANC);
        this.setLayout(new GridBagLayout());
        this.grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        this.addEntete();
        this.addFiltres();
        this.addAnnonces();

        this.setVisible(true);
    }

    private void addEntete() {
        Entete entete = new Entete(this.controller);
        grid.weightx = 1;
        grid.gridwidth = 1;
        grid.gridx = 0;
        grid.gridy = 0;
        grid.weighty = 0.1;
        grid.anchor = GridBagConstraints.NORTH;
        this.add(entete, grid);
    }

    private void addFiltres() {
        Filtres filtres = new Filtres(filtre);
        filtres.setBackground(Colors.GRIS_CLAIR);
        grid.gridy = 1;
        grid.weighty = 0.1;
        grid.insets = new Insets(50, 200, 40, 200);
        this.add(filtres, grid);
    }

    private void addAnnonces() {
        ArrayList<AnnonceItem> liste = new ArrayList<>();
        for (AnnonceEntity annonceEntity : (filtre.getCategorieEntity() != null ? controller.getModel().getAnnoncesIn(filtre.getCategorieEntity()) : controller.getModel().getAnnonces())) {
            liste.add(new AnnonceItem(this.controller, annonceEntity));
        }
        JPanel annonceListe = new AnnonceListe(liste);
        grid.gridy = 2;
        grid.weighty = 10;
        grid.insets = new Insets(10, 0, 10, 0);
        this.add(annonceListe, grid);
    }
}
