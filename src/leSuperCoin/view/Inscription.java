package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.controller.InscriptionController;

import javax.swing.*;
import java.awt.*;

public class Inscription extends JPanel {
    private InscriptionController form;

    public Inscription(Controller controller) {
        this.form = new InscriptionController(controller);

        // Afficher champ pseudo / mot de passe
        // Afficher un btn "ou s'inscrire" qui appelle this.form.getController().getView().navigate(View.Target.INSCRIPTION);

        // this.form.get/setPseudo(...); (peut être null)
        // this.form.get/setMotDePasse(...); (peut être null)
        // this.form.get/setNom(...); (peut être null)
        // this.form.get/setPrenom(...); (peut être null)
        // this.form.get/setMail(...); (peut être null)
        // this.form.isReady(); -> est-ce que le btn submit doit être disabled
        // this.form.submit();

        // r'appeler la rerendre le btn submit .set(...) (pour raffraichir s'il est grisé)
        // pas besoin d'appeler quoi que ce soit après le submit

        this.setVisible(true);
    }
}
