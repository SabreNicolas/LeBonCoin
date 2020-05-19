package leSuperCoin.view;

import leSuperCoin.resources.Strings;
import leSuperCoin.resources.Couleurs;

import javax.swing.*;
import java.awt.*;

public class Entete extends JPanel{

    public JPanel entete;
    public JPanel boutons;

    public JLabel nomAppli;
    public JButton depotAnnonce;
    public JButton monCompte;

    public Entete() {
        this.entete = new JPanel();
        this.boutons = new JPanel();

        this.nomAppli = new JLabel(Strings.NOM_APPLI);
        this.depotAnnonce = new JButton();
        this.monCompte = new JButton();

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

        this.entete.setSize(new Dimension(250, 250));

        this.entete.setVisible(true);
        this.boutons.setVisible(true);
    }
}
