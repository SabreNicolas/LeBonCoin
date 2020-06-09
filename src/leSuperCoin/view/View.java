package leSuperCoin.view;

import leSuperCoin.controller.Controller;
import leSuperCoin.controller.FiltreController;
import leSuperCoin.model.entities.AnnonceEntity;
import leSuperCoin.resources.Globals.*;

import javax.swing.*;

public class View extends JFrame {
    public enum Target {
        ACCUEIL,
        DEPOT_ANNONCE,
        ANNONCE,
        CONNEXION,
        INSCRIPTION,
        MON_COMPTE
    }

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;

        this.setTitle("Le super coin");
        this.setIconImage(new ImageIcon(getClass().getResource("../resources/images/logo.png")).getImage());
        this.setBackground(Colors.BLANC);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        this.navigate(Target.ACCUEIL);
    }

    public void navigate(Target target, Object payload) {
        this.getContentPane().removeAll();
        this.repaint();

        switch (target) {
            case ACCUEIL:
                this.add(new Accueil(this.controller, (FiltreController) payload));
                break;
            case DEPOT_ANNONCE:
                this.add(new DepotAnnonce(this.controller));
                break;
            case ANNONCE:
                this.add(new Annonce(this.controller, (AnnonceEntity) payload));
                break;
            case CONNEXION:
                this.add(new Connexion(this.controller));
                break;
            case INSCRIPTION:
                this.add(new Inscription(this.controller));
                break;
            case MON_COMPTE:
                this.add(new MonCompte(this.controller));
                break;
            default:
                throw new Error("Trying to navigate to inexsitant view");
        }

        this.validate();
    }

    public void navigate(Target target) {
        this.navigate(target, null);
    }
}