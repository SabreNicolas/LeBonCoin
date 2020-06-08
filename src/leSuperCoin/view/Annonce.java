package leSuperCoin.view;

import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;

public class Annonce extends JPanel {

    public Annonce() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BOTH;

        Entete entete = new Entete();
        entete.setBackground(Colors.BLEU);
        grid.weightx = 1;
        grid.gridwidth = 3;
        grid.gridx = 0;
        grid.gridy = 0;
        grid.weighty = 0.1;
        grid.anchor = GridBagConstraints.NORTH;
        this.add(entete, grid);

        JLabel retour = new JLabel("< Retour aux annonces");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.weighty = 0.2;
        grid.insets = new Insets(25, 250, 0, 250);
        this.add(retour, grid);

        /* Images */
        JPanel annonceImages = new JPanel();
        grid.gridx = 0;
        grid.gridy = 2;
        grid.weighty = 1;
        annonceImages.setBackground(Colors.GRIS_CLAIR);
        this.add(annonceImages, grid);

        /* Titre et prix */
        JPanel annonceDetail = new JPanel();
        grid.gridx = 0;
        grid.gridy = 3;
        grid.weighty = 0.1;
        annonceDetail.setBackground(Colors.BLANC);
        this.add(annonceDetail, grid);

        annonceDetail.setLayout(new GridBagLayout());
        GridBagConstraints gridAnnonceDetail = new GridBagConstraints();
        gridAnnonceDetail.fill = GridBagConstraints.BASELINE;

        JLabel titreAnnonce = new JLabel();
        titreAnnonce.setText("Titre de l'annonce");
        titreAnnonce.setFont(new Font(titreAnnonce.getFont().getName(), Font.PLAIN, 30));
        titreAnnonce.setForeground(Colors.NOIR);
        gridAnnonceDetail.gridx = 0;
        gridAnnonceDetail.gridy = 0;
        gridAnnonceDetail.anchor = GridBagConstraints.LINE_START;
        gridAnnonceDetail.weightx = 1;
        annonceDetail.add(titreAnnonce, gridAnnonceDetail);

        gridAnnonceDetail.gridx = 1;
        gridAnnonceDetail.gridy = 0;
        gridAnnonceDetail.anchor = GridBagConstraints.CENTER;
        gridAnnonceDetail.weightx = 10;
        this.add(new JLabel(), gridAnnonceDetail);

        JLabel prixAnnonce = new JLabel();
        prixAnnonce.setText("100€");
        prixAnnonce.setFont(new Font(prixAnnonce.getFont().getName(), Font.PLAIN, 30));
        prixAnnonce.setForeground(Colors.BLEU);
        gridAnnonceDetail.gridx = 2;
        gridAnnonceDetail.gridy = 0;
        gridAnnonceDetail.anchor = GridBagConstraints.LINE_END;
        gridAnnonceDetail.weightx = 1;
        annonceDetail.add(prixAnnonce, gridAnnonceDetail);

        /* Description */
        JPanel annonceDescription = new JPanel();
        grid.gridx = 0;
        grid.gridy = 4;
        grid.weighty = 0.2;
        annonceDescription.setBackground(Colors.BLANC);
        this.add(annonceDescription, grid);

        annonceDescription.setLayout(new GridBagLayout());
        GridBagConstraints gridAnnonceDescription = new GridBagConstraints();
        gridAnnonceDescription.fill = GridBagConstraints.BASELINE;

        JLabel titreDescription = new JLabel();
        titreDescription.setText("Description");
        titreDescription.setFont(new Font(titreDescription.getFont().getName(), Font.PLAIN, 30));
        titreDescription.setForeground(Colors.BLEU);
        gridAnnonceDescription.gridx = 0;
        gridAnnonceDescription.gridy = 0;
        gridAnnonceDescription.anchor = GridBagConstraints.LINE_START;
        gridAnnonceDescription.gridwidth = 1;
        gridAnnonceDescription.weightx = 1;
        annonceDescription.add(titreDescription, gridAnnonceDescription);

        JTextArea texteDescription = new JTextArea();
        texteDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In quis dui felis. Nullam commodo ullamcorper maximus. Praesent tincidunt vestibulum malesuada. Phasellus ultrices ligula vitae orci ultrices iaculis nec nec sapien. Nunc dapibus lobortis arcu, in luctus neque. Aenean at pulvinar turpis. Fusce ac orci lectus. Aenean eleifend auctor velit sit amet consequat. Nullam a nibh et felis posuere tincidunt. Suspendisse vel porttitor lectus, et sollicitudin eros. Quisque non augue ac ante placerat consequat.");
        texteDescription.setFont(new Font(texteDescription.getFont().getName(), Font.PLAIN, 15));
        texteDescription.setForeground(Colors.NOIR);
        texteDescription.setBackground(Colors.BLANC);
        texteDescription.setLineWrap(true);
        texteDescription.setWrapStyleWord(true);
        gridAnnonceDescription.gridx = 0;
        gridAnnonceDescription.gridy = 1;
        gridAnnonceDescription.anchor = GridBagConstraints.LINE_START;
        gridAnnonceDescription.gridwidth = 2;
        gridAnnonceDescription.weightx = 1;
        gridAnnonceDescription.fill = GridBagConstraints.BOTH;
        annonceDescription.add(texteDescription, gridAnnonceDescription);

        /* Information du vendeur */
        JPanel annonceInfoVendeur = new JPanel();
        grid.gridx = 0;
        grid.gridy = 5;
        grid.weighty = 0.1;
        annonceInfoVendeur.setBackground(Colors.BLANC);
        this.add(annonceInfoVendeur, grid);

        annonceInfoVendeur.setLayout(new GridBagLayout());
        GridBagConstraints gridAnnonceInfoVendeur = new GridBagConstraints();
        gridAnnonceInfoVendeur.fill = GridBagConstraints.BASELINE;

        JLabel titreInfoVendeur = new JLabel();
        titreInfoVendeur.setText("Information sur le vendeur");
        titreInfoVendeur.setFont(new Font(titreInfoVendeur.getFont().getName(), Font.PLAIN, 30));
        titreInfoVendeur.setForeground(Colors.BLEU);
        gridAnnonceInfoVendeur.gridx = 0;
        gridAnnonceInfoVendeur.gridy = 0;
        gridAnnonceInfoVendeur.anchor = GridBagConstraints.LINE_START;
        gridAnnonceInfoVendeur.gridwidth = 1;
        gridAnnonceInfoVendeur.weightx = 1;
        annonceInfoVendeur.add(titreInfoVendeur, gridAnnonceInfoVendeur);

        JTextArea texteInfoVendeur = new JTextArea();
        texteInfoVendeur.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In quis dui felis.");
        texteInfoVendeur.setFont(new Font(texteInfoVendeur.getFont().getName(), Font.PLAIN, 15));
        texteInfoVendeur.setForeground(Colors.NOIR);
        texteInfoVendeur.setBackground(Colors.BLANC);
        texteInfoVendeur.setLineWrap(true);
        texteInfoVendeur.setWrapStyleWord(true);
        gridAnnonceInfoVendeur.gridx = 0;
        gridAnnonceInfoVendeur.gridy = 1;
        gridAnnonceInfoVendeur.anchor = GridBagConstraints.LINE_START;
        gridAnnonceInfoVendeur.fill = GridBagConstraints.BOTH;
        gridAnnonceInfoVendeur.gridwidth = 2;
        gridAnnonceInfoVendeur.weightx = 1;
        annonceInfoVendeur.add(texteInfoVendeur, gridAnnonceInfoVendeur);
        
        this.setVisible(true);
    }
}
