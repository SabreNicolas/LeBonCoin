package leSuperCoin.view;

import javax.swing.*;
import java.awt.*;

public class Accueil extends JPanel {

    private JPanel accueil;

    private JPanel entete;

    public Accueil() {
        accueil = new JPanel();
        accueil.setLayout(new BoxLayout(accueil, BoxLayout.Y_AXIS));

        entete = new Entete();
        entete.setBackground(Color.green);
        entete.setSize(new Dimension(250, 250));

        accueil.add(entete);

        accueil.setVisible(true);
    }
}
