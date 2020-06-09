package leSuperCoin.view;

import leSuperCoin.controller.ConnexionController;
import leSuperCoin.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Connexion extends JPanel {
    private ConnexionController form;

    public Connexion(Controller controller) {
        this.form = new ConnexionController(controller);

        // Afficher champ pseudo / mot de passe
        // Afficher un btn "ou s'inscrire" qui appelle this.form.getController().getView().navigate(View.Target.INSCRIPTION);

        // this.form.get/setPseudo(...); (peut être null)
        // this.form.get/setMotDePasse(...); (peut être null)
        // this.form.isReady(); -> est-ce que le btn submit doit être disabled
        // this.form.submit();

        // r'appeler la rerendre le btn submit .set(...) (pour raffraichir s'il est grisé)
        // pas besoin d'appeler quoi que ce soit après le submit

        this.setVisible(true);
    }
}
