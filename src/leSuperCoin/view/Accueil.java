package leSuperCoin.view;

import javax.swing.*;

public class Accueil extends JFrame {

    private JPanel accueil;

    private JPanel entete;

    public Accueil() {
        accueil = new JPanel();
        accueil.setLayout(new BoxLayout(accueil, BoxLayout.Y_AXIS));

        entete = new Entete();

        accueil.add(entete);

        accueil.setVisible(true);
    }
}
