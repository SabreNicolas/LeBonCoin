package leSuperCoin.view;

import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Filtres extends JPanel {

   public Filtres() {

        List<String> listeCategorie = new ArrayList<>();
        listeCategorie.add("Véhicule");
        listeCategorie.add("Loisirs");
        listeCategorie.add("Immobilier");
        this.add(new JComboBox<>(listeCategorie.toArray(new String[listeCategorie.size()])));

        List<String> listeSousCategorie = new ArrayList<>();
        listeSousCategorie.add("Voitures");
        listeSousCategorie.add("Moto");
        listeSousCategorie.add("Nautisme");
        listeSousCategorie.add("Animaux");
        listeSousCategorie.add("Vélos");
        listeSousCategorie.add("Immobilier neuf");
        listeSousCategorie.add("Colocations");
        listeSousCategorie.add("Location");
        this.add(new JComboBox<>(listeSousCategorie.toArray(new String[listeSousCategorie.size()])));

        JTextField recherche = new JTextField(Constans.CHAMPS_RECHERCHE);
        recherche.setPreferredSize(new Dimension(300, 24));
        recherche.setBorder(BorderFactory.createEmptyBorder());
        this.add(recherche);

        JButton lancerRecherche = new JButton(Constans.LANCER_RECHERCHE);
        lancerRecherche.setBorder(BorderFactory.createEmptyBorder());
        lancerRecherche.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 5));
        lancerRecherche.setBackground(Colors.BLEU);
        lancerRecherche.setForeground(Colors.BLANC);
        this.add(lancerRecherche);

        this.setVisible(true);
    }
}
