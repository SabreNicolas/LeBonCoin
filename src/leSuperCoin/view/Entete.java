package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;
import java.awt.*;

public class Entete extends JPanel {

    public Entete(Controller controller) {

        this.setLayout(new BorderLayout());
        this.setBackground(Colors.BLEU);

        JLabel nomAppli = new JLabel(Constants.NOM_APPLI);
        nomAppli.setForeground(Colors.BLANC);
        nomAppli.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 25));
        this.add(nomAppli, BorderLayout.WEST);

        JPanel boutons = new JPanel();
        boutons.setLayout(new BorderLayout());
        boutons.setBorder(BorderFactory.createLineBorder(Colors.BLEU, 25));
        this.add(boutons, BorderLayout.EAST);

        if (controller.getModel().isConnected()) {
            JButton depotAnnonce = new JButton();
            depotAnnonce.setText(Constants.DEPOT_ANNONCE_BTN);
            // Ajouter l'icone "plus.png"
            depotAnnonce.setBorderPainted(false);
            depotAnnonce.setBackground(Colors.BLEU);
            depotAnnonce.setForeground(Colors.NOIR);
            depotAnnonce.addActionListener(e -> {
                depotAnnonce.setBackground(Colors.NOIR);
                controller.getView().navigate(View.Target.DEPOT_ANNONCE);
            });
            boutons.add(depotAnnonce, BorderLayout.WEST);
        }

        JButton monCompte = new JButton();
        monCompte.setText(controller.getModel().isConnected() ? Constants.MON_COMPTE_BTN : Constants.SE_CONNECTER_BTN);
        // Remplacer le texte par l'icone "utilisateur.png"
        monCompte.setBorderPainted(false);
        monCompte.setBackground(Colors.BLEU);
        monCompte.setForeground(Colors.BLANC);
        boutons.add(monCompte, BorderLayout.EAST);
        monCompte.addActionListener(e -> {
            if (controller.getModel().isConnected()) {
                controller.getView().navigate(View.Target.MON_COMPTE);
            } else {
                controller.getView().navigate(View.Target.CONNEXION);
            }
        });
        boutons.setVisible(true);

        this.setVisible(true);
    }
}
