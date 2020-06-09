package leSuperCoin.view;

import leSuperCoin.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MonCompte extends JPanel {
    private Controller controller;

    public MonCompte(Controller controller) {
        this.controller = controller;

        // Afficher un btn déconnexion qui appelle
        //  - this.form.getController().getModel().disconnect();
        //  - this.form.getController().getView().navigate(View.Target.ACCUEIL);

        this.setVisible(true);
    }
}
