package leSuperCoin.view;

import leSuperCoin.controller.DepotAnnonceController;
import leSuperCoin.model.entities.CategorieEntity;
import leSuperCoin.model.entities.CritereEntity;
import leSuperCoin.model.entities.SurCategorieEntity;
import leSuperCoin.resources.Globals.Colors;
import leSuperCoin.resources.Globals.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

public class DepotAnnonceEtapes extends JPanel {

    public static class Categorie extends JPanel {
        DepotAnnonceController form;
        Consumer<Boolean> toggleEtapeSuivante;
        GridBagConstraints grid;

        JPanel surCategoriePanel;
        JPanel categoriePanel;

        GridBagConstraints surCategoriePanelGrid;
        GridBagConstraints categoriePanelGrid;

        public Categorie(DepotAnnonceController form, Consumer<Boolean> toggleEtapeSuivante) {
            this.form = form;
            this.toggleEtapeSuivante = toggleEtapeSuivante;

            this.setLayout(new GridBagLayout());
            this.grid = new GridBagConstraints();
            this.grid.fill = GridBagConstraints.BOTH;
            this.grid.anchor = GridBagConstraints.NORTH;

            this.setBackground(Colors.BLANC);

            /* To Do :
                - Faire une boucle qui affiche toutes les catégories
                - Ajouter les icones (url : /ressources/images/categories/)
                - Quand clic sur un bouton mettre fond à Colors.BLEU et texte à Colors.BLANC
             */

            this.grid.insets = new Insets(10, 25, 10, 25);

            this.addSurCategorie();
            this.addCategorie();

            this.updateSurCategorie();

            this.setVisible(true);
        }

        private void addSurCategorie() {
            this.surCategoriePanel = new JPanel();
            this.surCategoriePanel.setLayout(new GridBagLayout());
            this.surCategoriePanelGrid = new GridBagConstraints();
            this.surCategoriePanelGrid.fill = GridBagConstraints.BOTH;
            this.surCategoriePanelGrid.insets = new Insets(100, 250, 100, 250);
            this.grid.gridx = 1;
            this.grid.gridy = 1;
            this.add(this.surCategoriePanel, this.grid);
        }

        private void updateSurCategorie() {
            this.surCategoriePanel.removeAll();
            this.surCategoriePanel.repaint();
            this.surCategoriePanelGrid.insets = new Insets(0, 0, 0, 0);

            JLabel titreSurCategorie = new JLabel();
            titreSurCategorie.setText(Constants.ETAPE_CATEGORIE);
            titreSurCategorie.setFont(new Font(titreSurCategorie.getFont().getName(), Font.PLAIN, 15));
            titreSurCategorie.setForeground(Colors.NOIR);
            this.surCategoriePanelGrid.gridx = 0;
            this.surCategoriePanelGrid.gridy = 0;
            this.surCategoriePanel.add(titreSurCategorie, this.surCategoriePanelGrid);

            int coords = 0;
            for (SurCategorieEntity surCategorieEntity : this.form.getController().getModel().getSurCategories()) {
                JButton surCategorie = new JButton();
                surCategorie.setText(surCategorieEntity.getNom());
                surCategorie.setBorderPainted(false);
                surCategorie.setBackground(this.form.getSurCategorie() == surCategorieEntity ? Colors.BLEU : Colors.GRIS_CLAIR);
                surCategorie.addActionListener(e -> {
                    this.form.setSurCategorie(surCategorieEntity);
                    this.updateCategorie();
                    this.updateSurCategorie();
                });
                this.surCategoriePanelGrid.gridx = coords / 3;
                this.surCategoriePanelGrid.gridy = coords % 3 + 1;
                this.surCategoriePanel.add(surCategorie, this.surCategoriePanelGrid);
                coords++;
            }

            this.surCategoriePanel.validate();
            this.surCategoriePanel.repaint();
            this.validate();
            this.repaint();
        }

        private void addCategorie() {
            this.categoriePanel = new JPanel();
            this.categoriePanel.setLayout(new GridBagLayout());
            this.categoriePanelGrid = new GridBagConstraints();
            this.categoriePanelGrid.fill = GridBagConstraints.BOTH;
            this.categoriePanelGrid.insets = new Insets(100, 250, 100, 250);
            this.grid.gridx = 1;
            this.grid.gridy = 2;
            this.add(this.categoriePanel, this.grid);

            JLabel titreCategorie = new JLabel();
            titreCategorie.setText(Constants.ETAPE_SOUS_CATEGORIE);
            titreCategorie.setFont(new Font(titreCategorie.getFont().getName(), Font.PLAIN, 15));
            titreCategorie.setForeground(Colors.NOIR);
            this.categoriePanelGrid.gridx = 0;
            this.categoriePanelGrid.gridy = 0;
            this.categoriePanel.add(titreCategorie, this.categoriePanelGrid);
        }

