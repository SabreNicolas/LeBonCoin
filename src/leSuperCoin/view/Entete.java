package leSuperCoin.view;

import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;

public class Entete extends JPanel{

    public Entete() {

        this.setLayout(new BorderLayout());

        JLabel nomAppli = new JLabel(Constans.NOM_APPLI);
        nomAppli.setForeground(Colors.BLANC);
        nomAppli.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 25));
        this.add(nomAppli, BorderLayout.WEST);

        JPanel boutons = new JPanel();
        boutons.setLayout(new BorderLayout());
        boutons.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 25));
        this.add(boutons, BorderLayout.EAST);

        JButton depotAnnonce = new JButton();
        depotAnnonce.setText(Constans.DEPOT_ANNONCE_BTN);
        // Ajouter l'icone "plus.png"
        depotAnnonce.setBorderPainted(false);
        depotAnnonce.setBackground(Colors.BLEU);
        depotAnnonce.setForeground(Colors.NOIR);
        boutons.add(depotAnnonce, BorderLayout.WEST);

        JButton monCompte = new JButton();
        monCompte.setText(Constans.MON_COMPTE_BTN);
        // Remplacer le texte par l'icone "utilisateur.png"
        monCompte.setBorderPainted(false);
        monCompte.setBackground(Colors.BLEU);
        monCompte.setForeground(Colors.BLANC);
        boutons.add(monCompte, BorderLayout.EAST);

        boutons.setVisible(true);

        this.setVisible(true);
    }
}
