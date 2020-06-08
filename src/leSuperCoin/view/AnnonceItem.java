package leSuperCoin.view;

import leSuperCoin.resources.Globals;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;

public class AnnonceItem extends JPanel {

    public AnnonceItem() {

        // A faire : créer une fonction pour les modifications de grid pour éviter la duplication de code.

        this.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 2));
        this.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.BASELINE;

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
        titre.setText("Titre de l'annonce");
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
        description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In quis dui felis. Nullam commodo ullamcorper maximus. Praesent tincidunt vestibulum malesuada. Phasellus ultrices ligula vitae orci ultrices iaculis nec nec sapien. Nunc dapibus lobortis arcu, in luctus neque. Aenean at pulvinar turpis. Fusce ac orci lectus. Aenean eleifend auctor velit sit amet consequat. Nullam a nibh et felis posuere tincidunt. Suspendisse vel porttitor lectus, et sollicitudin eros. Quisque non augue ac ante placerat consequat.");
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
        prix.setText("100€");
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