        private void updateCategorie() {
            this.categoriePanel.removeAll();
            this.categoriePanel.repaint();
            this.categoriePanelGrid.insets = new Insets(0, 0, 0, 0);

            JLabel titreCategorie = new JLabel();
            titreCategorie.setText(Constants.ETAPE_CATEGORIE);
            titreCategorie.setFont(new Font(titreCategorie.getFont().getName(), Font.PLAIN, 15));
            titreCategorie.setForeground(Colors.NOIR);
            this.categoriePanelGrid.gridx = 0;
            this.categoriePanelGrid.gridy = 0;
            this.categoriePanel.add(titreCategorie, this.categoriePanelGrid);

            int coords = 0;
            for (CategorieEntity categorieEntity : this.form.getController().getModel().getCategoriesOf(this.form.getSurCategorie())) {
                JButton categorie = new JButton();
                categorie.setText(categorieEntity.getNom());
                categorie.setBorderPainted(false);
                categorie.setBackground(this.form.getCategorie() == categorieEntity ? Colors.BLEU : Colors.GRIS_CLAIR);
                categorie.addActionListener(e -> {
                    this.form.setCategorie(categorieEntity);
                    this.updateCategorie();
                    this.toggleEtapeSuivante.accept(true);
                });
                this.categoriePanelGrid.gridx = coords / 3;
                this.categoriePanelGrid.gridy = coords % 3 + 1;
                this.categoriePanel.add(categorie, this.categoriePanelGrid);
                coords++;
            }

            this.categoriePanel.validate();
            this.categoriePanel.repaint();
            this.validate();
            this.repaint();
        }
    }

    public static class Description extends JPanel {
        DepotAnnonceController form;
        Consumer<Boolean> toggleEtapeSuivante;

        public Description(DepotAnnonceController form, Consumer<Boolean> toggleEtapeSuivante) {
            this.form = form;
            this.toggleEtapeSuivante = toggleEtapeSuivante;

            this.setLayout(new GridBagLayout());
            GridBagConstraints grid = new GridBagConstraints();
            grid.fill = GridBagConstraints.BOTH;

            this.setBackground(Colors.BLANC);

            JLabel titreDescription = new JLabel();
            titreDescription.setText(Constants.ETAPE_DESCRIPTION);
            titreDescription.setFont(new Font(titreDescription.getFont().getName(), Font.PLAIN, 15));
            titreDescription.setForeground(Colors.NOIR);
            grid.gridx = 0;
            grid.gridy = 0;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(titreDescription, grid);

            grid.insets = new Insets(10, 25, 10, 25);

            /*JLabel labelTitre = new JLabel();
            labelTitre.setText(Constants.ANNONCE_TITRE);
            grid.gridx = 0;
            grid.gridy = 1;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(labelTitre, grid);

            JTextField inputTitre = new JTextField();
            inputTitre.setPreferredSize(new Dimension(250, 20));
            inputTitre.setBorder(BorderFactory.createLineBorder(Colors.NOIR, 1));
            inputTitre.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    form.setTitre(inputTitre.getText());
                    if (form.getTitre() != null && form.getDescription() != null) {
                        toggleEtapeSuivante.accept(true);
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            grid.gridx = 1;
            grid.gridy = 1;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(inputTitre, grid);*/

            JLabel labelDescription = new JLabel();
            labelDescription.setText(Constants.ANNONCE_DESCRIPTION);
            grid.gridx = 0;
            grid.gridy = 2;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(labelDescription, grid);

            JTextArea inputDescription = new JTextArea();
            inputDescription.setLineWrap(true);
            inputDescription.setWrapStyleWord(true);
            inputDescription.setPreferredSize(new Dimension(250, 150));
            inputDescription.setBorder(BorderFactory.createLineBorder(Colors.NOIR, 1));
            inputDescription.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    form.setDescription(inputDescription.getText());
                    if (/*form.getTitre() != null &&*/ form.getDescription() != null) {
                        toggleEtapeSuivante.accept(true);
                    }
                }
            });
            grid.gridx = 1;
            grid.gridy = 2;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(inputDescription, grid);

            this.setVisible(true);
        }
    }

    public static class Criteres extends JPanel {
        DepotAnnonceController form;
        Consumer<Boolean> toggleEtapeSuivante;
        GridBagConstraints grid;

        public Criteres(DepotAnnonceController form, Consumer<Boolean> toggleEtapeSuivante) {
            this.form = form;
            this.toggleEtapeSuivante = toggleEtapeSuivante;

            this.setLayout(new GridBagLayout());
            this.grid = new GridBagConstraints();
            this.grid.fill = GridBagConstraints.BOTH;

            this.setBackground(Colors.BLANC);

            JLabel titreDescription = new JLabel();
            titreDescription.setText(Constants.ETAPE_CRITERES);
            titreDescription.setFont(new Font(titreDescription.getFont().getName(), Font.PLAIN, 15));
            titreDescription.setForeground(Colors.NOIR);
            this.grid.gridx = 0;
            this.grid.gridy = 0;
            this.grid.anchor = GridBagConstraints.NORTH;
            this.add(titreDescription, grid);

            grid.insets = new Insets(10, 25, 10, 25);

            this.addCriteres();
        }

        void addCriteres() {
            int y = 1;
            for (CritereEntity critereEntity : this.form.getController().getModel().getCriteresOf(this.form.getSurCategorie())) {
                JLabel label = new JLabel();

                label.setText(critereEntity.getNomCritere());
                this.grid.gridx = 0;
                this.grid.gridy = y;
                this.grid.anchor = GridBagConstraints.NORTH;
                this.add(label, grid);

                JTextField input = new JTextField();
                input.setPreferredSize(new Dimension(250, 20));
                input.setBorder(BorderFactory.createLineBorder(Colors.NOIR, 1));
                input.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        toggleEtapeSuivante.accept(true);
                        form.setCritere(critereEntity, input.getText());
                    }
                });
                grid.gridx = 1;
                grid.gridy = y++;
                grid.anchor = GridBagConstraints.NORTH;
                this.add(input, grid);
            }
        }
    }

    public static class Photo extends JPanel {

        public Photo() {

        }
    }
}
