package leSuperCoin.controller;

import leSuperCoin.view.View;


public class ConnexionController {
    private Controller controller;

    private String pseudo;
    private String motDePasse;

    public ConnexionController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isReady() {
        return this.pseudo != null && this.motDePasse != null;
    }

    public void submit() {
        if (this.controller.getModel().login(this.pseudo, this.motDePasse)) {
            this.controller.getView().navigate(View.Target.ACCUEIL);
        }
    }
}
