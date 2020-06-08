package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.model.entities.AnnonceEntity;
import leSuperCoin.model.entities.ValeurCritereEntity;
import leSuperCoin.resources.Globals;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AnnonceItem extends JPanel {
    Controller controller;
    AnnonceEntity annonceEntity;

    public AnnonceItem(Controller controller, AnnonceEntity annonceEntity) {
        this.controller = controller;
        this.annonceEntity = annonceEntity;


        String titreStr = "???";
        String prixStr = "???";
        for (ValeurCritereEntity valeurCritereEntity : this.controller.getModel().getValeurCriteresOf(annonceEntity)) {
            switch (valeurCritereEntity.getCritereEntity().getNomCritere()) {
                case "Titre":
                    titreStr = valeurCritereEntity.getValeur();
                    break;
                case "Prix":
                    prixStr = valeurCritereEntity.getValeur();
                    break;
            }
        }

        // A faire : créer une fonction pour les modifications de grid pour éviter la duplication de code.

        this.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 2));
        this.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BASELINE;

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                controller.getView().navigate(View.Target.ANNONCE, annonceEntity);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // Zone pour Image
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridheight = 2;
        grid.weightx = 1;
        grid.weighty = 1;
        grid.fill = GridBagConstraints.BOTH;
        grid.insets = new Insets(10, 10, 10, 10);
        this.add(new JButton("Image"), grid);

        grid.fill = GridBagConstraints.BASELINE;

        JLabel titre = new JLabel();
        // Todo: titre
        titre.setText(titreStr);
        titre.setFont(new Font(titre.getFont().getName(), Font.PLAIN, 30));
        titre.setForeground(Colors.BLEU);
        grid.gridx = 1;
        grid.gridy = 0;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        grid.anchor = GridBagConstraints.LINE_START;
        grid.weightx = 1;
        this.add(titre, grid);

        grid.gridx = 2;
        grid.gridy = 0;
        grid.gridwidth = 1;
        grid.anchor = GridBagConstraints.CENTER;
        grid.weightx = 1;
        this.add(new JLabel(), grid);

        JTextArea description = new JTextArea();
        description.setText(annonceEntity.getDescription());
        description.setFont(new Font(description.getFont().getName(), Font.PLAIN, 15));
        description.setForeground(Colors.NOIR);
        description.setBackground(Colors.GRIS_CLAIR);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        grid.gridx = 1;
        grid.gridy = 1;
        grid.gridwidth = 3;
        grid.fill = GridBagConstraints.BOTH;
        grid.weightx = 1;
        grid.weighty = 1;
        this.add(description, grid);

        grid.fill = GridBagConstraints.BASELINE;

        JLabel prix = new JLabel();
        // Todo: prix
        prix.setText(prixStr + " €");
        prix.setFont(new Font(titre.getFont().getName(), Font.PLAIN, 30));
        prix.setForeground(Colors.BLEU);
        grid.gridx = 3;
        grid.gridy = 0;
        grid.gridwidth = 1;
        grid.anchor = GridBagConstraints.LINE_END;
        grid.weightx = 1;
        this.add(prix, grid);

        this.setPreferredSize(new Dimension(1000, 200));
        this.setBackground(Colors.GRIS_CLAIR);

        this.setVisible(true);
    }
}
