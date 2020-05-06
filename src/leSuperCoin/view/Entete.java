package leSuperCoin.view;

import leSuperCoin.resources.Strings;
import leSuperCoin.resources.Couleurs;

import javax.swing.*;
import java.awt.*;

public class Entete extends JPanel{

    public JPanel entete = new JPanel();
    public JPanel boutons = new JPanel();

    public JLabel nomAppli = new JLabel(Strings.NOM_APPLI);
    public JButton depotAnnonce = new JButton();
    public JButton monCompte = new JButton();

    public Entete() {
        this.entete.setLayout(new BorderLayout());
        this.entete.add(this.nomAppli, BorderLayout.WEST);

        this.boutons.setLayout(new BorderLayout());
        this.entete.add(this.boutons, BorderLayout.EAST);
        this.boutons.add(this.depotAnnonce, BorderLayout.WEST);
        this.boutons.add(this.monCompte, BorderLayout.EAST);

        this.entete.setBackground(Couleurs.BLEU);

        this.nomAppli.setForeground(Couleurs.GRIS_CLAIR);

        this.depotAnnonce.setText(Strings.DEPOT_ANNONCE_BTN);
        // Ajouter l'icone "plus.png"
        this.depotAnnonce.setBorderPainted(false);
        this.depotAnnonce.setBackground(Couleurs.BLEU);
        this.depotAnnonce.setForeground(Couleurs.NOIR);

        this.monCompte.setText(Strings.MON_COMPTE_BTN);
        // Remplacer le texte par l'icone "utilisateur.png"
        this.monCompte.setBorderPainted(false);
        this.monCompte.setBackground(Couleurs.BLEU);
        this.monCompte.setForeground(Couleurs.GRIS_CLAIR);
    }
}
