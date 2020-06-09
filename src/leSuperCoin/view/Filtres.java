package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.controller.FiltreController;
import leSuperCoin.model.entities.CategorieEntity;
import leSuperCoin.model.entities.SurCategorieEntity;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Filtres extends JPanel {
    FiltreController controller;

    public Filtres(FiltreController controller) {
        this.controller = controller;
        this.render();
    }

    void render() {
        this.removeAll();
        this.repaint();

        List<String> listeCategorie = new ArrayList<>();
        Collection<SurCategorieEntity> surCategories = controller.getController().getModel().getSurCategories();
        for (SurCategorieEntity surCategorie : surCategories) {
            listeCategorie.add(surCategorie.getNom());
        }
        {
            JComboBox jComboBox = new JComboBox<>(listeCategorie.toArray(new String[listeCategorie.size()]));
            jComboBox.addActionListener(e -> {
                for (SurCategorieEntity surCategorie : surCategories) {
                    if (surCategorie.getNom() == jComboBox.getSelectedItem()) {
                        controller.setSurCategorieEntity(surCategorie);
                        render();
                        return;
                    }
                }
            });
            this.add(jComboBox);
        }

        if (this.controller.getSurCategorieEntity() != null) {
            List<String> listeSousCategorie = new ArrayList<>();
            Collection<CategorieEntity> categories = controller.getController().getModel().getCategoriesOf(this.controller.getSurCategorieEntity());
            for (CategorieEntity categorie : categories) {
                listeSousCategorie.add(categorie.getNom());
            }
            {
                JComboBox jComboBox = new JComboBox<>(listeSousCategorie.toArray(new String[listeSousCategorie.size()]));
                jComboBox.addActionListener(e -> {
                    for (CategorieEntity categorie : categories) {
                        if (categorie.getNom() == jComboBox.getSelectedItem()) {
                            this.controller.setCategorieEntity(categorie);
                            render();
                            return;
                        }
                    }
                });
                this.add(jComboBox);
            }

             /*JTextField recherche = new JTextField(Constants.CHAMPS_RECHERCHE);
             recherche.setPreferredSize(new Dimension(300, 24));
             recherche.setBorder(BorderFactory.createEmptyBorder());
             this.add(recherche);*/

            if (this.controller.getCategorieEntity() != null) {
                JButton lancerRecherche = new JButton(Constants.LANCER_RECHERCHE);
                lancerRecherche.setBorder(BorderFactory.createEmptyBorder());
                lancerRecherche.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 5));
                lancerRecherche.setBackground(Colors.BLEU);
                lancerRecherche.setForeground(Colors.BLANC);
                lancerRecherche.addActionListener(e -> {
                    controller.getController().getView().navigate(View.Target.ACCUEIL, controller);
                });
                this.add(lancerRecherche);
            }
        }


        this.setVisible(true);

        this.validate();
    }
}
