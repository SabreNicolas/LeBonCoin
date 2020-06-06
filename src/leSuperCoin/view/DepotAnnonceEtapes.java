package leSuperCoin.view;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;

public class DepotAnnonceEtapes extends JPanel {

    public static class Categorie extends JPanel {

        public Categorie() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints grid = new GridBagConstraints();
            grid.fill = GridBagConstraints.BOTH;

            this.setBackground(Colors.BLANC);

            JLabel titreCategorie = new JLabel();
            titreCategorie.setText(Constans.ETAPE_CATEGORIE);
            titreCategorie.setFont(new Font(titreCategorie.getFont().getName(), Font.PLAIN, 15));
            titreCategorie.setForeground(Colors.NOIR);
            grid.gridx = 0;
            grid.gridy = 0;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(titreCategorie, grid);

            /* To Do :
                - Faire une boucle qui affiche toutes les catégories
                - Ajouter les icones (url : /ressources/images/categories/)
                - Quand clic sur un bouton mettre fond à Colors.BLEU et texte à Colors.BLANC
             */

            grid.insets = new Insets(10, 25, 10, 25);

            JButton automobile = new JButton();
            automobile.setText(Constans.CATEGORIE_AUTOMOBILE);
            automobile.setBorderPainted(false);
            automobile.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 0;
            grid.gridy = 1;
            this.add(automobile, grid);

            JButton immobilier = new JButton();
            immobilier.setText(Constans.CATEGORIE_IMMOBILIER);
            immobilier.setBorderPainted(false);
            immobilier.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 0;
            grid.gridy = 2;
            this.add(immobilier, grid);

            JButton multimedia = new JButton();
            multimedia.setText(Constans.CATEGORIE_MULTIMEDIA);
            multimedia.setBorderPainted(false);
            multimedia.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 0;
            grid.gridy = 3;
            this.add(multimedia, grid);

            JButton materielPro = new JButton();
            materielPro.setText(Constans.CATEGORIE_MATERIEL_PRO);
            materielPro.setBorderPainted(false);
            materielPro.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 1;
            grid.gridy = 1;
            this.add(materielPro, grid);

            JButton services = new JButton();
            services.setText(Constans.CATEGORIE_SERVICES);
            services.setBorderPainted(false);
            services.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 1;
            grid.gridy = 2;
            this.add(services, grid);

            JButton mode = new JButton();
            mode.setText(Constans.CATEGORIE_MODE);
            mode.setBorderPainted(false);
            mode.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 1;
            grid.gridy = 3;
            this.add(mode, grid);

            JButton loisirs = new JButton();
            loisirs.setText(Constans.CATEGORIE_LOISIRS);
            loisirs.setBorderPainted(false);
            loisirs.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 2;
            grid.gridy = 1;
            this.add(loisirs, grid);

            JButton divers = new JButton();
            divers.setText(Constans.CATEGORIE_DIVERS);
            divers.setBorderPainted(false);
            divers.setBackground(Colors.GRIS_CLAIR);
            grid.gridx = 2;
            grid.gridy = 2;
            this.add(divers, grid);

            this.setVisible(true);
        }
    }

    public static class Description extends JPanel {

        public Description() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints grid = new GridBagConstraints();
            grid.fill = GridBagConstraints.BOTH;

            this.setBackground(Colors.BLANC);

            JLabel titreDescription = new JLabel();
            titreDescription.setText(Constans.ETAPE_DESCRIPTION);
            titreDescription.setFont(new Font(titreDescription.getFont().getName(), Font.PLAIN, 15));
            titreDescription.setForeground(Colors.NOIR);
            grid.gridx = 0;
            grid.gridy = 0;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(titreDescription, grid);

            grid.insets = new Insets(10, 25, 10, 25);

            JLabel labelTitre = new JLabel();;
            labelTitre.setText(Constans.ANNONCE_TITRE);
            grid.gridx = 0;
            grid.gridy = 1;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(labelTitre, grid);

            JTextField inputTitre = new JTextField();
            inputTitre.setPreferredSize(new Dimension(250, 20));
            inputTitre.setBorder(BorderFactory.createLineBorder(Colors.NOIR, 1));
            grid.gridx = 1;
            grid.gridy = 1;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(inputTitre, grid);

            JLabel labelDescription = new JLabel();;
            labelDescription.setText(Constans.ANNONCE_DESCRIPTION);
            grid.gridx = 0;
            grid.gridy = 2;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(labelDescription, grid);

            JTextArea inputDescription = new JTextArea();
            inputDescription.setLineWrap(true);
            inputDescription.setWrapStyleWord(true);
            inputDescription.setPreferredSize(new Dimension(250, 150));
            inputDescription.setBorder(BorderFactory.createLineBorder(Colors.NOIR, 1));
            grid.gridx = 1;
            grid.gridy = 2;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(inputDescription, grid);

            this.setVisible(true);
        }
    }

    public static class Prix extends JPanel {

        public Prix() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints grid = new GridBagConstraints();
            grid.fill = GridBagConstraints.BOTH;

            this.setBackground(Colors.BLANC);

            JLabel titreDescription = new JLabel();
            titreDescription.setText(Constans.ETAPE_PRIX);
            titreDescription.setFont(new Font(titreDescription.getFont().getName(), Font.PLAIN, 15));
            titreDescription.setForeground(Colors.NOIR);
            grid.gridx = 0;
            grid.gridy = 0;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(titreDescription, grid);

            grid.insets = new Insets(10, 25, 10, 25);

            JLabel labelPrix = new JLabel();;
            labelPrix.setText(Constans.ANNONCE_PRIX);
            grid.gridx = 0;
            grid.gridy = 1;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(labelPrix, grid);

            JTextField inputPrix = new JTextField();
            inputPrix.setPreferredSize(new Dimension(250, 20));
            inputPrix.setBorder(BorderFactory.createLineBorder(Colors.NOIR, 1));
            grid.gridx = 1;
            grid.gridy = 1;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(inputPrix, grid);
        }
    }

    public static class Photo extends JPanel {

        public Photo() {

        }
    }

    public static class Recapitulatif extends JPanel {

        public Recapitulatif() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints grid = new GridBagConstraints();
            grid.fill = GridBagConstraints.BOTH;

            JLabel titreCategorie = new JLabel();
            titreCategorie.setText(Constans.ETAPE_RECAPITULATIF);
            titreCategorie.setFont(new Font(titreCategorie.getFont().getName(), Font.PLAIN, 15));
            titreCategorie.setForeground(Colors.NOIR);
            grid.gridx = 0;
            grid.gridy = 0;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(titreCategorie, grid);

            Categorie categorie = new Categorie();
            grid.gridx = 0;
            grid.gridy = 1;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(categorie, grid);

            Description description = new Description();
            grid.gridx = 0;
            grid.gridy = 2;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(description, grid);

            Prix prix = new Prix();
            grid.gridx = 0;
            grid.gridy = 3;
            grid.anchor = GridBagConstraints.NORTH;
            this.add(prix, grid);

            this.setVisible(true);
        }
    }

}
